/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import py.com.oym.model.views.GiManzanaView;
import py.com.oym.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("gimanzanaview")
public class GiManzanaREST extends AbstractFacade<GiManzanaView> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;
    

    public GiManzanaREST() {
        super(GiManzanaView.class);
    }

    @OPTIONS
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @OPTIONS
    @Path("{id}")    
    @Produces({"application/json"})
    public String option2() {
        return "";
    }

    @OPTIONS
    @Path("fraccion/{id}")
    @Produces({"application/json"})
    public String option3() {
        return "";
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public GiManzanaView findById(@PathParam("id")     Long   id,
                                  @HeaderParam("token") String token) {
        setToken(token);                        
        return super.find(id);
    }

    @GET
    @Path("fraccion/{id}")
    @Produces({"application/json"})
    public List<GiManzanaView> findByIdFraccion(@PathParam("id")     Long idgiFraccion,
                                                @HeaderParam("token") String token) {
        setToken(token);                        
        return getEntityManager().
                createNamedQuery("GiManzanaView.findByIdgiFraccion").
                    setParameter("idgiFraccion", idgiFraccion).
                    getResultList();        

    }

    @GET
    @Produces({"application/json"})
    public List<GiManzanaView> find(@QueryParam("fraccion")  Long fraccion,
                                    @QueryParam("manzana")   String manzana,
                                    @HeaderParam("token")    String token) {
        setToken(token);                        
        Long idempresa = this.getIdempresa();
        if (fraccion != null && manzana != null){
            return getEntityManager().
                    createNamedQuery("GiManzanaView.findByCodigo").
                        setParameter("idempresa",  idempresa).
                        setParameter("giFraccion", fraccion).
                        setParameter("codigo",     manzana).
                        getResultList();        
        }
        else if (fraccion != null){
            return getEntityManager().
                    createNamedQuery("GiManzanaView.findByGiFraccion").
                        setParameter("idempresa", idempresa).
                        setParameter("giFraccion",fraccion).
                        getResultList();        
        }
        return super.findAll();
    }

    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<GiManzanaView> findRange(@PathParam("from")   Integer from,
                                         @PathParam("to")     Integer to,
                                         @HeaderParam("token") String  token) {
        setToken(token);                        
        return super.findRange(new int[]{from, to});
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
