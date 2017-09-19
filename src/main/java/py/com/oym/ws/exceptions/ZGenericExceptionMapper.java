/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;
import py.com.oym.ws.model.ErrorMessage;

/**
 *
 * @author Jorge Enciso
 */
@Provider
public class ZGenericExceptionMapper implements ExceptionMapper<Throwable>{
    private static final Logger LOGGER = Logger.getLogger(ZGenericExceptionMapper.class);
    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage error = new ErrorMessage();
        error.setErrorMessage(exception.getMessage());
        error.setErrorCode(500);
        error.setDocumentation("");
        LOGGER.info(error.getErrorMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
    }
    
}
