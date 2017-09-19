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
public class TokenError extends RuntimeException {
    public TokenError(){
        super();
    }
    
    public TokenError(String message){
        super(message);
    }

    public TokenError(String message, Throwable cause){
        super(message, cause);
    }

    public TokenError(Throwable cause){
        super(cause);
    }
}
