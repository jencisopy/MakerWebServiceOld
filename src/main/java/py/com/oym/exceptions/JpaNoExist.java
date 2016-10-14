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
public class JpaNoExist extends RuntimeException {
    public JpaNoExist(){
        super();
    }
    public JpaNoExist(String message){
        super(message);
    }

    public JpaNoExist(String message, Throwable cause){
        super(message, cause);
    }

    public JpaNoExist(Throwable cause){
        super(cause);
    }
}
