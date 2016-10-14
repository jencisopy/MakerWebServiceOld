/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    private static final Logger LOGGER = Logger.getLogger(CORSFilter.class);

   @Override
   public void filter(final ContainerRequestContext requestContext,
                      final ContainerResponseContext responseContext) throws IOException {
       
        LOGGER.info("CORSFilter IN "+requestContext.getMethod());
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, token");
        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        responseContext.getHeaders().add("Access-Control-Max-Age", "1728000");
   }
}
