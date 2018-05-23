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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import py.com.oym.model.views.ItemlistaprecioView;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("itemlistaprecioview")
public class ItemlistaprecioViewREST extends AbstractFacade<ItemlistaprecioView> {
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;
    
    @Inject
    private Sesiones sesiones;


    public ItemlistaprecioViewREST() {
        super(ItemlistaprecioView.class);
    }

    
    @GET
    @Path("{iditem}")
    @Produces({"application/json"})
    public List<ItemlistaprecioView> find(@PathParam("iditem")     Long   iditem,
                           @HeaderParam("token") String token) {
        setToken(token);
        return findByIditem(iditem);
    }
    

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    
    protected List<ItemlistaprecioView> findByIditem(Long iditem) {
        try {
            return (List<ItemlistaprecioView>) em.createNamedQuery("ItemlistaprecioView.findAll").
                    setParameter("iditem", iditem).getResultList();
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
