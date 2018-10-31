package py.com.oym.ws.resources;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("menu")
public class MenuREST {

    @OPTIONS
    @Path("menugestion")
    @Produces({"application/json"})
    public String menugestion1() {
        return "";
    }

    @GET
    @Path("menugestion")
    @Produces({"application/json"})
    public String menugestion() {
        String menugestion = "[{\"title\":\"Inicio\"," + "\"component\":\"InicioPage\"," + "\"icon\":\"home\"},"//Menú Inicio
                + "{\"title\":\"Productos\"," + "\"component\":\"ProductosListaPage\"," + "\"icon\":\"basket\"},"//Menú Productos
                + "{\"title\":\"Clientes\"," + "\"component\":\"ClientesListaPage\"," + "\"icon\":\"person\"},"//Menú Clientes
                + "{\"title\":\"Proveedores\"," + "\"component\":\"ProveedoresListaPage\"," + "\"icon\":\"cart\"},"//Menu Proveedores
                + "{\"title\":\"Stock\"," + "\"icon\":\"cash\"," + ""//Menú Stock con Submenus Entrada,Salida y Envio
                + "\"submenu\":[{\"title\":\"Entradas\"," + "\"component\":\"StockEntradasListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Salidas\"," + "\"component\":\"StockSalidasListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Envios\"," + "\"component\":\"StockEnviosListaPage\"," + "\"icon\":\"cash\"}"
                + "]}, "//Menú Compras con Submenus Compras,Ordenes,Fondo Fijo, Créditos y Débitos
                + "{\"title\":\"Compras\"," + "\"icon\":\"basket\"," + ""
                + "\"submenu\":[{\"title\":\"Ordenes\"," + "\"component\":\"ComprasOrdenesListaPage\"," + "\"icon\":\"document\"},"
                + "{\"title\":\"Compras\"," + "\"component\":\"ComprasListaPage\"," + "\"icon\":\"cart\"},"
                + "{\"title\":\"Fondo Fijo\"," + "\"component\":\"FondoFijoListaPage\"," + "\"icon\":\"cart\"},"
                + "{\"title\":\"Créditos\"," + "\"component\":\"ComprasCreditosListaPage\"," + "\"icon\":\"card\"},"
                + "{\"title\":\"Débitos\"," + "\"component\":\"ComprasDebitosListaPage\"," + "\"icon\":\"card\"}"
                + "]}, "//Menú Ventas con Submenus Pedidos,Facturas,Créditos y Débitos
                + "{\"title\":\"Ventas\"," + "\"icon\":\"cash\"," + ""
                + "\"submenu\":[{\"title\":\"Pedidos\"," + "\"component\":\"VentasPedidosListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Facturas\"," + "\"component\":\"VentasFacturasListaPage\"," + "\"icon\":\"document\"},"
                + "{\"title\":\"Créditos\"," + "\"component\":\"VentasCreditosListaPage\"," + "\"icon\":\"card\"},"
                + "{\"title\":\"Débitos\"," + "\"component\":\"VentasDebitosListaPage\"," + "\"icon\":\"card\"}"
                + "]}, "//Menú Finanzas con Submenus Pagos,Cobranzas,Ret.Clientes y Ret.Proveedor
                + "{\"title\":\"Finanzas\"," + "\"icon\":\"stats\"," + ""
                + "\"submenu\":[{\"title\":\"Pagos\"," + "\"component\":\"FinanzasPagosListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Cobranzas\"," + "\"component\":\"FinanzasCobrosListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Ret. Cliente\"," + "\"component\":\"FinanzasRetClienteListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Ret. Proveedor\"," + "\"component\":\"FinanzasRetProveedorListaPage\"," + "\"icon\":\"cash\"}"
                + "]}, "
                + "{\"title\":\"Configuración\"," + "\"component\":\"ConfiguracionMenuPage\"," + "\"icon\":\"build\"},"//Menú Configuración
                + "{\"title\":\"Acerca de\"," + "\"component\":\"AcercaDePage\"," + "\"icon\":\"paper\"}"//Menú Acerca De
                + "]";

        return menugestion;
    }

    @OPTIONS
    @Path("menuinmobiliario")
    @Produces({"application/json"})
    public String menuinmobiliario1() {
        return "";
    }

    @GET
    @Path("menuinmobiliario")
    @Produces({"application/json"})
    public String menuinmobiliario() {
        String menuinmobiliario = "[{\"title\":\"Inicio\"," + "\"component\":\"InicioPage\"," + "\"icon\":\"home\"},"//Menú Inicio
                + "{\"title\":\"Departamentos\"," + "\"component\":\"DepartamentosListaPage\"," + "\"icon\":\"home\"},"//Menú Departamentos
                + "{\"title\":\"Fracciones\"," + "\"component\":\"FraccionesListaPage\"," + "\"icon\":\"grid\"},"//Menú Fracciones
                + "{\"title\":\"Clientes\"," + "\"component\":\"ClientesFormPage\"," + "\"icon\":\"person\"},"//Menú Clientes
                + "{\"title\":\"Contratos\"," + "\"component\":\"ContratosListaPage\"," + "\"icon\":\"paper\"},"//Menú Contrato
                + "{\"title\":\"Configuracion\"," + "\"component\":\"ConfigPage\"," + "\"icon\":\"settings\"},"//Menú Configuración
                + "{\"title\":\"Acerca de\"," + "\"component\":\"AcercaDePage\"," + "\"icon\":\"paper\"}"//Menú Acerca De     
                + "]";

        return menuinmobiliario;
    }

}
