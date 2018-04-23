/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        resources.add(py.com.oym.ws.resources.CtactependientedetalleREST.class);
        resources.add(py.com.oym.ws.resources.CtactereferidoREST.class);
        resources.add(py.com.oym.ws.resources.GiFraccionREST.class);
        resources.add(py.com.oym.ws.resources.GiLoteMejoraFacadeREST.class);
        resources.add(py.com.oym.ws.resources.GiLoteREST.class);
        resources.add(py.com.oym.ws.resources.GiLotevtaDocumentoFacadeREST.class);
        resources.add(py.com.oym.ws.resources.GiLotevtaREST.class);
        resources.add(py.com.oym.ws.resources.GiLotevtaViewREST.class);
        resources.add(py.com.oym.ws.resources.GiManzanaREST.class);
        resources.add(py.com.oym.ws.resources.ItemmovcondicionREST.class);
        resources.add(py.com.oym.ws.resources.MonedaREST.class);
        resources.add(py.com.oym.ws.resources.ProvinciaREST.class);
        resources.add(py.com.oym.ws.resources.UserBean.class);
        resources.add(py.com.oym.ws.resources.VendedorREST.class);
    }
    
}
