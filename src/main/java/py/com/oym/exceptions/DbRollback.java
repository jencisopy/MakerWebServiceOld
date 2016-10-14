/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author Jorge Enciso
 */
@ApplicationException(rollback=true)
public class DbRollback extends RuntimeException {
    public DbRollback(){
        super();
    }
    public DbRollback(String message){
        super(message);
    }

    public DbRollback(String message, Throwable cause){
        super(message, cause);
    }

    public DbRollback(Throwable cause){
        super(cause);
    }
}
