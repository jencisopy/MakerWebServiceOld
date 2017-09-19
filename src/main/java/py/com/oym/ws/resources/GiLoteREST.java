/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import py.com.oym.model.tables.GiLote;
import py.com.oym.model.tables.Vendedor;
import py.com.oym.model.tables.GiLoteestado;
import py.com.oym.model.views.GiLoteView;
import py.com.oym.ws.model.ReturnMessage;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("giloteview")
public class GiLoteREST extends AbstractFacade<GiLoteView> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;
    
    @Inject
    private Sesiones sesiones;
    
    
    public GiLoteREST() {
        super(GiLoteView.class);
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

    @OPTIONS
    @Path("findbyfraccion")
    @Produces({"application/json"})
    public String optionByFraccion(){
        return "";
    }
    
    @OPTIONS
    @Path("fraccion/{idfraccion}")
    @Produces({"application/json"})
    public String optionByIdFraccion(){
        return "";
    }    

    @OPTIONS
    @Path("reservar/{id}")
    @Produces({"application/json"})
    public String reservar() {
        return "";
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public GiLoteView findById(@PathParam("id")      Long   id,
                               @HeaderParam("token") String token) {
        setToken(token);                        
        return super.find(id);
    }

    @GET
    @Produces({"application/json"})
    public List<GiLoteView> find(@HeaderParam("token")   String token) {
        setToken(token);                        
        return super.findAll();
    }

    @GET
    @Path("findbyfraccion")
    @Produces({"application/json"})
    public List<GiLoteView> findByFraccion(@QueryParam("fraccion") Long   fraccion,
                                           @QueryParam("estado") String estado, 
                                           @HeaderParam("token")   String token) {
        setToken(token);                        
        Long idempresa = this.getIdempresa();
        return getEntityManager().
                createNamedQuery("GiLoteView.findByGiFraccion").
                    setParameter("idempresa", idempresa).
                    setParameter("giFraccion", fraccion).
                    setParameter("giLoteestado", estado).
                    getResultList();        
    }

    @GET
    @Path("fraccion/{idfraccion}")
    @Produces({"application/json"})
    public List<GiLoteView> findByIdFraccion(@PathParam("idfraccion") Long   idfraccion,
                                             @HeaderParam("token")    String token) {
        setToken(token);                        
        Long idempresa = this.getIdempresa();
        return getEntityManager().
                createNamedQuery("GiLoteView.findByIdgiFraccion").
                    setParameter("idgiFraccion", idfraccion).
                    getResultList();        
    }
    
    @GET
    @Path("{fraccion}/{manzana}/{lote}")
    @Produces({"application/json"})
    public List<GiLoteView> findByCodigo(@PathParam("fraccion")  Long fraccion,
                                         @PathParam("manzana")   String manzana,
                                         @PathParam("lote")      String lote,
                                         @HeaderParam("token")   String token) {
        setToken(token);                        
        Long idempresa = this.getIdempresa();        
        return getEntityManager().
                createNamedQuery("GiLoteView.findByCodigo").
                    setParameter("idempresa", idempresa).
                    setParameter("giFraccion", fraccion).
                    setParameter("giManzana",  manzana).
                    setParameter("codigo",     lote).
                    getResultList();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<GiLoteView> findRange(@PathParam("from") Integer from,
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

    @POST
    @Path("reservar/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response reservar(@PathParam("id") Long id,
                             @HeaderParam("token") String token) {
        setToken(token);        
        GiLote lote = em.find(GiLote.class, id);
        if (!(lote.getIdgiLoteestado().getIdgiLoteestado().equals("1")
                || lote.getIdgiLoteestado().getIdgiLoteestado().equals("3"))) {
            throw new py.com.oym.ws.exceptions.LoteEstado("Este lote no esta disponible");
        }
        Vendedor vendedor = em.find(Vendedor.class, getIdVendedor());
        GiLoteestado estado = em.find(GiLoteestado.class,"A");
        String estadoAnterior = lote.getIdgiLoteestado().getIdgiLoteestado();
        lote.setIdgiLoteestado(estado);
        lote.setIdgiLoteestadoAnt(estadoAnterior);
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);        
        calendar.set(Calendar.MILLISECOND,0);        

        Date today = calendar.getTime();

        lote.setFechacambioestado(new Date());
        lote.setFechareserva(today);
        lote.setIdvendedorreserva(vendedor);
        getEntityManager().merge(lote);

        ReturnMessage returnMsg = new ReturnMessage();
        returnMsg.setId(lote.getIdgiLote().toString());
        return Response.ok().entity(returnMsg).build();
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
