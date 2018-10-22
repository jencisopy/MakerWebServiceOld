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
        String menugestion = "[{\"title\":\"Inicio\"," + "\"component\":\"InicioPage\"," + "\"icon\":\"Home\"},"
                + "{\"title\":\"Productos\"," + "\"component\":\"ProductosListaPage\"," + "\"icon\":\"basket\"},"
                + "{\"title\":\"Clientes\"," + "\"component\":\"ClientesListaPage\"," + "\"icon\":\"person\"},"
                + "{\"title\":\"Proveedores\"," + "\"component\":\"ProveedoresListaPage\"," + "\"icon\":\"cart\"},"
                + "{\"title\":\"Stock\"," + "\"icon\":\"cash\"," + ""
                + "\"submenu\":[{\"title\":\"Entradas\"," + "\"component\":\"StockEntradasListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Salidas\"," + "\"component\":\"StockSalidasListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Envios\"," + "\"component\":\"StockEnviosListaPage\"," + "\"icon\":\"cash\"}"
                + "]}, "
                + "{\"title\":\"Compras\"," + "\"icon\":\"basket\"," + ""
                + "\"submenu\":[{\"title\":\"Ordenes\"," + "\"component\":\"ComprasOrdenesListaPage\"," + "\"icon\":\"document\"},"
                + "{\"title\":\"Compras\"," + "\"component\":\"ComprasListaPage\"," + "\"icon\":\"cart\"},"
                + "{\"title\":\"Créditos\"," + "\"component\":\"ComprasCreditosListaPage\"," + "\"icon\":\"card\"},"
                + "{\"title\":\"Débitos\"," + "\"component\":\"ComprasDebitosListaPage\"," + "\"icon\":\"card\"}"
                + "]}, "
                + "{\"title\":\"Ventas\"," + "\"icon\":\"cash\"," + ""
                + "\"submenu\":[{\"title\":\"Pedidos\"," + "\"component\":\"VentasPedidosListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Facturas\"," + "\"component\":\"VentasFacturasListaPage\"," + "\"icon\":\"document\"},"
                + "{\"title\":\"Créditos\"," + "\"component\":\"VentasCreditosListaPage\"," + "\"icon\":\"card\"},"
                + "{\"title\":\"Débitos\"," + "\"component\":\"VentasDebitosListaPage\"," + "\"icon\":\"card\"}"
                + "]}, "
                + "{\"title\":\"Finanzas\"," + "\"icon\":\"stats\"," + ""
                + "\"submenu\":[{\"title\":\"Pagos\"," + "\"component\":\"FinanzasPagosListaPage\"," + "\"icon\":\"cash\"},"
                + "{\"title\":\"Cobranzas\"," + "\"component\":\"FinanzasCobrosListaPage\"," + "\"icon\":\"cash\"}"
                + "]}, "
                + "{\"title\":\"Configuración\"," + "\"component\":\"ConfiguracionMenuPage\"," + "\"icon\":\"build\"},"
                + "{\"title\":\"Acerca de\"," + "\"component\":\"AcercaDePage\"," + "\"icon\":\"paper\"}"
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
        String menuinmobiliario = "[{\"title\":\"Inicio\"," + "\"component\":\"InicioPage\"," + "\"icon\":\"Home\"},"
                + "{\"title\":\"Departamentos\"," + "\"component\":\"DepartamentosListaPage\"," + "\"icon\":\"home\"},"
                + "{\"title\":\"Fracciones\"," + "\"component\":\"FraccionesListaPage\"," + "\"icon\":\"grid\"},"
                + "{\"title\":\"Clientes\"," + "\"component\":\"ClientesFormPage\"," + "\"icon\":\"person\"},"
                + "{\"title\":\"Contratos\"," + "\"component\":\"ContratosListaPage\"," + "\"icon\":\"paper\"},"
                + "{\"title\":\"Configuracion\"," + "\"component\":\"ConfigPage\"," + "\"icon\":\"settings\"},"
                + "{\"title\":\"Acerca de\"," + "\"component\":\"AcercaDePage\"," + "\"icon\":\"paper\"}"     
                + "]";

        return menuinmobiliario;
    }

}
