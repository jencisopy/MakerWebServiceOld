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
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
import py.com.oym.model.ReturnMessage;
import py.com.oym.model.UserSession;

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
    
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(GiLotevtaView entity,
                            @HeaderParam("token") String token){
        GiLotevta row;            
        setToken(token);                                
        row = setGiLoteVta(entity);
        super.create(row);
        ReturnMessage returnMsg = new ReturnMessage();
        returnMsg.setId(row.getIdgiLotevta().toString());
        return Response.ok().entity(returnMsg).build(); 
    }

    public GiLotevta setGiLoteVta(GiLotevtaView r){
        GiLotevta row = new GiLotevta();
        /*
        Agregar en gi_lotevtapersona
        Setear lote como vendido
        Marcar registro que fue cargado desde dispositivo movil
        
        Controlar fecha
        
        Ver impuestogrupo por defecto.
        Ver moneda y cambio por defecto.
        
        */
        row.setIdempresa(getIdempresa());
        row.setIdperiodo(1L);
        row.setFecha(r.getFecha());
        row.setNrovta(getNroVta(r));
        row.setRecibonro(r.getRecibonro());
        row.setCambio(r.getCambio());
        row.setPreciovtacontado(r.getPreciovtacontado());
        row.setPorcadminvtacontado(r.getPreciovtacontado());
        row.setPorcadminvtacontado(r.getPorcadminvtacontado());
        row.setImportesena(r.getImportesena());
        row.setImporteinicial(r.getImporteinicial());
        row.setImportecuota(r.getImportecuota());
        row.setFechaprimervto(r.getFechaprimervto());
        row.setCuotasCnt(r.getCuotasCnt());
        row.setObservacion(r.getObservacion());
        row.setIdgiLotevtaestado("C");
        row.setConfirmado(false);
        
        
        GiLote lote = (GiLote)getData("GiLote","No existe Lote", 
                                            new Params("idempresa", getIdempresa()),
                                            new Params("giFraccion",r.getGiFraccion()),
                                            new Params("giManzana", r.getGiManzana()),
                                            new Params("codigo",    r.getGiLote()));

        // Validar que el lote este disponible
        if (!(lote.getIdgiLoteestado().getIdgiLoteestado().equals("1") ||
                lote.getIdgiLoteestado().getIdgiLoteestado().equals("3"))){
             throw new py.com.oym.exceptions.LoteEstado("Este lote no esta disponible");
        }
        row.setIdgiLote(lote);

        Impuestogrupo imp = (Impuestogrupo)getData("Impuestogrupo","No existe grupo impositivo", 
                                            new Params("codigo",r.getImpuestogrupo()));
        row.setIdimpuestogrupo(imp);
        
        Ctacte ctacte = (Ctacte)getData("Ctacte","No existe este cliente",
                                        new Params("codigo",    r.getCtacte()),
                                        new Params("idempresa", getIdempresa()));
        row.setIdctacte(ctacte);
        
        if (r.getCanalvta() != null){
            Canalvta canalvta = (Canalvta)getData("Canalvta","No existe este canal de venta",
                                            new Params("codigo",r.getCanalvta()),
                                            new Params("idempresa",getIdempresa()));
            row.setIdcanalvta(canalvta);
        }
        

        if (r.getCanalpublicidad() != null){
            Canalpublicidad canalpublicidad = (Canalpublicidad)getData("Canalpublicidad","No existe este canal de públicidad",
                                            new Params("codigo",r.getCanalpublicidad()),
                                            new Params("idempresa",getIdempresa()));
            row.setIdcanalpublicidad(canalpublicidad);
        }
        
        Vendedor vendedor = (Vendedor)getData(Vendedor.class, getIdVendedor());
        row.setIdvendedor(vendedor);

        row.setIdconductor(vendedor);

        Itemmovcondicion itemmovcondicion = (Itemmovcondicion)getData("Itemmovcondicion","No existe este plan de pago",
                                        new Params("codigo",r.getItemmovcondicion()),
                                        new Params("idempresa",getIdempresa()));
        row.setIditemmovcondicion(itemmovcondicion);
        
        // GiLoteVtaCuotaParam
        // Si hay seña
        GiLotevtacuotaparam cuotaParam;
        if (r.getImportesena() != null && r.getImportesena().intValue() > 0){
            cuotaParam = new GiLotevtacuotaparam();            
            cuotaParam.setCuotatipo((short)6);
            cuotaParam.setCuotasCnt((short)1);
            cuotaParam.setIntervalo((short)30);
            cuotaParam.setMonto(r.getImportesena());
            cuotaParam.setPrimervto(r.getFecha());
            row.addCuotaParam(cuotaParam);
        }
        if (r.getImportecuota().intValue() > 0){
            cuotaParam = new GiLotevtacuotaparam();
            cuotaParam.setCuotatipo((short)1);
            cuotaParam.setCuotasCnt(r.getCuotasCnt());
            cuotaParam.setIntervalo((short)1);
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
        if (r.getCodigo() == null || r.getCodigo().isEmpty()){
            row.setCodigo(getNewContratoNro(r));        
        }
        else{
            row.setCodigo(r.getCodigo());
        }
        String idnro = String.format("%1$"+2+"s", String.valueOf(getIdempresa()))+"V  001001 "+row.getCodigo()+"CN";
        row.setIdnro(idnro);
        
        return row;
    }
        
    
    private String getNewContratoNro(GiLotevtaView r){
        Query query = em.createNativeQuery("select max(codigo) from datos.gi_lotevta where idempresa = "+getIdempresa());
        String result = (String)query.getSingleResult();
        if (result == null){
            result = "         1";
        }
        else{
            long l = Long.valueOf(result.trim())+1;
            result = String.valueOf(l);
            result = String.format("%1$"+10+"s", result);
        }
        return result;
    }

    private Short getNroVta(GiLotevtaView r){
        Query query = em.createNativeQuery("select max(nrovta) from datos.gi_lotevta where idgi_lote = "+r.getIdgiLote());
        Short result = (Short)query.getSingleResult();
        if (result == null){
            result = 1;
        }
        else{
            result++;
        }
        return result;
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    protected UserSession getUserSession(String key){
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