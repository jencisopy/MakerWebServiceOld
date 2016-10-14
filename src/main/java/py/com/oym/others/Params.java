/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.others;

/**
 *
 * @author Jorge Enciso
 */
public class Params {
    private String field;
    private Object fieldValue;

    public Params(){
        super();
    }
    
    public Params(String field, Object fieldValue){
        this.field = field;
        this.fieldValue = fieldValue;
    }
    
    public Object getField() {
        return field;
    }

    public void setField(String field) { 
        this.field = field;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
}
