/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.Calendar;
import java.util.Date;
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
import py.com.oym.model.views.ItemmovimientoLightView;
import py.com.oym.model.views.ItemmovimientoView;
import py.com.oym.model.views.ItemmovimientodetalleView;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("")
public class ItemmovimientoViewREST extends AbstractFacade<ItemmovimientoLightView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    Date fechaini;
    Date fechafin;

    public ItemmovimientoViewREST() {
        super(ItemmovimientoLightView.class);
    }

    @OPTIONS
    @Path("clientes/ventas/{idctacte}")
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    
    @OPTIONS
    @Path("clientes/ventas/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public String optionb() {
        return "";
    }
    
    @OPTIONS
    @Path("proveedor/ordenes/{idctacte}")
    @Produces({"application/json"})
    public String option2() {
        return "";
    }
    
    @OPTIONS
    @Path("proveedor/ordenes/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public String option2b() {
        return "";
    }

    @OPTIONS
    @Path("clientes/pedidos/{idctacte}")
    @Produces({"application/json"})
    public String option1() {
        return "";
    }

    @OPTIONS
    @Path("clientes/pedidos/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public String option1b() {
        return "";
    }


    @OPTIONS
    @Path("proveedor/compras/{idctacte}")
    @Produces({"application/json"})
    public String option3() {
        return "";
    }
    
    @OPTIONS
    @Path("proveedor/compras/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public String option3b() {
        return "";
    }

    @OPTIONS
    @Path("documentos/ventas/{from}/{to}")
    @Produces({"application/json"})
    public String option4() {
        return "";
    }

    @OPTIONS
    @Path("documentos/ventas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String docvenfromtosearch() {
        return "";
    }

    @OPTIONS
    @Path("documentos/ventas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String docvenfromtosearchanhomes() {
        return "";
    }

    @OPTIONS
    @Path("documentos/ordenes/{from}/{to}")
    @Produces({"application/json"})
    public String option5() {
        return "";
    }

    @OPTIONS
    @Path("documentos/ordenes/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String docordfromtosearch() {
        return "";
    }

    @OPTIONS
    @Path("documentos/ordenes/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String docordfromtosearchanhomes() {
        return "";
    }

    @OPTIONS
    @Path("documentos/pedidos/{from}/{to}")
    @Produces({"application/json"})
    public String option6() {
        return "";
    }

    @OPTIONS
    @Path("documentos/pedidos/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String docpedfromtosearch() {
        return "";
    }

    @OPTIONS
    @Path("documentos/pedidos/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String docpedfromtosearchanhomes() {
        return "";
    }

    @OPTIONS
    @Path("documentos/compras/{from}/{to}")
    @Produces({"application/json"})
    public String option7() {
        return "";
    }

    @OPTIONS
    @Path("documentos/compras/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String doccomfromtosearch() {
        return "";
    }

    @OPTIONS
    @Path("documentos/compras/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String doccomfromtosearchanhomes() {
        return "";
    }
    
    @OPTIONS
    @Path("documentos/envios/{from}/{to}")
    @Produces({"application/json"})
    public String option8() {
        return "";
    }

    @OPTIONS
    @Path("documentos/envios/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option8b() {
        return "";
    }

    @OPTIONS
    @Path("documentos/envios/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String option8c() {
        return "";
    }
    
     @OPTIONS
    @Path("documentos/entradas/{from}/{to}")
    @Produces({"application/json"})
    public String option9() {
        return "";
    }

    @OPTIONS
    @Path("documentos/entradas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option9b() {
        return "";
    }

    @OPTIONS
    @Path("documentos/entradas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String option9c() {
        return "";
    }
    
     @OPTIONS
    @Path("documentos/salidas/{from}/{to}")
    @Produces({"application/json"})
    public String option10() {
        return "";
    }

    @OPTIONS
    @Path("documentos/salidas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option10b() {
        return "";
    }

    @OPTIONS
    @Path("documentos/salidas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String option10c() {
        return "";
    }
    
    @OPTIONS
    @Path("documentos/itemmovimientoview/{iditemmovimiento}")
    @Produces({"application/json"})
    public String option11c() {
        return "";
    }
    
    @OPTIONS
    @Path("documentos/itemmovimientodetalleview/{iditemmovimiento}")
    @Produces({"application/json"})
    public String option12c() {
        return "";
    }
    

    @GET
    @Path("clientes/ventas/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findFacturas(@PathParam("idctacte") Long idctacte,
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("V", idctacte, null, null, from, to, null);
    }

    @GET
    @Path("clientes/pedidos/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findPedidos(@PathParam("idctacte") Long idctacte,
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("VP", idctacte, null, null, from, to, null);
    }

    @GET
    @Path("documentos/pedidos/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findPedidosRango(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("VP", null, null, null, from, to, null);
    }

    @GET
    @Path("documentos/pedidos/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findPedidosRangoSearch(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("VP", null, null, null, from, to, search);
    }

    @GET
    @Path("documentos/pedidos/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findPedidosRangoSearchAnhoMes(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("VP", null, anho, mes, from, to, search);
    }

    @GET
    @Path("documentos/ventas/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findFacturasRango(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("V", null, null, null, from, to, null);
    }

    @GET
    @Path("documentos/ventas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findFacturasRangoSearch(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("V", null, null, null, from, to, search);
    }

    @GET
    @Path("documentos/ventas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findFacturasRangoSearchFecha(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("V", null, anho, mes, from, to, search);
    }

    @GET
    @Path("documentos/entradas/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findEntradasRango(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("E", null, null, null, from, to, null);
    }

    @GET
    @Path("documentos/entradas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findEntradasRangoSearch(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("E", null, null, null, from, to, search);
    }

    @GET
    @Path("documentos/entradas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findEntradasRangoSearchAnhomes(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("E", null, anho, mes, from, to, search);
    }

    @GET
    @Path("documentos/salidas/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findSalidasRango(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("S", null, null, null, from, to, null);
    }

    @GET
    @Path("documentos/salidas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findSalidasRangoSearch(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("S", null, null, null, from, to, search);
    }

    @GET
    @Path("documentos/salidas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findSalidasRangoSearchAnhomes(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("S", null, anho, mes, from, to, search);
    }

    @GET
    @Path("documentos/envios/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findEnviosRango(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("EN", null, null, null, from, to, null);
    }

    @GET
    @Path("documentos/envios/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findEnviosRangoSearch(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("EN", null, null, null, from, to, search);
    }

    @GET
    @Path("documentos/envios/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findEnviosRangoSearchAnhomes(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("EN", null, anho, mes, from, to, search);
    }

    @GET
    @Path("documentos/ordenes/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findOrdenesRango(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("COR", null, null, null, from, to, null);
    }

    @GET
    @Path("documentos/ordenes/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findOrdenesRangoSearch(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("COR", null, null, null, from, to, search);
    }

    @GET
    @Path("documentos/ordenes/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findOrdenesRangoSearchAnhoMes(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("COR", null, anho, mes, from, to, search);
    }

    @GET
    @Path("documentos/compras/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findComprasRango(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("C", null, null, null, from, to, null);
    }

    @GET
    @Path("documentos/compras/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findComprasRangoSearch(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("C", null, null, null, from, to, search);
    }

    @GET
    @Path("documentos/itemmovimientoview/{iditemmovimiento}")
    @Produces({"application/json"})
    public ItemmovimientoView findItemmovimientoviewbyId(
            @PathParam("iditemmovimiento") Long iditemmovimiento,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmovView(iditemmovimiento);
    }
    
    @GET
    @Path("documentos/itemmovimientodetalleview/{iditemmovimiento}")
    @Produces({"application/json"})
    public List<ItemmovimientodetalleView> findItemmovimientodetalleviewbyIditemmovimiento(
            @PathParam("iditemmovimiento") Long iditemmovimiento,
            @HeaderParam("token") String token) {
        setToken(token);

            Query query = getEntityManager()
                    .createNamedQuery("ItemmovimientodetalleView.findByIditemmovimiento")
                    .setParameter("iditemmovimiento", iditemmovimiento);

            List<ItemmovimientodetalleView> result = query.getResultList();
        
        return result;
    }
    @GET
    @Path("documentos/compras/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findComprasRangoSearchAnhomes(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("C", null, anho, mes, from, to, search);
    }

    @GET
    @Path("proveedor/ordenes/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findOrdenes(@PathParam("idctacte") Long idctacte,
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("COR", idctacte, null, null, from, to, null);
    }

    @GET
    @Path("proveedor/compras/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findCompras(@PathParam("idctacte") Long idctacte,
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        return findItemmov("C", idctacte, null, null, from, to, null);
    }

    protected ItemmovimientoView findItemmovView(Long iditemmovimiento) {
        try {
            String sql = "SELECT i FROM ItemmovimientoView i "
                    + "where i.idempresa = :idempresa "
                    + "and i.iditemmovimiento = :iditemmovimiento "
                    + "and i.confirmado = 1 "
                    + "and i.anulado = 0 ";

            Query query = em.createQuery(sql + " order by i.fecha desc, secuencia, nro")
                    .setParameter("iditemmovimiento", iditemmovimiento)
                    .setParameter("idempresa", super.getIdempresa());
            
            return (ItemmovimientoView) query
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }        
    }
    protected List<ItemmovimientoLightView> findItemmov(String iddocumento,
            Long idctacte,
            Integer anho,
            String mes,
            Integer from,
            Integer to,
            String search) {
        try {
            if (anho != null) {
                calculateRangeFecha(anho, mes);
            }
            if (search != null){
                if (search.trim().isEmpty()){
                    search = null;
                }
            }
            String sql = "SELECT i FROM ItemmovimientoLightView i "
                    + "where i.idempresa = :idempresa "
                    + "and i.iddocumento = :iddocumento "
                    + "and i.confirmado = 1 "
                    + "and i.anulado = 0 ";

            if (idctacte != null) {
                sql += " and i.idctacte = :idctacte";
            }
            if (search != null) {
                sql += " and (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact)";
            }
            if (anho != null) {
                sql += " and i.fecha between :fechaini and :fechafin";
            }
            Query query = em.createQuery(sql + " order by i.fecha desc, secuencia, nro")
                    .setParameter("iddocumento", iddocumento)
                    .setParameter("idempresa", super.getIdempresa());

            if (idctacte != null) {
                query.setParameter("idctacte", idctacte);
            }

            if (search != null) {
                query.setParameter("search", "%" + search.trim() + "%")
                        .setParameter("searchExact", search.trim());

            }
            if (anho != null) {
                query.setParameter("fechaini", fechaini)
                        .setParameter("fechafin", fechafin);
            }

            return (List<ItemmovimientoLightView>) query
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected void calculateRangeFecha(Integer anho, String mes) {
        Calendar cal = Calendar.getInstance();
        // Si mes = * entonces es todo el año
        if ("*".equals(mes)) {
            cal.set(anho, 0, 1, 0, 0, 0);
            fechaini = cal.getTime();
            cal.set(anho, 11, 31, 23, 59, 59);
            fechafin = cal.getTime();
        } else {
            cal.set(anho, Integer.parseInt(mes) - 1, 1, 0, 0, 0);
            fechaini = cal.getTime();
            cal.set(anho, Integer.parseInt(mes) - 1, 1, 23, 59, 59);
            cal.add(Calendar.MONTH, +1);
            cal.add(Calendar.DATE, -1);
            fechafin = cal.getTime();
        }
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
