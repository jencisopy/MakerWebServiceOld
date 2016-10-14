/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import py.com.oym.model.UserSession;

/**
 *
 * @author Jorge Enciso
 */
@Singleton
@Startup
public class Sesiones {
    Map<String, Object> sessionVar = new HashMap<>();    
    
    public UserSession getUserSession(String sessionId){
        UserSession sesion = (UserSession)sessionVar.get(sessionId);
        if (sesion != null){
            // Verificar si ya expiro su sesión
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(sesion.getLastReference());
            cal2.setTime(new Date());
            long time1 = cal1.getTimeInMillis();
            long time2 = cal2.getTimeInMillis();
            // Diferencias en minutos desde la ultima vez que se hizo referencia a esta sesión.        
            long minutos = (time2 - time1)/(60 * 1000);
            if (minutos >= 120){
                sessionVar.remove(sessionId);
                return null;
            }
            sesion.setLastReference(new Date());
        }
        return sesion;
    }
    
    public void setSessionVar(String key, Object value){
        sessionVar.put(key, value);
    }
}
