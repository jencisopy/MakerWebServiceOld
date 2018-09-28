/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.ws.resources;

import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.oym.others.Params;
import py.com.oym.model.tables.Canalvta;
import py.com.oym.model.tables.Ctacte;
import py.com.oym.model.views.GiLotevtaView;
import py.com.oym.model.tables.GiLotevta;
import py.com.oym.model.tables.GiLote;
import py.com.oym.model.tables.Impuestogrupo;
import py.com.oym.model.tables.Canalpublicidad;
import py.com.oym.model.tables.GiLotevtacuotaparam;
import py.com.oym.model.tables.GiLotevtapersona;
import py.com.oym.model.tables.Vendedor;
import py.com.oym.model.tables.Itemmovcondicion;
import py.com.oym.ws.model.ReturnMessage;
import py.com.oym.ws.model.UserSession;
import py.com.oym.model.tables.GiContratonroctrl;
import py.com.oym.model.tables.GiFraccion;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Path("gilotevta")
public class GiLotevtaREST extends AbstractFacade<GiLotevta> {

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @Inject
    private Sesiones sesiones;

    public GiLotevtaREST() {
        super(GiLotevta.class);
    }

    @OPTIONS
    @Produces({"application/json"})
    public String option() {
        return "";
    }

    @GET
    @Path("/testnrocontrato/{idfraccion}")
    @Produces({MediaType.TEXT_PLAIN})
    public String testNroContrato(
                        @PathParam("idfraccion") Long idfraccion,
                        @HeaderParam("token") String token) {
        setToken(token);
        GiFraccion row = em.find(GiFraccion.class, idfraccion);
        return getNewContratoNro(row);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(GiLotevtaView entity,
            @HeaderParam("token") String token) {
        
//        throw new py.com.oym.exceptions.OpcionNoDisponible("Esta opción no esta disponible");
        GiLotevta row;
        setToken(token);
        row = setGiLoteVta(entity);
        super.create(row);
        ReturnMessage returnMsg = new ReturnMessage();
        returnMsg.setId(row.getIdgiLotevta().toString());
        return Response.ok().entity(returnMsg).build();
    }

    public GiLotevta setGiLoteVta(GiLotevtaView r) {
        GiLotevta row = new GiLotevta();
        /*
            Marcar registro que fue cargado desde dispositivo movil
            Controlar fecha
         */
        row.setIdempresa(getIdempresa());
        row.setIdperiodo(1L);
        row.setFecha(r.getFecha());
        row.setNrovta(getNroVta(r));
        row.setRecibonro(r.getRecibonro());
        row.setCambio(r.getCambio());
        row.setPreciovtacontado(r.getPreciovtacontado());
        row.setPorcadminvtacontado(r.getPorcadminvtacontado());
        row.setImportesena(r.getImportesena());
        row.setImporteinicial(r.getImporteinicial());
        row.setImportecuota(r.getImportecuota());
        row.setFechaprimervto(r.getFechaprimervto());
        row.setCuotasCnt(r.getCuotasCnt());
        row.setObservacion(r.getObservacion());
        row.setIdgiLotevtaestado("C");
        row.setBoletadeposito(r.getBoletadeposito());
        row.setConfirmado(false);

        GiLote lote = (GiLote) getData("GiLote", "No existe Lote",
                new Params("idempresa", getIdempresa()),
                new Params("giFraccion", r.getGiFraccion()),
                new Params("giManzana", r.getGiManzana()),
                new Params("codigo", r.getGiLote()));

        // Validar que el lote este disponible
        if (!(lote.getIdgiLoteestado().getIdgiLoteestado().equals("1")
                || lote.getIdgiLoteestado().getIdgiLoteestado().equals("3"))) {
            throw new py.com.oym.ws.exceptions.LoteEstado("Este lote no esta disponible");
        }
        row.setIdgiLote(lote);

        Impuestogrupo imp = (Impuestogrupo) getData("Impuestogrupo", "No existe grupo impositivo",
                new Params("codigo", r.getImpuestogrupo()));
        row.setIdimpuestogrupo(imp);

        Ctacte ctacte = (Ctacte) getData("Ctacte", "No existe este cliente",
                new Params("codigo", r.getCtacte()),
                new Params("idempresa", getIdempresa()));
        row.setIdctacte(ctacte);

        if (r.getCanalvta() != null) {
            Canalvta canalvta = (Canalvta) getData("Canalvta", "No existe este canal de venta",
                    new Params("codigo", r.getCanalvta()),
                    new Params("idempresa", getIdempresa()));
            row.setIdcanalvta(canalvta);
        }

        if (r.getCanalpublicidad() != null) {
            Canalpublicidad canalpublicidad = (Canalpublicidad) getData("Canalpublicidad", "No existe este canal de públicidad",
                    new Params("codigo", r.getCanalpublicidad()),
                    new Params("idempresa", getIdempresa()));
            row.setIdcanalpublicidad(canalpublicidad);
        }

        Vendedor vendedor = (Vendedor) getData(Vendedor.class, getIdVendedor());
        row.setIdvendedor(vendedor);

        row.setIdconductor(vendedor);
        
        // Buscar condicion de venta que coincida con la cantidad de cuotas
        if (row.getCuotasCnt() > 1){
            List<Itemmovcondicion> itemmovcondList = em.createNamedQuery("Itemmovcondicion.findByCuotas").
                                                            setParameter("idempresa", getIdempresa()).
                                                            setParameter("cuotas", row.getCuotasCnt()).
                                                            getResultList();
                                                            
            
            /*
            Itemmovcondicion itemmovcondicion = (Itemmovcondicion) getData("Itemmovcondicion", "No existe este plan de pago",
                    new Params("codigo", r.getItemmovcondicion()),
                    new Params("idempresa", getIdempresa()));
            */
            if (!itemmovcondList.isEmpty()){
                Itemmovcondicion itemmovcondicion = itemmovcondList.get(0);
                row.setIditemmovcondicion(itemmovcondicion);
            }
        }

        // GiLoteVtaCuotaParam        
        GiLotevtacuotaparam cuotaParam;
        // Si no es contado
        if (r.getCuotasCnt().intValue() > 1) {
            // Si hay seña            
            if (r.getImportesena() != null && r.getImportesena().intValue() > 0) {
                cuotaParam = new GiLotevtacuotaparam();
                cuotaParam.setCuotatipo((short) 6);
                cuotaParam.setCuotasCnt((short) 1);
                cuotaParam.setIntervalo((short) 30);
                cuotaParam.setMonto(r.getImportesena());
                cuotaParam.setPrimervto(r.getFecha());
                row.addCuotaParam(cuotaParam);
            }
            // Si hay importe inicial
            if (r.getImporteinicial() != null && r.getImporteinicial().intValue() > 0) {
                cuotaParam = new GiLotevtacuotaparam();
                cuotaParam.setCuotatipo((short) 2);
                cuotaParam.setCuotasCnt((short) 1);
                cuotaParam.setIntervalo((short) 30);
                cuotaParam.setMonto(r.getImporteinicial());
                cuotaParam.setPrimervto(r.getFecha());
                row.addCuotaParam(cuotaParam);
            }
        }
        // Si es contado
        if (r.getCuotasCnt().intValue() == 1) {
            cuotaParam = new GiLotevtacuotaparam();
            cuotaParam.setCuotatipo((short) 1);
            cuotaParam.setCuotasCnt(r.getCuotasCnt());
            cuotaParam.setIntervalo((short) 1);
            cuotaParam.setMonto(r.getPreciovtacontado());
            cuotaParam.setPrimervto(r.getFecha());
            row.addCuotaParam(cuotaParam);
        }
        // Si es en cuotas
        else if (r.getImportecuota().intValue() > 0) {
            cuotaParam = new GiLotevtacuotaparam();
            cuotaParam.setCuotatipo((short) 1);
            cuotaParam.setCuotasCnt(r.getCuotasCnt());
            cuotaParam.setIntervalo((short) 1);
            cuotaParam.setMonto(r.getImportecuota());
            cuotaParam.setPrimervto(r.getFecha());
            row.addCuotaParam(cuotaParam);
        }
        // Agregar persona al contrato
        GiLotevtapersona persona = new GiLotevtapersona();
        persona.setIdPersona(ctacte.getIdpersonatitular().getIdpersona());
        persona.setRol("Principal");
        row.addPersona(persona);
        // Nro de contrato
        if (r.getCodigo() == null || r.getCodigo().isEmpty()) {
            row.setCodigo(getNewContratoNro(lote.getGiManzana().getGiFraccion()));
        } else {
            row.setCodigo(r.getCodigo());
        }
        String idnro = String.format("%1$" + 2 + "s", String.valueOf(getIdempresa())) + "V  001001 " + row.getCodigo() + "CN";
        row.setIdnro(idnro);
        
        // Actualizar nro de contrato si modo es 4
        Object[] results = getContratoNroParam();
        if (results != null){
            if ("4".equals(Objects.toString(results[0], ""))) {
                Query query;
                query = em.createNativeQuery("SELECT * "
                        + " from datos.gi_contratonroctrl "
                        + " where idempresa = " + getIdempresa()
                        + " and fraccion = " + lote.getGiManzana().getGiFraccion().getCodigo(), GiContratonroctrl.class);

                GiContratonroctrl obj = (GiContratonroctrl)query.getSingleResult();
                obj.setUltimonro(row.getCodigo());
                em.merge(obj);
            }
            if ("5".equals(Objects.toString(results[0], ""))){
                Query query;
                query = em.createNativeQuery("SELECT * "
                        + " from datos.gi_contratonroctrl "
                        + " where idempresa = " + getIdempresa()
                        + " and fraccion = 0", GiContratonroctrl.class);

                GiContratonroctrl obj = (GiContratonroctrl)query.getSingleResult();
                obj.setUltimonro(row.getCodigo());
                em.merge(obj);
            }
        }
        return row;        
    }

    private String getNewContratoNro(GiFraccion r) {
        Long gi_fraccion;
        Query query;
        gi_fraccion = r.getCodigo();        
        
        Object[] results = getContratoNroParam();

        String result = "";
        Integer numero;
        String cnumero;
        String cnumero2;
        Integer parte1=0;
        Integer parte2=0;
        if (results != null){
            parte1 = Integer.valueOf(Objects.toString(results[1], "3"));
            parte2 = Integer.valueOf(Objects.toString(results[2], "6"));
        }

        //(ultimo contrato + 1)  
        if (results == null || "0".equals(Objects.toString(results[0], "")) 
                    || "1".equals(Objects.toString(results[0], ""))) {
            query = em.createNativeQuery("select max(codigo) "
                    + "from datos.gi_lotevta_view "
                    + "where idempresa = " + getIdempresa());
            
            result = (String) query.getSingleResult();
            if (result == null) {
                result = "         1";
            } else {
                long l = Long.valueOf(result.trim()) + 1;
                result = String.valueOf(l);
                result = String.format("%010d", Integer.valueOf(result));
            }
            return result;
        }

        //(ultimo contrato de la fraccion + 1)        
        if ("2".equals(Objects.toString(results[0], ""))) {
            query = em.createNativeQuery("SELECT MAX(gi_lotevta_view.codigo) "
                    + " from datos.gi_lotevta_view "
                    + " where idempresa = " + getIdempresa()
                    + " and gi_fraccion = " + gi_fraccion);

            result = (String) query.getSingleResult();
            result = Objects.toString(result, "0");

            numero = Integer.valueOf(result.substring(result.lastIndexOf('-') + 1)) + 1;
            cnumero = String.format("%0" + parte2.toString() + "d", numero);
            cnumero2 = String.format("%0" + parte1.toString() + "d", gi_fraccion);
            result = cnumero2 + "-" + cnumero.trim();
        }

        //numeracion secuencial por fraccion (cantidad de contratos + 1)  
        if ("3".equals(Objects.toString(results[0], ""))) {

            query = em.createNativeQuery("SELECT CONVERT(CHAR(10),count(*)) "
                    + " from datos.gi_lotevta_view "
                    + " where idempresa = " + getIdempresa()
                    + " and gi_fraccion = " + gi_fraccion);

            result = (String) query.getSingleResult();
            result = Objects.toString(result, "0");

            numero = Integer.valueOf(result.trim()) + 1;
            cnumero = String.format("%0" + parte2.toString() + "d", numero);
            cnumero2 = String.format("%0" + parte1.toString() + "d", gi_fraccion);
            result = cnumero2 + "-" + cnumero;
        }

        //recuperar ultimo nro. contrato guardado por fraccion + 1
        if ("4".equals(Objects.toString(results[0], ""))) {
            query = em.createNativeQuery("SELECT ultimonro "
                    + " from datos.gi_contratonroctrl "
                    + " where idempresa = " + getIdempresa()
                    + " and fraccion = " + gi_fraccion);

            try {
                result = (String) query.getSingleResult();
            } catch (Exception e) {
                result = "0";
            }

            result = Objects.toString(result, "0");

            //numero = Integer.valueOf(result.trim()) + 1;
            numero = Integer.valueOf(result.substring(result.lastIndexOf('-') + 1)) + 1;            
            cnumero = String.format("%0" + parte2.toString() + "d", numero);
            cnumero2 = String.format("%0" + parte1.toString() + "d", gi_fraccion);
            result = cnumero2 + "-" + cnumero.trim();
        }
        
        //recuperar ultimo nro. contrato guardado por fraccion + 1
        if ("4".equals(Objects.toString(results[0], ""))) {
            query = em.createNativeQuery("SELECT ultimonro "
                    + " from datos.gi_contratonroctrl "
                    + " where idempresa = " + getIdempresa()
                    + " and fraccion = " + gi_fraccion);

            try {
                result = (String) query.getSingleResult();
            } catch (Exception e) {
                result = "0";
            }

            result = Objects.toString(result, "0");

            //numero = Integer.valueOf(result.trim()) + 1;
            numero = Integer.valueOf(result.substring(result.lastIndexOf('-') + 1)) + 1;            
            cnumero = String.format("%0" + parte2.toString() + "d", numero);
            cnumero2 = String.format("%0" + parte1.toString() + "d", gi_fraccion);
            result = cnumero2 + "-" + cnumero.trim();
        }

        //recuperar ultimo nro. contrato guardado + 1
        if ("5".equals(Objects.toString(results[0], ""))) {
            query = em.createNativeQuery("SELECT ultimonro "
                    + " from datos.gi_contratonroctrl "
                    + " where idempresa = " + getIdempresa()
                    + " and fraccion = 0");
            result = (String) query.getSingleResult();
            if (result == null) {
                result = "         1";
            } else {
                long l = Long.valueOf(result.trim()) + 1;
                result = String.valueOf(l);
                result = String.format("%1$10s", result.trim());
            }
        }
        return result;
    }

    private Object[] getContratoNroParam(){
        Object results[];
        Query query = em.createNativeQuery(
                "select numeracionmodo,numeracionpart1,numeracionpart2 "
                + "from datos.gi_contratoparam "
                + "where idempresa = " + getIdempresa());
        try{
            results = (Object[]) query.getSingleResult();
        } 
        catch (NoResultException exp) {
            results = null;
        }
        return results;
    }

    private Short getNroVta(GiLotevtaView r) {
        Query query = em.createNativeQuery("select max(nrovta) "
                + "from datos.gi_lotevta "
                + "where idgi_lote = " + r.getIdgiLote());
        
        Short result = (Short) query.getSingleResult();
        if (result == null) {
            result = 1;
        } else {
            result++;
        }
        return result;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected UserSession getUserSession(String key) {
        UserSession userSession = sesiones.getUserSession(key);
        return userSession;
    }
}


/*
{"fecha": "2015-07-01T23:28:56.782Z",
"giFraccion":9999,
"giManzana":"1",
"giLote":"13",
"recibonro":"",
"cambio":1,
"preciovtacontado":0,
"porcadminvtacontado":0,
"importesena":500000,
"importecuota":500000,
"importeinicial":0,
"fechaprimervto":"",
"cuotasCnt":130,
"observacion":"obs",
"impuestogrupo":"10", 
 "ctacte":"WEB1",
"vendedor":"201",
"conductor":"201",
"canalpublicidad":"00001",
"canalvta":"00001",
"itemmovcondicion":"130"
}
 */
