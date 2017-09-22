/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mtrinidad
 */
@XmlRootElement
public class BancardPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer tid;
    private String prd_id;
    private List<String> sub_id;
    private List<String> inv_id;
    private Integer amt;
    private String curr;
    private String trn_dat;
    private String trn_hou;
    private Integer cm_amt;
    private String cm_curr;
    private BancardAddlModel addl;
    private String type;
    
    public BancardPayment(){
        
    }
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(String prd_id) {
        this.prd_id = prd_id;
    }

    public List<String> getSub_id() {
        return sub_id;
    }

    public void setSub_id(List<String> sub_id) {
        this.sub_id = sub_id;
    }

    public List<String> getInv_id() {
        return inv_id;
    }

    public void setInv_id(List<String> inv_id) {
        this.inv_id = inv_id;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getTrn_dat() {
        return trn_dat;
    }

    public void setTrn_dat(String trn_dat) {
        this.trn_dat = trn_dat;
    }

    public String getTrn_hou() {
        return trn_hou;
    }

    public void setTrn_hou(String trn_hou) {
        this.trn_hou = trn_hou;
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

    public BancardAddlModel getAddl() {
        return addl;
    }

    public void setAddl(BancardAddlModel addl) {
        this.addl = addl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
