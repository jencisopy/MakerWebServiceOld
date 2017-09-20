/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
public class CtactependientedetalleREST extends AbstractFacade<CtactependientedetalleView> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    public CtactependientedetalleREST() {
        super(CtactependientedetalleView.class);
    }

    @GET
    @Produces({"application/json"})
    public Response find(@QueryParam("tid") String tid,
            @QueryParam("prd_id") Integer prd_id,
            @QueryParam("sub_id") List<String> sub_id,
            @QueryParam("addl") String addl
    ) {
//        setToken(token);     
        List<String> messageDsc = new ArrayList<>();
        BancardMessage message = new BancardMessage();
        BancardInvoiceResponse bancardInvoiceResponse = new BancardInvoiceResponse();

        ClienteView cliente = (ClienteView) getData("ClienteView", "No existe este cliente",
                new Params("codigo", sub_id),
                new Params("idempresa", 90L));
        if (cliente.getIdctacte() == 0) {
            message.setLevel("error");
            message.setKey("SubscriberNotFound");
            messageDsc.add("El abonado con código " + sub_id + " no existe");
            message.setDsc(messageDsc);

            bancardInvoiceResponse.setStatus("error");
            bancardInvoiceResponse.setTid(tid);
            bancardInvoiceResponse.setMessages(message);

            return Response.status(Response.Status.NOT_FOUND).entity(bancardInvoiceResponse).build();
        }
        List<BancardInvoice> invoices = findByCtacte(sub_id.get(0));
        if (invoices.isEmpty()) {
            message.setLevel("info");
            message.setKey("SubscriberWithoutDebt");
            messageDsc.add("El abonado con código " + sub_id + " no tiene deuda pendiente");
            message.setDsc(messageDsc);

            bancardInvoiceResponse.setStatus("success");
            bancardInvoiceResponse.setTid(tid);
            bancardInvoiceResponse.setMessages(message);

            return Response.status(Response.Status.OK).entity(bancardInvoiceResponse).build();
        }

        bancardInvoiceResponse.setStatus("success");
        bancardInvoiceResponse.setTid(tid);
        message.setLevel("success");
        message.setKey("QueryProcessed");
        messageDsc.add("Consulta procesada con éxito");
        message.setDsc(messageDsc);
        bancardInvoiceResponse.setMessages(message);
        bancardInvoiceResponse.setInvoices(invoices);
        return Response.status(Response.Status.OK)
                .entity(bancardInvoiceResponse)
                .build();
    }

    public List<BancardInvoice> findByCtacte(String ctacte) {
        Long idempresa = 90L;
        EntityManager em = getEntityManager();
        List<BancardInvoice> invoices = new ArrayList<>();
        List<CtactependientedetalleView> ctactependientedetalle
                = (List<CtactependientedetalleView>) em.createNamedQuery("CtactependientedetalleView.findByCtacte").
                        setParameter("idempresa", idempresa).
                        setParameter("ctacte", ctacte).getResultList();
        Integer cont =0;
        for (CtactependientedetalleView ctactependientedetalle1 : ctactependientedetalle) {
            BancardInvoice invoice = new BancardInvoice();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");                     
            invoice.setDue(formatter.format(ctactependientedetalle1.getFecVen()));
            invoice.setAmt(ctactependientedetalle1.getTotalsaldo());
            invoice.setMin_amt(ctactependientedetalle1.getTotalsaldo());
            invoice.setCm_amt(0);
            invoice.setCm_curr("");
            invoice.setDsc("");
            List<String> nextDuesList = new ArrayList<>();
            invoice.setNext_dues(nextDuesList);
            List<String> invoiceList = new ArrayList<>();
            invoiceList.add(((Long) ctactependientedetalle1.getIdctactependientedetalle()).toString());
            List<String> addlList = new ArrayList<>();
            addlList.add("Factura Nro: "+ctactependientedetalle1.getSecuencia().trim()+"-"+ctactependientedetalle1.getNro().trim()+" - Cliente: "+ctactependientedetalle1.getCtactenombre());
            invoice.setAddl(addlList);
            invoice.setInv_id(invoiceList);
            invoice.setCurr(ctactependientedetalle1.getMoneda());
            invoices.add(invoice);
            cont++;
            if (cont >9){
                break;
            }
        }
        return invoices;
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
