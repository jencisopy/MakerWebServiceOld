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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import py.com.oym.model.tables.Ctactereferido;
import py.com.oym.ws.model.ReturnMessage;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("ctactereferido")
public class CtactereferidoREST extends AbstractFacade<Ctactereferido> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;
    
    @Inject
    private Sesiones sesiones;
    

    public CtactereferidoREST() {
        super(Ctactereferido.class);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(Ctactereferido entity,
            @HeaderParam("token") String token) {
        setToken(token);
        entity.setIdempresa(getIdempresa());        
        getEntityManager().persist(entity);
        // Retornar valor
        ReturnMessage returnMsg = new ReturnMessage();
        returnMsg.setId(entity.getIdctactereferido().toString());
        return Response.ok().entity(returnMsg).build(); 
    }        

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Ctactereferido findById(@PathParam("id") Long id,
            @HeaderParam("token") String token) {
        setToken(token);
        return super.find(id);
    }


    @GET
    @Produces({"application/json"})
    public List<Ctactereferido> find(@HeaderParam("token") String token) {
        setToken(token);
        return super.findAll();
    }
    

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Ctactereferido> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    protected UserSession getUserSession(String key) {
        UserSession userSession = sesiones.getUserSession(key);
        return userSession;
    }    
}
