/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.model;

import java.util.List;

/**
 *
 * @author mtrinidad
 */
public class BancardAddlModel {
    private String cmr_id;
    private Integer cmr_bra;
    private List<String> srv_dta;
    private String payment_method;

    public String getCmr_id() {
        return cmr_id;
    }

    public void setCmr_id(String cmr_id) {
        this.cmr_id = cmr_id;
    }

    public Integer getCmr_bra() {
        return cmr_bra;
    }

    public void setCmr_bra(Integer cmr_bra) {
        this.cmr_bra = cmr_bra;
    }

    public List<String> getSrv_dta() {
        return srv_dta;
    }

    public void setSrv_dta(List<String> srv_dta) {
        this.srv_dta = srv_dta;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
    
}
