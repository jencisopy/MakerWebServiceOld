/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.oym.model.views.ClienteView;
import py.com.oym.model.views.CtactependientedetalleView;
import py.com.oym.others.Params;
import py.com.oym.ws.model.BancardInvoice;
import py.com.oym.ws.model.BancardInvoiceResponse;
import py.com.oym.ws.model.BancardMessage;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author mtrinidad
 */
@Stateless
@Path("invoices")
public class CtactependientedetalleViewFacadeREST extends AbstractFacade<CtactependientedetalleView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;
    
    public CtactependientedetalleViewFacadeREST() {
        super(CtactependientedetalleView.class);
    }

    @GET
    @Produces({"application/json"})
    public Response find(@QueryParam("tid")   String tid,
                                    @QueryParam("prd_id") Integer prd_id,
                                    @QueryParam("sub_id") String sub_id,
                                    @QueryParam("addl")   JsonObject addl,
                                    @HeaderParam("token") String token) {
        setToken(token);     
        BancardMessage messages = new BancardMessage();

        ClienteView cliente = (ClienteView) getData("Cliente", "No existe este cliente",
                new Params("idctacte", sub_id),
                new Params("idempresa", getIdempresa()));
        if (cliente.getIdctacte() ==0){
            messages.setLevel("info");
            messages.setKey("SubscriberNotFound");
            messages.setDsc("El abonado con código "+sub_id+" no existe");
            return Response.status(Response.Status.NOT_FOUND).entity(messages).build();
        }
        List<BancardInvoice> invoices = findByCtacte(sub_id);
        if (invoices.isEmpty()){
            messages.setLevel("info");
            messages.setKey("SubscriberWithoutDebt");
            messages.setDsc("El abonado con código "+sub_id+" no tiene deuda pendiente");
            return Response.status(Response.Status.OK).entity(messages).build();
        }

        BancardInvoiceResponse bancardInvoiceResponse = new BancardInvoiceResponse();
        bancardInvoiceResponse.setTid(tid);
        bancardInvoiceResponse.setMessages(messages);
        bancardInvoiceResponse.setInvoices(invoices);
        return Response.status(Response.Status.OK)
                .entity(bancardInvoiceResponse)
                .build();
    }

    public List<BancardInvoice> findByCtacte(String idctacte) {
        Long idempresa  = this.getIdempresa();
        EntityManager em = getEntityManager();
        List<BancardInvoice> invoices = new ArrayList<>();
        List<CtactependientedetalleView> ctactependientedetalle =
                (List<CtactependientedetalleView>) em.createNamedQuery("CtactependientedetalleView.findByCliente").
                            setParameter("idempresa",idempresa).
                            setParameter("idctacte", idctacte).getResultList();
        for (CtactependientedetalleView ctactependientedetalle1 : ctactependientedetalle) {
            BancardInvoice invoice = new BancardInvoice();
            invoice.setDue(ctactependientedetalle1.getFecVen().toString());
            invoice.setAmt(ctactependientedetalle1.getSaldo());
            invoice.setMin_amt(ctactependientedetalle1.getSaldo());
            invoice.setInv_id(((Long) ctactependientedetalle1.getIdctactependientedetalle()).toString());
            invoice.setCurr(ctactependientedetalle1.getMoneda());
            invoices.add(invoice);
        }
        return invoices;
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
