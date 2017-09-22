/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import py.com.oym.model.tables.BocaCobranza;
import py.com.oym.model.views.CtactependientedetalleView;
import py.com.oym.ws.model.BancardMessage;
import py.com.oym.ws.model.BancardPayment;
import py.com.oym.ws.model.BancardPaymentResponse;
import py.com.oym.ws.model.UserSession;

/**
 *
 * @author mtrinidad
 */
@Stateless
@Path("")
public class BocaCobranzaREST extends AbstractFacade<BocaCobranza> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    public BocaCobranzaREST() {
        super(BocaCobranza.class);
    }

    @POST
    @Path("bancard/payments")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response payment(BancardPayment payment) {

        CtactependientedetalleView ctactependientedetalle;

        ctactependientedetalle = findByInvoiceId(Long.parseLong(payment.getInv_id().get(0)));

        List<String> messageDsc = new ArrayList<>();
        List<String> prntMsg = new ArrayList<>();
        BancardMessage message = new BancardMessage();
        BancardPaymentResponse bancardPaymentResponse = new BancardPaymentResponse();

        if (ctactependientedetalle == null) {
            message.setLevel("error");
            message.setKey("SubscriberWithoutDebt");
            messageDsc.add("El pago no fue aprobado. El abonado no tiene deuda pendiente");
            message.setDsc(messageDsc);

            bancardPaymentResponse.setStatus("error");
            bancardPaymentResponse.setTkt("");
            bancardPaymentResponse.setAut_cod(0);
            bancardPaymentResponse.setPrnt_msg(prntMsg);
            bancardPaymentResponse.setTid(payment.getTid());
            bancardPaymentResponse.setMessages(message);

            return Response.status(Response.Status.FORBIDDEN).entity(bancardPaymentResponse).build();
        }
        if (ctactependientedetalle.getFecVen().before(new Date())) {
            message.setLevel("error");
            message.setKey("OverdueInvoice");
            messageDsc.add("El pago no fue autorizado. La factura Nro. "
                    + ctactependientedetalle.getSecuencia().trim() + "-"
                    + ctactependientedetalle.getNro().trim() + " del abonado Nro. "
                    + ctactependientedetalle.getCtacte().trim() + " está vencida y se cumplió el período de gracia");
            message.setDsc(messageDsc);
            bancardPaymentResponse.setStatus("error");
            bancardPaymentResponse.setTkt("");
            bancardPaymentResponse.setAut_cod(0);
            bancardPaymentResponse.setPrnt_msg(prntMsg);
            bancardPaymentResponse.setTid(payment.getTid());
            bancardPaymentResponse.setMessages(message);
            return Response.status(Response.Status.FORBIDDEN).entity(bancardPaymentResponse).build();
        }

        BocaCobranza bocaCobranza = new BocaCobranza();
        bocaCobranza.setIdempresa(90L);
        bocaCobranza.setIdctactependientedetalle(ctactependientedetalle.getIdctactependientedetalle());
        bocaCobranza.setIdcaja(1L);
        bocaCobranza.setNumeroOperacion(Long.parseLong(payment.getTid().toString()));
        bocaCobranza.setMontopagado(BigDecimal.valueOf(payment.getAmt()));
        bocaCobranza.setMontocuota(ctactependientedetalle.getMonto());
        String fechaPago = payment.getTrn_dat().replaceAll("-", "");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try {
            bocaCobranza.setFechaPago(formatter.parse(fechaPago));
        } catch (ParseException ex) {
            message.setLevel("error");
            message.setKey("Error en el origen");
            messageDsc.add(ex.getMessage());
            message.setDsc(messageDsc);
            bancardPaymentResponse.setStatus("error");
            bancardPaymentResponse.setTkt("");
            bancardPaymentResponse.setPrnt_msg(prntMsg);
            bancardPaymentResponse.setAut_cod(0);
            bancardPaymentResponse.setTid(payment.getTid());
            bancardPaymentResponse.setMessages(message);
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(bancardPaymentResponse).build();
        }
        bocaCobranza.setMontointeres(BigDecimal.valueOf(payment.getAmt()).subtract((BigDecimal) ctactependientedetalle.getMonto()));
        bocaCobranza.setEstado("PA");
        try {
            getEntityManager().persist(bocaCobranza);
            message.setLevel("info");
            message.setKey("PaymentProcessed");
            messageDsc.add("El pago fue autorizado");
            message.setDsc(messageDsc);
            bancardPaymentResponse.setStatus("success");
            bancardPaymentResponse.setTkt("");
            bancardPaymentResponse.setPrnt_msg(prntMsg);
            bancardPaymentResponse.setAut_cod(0);
            bancardPaymentResponse.setTid(payment.getTid());
            bancardPaymentResponse.setMessages(message);
            return Response.status(Response.Status.FORBIDDEN).entity(bancardPaymentResponse).build();
        } catch (Exception ex) {
            message.setLevel("error");
            message.setKey("Error en el origen");
            messageDsc.add(ex.getMessage());
            message.setDsc(messageDsc);
            bancardPaymentResponse.setStatus("error");
            bancardPaymentResponse.setTkt("");
            bancardPaymentResponse.setPrnt_msg(prntMsg);
            bancardPaymentResponse.setAut_cod(0);
            bancardPaymentResponse.setTid(payment.getTid());
            bancardPaymentResponse.setMessages(message);
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(bancardPaymentResponse).build();
        }
    }

    public CtactependientedetalleView findByInvoiceId(Long invoice_id) {
        EntityManager em = getEntityManager();
        try {
            return (CtactependientedetalleView) em.createNamedQuery("CtactependientedetalleView.findById").
                    setParameter("idctactependientedetalle", invoice_id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("bancard/reverse")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response reverse(String data) {
        JSONObject inputJsonObj = new JSONObject(data);
        Integer tid = (Integer) inputJsonObj.get("tid");

        BocaCobranza bocaCobranza = null;

        EntityManager em = getEntityManager();
        try {
            //TODO: faltaria enviar un parametro de idbocacobranza
            bocaCobranza = (BocaCobranza) em.createNamedQuery("BocaCobranza.findByNumeroOperacion").
                    setParameter("idempresa", 90L).
                    setParameter("numeroOperacion", Long.parseLong(tid.toString())).getSingleResult();
        } catch (Exception e) {
        }
        if (bocaCobranza == null) {
            //Usamos esto para NO depender de un modelo. Se puede utilizar el modelo BancardMessageResponse
            //pero es una variante. Asi aprendemos algo nuevo cada dia
            JsonObject model = Json.createObjectBuilder()
                    .add("status", "error")
                    .add("messages", Json.createArrayBuilder()
                            .add(Json.createObjectBuilder()
                                    .add("level", "error")
                                    .add("key", "SubscriberNotFound")
                                    .add("dsc", Json.createArrayBuilder().add("Transacción no reversada")
                                    ))).build();

            StringWriter stWriter = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(stWriter);
            jsonWriter.writeObject(model);
            jsonWriter.close();
            return Response.status(Response.Status.NOT_FOUND).entity(stWriter.toString()).build();
        } else {
            bocaCobranza.setEstado("RE");
            getEntityManager().merge(bocaCobranza);
            //Usamos esto para no depender de un modelo
            JsonObject model = Json.createObjectBuilder()
                    .add("status", "success")
                    .add("messages", Json.createArrayBuilder()
                            .add(Json.createObjectBuilder()
                                    .add("level", "info")
                                    .add("key", "TransactionReversed")
                                    .add("dsc", Json.createArrayBuilder().add("Transacción reversada satisfactoriamente")
                                    ))).build();

            StringWriter stWriter = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(stWriter);
            jsonWriter.writeObject(model);
            jsonWriter.close();
            return Response.status(Response.Status.OK).entity(stWriter.toString()).build();
        }
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
