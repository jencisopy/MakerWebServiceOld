/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.Base64;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.oym.model.tables.GiLoteMejora;
import py.com.oym.ws.model.ReturnMessage;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author mtrinidad
 */
@Stateless
@Path("lotemejora")
public class GiLoteMejoraFacadeREST extends AbstractFacade<GiLoteMejora> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    public GiLoteMejoraFacadeREST() {
        super(GiLoteMejora.class);
    }

    @POST
    @Path("upload")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(GiLoteMejora entity,
            @HeaderParam("token") String token) {

        setToken(token);
        byte[] imageByteArray = Base64.getDecoder().decode(entity.getDocumentoBase64());
        entity.setFoto(imageByteArray);
        super.create(entity);
        ReturnMessage returnMsg = new ReturnMessage();
        returnMsg.setId(entity.getIdgiLoteMejora().toString());
        return Response.ok().entity(returnMsg).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, GiLoteMejora entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public GiLoteMejora find(@PathParam("id") Long id) {
        return super.find(id);
    }

    
    @OPTIONS
    @Path("list/{idgilote}")
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @GET
    @Path("list/{idgilote}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<GiLoteMejora> findByIdlote(@HeaderParam("token") String token,
                                            @PathParam("idgilote") Long idgilote) {
        List<GiLoteMejora> list;
        setToken(token);
        list = getEntityManager().
                createNamedQuery("GiLoteMejoraSinfoto.findByIdlote").
                setParameter("idgilote", idgilote).
                getResultList();

        return list;
    }


    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<GiLoteMejora> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
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
