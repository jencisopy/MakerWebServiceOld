/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.exceptions;

/**
 *
 * @author Jorge Enciso
 */
public class OpcionNoDisponible extends RuntimeException {
    public OpcionNoDisponible(){
        super();
    }
    
    public OpcionNoDisponible(String message){
        super(message);
    }

    public OpcionNoDisponible(String message, Throwable cause){
        super(message, cause);
    }

    public OpcionNoDisponible(Throwable cause){
        super(cause);
    }
}
