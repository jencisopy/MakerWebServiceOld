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
import py.com.oym.model.views.GiFraccionView;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("gifraccionview")
public class GiFraccionREST extends AbstractFacade<GiFraccionView> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;
    
    @Inject
    private Sesiones sesiones;
    
    
    public GiFraccionREST() {
        super(GiFraccionView.class);
    }

    @OPTIONS
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @OPTIONS
    @Path("{id}")
    @Produces({"application/json"})
    public String optionId() {
        return "";
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public GiFraccionView findById(@PathParam("id")     Long   id,
                                   @HeaderParam("token") String token) {
        setToken(token);                
        return super.find(id);
    }
    

    @GET
    @Produces({"application/json"})
    public List<GiFraccionView> find(@HeaderParam("token") String token,
                                     @QueryParam("codigo") Long codigo,
                                     @QueryParam("dpto")  String provincia) {
        setToken(token);        
        if (codigo != null){
            return super.findByCodigo("GiFraccionView.findByCodigo", codigo);
        }
        else if (provincia != null){
            Long idempresa = this.getIdempresa();                    
            return getEntityManager().
                    createNamedQuery("GiFraccionView.findByProvincia").
                    setParameter("idempresa", idempresa).
                    setParameter("provincia", provincia).
                    getResultList();        
        }
        return super.findAll();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<GiFraccionView> findRange(@PathParam("from") Integer from,
                                          @PathParam("to")   Integer to,
                                          @HeaderParam("token") String token) {
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
