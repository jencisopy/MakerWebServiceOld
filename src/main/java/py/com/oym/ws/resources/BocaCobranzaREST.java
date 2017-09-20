/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import py.com.oym.model.tables.BocaCobranza;
import py.com.oym.model.views.CtactependientedetalleView;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author mtrinidad
 */
@Stateless
@Path("payments")
public class BocaCobranzaREST extends AbstractFacade<BocaCobranza> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;
    
    public BocaCobranzaREST() {
        super(BocaCobranza.class);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void payment(@QueryParam("tid") String tid,
            @QueryParam("prd_id") Integer prd_id,
            @QueryParam("sub_id") List<String> sub_id,
            @QueryParam("inv_id") List<String> inv_id,
            @QueryParam("sub_id") Integer amt) {
     
        CtactependientedetalleView ctactependientedetalle;
        
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
