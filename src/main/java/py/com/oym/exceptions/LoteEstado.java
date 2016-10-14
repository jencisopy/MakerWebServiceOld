/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.exceptions;
/**
 *
 * @author Jorge Enciso
 */
public class LoteEstado extends RuntimeException{
    public LoteEstado(){
        super();
    }
    
    public LoteEstado(String message){
        super(message);
    }

    public LoteEstado(String message, Throwable cause){
        super(message, cause);
    }

    public LoteEstado(Throwable cause){
        super(cause);
    }
}
