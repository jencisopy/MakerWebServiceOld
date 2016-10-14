/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import py.com.oym.model.ErrorMessage;
import py.com.oym.model.LoginOk;
import py.com.oym.model.UserSession;
import py.com.oym.model.tables.Vendedor;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("login")
public class UserBean extends AbstractFacade<Vendedor>{
    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;
    
    
    public UserBean() {
        super(Vendedor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


    @OPTIONS
    @Path("{user}/{password}")    
    @Produces({"application/json"})
    public String option() {
        return "";
    }
    
    @GET
    @Path("{user}/{password}")
    @Produces({"application/json"})
    public Response login(@PathParam("user")     String user,
                          @PathParam("password") String clave) {
        UserSession userSession = super.loginUser(user, clave);
        if (userSession == null){
            ErrorMessage error = new ErrorMessage();
            error.setErrorMessage("Usuario o contraseña invalida");
            error.setErrorCode(404);
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }
        LoginOk loginOk = new LoginOk();
        loginOk.setIdempresa(userSession.getIdempresa());
        loginOk.setIdvendedor(userSession.getIdvendedor());
               
        loginOk.setAuth(userSession.getSessionId());
        loginOk.setMessage("Tiene válides hasta 120 minutos de inactividad");
        sesiones.setSessionVar(userSession.getSessionId(), userSession);
        return Response
                .ok(userSession.getSessionId())
                .entity(loginOk)
                .build();
    }

    @Override
    protected UserSession getUserSession(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
