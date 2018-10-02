/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
import org.apache.log4j.Logger;
import py.com.oym.model.tables.Documentlink;
import py.com.oym.model.tables.DocumentlinkPK;
import py.com.oym.model.tables.GiLoteMejora;
import py.com.oym.model.tables.GiLoteMejoraSinfoto;
import py.com.oym.ws.model.ReturnMessage;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author mtrinidad
 */
@Stateless
@Path("lotemejora")
public class GiLoteMejoraREST extends AbstractFacade<GiLoteMejora> {
    private static final Logger LOGGER  = Logger.getLogger(GiLoteMejoraREST.class);
    
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    public GiLoteMejoraREST() {
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
        
        Query query;
        query = em.createNativeQuery("SELECT documentlinkpath "
                + " from datos.empresaparam "
                + " where idempresa = " + getIdempresa());

        String documentLinkPath = ((Object) query.getSingleResult()).toString().trim();
        String fileName, fileSystemName;

        fileName = "mejora_"+entity.getIdgiLoteMejora().toString() + ".jpg";
        fileSystemName = documentLinkPath+"\\mejora_" + entity.getIdgiLoteMejora().toString() + "_" + entity.getIdgiLote() + "_gi_lote.jpg";
        Documentlink documentLink = new Documentlink();
        DocumentlinkPK documentLinkPK = new DocumentlinkPK();
        documentLinkPK.setArchivo(fileName);
        documentLinkPK.setId(entity.getIdgiLote());
        documentLinkPK.setTabla("gi_lote");
        documentLink.setDocumentlinkPK(documentLinkPK);

        OutputStream out = null;

        try {
            out = new BufferedOutputStream(new FileOutputStream(fileSystemName));
            out.write(imageByteArray);
        } catch (IOException ex) {
            LOGGER.error(ex.getCause());
            throw new py.com.oym.ws.exceptions.LoteEstado("Error al guardar archivo de imagen");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    LOGGER.error(ex.getCause());
                    throw new py.com.oym.ws.exceptions.LoteEstado("Error al cerrar archivo de imagen");
                }
            }
        }
        em.persist(documentLink);
        
        entity.setIdDocumentlink(documentLink.getDocumentlinkPK().getId());
        em.merge(entity);
        
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
    public List<GiLoteMejoraSinfoto> findByIdlote(@HeaderParam("token") String token,
            @PathParam("idgilote") Long idgilote) {
        List<GiLoteMejoraSinfoto> list;
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
