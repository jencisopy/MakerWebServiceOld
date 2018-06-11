/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import py.com.oym.others.Params;
import py.com.oym.model.views.ClienteView;
import py.com.oym.model.tables.Ctacte;
import py.com.oym.model.tables.Pais;
import py.com.oym.model.tables.Persona;
import py.com.oym.model.tables.Personafisica;
import py.com.oym.model.views.ClienteLightView;
import py.com.oym.ws.model.ReturnMessage;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("clienteview")
public class ClienteREST extends AbstractFacade<ClienteView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Resource
    EJBContext context;

    @Inject
    private Sesiones sesiones;

    public ClienteREST() {
        super(ClienteView.class);
    }

    @OPTIONS
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response create(ClienteView entity,
            @HeaderParam("token") String token) {
        setToken(token);
        
        // Persona
        Persona persona = new Persona();
        Pais pais = (Pais) getData("Pais", "No existe este país",
                new Params("codigo", "PY"),
                new Params("idempresa", getIdempresa()));
        persona.setIdpais(pais);
        persona.setDocumentotipo("CED");
        persona.setDocumento(entity.getCodigo());
        persona.setNombre(entity.getNombre());
        persona.setTipo((short) 2);
        persona.setRuc(entity.getRuc());
        persona.setTelefono(entity.getTelefono());
        persona.setTelefonocelular(entity.getTelefonocelular());
        persona.setTelefonofax(entity.getTelefonofax());
        persona.setEmail(entity.getEmail());
        persona.setWeb(entity.getWeb());
        persona.setCodigopostal(entity.getCodigopostal());
        
        persona.setInactivo(Boolean.FALSE);
        persona.setIdempresa(getIdempresa());
        persona.setDireccion(entity.getDireccion());

        getEntityManager().persist(persona);

        // Persona fisica
        Personafisica personaFisica = new Personafisica();
        personaFisica.setIdpersona(persona.getIdpersona());
        personaFisica.setApellido(entity.getApellido());
        personaFisica.setEmpresatrabaja(entity.getEmpresatrabaja());
        personaFisica.setDirecciontrabajo(entity.getDirecciontrabajo());
        personaFisica.setTelefonotrabajo(entity.getTelefonotrabajo());
        personaFisica.setSexo(entity.getSexo());
        personaFisica.setEstadocivil(entity.getEstadocivil());
        personaFisica.setIngresomensual(entity.getIngresomensual());
        personaFisica.setEgresomensual(entity.getEgresomensual());
        personaFisica.setFechaingresotrabajo(entity.getFechaingresotrabajo());
        personaFisica.setHijos_cantidad(entity.getHijos_cantidad());
        personaFisica.setFechanacimiento(entity.getFechanacimiento());
        personaFisica.setNacionalidad(entity.getNacionalidad());
        personaFisica.setLugarDeNacimiento(entity.getLugarDeNacimiento());
        //personaFisica.setDebitoautomatico(entity.getDebitoautomatico());
        getEntityManager().persist(personaFisica);
        
        // Ctacte
        Ctacte ctacte = new Ctacte();
        ctacte.setIdpersonatitular(persona);
        ctacte.setCodigo(entity.getCodigo());
        if (entity.getCtactenombre() == null || entity.getCtactenombre().isEmpty()){
            String ctacteNombre = entity.getNombre().trim();
            if (entity.getApellido() != null){
                ctacteNombre += ", "+ entity.getApellido().trim();                
            }
            if (ctacteNombre.length() > 50){
                ctacteNombre = ctacteNombre.substring(0,49);
            }
            entity.setCtactenombre(ctacteNombre);
        }
          
        ctacte.setNombre(entity.getCtactenombre());
        ctacte.setEscliente((short) 1);
        ctacte.setEssocio((short) 0);
        ctacte.setEsproveedor((short) 0);
        ctacte.setRuc(entity.getRuc());
        if (entity.getDireccionctacte() == null || entity.getDireccionctacte().isEmpty()){
            entity.setDireccionctacte(entity.getDireccion());
        }
        ctacte.setDireccionctacte(entity.getDireccionctacte());
        if (entity.getTelefonoctacte() == null || entity.getTelefonoctacte().isEmpty()){
            entity.setTelefonoctacte(entity.getTelefono());
        }
        ctacte.setTelefonoctacte(entity.getTelefonoctacte());
        ctacte.setConyugue(entity.getConyugue());
        ctacte.setConyuguecedula(entity.getConyuguecedula());
        ctacte.setCodeudor(entity.getCodeudor());
        ctacte.setCodeudorcedula(entity.getCodeudorcedula());
        ctacte.setCodeudordireccion(entity.getCodeudordireccion());
        ctacte.setCodeudortelefono(entity.getCodeudortelefono());
        ctacte.setCredito(BigDecimal.ZERO);
        ctacte.setDescuento(BigDecimal.ZERO);
        ctacte.setIdempresa(getIdempresa());
        ctacte.setInactivo(Boolean.FALSE);
        ctacte.setFechaingreso(new Date());
        // Grabar ctacte
        getEntityManager().persist(ctacte);
        // Retornar valor
        ReturnMessage returnMsg = new ReturnMessage();
        returnMsg.setId(ctacte.getIdctacte().toString());
        return Response.ok().entity(returnMsg).build(); 
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public ClienteView findById(@PathParam("id") Long id,
            @HeaderParam("token") String token) {
        setToken(token);
        return super.find(id);
    }

    @GET
    @Produces({"application/json"})
    public List<ClienteView> find(@HeaderParam("token") String token,
            @QueryParam("codigo") String codigo) {
        setToken(token);
        if (codigo != null) {
            return super.findByCodigo("ClienteView.findByCodigo", codigo);
        }
        return super.findAll();
    }


    @OPTIONS
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public String option2() {
        return "";
    }    
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<ClienteLightView> findRange(@PathParam("from") Integer from, 
                                      @PathParam("to") Integer to,
                                      @HeaderParam("token") String token) {
        setToken(token);
        List<ClienteLightView> result = new ArrayList();
        try {
            Query query = getEntityManager()
                                .createNamedQuery("ClienteLightView.findAll")
                                .setParameter("idempresa", getIdempresa())
                                .setFirstResult(from)
                                .setMaxResults(to - from + 1);
                                
            
            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }



    @OPTIONS
    @Path("{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option3() {
        return "";
    }    
    
    @GET
    @Path("{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ClienteLightView> findRange(@PathParam("from") Integer from, 
                                      @PathParam("to") Integer to,
                                      @PathParam("search") String search,
                                      @HeaderParam("token") String token) {
        setToken(token);
        List<ClienteLightView> result = new ArrayList();
        try {
            Query query = getEntityManager()
                                .createNamedQuery("ClienteLightView.findByCodeAndName")
                                .setParameter("idempresa", getIdempresa())
                                .setParameter("nombre", "%"+search+"%")  
                                .setParameter("codigo", "%"+search+"%")  
                                .setFirstResult(from)
                                .setMaxResults(to - from + 1);
                                
            
            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected UserSession getUserSession(String key) {
        UserSession userSession = sesiones.getUserSession(key);
        return userSession;
    }
}

/*
{"codigo":"WEB3",
 "nombre":"WEB SERVICE3",
 "ruc":"WEB3",
 "telefono":"zzzz",
 "email":"jenciso@oym.com.py",
 "empresatrabaja":"OYM",
 "direcciontrabajo":"cap. cristaldo ",
 "telefonotrabajo":"xx"}
*/