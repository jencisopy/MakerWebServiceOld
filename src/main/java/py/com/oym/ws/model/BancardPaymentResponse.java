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
public class BancardPaymentResponse {
    private String status;
    private Integer tid;
    private String tkt;    
    private Integer aut_cod;
    private BancardMessage messages;
    private List<String> prnt_msg;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public BancardMessage getMessages() {
        return messages;
    }

    public void setMessages(BancardMessage messages) {
        this.messages = messages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTkt() {
        return tkt;
    }

    public void setTkt(String tkt) {
        this.tkt = tkt;
    }

    public Integer getAut_cod() {
        return aut_cod;
    }

    public void setAut_cod(Integer aut_cod) {
        this.aut_cod = aut_cod;
    }

    public List<String> getPrnt_msg() {
        return prnt_msg;
    }

    public void setPrnt_msg(List<String> prnt_msg) {
        this.prnt_msg = prnt_msg;
    }  
}
