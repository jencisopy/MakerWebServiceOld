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
import py.com.oym.model.views.CtacteretencionView;
import py.com.oym.model.views.CtacteretenciondetalleView;
import py.com.oym.ws.model.UserSession;

@Stateless
@Path("")
public class CtacteretencionViewREST extends AbstractFacade<CtacteretenciondetalleView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    Date fechaini;
    Date fechafin;

    List<CtacteretenciondetalleView> resultList;

    public CtacteretencionViewREST() {
        super(CtacteretenciondetalleView.class);
    }

    /**
     * Cabecera de la Retencion, tiene los datos de la cabecera de la retención
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/ctacteretencionview/{idctactemovimiento}")
    @Produces({"application/json"})
    public String cabeceraretencion() {
        return "";
    }

    @GET
    @Path("documentos/ctacteretencionview/{idctactemovimiento}")
    @Produces({"application/json"})
    public CtacteretencionView findCtacteretByIdctactemov(
            @PathParam("idctactemovimiento") Long idctactemovimiento,
            @HeaderParam("token") String token) {
        setToken(token);
        CtacteretencionView result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtacteretencionView.findByIdctactemovimiento")
                    .setParameter("idctactemovimiento", idctactemovimiento);

            result = (CtacteretencionView) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    /**
     * Detalle de la Retención, tiene los datos de los detalles de la retención
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/ctacteretenciondetalleview/{idctactemovimiento}")
    @Produces({"application/json"})
    public String detalleteretencion() {
        return "";
    }

    @GET
    @Path("documentos/ctacteretenciondetalleview/{idctactemovimiento}")
    @Produces({"application/json"})
    public List<CtacteretenciondetalleView> findCtacteretdetByIdctactemov(
            @PathParam("idctactemovimiento") Long idctactemovimiento,
            @HeaderParam("token") String token) {
        setToken(token);
        List<CtacteretenciondetalleView> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtacteretenciondetalleView.findByIdctactemovimiento")
                    .setParameter("idctactemovimiento", idctactemovimiento);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    /**
     * DOCUMENTOS RETENCION PROVEEDOR
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/retencionproveedor/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String retencionproveedor() {
        return "";
    }

    @GET
    @Path("documentos/retencionproveedor/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<CtacteretencionView> findRangeRetencionProveedorSearchAnhoMes(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);

        return findCtacteRetencion("RP", null, anho, mes, from, to, search);

    }

    /**
     * DOCUMENTOS RETENCION CLIENTE
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/retencioncliente/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String retencioncliente() {
        return "";
    }

    @GET
    @Path("documentos/retencioncliente/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<CtacteretencionView> findRangeRetencionClienteSearchAnhoMes(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);

        return findCtacteRetencion("RC", null, anho, mes, from, to, search);

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

    protected List<CtacteretencionView> findCtacteRetencion(String iddocumento,
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
            if (search != null) {
                if (search.trim().isEmpty()) {
                    search = null;
                }
            }
            String sql = "SELECT i FROM CtacteretencionView i "
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
            Query query = em.createQuery(sql + " order by i.fecha desc, secuencia, nro desc")
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

            return (List<CtacteretencionView>) query
                    .setFirstResult(from)
                    .setMaxResults(to - from + 1)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
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

    protected List<CtacteretenciondetalleView> resolveFecha(List<Object[]> result) {
        resultList = new ArrayList<>();
        CtacteretenciondetalleView row;
        for (int i = 0; i < result.size(); i++) {
            Date fecha = (Date) result.get(i)[1];
            row = (CtacteretenciondetalleView) result.get(i)[0];
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
