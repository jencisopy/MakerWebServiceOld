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
import py.com.oym.model.views.ItemmovplnView;
import py.com.oym.model.views.ItemmovplndetalleView;
import py.com.oym.ws.model.UserSession;

@Stateless
@Path("")
public class ItemmovplnViewREST extends AbstractFacade<ItemmovplndetalleView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    Date fechaini;
    Date fechafin;

    List<ItemmovplndetalleView> resultList;

    public ItemmovplnViewREST() {
        super(ItemmovplndetalleView.class);
    }

    /**
     * Cabecera de la Planilla de Fondo Fijo.
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/itemmovplnview/{iditemmovpln}")
    @Produces({"application/json"})
    public String cabecerafondofijo() {
        return "";
    }

    @GET
    @Path("documentos/itemmovplnview/{iditemmovpln}")
    @Produces({"application/json"})
    public ItemmovplnView findItemmovplnByIditemmovpln(
            @PathParam("iditemmovpln") Long iditemmovpln,
            @HeaderParam("token") String token) {
        setToken(token);
        ItemmovplnView result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("ItemmovplnView.findByIditemmovpln")
                    .setParameter("iditemmovpln", iditemmovpln);

            result = (ItemmovplnView) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    /**
     * Detalle de la Planilla de Fondo Fijo.
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/itemmovplndetalleview/{iditemmovpln}")
    @Produces({"application/json"})
    public String detallefondofijo() {
        return "";
    }

    @GET
    @Path("documentos/itemmovplndetalleview/{iditemmovpln}")
    @Produces({"application/json"})
    public List<ItemmovplndetalleView> findItemMovPlndetByIdItemmovpln(
            @PathParam("iditemmovpln") Long iditemmovpln,
            @HeaderParam("token") String token) {
        setToken(token);
        List<ItemmovplndetalleView> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("ItemmovplndetalleView.findByIditemmovpln")
                    .setParameter("iditemmovpln", iditemmovpln);

            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    /**
     * DOCUMENTOS PLANILLA FONDO FIJO
     *
     * @return
     */
    @OPTIONS
    @Path("documentos/fondofijo/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public String fondofijo() {
        return "";
    }

    @GET
    @Path("documentos/fondofijo/{from}/{to}/{search}/{anho}/{mes}")
    @Produces({"application/json"})
    public List<ItemmovplnView> findRangeFondofijoSearchAnhoMes(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @PathParam("anho") Integer anho,
            @PathParam("mes") String mes,
            @HeaderParam("token") String token) {
        setToken(token);

        return findItemMovPln("FF", anho, mes, from, to, search);

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
    //Trae los datos de la Planilla de Fondo Fijo y los puede filtrar por Deposito y Nro.

    protected List<ItemmovplnView> findItemMovPln(String iddocumento,
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
            String sql = "SELECT i FROM ItemmovplnView i "
                    + "where i.idempresa = :idempresa "
                    + "and i.iddocumento = :iddocumento "
                    + "and i.confirmado = 1 "
                    + "and i.anulado = 0 ";

            if (search != null) {
                sql += " and (i.deposito like :search or LOWER(i.depositonombre) like LOWER(:search) "
                        + "or i.concepto like :search or LOWER(i.conceptonombre) like LOWER(:search) "
                        + "or LOWER(i.observacion) like LOWER(:search)  "
                        + "or TRIM(i.nro) = :searchExact)";
            }
            if (anho != null) {
                sql += " and i.fecha between :fechaini and :fechafin";
            }
            Query query = em.createQuery(sql + " order by i.fecha desc, nro desc")
                    .setParameter("iddocumento", iddocumento)
                    .setParameter("idempresa", super.getIdempresa());

            if (search != null) {
                query.setParameter("search", "%" + search.trim() + "%")
                        .setParameter("searchExact", search.trim());

            }
            if (anho != null) {
                query.setParameter("fechaini", fechaini)
                        .setParameter("fechafin", fechafin);
            }

            return (List<ItemmovplnView>) query
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

    protected List<ItemmovplndetalleView> resolveFecha(List<Object[]> result) {
        resultList = new ArrayList<>();
        ItemmovplndetalleView row;
        for (int i = 0; i < result.size(); i++) {
            Date fecha = (Date) result.get(i)[1];
            row = (ItemmovplndetalleView) result.get(i)[0];
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
