/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.ArrayList;
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

    @OPTIONS
    @Path("documentos/cobranzas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option2() {
        return "";
    }

    @GET
    @Path("documentos/cobranzas/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangeCobranza(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result ;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdctacte")
                    .setParameter("search", search)
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
    @Path("documentos/pagos/{from}/{to}/{search}")
    @Produces({"application/json"})
    public String option3() {
        return "";
    }
    
    @GET
    @Path("documentos/pagos/{from}/{to}/{search}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangePago(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @PathParam("search") String search,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result;
        try {
            Query query = getEntityManager()
                    .createNamedQuery("CtactemovimientodetalleView.findByIdctacte")
                    .setParameter("search", search)
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
    @Path("documentos/cobranzas/{from}/{to}")
    @Produces({"application/json"})
    public String option5() {
        return "";
    }

    @GET
    @Path("documentos/cobranzas/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangeCobranzaAll(@PathParam("from") Integer from,
            @PathParam("to") Integer to,
            @HeaderParam("token") String token) {
        setToken(token);
        List<Object[]> result ;
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
    @Path("documentos/pagos/{from}/{to}")
    @Produces({"application/json"})
    public String option4() {
        return "";
    }

    @GET
    @Path("documentos/pagos/{from}/{to}")
    @Produces({"application/json"})
    public List<CtactemovimientodetalleView> findRangePagoAll(@PathParam("from") Integer from,
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
