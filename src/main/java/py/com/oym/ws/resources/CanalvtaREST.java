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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import py.com.oym.model.views.CanalvtaView;
import py.com.oym.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("canalvtaview")
public class CanalvtaREST extends AbstractFacade<CanalvtaView> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;
    

    public CanalvtaREST() {
        super(CanalvtaView.class);
    }


    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public CanalvtaView findById(@PathParam("id") Long id,
                                 @HeaderParam("token") String token) {
        setToken(token);                
        return super.find(id);
    }



    @GET
    @Produces({"application/json"})
    public List<CanalvtaView> find(@HeaderParam("token") String token,
                                   @QueryParam("codigo") String codigo) {
        setToken(token);        
        if (codigo != null){
            return super.findByCodigo("CanalvtaView.findByCodigo", codigo);
        }
        return super.findAll();
    }
    

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<CanalvtaView> findRange(@PathParam("from") Integer from, 
                                        @PathParam("to") Integer to,
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
