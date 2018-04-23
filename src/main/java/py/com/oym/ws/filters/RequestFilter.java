/*
* Copyright (c) 2015-2017 OyM System Group S.A.
* Capitan Cristaldo 464, Asunción, Paraguay
* All rights reserved. 
*
* NOTICE:  All information contained herein is, and remains
* the property of OyM System Group S.A. and its suppliers,
* if any.  The intellectual and technical concepts contained
* herein are proprietary to OyM System Group S.A.
* and its suppliers and protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material
* is strictly forbidden unless prior written permission is obtained
* from OyM System Group S.A.
 */
package py.com.oym.ws.filters;

import java.io.IOException;
import java.io.StringWriter;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

@Provider
public class RequestFilter implements ContainerRequestFilter {
    private static final Logger LOGGER = Logger.getLogger(RequestFilter.class);

    @Context
    private HttpServletRequest sr;

    
    @PostConstruct
    public void init() {
    }  
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
//        if ( requestContext.getRequest().getMethod().equals( "OPTIONS" ) ) {
//            requestContext.abortWith( Response.status( Response.Status.OK ).build() );
//        }
    }
}
