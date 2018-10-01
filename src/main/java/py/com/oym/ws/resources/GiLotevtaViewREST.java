/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import py.com.oym.model.views.GiLotevtaView;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("gilotevtaview")
public class GiLotevtaViewREST extends AbstractFacade<GiLotevtaView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    public GiLotevtaViewREST() {
        super(GiLotevtaView.class);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public GiLotevtaView findById(@PathParam("id") Long id,
            @HeaderParam("token") String token) {
        setToken(token);
        return super.find(id);
    }

    @GET
    @Produces({"application/json"})
    public List<GiLotevtaView> find(@QueryParam("nro") String nro,
            @HeaderParam("token") String token) {
        setToken(token);
        if (nro != null) {
            return super.findByCodigo("GiLotevtaView.findByCodigo", nro);
        }
        return findByVendedor();
    }

    
    @OPTIONS
    @Path("vendedor")
    @Produces({"application/json"})
    public String option1() {
        return "";
    }

    @OPTIONS
    @Path("vendedor/{from}/{to}")
    @Produces({"application/json"})
    public String option1b() {
        return "";
    }
    
    
    @GET
    @Path("vendedor")
    @Produces({"application/json"})
    public List<GiLotevtaView> findByVendedor(@HeaderParam("token") String token) {
        setToken(token);
        return findByVendedor();
    }

    @GET
    @Path("vendedor/{from}/{to}")
    @Produces({"application/json"})
    public List<GiLotevtaView> findByVendedor(@HeaderParam("token") String token,
                                        @PathParam("from") Integer from, 
                                        @PathParam("to") Integer to) {
        setToken(token);
        return findByVendedor(from, to);
    }
    
    public List<GiLotevtaView> findByVendedor() {
        Long idempresa = this.getIdempresa();
        Long idvendedor = this.getIdVendedor();
        EntityManager em = getEntityManager();
        return (List<GiLotevtaView>) em.createNamedQuery("GiLotevtaView.findByVendedor").
                setParameter("idempresa", idempresa).
                setParameter("idvendedor", idvendedor).getResultList();
    }

    public List<GiLotevtaView> findByVendedor(Integer from, Integer to) {
        Long idempresa = this.getIdempresa();
        Long idvendedor = this.getIdVendedor();
        EntityManager em = getEntityManager();
        return (List<GiLotevtaView>) em.createNamedQuery("GiLotevtaView.findByVendedor").
                setParameter("idempresa", idempresa).
                setParameter("idvendedor", idvendedor).
                setFirstResult(from).
                setMaxResults(to).
                getResultList();
    }
    
    @OPTIONS
    @Path("vendedorfecha/{fromDate}/{toDate}")
    @Produces({"application/json"})
    public String option2() {
        return "";
    }
    
    @GET
    @Path("vendedorfecha/{fromDate}/{toDate}")
    @Produces({"application/json"})
    public List<GiLotevtaView> findByVendedorFecha(@PathParam("fromDate") String fromDate,
            @PathParam("toDate") String toDate,
            @HeaderParam("token") String token) throws ParseException {
        setToken(token);
        return findByVendedorFecha(fromDate,toDate);
    }

    public List<GiLotevtaView> findByVendedorFecha(String fromDate, String toDate) throws ParseException {
        Long idempresa = this.getIdempresa();
        Long idvendedor = this.getIdVendedor();
        EntityManager em = getEntityManager();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");

        Date dfromDate = format.parse(fromDate);
        Date dtoDate = format.parse(toDate);

        return (List<GiLotevtaView>) em.createNamedQuery("GiLotevtaView.findByVendedorFecha").
                setParameter("idempresa", idempresa).
                setParameter("fromDate", dfromDate).
                setParameter("toDate", dtoDate).
                setParameter("idvendedor", idvendedor).getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<GiLotevtaView> findRange(@PathParam("from") Integer from,
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
    protected UserSession getUserSession(String key) {
        UserSession userSession = sesiones.getUserSession(key);
        return userSession;
    }
}
