/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.ArrayList;
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
import javax.ws.rs.core.MediaType;
import py.com.oym.model.views.CtactemovimientoView;
import py.com.oym.model.views.CtactemovimientodetalleView;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author mtrinidad
 */
@Stateless
@Path("")
public class CtactemovimientodetalleViewREST extends AbstractFacade<CtactemovimientodetalleView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    Date fechaini;
    Date fechafin;

    List<CtactemovimientodetalleView> resultList;

    public CtactemovimientodetalleViewREST() {
        super(CtactemovimientodetalleView.class);
    }

    @OPTIONS
    @Path("documentos/ctactemovimientodetalle/{id}")
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @GET
    @Path("documentos/ctactemovimientodetalle/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CtactemovimientodetalleView find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * COBROS DETALLES
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/cobrosdetalle/{from}/{to}")
    @Produces({"application/json"})
    public String option5() {
        return "";
    }

    @GET
    @Path("documentos/cobrosdetalle/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangeCobranzaAll(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdempresaDocumento")
                    .setParameter("idempresa", super.getIdempresa())
                    .setParameter("iddocumento", "CO")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    @OPTIONS
    @Path("documentos/cobrosdetalle/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option2() {
        return "";
    }

    @GET
    @Path("documentos/cobrosdetalle/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangeCobranza(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByRefDocumento")
                    .setParameter("search", "%" + search.trim() + "%")
                    .setParameter("searchExact", search.trim())
                    .setParameter("iddocumento", "CO")
                    .setParameter("idempresa", super.getIdempresa())
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    @OPTIONS
    @Path("clientes/cobrosdetalle/{idctacte}")
    @Produces({"application/json"})
    public String option6() {
        return "";
    }

    @GET
    @Path("clientes/cobrosdetalle/{idctacte}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangeCobranzaIdctacte(
            @PathParam("idctacte") Long idctacte,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            result = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdctacte")
                    .setParameter("idctacte", idctacte)
                    .setParameter("iddocumento", "CO")
                    .getResultList();

            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    /**
     * COBROS POR CLIENTE
     *
     * @return
     */
    @OPTIONS
    @Path("clientes/cobrosdetalle/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public String option6a() {
        return "";
    }

    @GET
    @Path("clientes/cobrosdetalle/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findCobranzaByIdctacte(
            @PathParam("idctacte") Long idctacte,
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdctacte")
                    .setParameter("idctacte", idctacte)
                    .setParameter("iddocumento", "CO")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

             result = query.getResultList();

            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    /**
     * PAGOS DETALLES
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/pagosdetalle/{from}/{to}")
    @Produces({"application/json"})
    public String option4() {
        return "";
    }

    @GET
    @Path("documentos/pagosdetalle/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangePagoAll(
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdempresaDocumento")
                    .setParameter("idempresa", super.getIdempresa())
                    .setParameter("iddocumento", "PP")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    @OPTIONS
    @Path("documentos/pagosdetalle/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option3() {
        return "";
    }

    @GET
    @Path("documentos/pagosdetalle/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangePago(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByRefDocumento")
                    .setParameter("search", "%" + search.trim() + "%")
                    .setParameter("searchExact", search.trim())
                    .setParameter("iddocumento", "PP")
                    .setParameter("idempresa", super.getIdempresa())
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    @OPTIONS
    @Path("proveedor/pagosdetalle/{idctacte}")
    @Produces({"application/json"})
    public String option7() {
        return "";
    }

    @GET
    @Path("proveedor/pagosdetalle/{idctacte}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangePagosIdctacte(
            @PathParam("idctacte") Long idctacte,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            result = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdctacte")
                    .setParameter("idctacte", idctacte)
                    .setParameter("iddocumento", "PP")
                    .getResultList();

            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    
     /**
     * PAGOS POR PROVEEDOR
     *
     * @return
     */
    @OPTIONS
    @Path("proveedor/pagosdetalle/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public String option7a() {
        return "";
    }

    @GET
    @Path("proveedor/pagosdetalle/{idctacte}/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangePagosByIdctacte(
            @PathParam("idctacte") Long idctacte,
            @PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            result = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdctacte")
                    .setParameter("idctacte", idctacte)
                    .setParameter("iddocumento", "PP")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1)
                    .getResultList();

            resultList = resolveFecha(result);
        } catch (NoResultException e) {
            return null;
        }
        return resultList;
    }

    @OPTIONS
    @Path("documentos/ctactemovimientoview/{idctactemovimiento}")
    @Produces({"application/json"})
    public String option9() {
        return "";
    }

    @GET
    @Path("documentos/ctactemovimientoview/{idctactemovimiento}")
    @Produces({"application/json"})
    public CtactemovimientoView findCtactemovByIdctactemov(
            @PathParam("idctactemovimiento") Long idctactemovimiento,
            @HeaderParam("token") String token) {
        setToken(token);
        CtactemovimientoView result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientoView.findByIdctactemovimiento")
                    .setParameter("idctactemovimiento", idctactemovimiento);

            result = (CtactemovimientoView) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    @OPTIONS
    @Path("documentos/ctactemovimientodetalleview/{idctactemovimiento}")
    @Produces({"application/json"})
    public String option10() {
        return "";
    }

    @GET
    @Path("documentos/ctactemovimientodetalleview/{idctactemovimiento}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findCtactemovdetByIdctactemov(
            @PathParam("idctactemovimiento") Long idctactemovimiento,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtactemovimientodetalleView> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdctactemovimiento")
                    .setParameter("idctactemovimiento", idctactemovimiento);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    /**
     * DOCUMENTOS COBROS
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/cobranzas/{from}/{to}")
    @Produces({"application/json"})
    public String option8() {
        return "";
    }

    @GET
    @Path("documentos/cobranzas/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientoView> findRangeCobranza(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtactemovimientoView> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientoView.findByIdempresaDocumento")
                    .setParameter("idempresa", super.getIdempresa())
                    .setParameter("iddocumento", "CO")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    @OPTIONS
    @Path("documentos/cobranzas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option19() {
        return "";
    }

    @GET
    @Path("documentos/cobranzas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<CtactemovimientoView> findRangeCobranzaSearch(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtactemovimientoView> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientoView.findByRefDocumento")
                    .setParameter("search", "%" + search.trim() + "%")
                    .setParameter("searchExact", search.trim())
                    .setParameter("iddocumento", "CO")
                    .setParameter("idempresa", super.getIdempresa())
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    @OPTIONS
    @Path("documentos/cobranzas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String option11() {
        return "";
    }

    @GET
    @Path("documentos/cobranzas/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<CtactemovimientoView> findRangeCobranzaSearchAnhoMes(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtactemovimientoView> result;
        try {

            calculateRangeFecha(anho, mes);

            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientoView.findByRefDocumentoFecha")
                    .setParameter("search", "%" + search.trim() + "%")
                    .setParameter("searchExact", search.trim())
                    .setParameter("fechaini", fechaini)
                    .setParameter("fechafin", fechafin)
                    .setParameter("idempresa", super.getIdempresa())
                    .setParameter("iddocumento", "CO")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    /**
     * DOCUMENTOS PAGOS
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/pagos/{from}/{to}")
    @Produces({"application/json"})
    public String option20() {
        return "";
    }

    @GET
    @Path("documentos/pagos/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientoView> findRangePagos(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtactemovimientoView> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientoView.findByIdempresaDocumento")
                    .setParameter("idempresa", super.getIdempresa())
                    .setParameter("iddocumento", "PP")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    @OPTIONS
    @Path("documentos/pagos/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option12() {
        return "";
    }

    @GET
    @Path("documentos/pagos/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<CtactemovimientoView> findRangePagosSearch(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtactemovimientoView> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientoView.findByRefDocumento")
                    .setParameter("search", "%" + search.trim() + "%")
                    .setParameter("searchExact", search.trim())
                    .setParameter("idempresa", super.getIdempresa())
                    .setParameter("iddocumento", "PP")
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    @OPTIONS
    @Path("documentos/pagos/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String option13() {
        return "";
    }

    @GET
    @Path("documentos/pagos/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<CtactemovimientoView> findRangePagoSearchAnhoMes(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtactemovimientoView> result;
        try {

            calculateRangeFecha(anho, mes);

            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientoView.findByRefDocumentoFecha")
                    .setParameter("search", "%" + search.trim() + "%")
                    .setParameter("searchExact", search.trim())
                    .setParameter("fechaini", fechaini)
                    .setParameter("fechafin", fechafin)
                    .setParameter("idempresa", super.getIdempresa())
                    .setParameter("iddocumento", "PP")
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
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    protected void calculateRangeFecha(Integer anho, String mes) {
        Calendar cal = Calendar.getInstance();
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

    protected List<CtactemovimientodetalleView> resolveFecha(List<Object[]> result) {
        resultList = new ArrayList<>();
        CtactemovimientodetalleView row;
        for (int i = 0; i < result.size(); i++) {
            Date fecha = (Date) result.get(i)[1];
            row = (CtactemovimientodetalleView) result.get(i)[0];
            row.setFecha(fecha);
            resultList.add(row);
        }
        return resultList;
    }

    @Override
    protected UserSession getUserSession(String key) {
        UserSession userSession = sesiones.getUserSession(key);
        return userSession;
    }

}
