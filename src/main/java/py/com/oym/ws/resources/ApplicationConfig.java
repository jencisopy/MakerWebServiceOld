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
package py.com.oym.ws.resources;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Jorge Enciso
 */
@javax.ws.rs.ApplicationPath("api/v1")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(py.com.oym.ws.exceptions.JpaNoExistExceptionMapper.class);
        resources.add(py.com.oym.ws.exceptions.LoteEstadoExceptionMapper.class);
        resources.add(py.com.oym.ws.exceptions.ZGenericExceptionMapper.class);
        resources.add(py.com.oym.ws.filters.CORSFilter.class);
        resources.add(py.com.oym.ws.filters.RequestFilter.class);
        resources.add(py.com.oym.ws.resources.BocaCobranzaREST.class);
        resources.add(py.com.oym.ws.resources.CanalpublicidadREST.class);
        resources.add(py.com.oym.ws.resources.CanalvtaREST.class);
        resources.add(py.com.oym.ws.resources.CiudadViewREST.class);
        resources.add(py.com.oym.ws.resources.ClienteREST.class);
        resources.add(py.com.oym.ws.resources.CtactemovimientoViewREST.class);
        resources.add(py.com.oym.ws.resources.CtactependientedetalleREST.class);
        resources.add(py.com.oym.ws.resources.CtactereferidoREST.class);
        resources.add(py.com.oym.ws.resources.CtacteretencionViewREST.class);
        resources.add(py.com.oym.ws.resources.GiFraccionREST.class);
        resources.add(py.com.oym.ws.resources.GiLoteMejoraREST.class);
        resources.add(py.com.oym.ws.resources.GiLoteREST.class);
        resources.add(py.com.oym.ws.resources.GiLotevtaDocumentoREST.class);
        resources.add(py.com.oym.ws.resources.GiLotevtaREST.class);
        resources.add(py.com.oym.ws.resources.GiLotevtaViewREST.class);
        resources.add(py.com.oym.ws.resources.GiManzanaREST.class);
        resources.add(py.com.oym.ws.resources.ItemlistaprecioViewREST.class);
        resources.add(py.com.oym.ws.resources.ItemmovcondicionREST.class);
        resources.add(py.com.oym.ws.resources.ItemmovimientoViewREST.class);
        resources.add(py.com.oym.ws.resources.ItemmovplnViewREST.class);
        resources.add(py.com.oym.ws.resources.ItemproductoViewREST.class);
        resources.add(py.com.oym.ws.resources.ItemproductostockViewREST.class);
        resources.add(py.com.oym.ws.resources.MenuREST.class);
        resources.add(py.com.oym.ws.resources.MonedaREST.class);
        resources.add(py.com.oym.ws.resources.ProveedorREST.class);
        resources.add(py.com.oym.ws.resources.ProvinciaREST.class);
        resources.add(py.com.oym.ws.resources.UserBean.class);
        resources.add(py.com.oym.ws.resources.VendedorREST.class);
    }
    
}
