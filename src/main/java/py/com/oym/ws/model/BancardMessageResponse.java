/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge Enciso
 */
@XmlRootElement
public class BancardMessageResponse {
    private String status;
    private String tid;
    private BancardMessage messages;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
    
}
