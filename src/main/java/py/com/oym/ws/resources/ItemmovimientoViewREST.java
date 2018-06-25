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
@Path("clientes")
public class ItemmovimientoViewREST extends AbstractFacade<ItemmovimientoLightView> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;
    
    @Inject
    private Sesiones sesiones;

    public ItemmovimientoViewREST() {
        super(ItemmovimientoLightView.class);
    }
    
    @OPTIONS
    @Path("facturas/{idctacte}")    
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @GET
    @Path("facturas/{idctacte}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findFacturas(@PathParam("idctacte")     Long   idctacte,
                           @HeaderParam("token") String token) {
        setToken(token);
        return findFacturasByIdctacte(idctacte);
    }

    
    @OPTIONS
    @Path("pedidos/{idctacte}")
    @Produces({"application/json"})
    public String option1() {
        return "";
    }
    
    @GET
    @Path("pedidos/{idctacte}")
    @Produces({"application/json"})
    public List<ItemmovimientoLightView> findPedidos(@PathParam("idctacte")     Long   idctacte,
                           @HeaderParam("token") String token) {
        setToken(token);
        return findPedidosByIdctacte(idctacte);
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
