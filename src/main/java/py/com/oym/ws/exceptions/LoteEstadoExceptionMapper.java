/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import py.com.oym.ws.model.ErrorMessage;

/**
 *
 * @author Jorge Enciso
 */
@Provider
public class LoteEstadoExceptionMapper implements ExceptionMapper<LoteEstado>{
    @Override
    public Response toResponse(LoteEstado exception) {
        ErrorMessage error = new ErrorMessage();
        error.setErrorMessage(exception.getMessage());
        error.setErrorCode(400);
        error.setDocumentation("");
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }
    
}

