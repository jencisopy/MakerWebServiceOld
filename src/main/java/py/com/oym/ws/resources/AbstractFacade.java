/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import py.com.oym.others.Params;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
public abstract class AbstractFacade<T>{

    private Class<T> entityClass;
    private String token;
    private Long idEmpresa = 98L;
    private Long idVendedor = 0L;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    protected abstract UserSession getUserSession(String key);    

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /*
     public T findByCodigo(String entity, Object codigo) {
     Query query = getEntityManager().createQuery("select o from "+entity+" o where idempresa = 1 and codigo = "+codigo);
     return (T)query.getSingleResult();
     }
     */
    public List<T> findByCodigo(String query, Object codigo) {
        try {
            Long idempresa = this.getIdempresa();
            EntityManager em = getEntityManager();
            return (List<T>) em.createNamedQuery(query).
                    setParameter("idempresa", idempresa).
                    setParameter("codigo", codigo).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<T> findAll() {
        Long idempresa = this.getIdempresa();
        try {
            return getEntityManager().
                    createNamedQuery(entityClass.getSimpleName() + ".findAll").
                    setParameter("idempresa", idempresa).
                    getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    protected String getToken() {
        return token;
    }

    protected void setToken(String token) {
        verifyToken(token);
        String[] tokens = token.split("\\-");
        this.idEmpresa  = Long.parseLong(tokens[0]);
        this.idVendedor = Long.parseLong(tokens[1]);
        this.token = token;
    }

    public Long getIdempresa() {
        return idEmpresa;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    protected Boolean verifyToken(String token) {
        if (token == null){
            throw new py.com.oym.ws.exceptions.TokenError("Debe proporcionar el token de autorización");
        }
        if (getUserSession(token) == null){
            throw new py.com.oym.ws.exceptions.TokenError("Este token ya expiró o es es incorrecto");            
        }
        return true;
    }

    public UserSession loginUser(String user, String clave) {
        // Buscar en usuarioVendedor
        Map<String, Object> params = new HashMap<>();
        String query = "select usuariovendedor.usuario, vendedor.idvendedor, vendedor.idempresa "
                    +  "from datos.usuarioVendedor " 
                    +  "inner join datos.vendedor on usuariovendedor.idvendedor = vendedor.idvendedor "
                    +  "where usuarioalias = :user"; 
        params.put("user", user);
        List<Object> userVendedor = findByNativeQuery(query, params);
        if (userVendedor == null || userVendedor.isEmpty()) {
            return null;
        }
        // Si existe, buscar en usuario       
        Object[] rowVendedor = (Object[]) userVendedor.get(0);
        params = new HashMap<>();                
        params.put("usuario", rowVendedor[0].toString());
        query =  "select codigo, rol, clave "
                +"from catalogo.usuario "
                +"where codigo = :usuario";
        
        List<Object> usuarios = findByNativeQuery(query, params);
        if (usuarios == null || usuarios.isEmpty()) {
            return null;
        }
        // Si existe, validar contraseña con clave
        Object[] rowUsuario = (Object[]) usuarios.get(0);
        String md5 = rowUsuario[0].toString().toUpperCase().trim() + rowUsuario[1].toString().trim() + clave.trim();
        String claveEncriptada = getMD5(md5);
        // Si todo ok, generar token
        if (claveEncriptada.equals(rowUsuario[2].toString())) { 
            // idempresa, vendedor, string validacion
            String idempresa  = rowVendedor[2].toString().trim();
            String idvendedor = rowVendedor[1].toString().trim();
            String usuario    = rowUsuario[0].toString().toUpperCase().trim();
            String usuarioRol = rowUsuario[1].toString().toUpperCase().trim();
            Date fecha = new Date();
            md5 = usuario + usuarioRol + clave.trim() + idempresa + idvendedor + fecha;
            String tokenGenerado = idempresa+"-"+idvendedor+"-"+getMD5(md5);
            UserSession userSession = new UserSession();
            userSession.setIdempresa(Long.parseLong(idempresa));
            userSession.setIdvendedor(Long.parseLong(idvendedor));
            userSession.setSessionId(tokenGenerado);
            userSession.setTimeLogin(fecha);
            //userSession.setHost(getHost());
            //userSession.setIp(getIp());
            userSession.setUser(usuario);
            return userSession;
        }
        return null;
    }

    public String getIp() {
        HttpServletRequest request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
        String ip = request.getHeader("X-FORWARDED-FOR");  
        if (ip == null) {  
                ip = request.getRemoteAddr();
        }
        return ip;
    }
  
    public String getHost() {
        HttpServletRequest request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
        String host = request.getRemoteHost();
        return host;
    }

    protected FacesContext getFacesContext() {
            return FacesContext.getCurrentInstance();	
    }

    protected Application getApplication() {
            return getFacesContext().getApplication();
    }
    
    private String getMD5(String msg) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            //log.debug("Error al obtener hash MD5. " + ex.getMessage());
        }
        if (md != null) {

                // codigo + rol + clave
            md.update(msg.getBytes());
            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return (sb.toString()).toUpperCase();
        }
        return null;
    }    

    public List<Object> findByNativeQuery(String queryString, Map<String, Object> parameters) {
        EntityManager em = getEntityManager();

        Query query = em.createNativeQuery(queryString);
        if (parameters != null && !parameters.isEmpty()) {
            populateQueryParameters(query, parameters);
        }
        List<Object> result = query.getResultList();
        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

    protected Object getData(String nameQuery, String errorMessage, Params... params) {
        Object ejb;
        Query query;
        try {
            query = getEntityManager().createNamedQuery(nameQuery + ".findByCodigo");
            for (int i = 0; i < params.length; i++) {
                query.setParameter((String) params[i].getField(), params[i].getFieldValue());
            }
            ejb = query.getSingleResult();
        } catch (NoResultException ex) {
            throw new py.com.oym.ws.exceptions.JpaNoExist(errorMessage);
        }
        return ejb;
    }
    
    protected Object getData(Class<?> clase, Object id){
        Object ejb;
        Query query;
        
        try {
            ejb = getEntityManager().find(clase, id);
        } catch (Exception ex) {
            throw new py.com.oym.ws.exceptions.JpaNoExist("No existe entidad");
        }
        return ejb;
    }    
}
