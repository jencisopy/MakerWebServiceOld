/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import py.com.oym.model.views.ItemproductoView;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("itemproductoview")
public class ItemproductoViewREST extends AbstractFacade<ItemproductoView> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;
    
    @Inject
    private Sesiones sesiones;


    public ItemproductoViewREST() {
        super(ItemproductoView.class);
    }

    
    @OPTIONS
    @Produces({"application/json"})
    public String option() {
        return "";
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public ItemproductoView find(@PathParam("id")     Long   id,
                           @HeaderParam("token") String token) {
        setToken(token);
        return super.find(id);
    }
    

    @GET
    @Produces({"application/json"})
    public List<ItemproductoView> find(@HeaderParam("token") String token,
                                 @QueryParam("codigo") String codigo) {
        setToken(token);        
        if (codigo != null){
            return super.findByCodigo("ItemproductoView.findByCodigo", codigo);
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
    public List<ItemproductoView> findRange(@PathParam("from") Integer from, 
                                      @PathParam("to") Integer to,
                                      @HeaderParam("token") String token) {
        setToken(token);
        List<ItemproductoView> result = new ArrayList();
        try {
            Query query = getEntityManager()
                                .createNamedQuery("ItemproductoView.findAll")
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
    public List<ItemproductoView> findRange(@PathParam("from") Integer from, 
                                      @PathParam("to") Integer to,
                                      @PathParam("search") String search,
                                      @HeaderParam("token") String token) {
        setToken(token);
        List<ItemproductoView> result = new ArrayList();
        try {
            Query query = getEntityManager()
                                .createNamedQuery("ItemproductoView.findByCodeAndName")
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
    protected UserSession getUserSession(String key){
        UserSession userSession = sesiones.getUserSession(key);
        return userSession;
    }
}
