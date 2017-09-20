/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.model;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mtrinidad
 */
@XmlRootElement
public class BancardInvoice   {

    private String due;
    private BigDecimal amt  ;
    private BigDecimal min_amt;
    private List<String> inv_id;
    private List<String> addl;
    private List<String> next_dues;
    private String curr;
    private Integer cm_amt;
    private String cm_curr;
    private String dsc;

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getMin_amt() {
        return min_amt;
    }

    public void setMin_amt(BigDecimal min_amt) {
        this.min_amt = min_amt;
    }

    public List<String> getInv_id() {
        return inv_id;
    }

    public void setInv_id(List<String> inv_id) {
        this.inv_id = inv_id;
    }

    public List<String> getAddl() {
        return addl;
    }

    public void setAddl(List<String> addl) {
        this.addl = addl;
    }

    public List<String> getNext_dues() {
        return next_dues;
    }

    public void setNext_dues(List<String> next_dues) {
        this.next_dues = next_dues;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public Integer getCm_amt() {
        return cm_amt;
    }

    public void setCm_amt(Integer cm_amt) {
        this.cm_amt = cm_amt;
    }

    public String getCm_curr() {
        return cm_curr;
    }

    public void setCm_curr(String cm_curr) {
        this.cm_curr = cm_curr;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }          
}
