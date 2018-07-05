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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import py.com.oym.model.views.ItemmovimientoLightView;
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

    public ItemmovimientoViewREST() {
        super(ItemmovimientoLightView.class);
    }
    
    @OPTIONS
    @Path("clientes/facturas/{idctacte}")    
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @OPTIONS
    @Path("proveedor/ordenes/{idctacte}")    
    @Produces({"application/json"})
    public String option2() {
        return "";
    }
    
    @OPTIONS
    @Path("clientes/pedidos/{idctacte}")
    @Produces({"application/json"})
    public String option1() {
        return "";
    }

    @OPTIONS
    @Path("proveedor/compras/{idctacte}")
    @Produces({"application/json"})
    public String option3() {
        return "";
    }
    
    
    @GET
    @Path("clientes/facturas/{idctacte}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findFacturas(@PathParam("idctacte")     Long   idctacte,
                           @HeaderParam("token") String token) {
        setToken(token);
        return findFacturasByIdctacte(idctacte);
    }

    
    @GET
    @Path("clientes/pedidos/{idctacte}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findPedidos(@PathParam("idctacte")     Long   idctacte,
                           @HeaderParam("token") String token) {
        setToken(token);
        return findPedidosByIdctacte(idctacte);
    }
    
    @GET
    @Path("proveedor/ordenes/{idctacte}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findOrdenes(@PathParam("idctacte")     Long   idctacte,
                           @HeaderParam("token") String token) {
        setToken(token);
        return findOrdenesByIdctacte(idctacte);
    }

    @GET
    @Path("proveedor/compras/{idctacte}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findCompras(@PathParam("idctacte")     Long   idctacte,
                           @HeaderParam("token") String token) {
        setToken(token);
        return findComprasByIdctacte(idctacte);
    }
    
    protected List<ItemmovimientoLightView> findFacturasByIdctacte(Long idctacte) {
        try {
            return (List<ItemmovimientoLightView>) em.createNamedQuery("ItemmovimientoLightView.findFacturasByIdctacte").
                    setParameter("idctacte", idctacte).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected List<ItemmovimientoLightView> findPedidosByIdctacte(Long idctacte) {
        try {
            return (List<ItemmovimientoLightView>) em.createNamedQuery("ItemmovimientoLightView.findPedidosByIdctacte").
                    setParameter("idctacte", idctacte).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected List<ItemmovimientoLightView> findOrdenesByIdctacte(Long idctacte) {
        try {
            return (List<ItemmovimientoLightView>) em.createNamedQuery("ItemmovimientoLightView.findOrdenesByIdctacte").
                    setParameter("idctacte", idctacte).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected List<ItemmovimientoLightView> findComprasByIdctacte(Long idctacte) {
        try {
            return (List<ItemmovimientoLightView>) em.createNamedQuery("ItemmovimientoLightView.findComprasByIdctacte").
                    setParameter("idctacte", idctacte).getResultList();
        } catch (NoResultException e) {
            return null;
        }
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
