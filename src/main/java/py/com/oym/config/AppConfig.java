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
package py.com.oym.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import org.apache.log4j.Logger;

/**
 * Esta clase gestiona la lectura de los parametros del sistema almacenadas
 * en el archivo netel.properties.
 * @author Jorge Enciso
 */
@Named(value = "appConfig")
@ApplicationScoped
public class AppConfig {
    private static final Logger LOGGER = Logger.getLogger(AppConfig.class);
    Properties properties = new Properties();    

    /**
     * Creates a new instance of AppConfig
     */
    public AppConfig() {
    }
    
    public void onStartup(@Observes @Initialized(ApplicationScoped.class) Object init) {
        init();
    }
 
    private void init() {
        String path = System.getProperty("jboss.server.config.dir");
        InputStream input = null;
        try {
            input = new FileInputStream(path + File.separator + "makerwebservices.properties");
            // load a properties file
            properties.load(input);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }
        }        
    }

    public Properties getProperties() {
        return properties;
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
