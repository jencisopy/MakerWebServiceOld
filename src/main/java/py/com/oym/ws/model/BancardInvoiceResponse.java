/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mtrinidad
 */
@XmlRootElement
public class BancardInvoiceResponse {
    private String status;
    private String tid;
    private BancardMessage messages;
    private List<BancardInvoice> invoices;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public BancardMessage getMessages() {
        return messages;
    }

    public void setMessages(BancardMessage messages) {
        this.messages = messages;
    }

    public List<BancardInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<BancardInvoice> invoices) {
        this.invoices = invoices;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  
}
