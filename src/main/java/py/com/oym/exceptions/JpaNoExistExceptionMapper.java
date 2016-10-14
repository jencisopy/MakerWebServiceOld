/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import py.com.oym.model.ErrorMessage;

/**
 *
 * @author Jorge Enciso
 */
@Provider
public class JpaNoExistExceptionMapper implements ExceptionMapper<JpaNoExist>{

    @Override
    public Response toResponse(JpaNoExist exception) {
        ErrorMessage error = new ErrorMessage();
        error.setErrorMessage(exception.getMessage());
        error.setErrorCode(404);
        error.setDocumentation("");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
    
}
