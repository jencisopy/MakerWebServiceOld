/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "ctactemovimiento_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtactemovimientoView.findAll", query = "SELECT c FROM CtactemovimientoView c")
    , @NamedQuery(name = "CtactemovimientoView.findByIdctactemovimiento", query = "SELECT c FROM CtactemovimientoView c WHERE c.idctactemovimiento = :idctactemovimiento")
    , @NamedQuery(name = "CtactemovimientoView.findByIdnro", query = "SELECT c FROM CtactemovimientoView c WHERE c.idnro = :idnro")
    , @NamedQuery(name = "CtactemovimientoView.findByIdempresa", query = "SELECT c FROM CtactemovimientoView c WHERE c.idempresa = :idempresa")
    , @NamedQuery(name = "CtactemovimientoView.findByIdperiodo", query = "SELECT c FROM CtactemovimientoView c WHERE c.idperiodo = :idperiodo")
    , @NamedQuery(name = "CtactemovimientoView.findByIdsucursal", query = "SELECT c FROM CtactemovimientoView c WHERE c.idsucursal = :idsucursal")
    , @NamedQuery(name = "CtactemovimientoView.findByIddocumento", query = "SELECT c FROM CtactemovimientoView c WHERE c.iddocumento = :iddocumento")
    , @NamedQuery(name = "CtactemovimientoView.findByIddocumentotipo", query = "SELECT c FROM CtactemovimientoView c WHERE c.iddocumentotipo = :iddocumentotipo")
    , @NamedQuery(name = "CtactemovimientoView.findByIdctacte", query = "SELECT c FROM CtactemovimientoView c WHERE c.idctacte = :idctacte")
    , @NamedQuery(name = "CtactemovimientoView.findByIdctactesub", query = "SELECT c FROM CtactemovimientoView c WHERE c.idctactesub = :idctactesub")
    , @NamedQuery(name = "CtactemovimientoView.findByIdcobrador", query = "SELECT c FROM CtactemovimientoView c WHERE c.idcobrador = :idcobrador")
    , @NamedQuery(name = "CtactemovimientoView.findByIdmoneda", query = "SELECT c FROM CtactemovimientoView c WHERE c.idmoneda = :idmoneda")
    , @NamedQuery(name = "CtactemovimientoView.findByIdconcepto", query = "SELECT c FROM CtactemovimientoView c WHERE c.idconcepto = :idconcepto")
    , @NamedQuery(name = "CtactemovimientoView.findByIdsubrubro", query = "SELECT c FROM CtactemovimientoView c WHERE c.idsubrubro = :idsubrubro")
    , @NamedQuery(name = "CtactemovimientoView.findByIdctbcuenta", query = "SELECT c FROM CtactemovimientoView c WHERE c.idctbcuenta = :idctbcuenta")
    , @NamedQuery(name = "CtactemovimientoView.findByIdvendedor", query = "SELECT c FROM CtactemovimientoView c WHERE c.idvendedor = :idvendedor")
    , @NamedQuery(name = "CtactemovimientoView.findByIdshpLocal", query = "SELECT c FROM CtactemovimientoView c WHERE c.idshpLocal = :idshpLocal")
    , @NamedQuery(name = "CtactemovimientoView.findByIdtarjprepaga", query = "SELECT c FROM CtactemovimientoView c WHERE c.idtarjprepaga = :idtarjprepaga")
    , @NamedQuery(name = "CtactemovimientoView.findByIditemmovcondicion", query = "SELECT c FROM CtactemovimientoView c WHERE c.iditemmovcondicion = :iditemmovcondicion")
    , @NamedQuery(name = "CtactemovimientoView.findByIdctactegarantia", query = "SELECT c FROM CtactemovimientoView c WHERE c.idctactegarantia = :idctactegarantia")
    , @NamedQuery(name = "CtactemovimientoView.findByIdctactebancoprestamotipo", query = "SELECT c FROM CtactemovimientoView c WHERE c.idctactebancoprestamotipo = :idctactebancoprestamotipo")
    , @NamedQuery(name = "CtactemovimientoView.findByTimbrado", query = "SELECT c FROM CtactemovimientoView c WHERE c.timbrado = :timbrado")
    , @NamedQuery(name = "CtactemovimientoView.findByTimbradoTipo", query = "SELECT c FROM CtactemovimientoView c WHERE c.timbradoTipo = :timbradoTipo")
    , @NamedQuery(name = "CtactemovimientoView.findBySecuencia", query = "SELECT c FROM CtactemovimientoView c WHERE c.secuencia = :secuencia")
    , @NamedQuery(name = "CtactemovimientoView.findByNro", query = "SELECT c FROM CtactemovimientoView c WHERE c.nro = :nro")
    , @NamedQuery(name = "CtactemovimientoView.findByFecha", query = "SELECT c FROM CtactemovimientoView c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CtactemovimientoView.findByTotalmonto", query = "SELECT c FROM CtactemovimientoView c WHERE c.totalmonto = :totalmonto")
    , @NamedQuery(name = "CtactemovimientoView.findByTotalmora", query = "SELECT c FROM CtactemovimientoView c WHERE c.totalmora = :totalmora")
    , @NamedQuery(name = "CtactemovimientoView.findByTotalinteres", query = "SELECT c FROM CtactemovimientoView c WHERE c.totalinteres = :totalinteres")
    , @NamedQuery(name = "CtactemovimientoView.findByTotaldescuento", query = "SELECT c FROM CtactemovimientoView c WHERE c.totaldescuento = :totaldescuento")
    , @NamedQuery(name = "CtactemovimientoView.findByTotalcobranzarecargo", query = "SELECT c FROM CtactemovimientoView c WHERE c.totalcobranzarecargo = :totalcobranzarecargo")
    , @NamedQuery(name = "CtactemovimientoView.findByCambio", query = "SELECT c FROM CtactemovimientoView c WHERE c.cambio = :cambio")
    , @NamedQuery(name = "CtactemovimientoView.findByObservacion", query = "SELECT c FROM CtactemovimientoView c WHERE c.observacion = :observacion")
    , @NamedQuery(name = "CtactemovimientoView.findByVentanilla", query = "SELECT c FROM CtactemovimientoView c WHERE c.ventanilla = :ventanilla")
    , @NamedQuery(name = "CtactemovimientoView.findByConfirmado", query = "SELECT c FROM CtactemovimientoView c WHERE c.confirmado = :confirmado")
    , @NamedQuery(name = "CtactemovimientoView.findByAnulado", query = "SELECT c FROM CtactemovimientoView c WHERE c.anulado = :anulado")
    , @NamedQuery(name = "CtactemovimientoView.findByCtacteafecta", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctacteafecta = :ctacteafecta")
    , @NamedQuery(name = "CtactemovimientoView.findByFechareplicacion", query = "SELECT c FROM CtactemovimientoView c WHERE c.fechareplicacion = :fechareplicacion")
    , @NamedQuery(name = "CtactemovimientoView.findByFechamodificacion", query = "SELECT c FROM CtactemovimientoView c WHERE c.fechamodificacion = :fechamodificacion")
    , @NamedQuery(name = "CtactemovimientoView.findByFechacreacion", query = "SELECT c FROM CtactemovimientoView c WHERE c.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "CtactemovimientoView.findByFirma", query = "SELECT c FROM CtactemovimientoView c WHERE c.firma = :firma")
    , @NamedQuery(name = "CtactemovimientoView.findByAuditUk", query = "SELECT c FROM CtactemovimientoView c WHERE c.auditUk = :auditUk")
    , @NamedQuery(name = "CtactemovimientoView.findByAppuser", query = "SELECT c FROM CtactemovimientoView c WHERE c.appuser = :appuser")
    , @NamedQuery(name = "CtactemovimientoView.findByIdempresasucursal", query = "SELECT c FROM CtactemovimientoView c WHERE c.idempresasucursal = :idempresasucursal")
    , @NamedQuery(name = "CtactemovimientoView.findBySucursal", query = "SELECT c FROM CtactemovimientoView c WHERE c.sucursal = :sucursal")
    , @NamedQuery(name = "CtactemovimientoView.findBySucursalnombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.sucursalnombre = :sucursalnombre")
    , @NamedQuery(name = "CtactemovimientoView.findByCtacte", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctacte = :ctacte")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactenombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactenombre = :ctactenombre")
    , @NamedQuery(name = "CtactemovimientoView.findByEscliente", query = "SELECT c FROM CtactemovimientoView c WHERE c.escliente = :escliente")
    , @NamedQuery(name = "CtactemovimientoView.findByEsproveedor", query = "SELECT c FROM CtactemovimientoView c WHERE c.esproveedor = :esproveedor")
    , @NamedQuery(name = "CtactemovimientoView.findByRuc", query = "SELECT c FROM CtactemovimientoView c WHERE c.ruc = :ruc")
    , @NamedQuery(name = "CtactemovimientoView.findByDireccion", query = "SELECT c FROM CtactemovimientoView c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactesub", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactesub = :ctactesub")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactesubnombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactesubnombre = :ctactesubnombre")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactesubruc", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactesubruc = :ctactesubruc")
    , @NamedQuery(name = "CtactemovimientoView.findByTarjprepaga", query = "SELECT c FROM CtactemovimientoView c WHERE c.tarjprepaga = :tarjprepaga")
    , @NamedQuery(name = "CtactemovimientoView.findByCobrador", query = "SELECT c FROM CtactemovimientoView c WHERE c.cobrador = :cobrador")
    , @NamedQuery(name = "CtactemovimientoView.findByCobradornombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.cobradornombre = :cobradornombre")
    , @NamedQuery(name = "CtactemovimientoView.findByCobradorcomision", query = "SELECT c FROM CtactemovimientoView c WHERE c.cobradorcomision = :cobradorcomision")
    , @NamedQuery(name = "CtactemovimientoView.findByMoneda", query = "SELECT c FROM CtactemovimientoView c WHERE c.moneda = :moneda")
    , @NamedQuery(name = "CtactemovimientoView.findByConcepto", query = "SELECT c FROM CtactemovimientoView c WHERE c.concepto = :concepto")
    , @NamedQuery(name = "CtactemovimientoView.findByConceptonombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.conceptonombre = :conceptonombre")
    , @NamedQuery(name = "CtactemovimientoView.findBySubrubro", query = "SELECT c FROM CtactemovimientoView c WHERE c.subrubro = :subrubro")
    , @NamedQuery(name = "CtactemovimientoView.findBySubrubronombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.subrubronombre = :subrubronombre")
    , @NamedQuery(name = "CtactemovimientoView.findByIdrubro", query = "SELECT c FROM CtactemovimientoView c WHERE c.idrubro = :idrubro")
    , @NamedQuery(name = "CtactemovimientoView.findByRubro", query = "SELECT c FROM CtactemovimientoView c WHERE c.rubro = :rubro")
    , @NamedQuery(name = "CtactemovimientoView.findByRubronombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.rubronombre = :rubronombre")
    , @NamedQuery(name = "CtactemovimientoView.findByCtbcuenta", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctbcuenta = :ctbcuenta")
    , @NamedQuery(name = "CtactemovimientoView.findByCtbcuentanombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctbcuentanombre = :ctbcuentanombre")
    , @NamedQuery(name = "CtactemovimientoView.findByVendedor", query = "SELECT c FROM CtactemovimientoView c WHERE c.vendedor = :vendedor")
    , @NamedQuery(name = "CtactemovimientoView.findByVendedornombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.vendedornombre = :vendedornombre")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactetipo", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactetipo = :ctactetipo")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactetiponombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactetiponombre = :ctactetiponombre")
    , @NamedQuery(name = "CtactemovimientoView.findByShpLocal", query = "SELECT c FROM CtactemovimientoView c WHERE c.shpLocal = :shpLocal")
    , @NamedQuery(name = "CtactemovimientoView.findByShpLocalnombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.shpLocalnombre = :shpLocalnombre")
    , @NamedQuery(name = "CtactemovimientoView.findByItemmovcondicion", query = "SELECT c FROM CtactemovimientoView c WHERE c.itemmovcondicion = :itemmovcondicion")
    , @NamedQuery(name = "CtactemovimientoView.findByItemmovcondicionnombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.itemmovcondicionnombre = :itemmovcondicionnombre")
    , @NamedQuery(name = "CtactemovimientoView.findByDocumentonombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.documentonombre = :documentonombre")
    , @NamedQuery(name = "CtactemovimientoView.findByDocumentotiponombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.documentotiponombre = :documentotiponombre")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactebancoprestamotipo", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactebancoprestamotipo = :ctactebancoprestamotipo")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactebancoprestamotiponombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactebancoprestamotiponombre = :ctactebancoprestamotiponombre")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactegarantia", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactegarantia = :ctactegarantia")
    , @NamedQuery(name = "CtactemovimientoView.findByCtactegarantianombre", query = "SELECT c FROM CtactemovimientoView c WHERE c.ctactegarantianombre = :ctactegarantianombre")})
public class CtactemovimientoView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idctactemovimiento")
    private long idctactemovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperiodo")
    private long idperiodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsucursal")
    private long idsucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iddocumento")
    private String iddocumento;
    @Size(max = 2)
    @Column(name = "iddocumentotipo")
    private String iddocumentotipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacte")
    private long idctacte;
    @Column(name = "idctactesub")
    private Long idctactesub;
    @Column(name = "idcobrador")
    private Long idcobrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmoneda")
    private long idmoneda;
    @Column(name = "idconcepto")
    private Long idconcepto;
    @Column(name = "idsubrubro")
    private Long idsubrubro;
    @Column(name = "idctbcuenta")
    private Long idctbcuenta;
    @Column(name = "idvendedor")
    private Long idvendedor;
    @Column(name = "idshp_local")
    private Long idshpLocal;
    @Column(name = "idtarjprepaga")
    private Long idtarjprepaga;
    @Column(name = "iditemmovcondicion")
    private Long iditemmovcondicion;
    @Column(name = "idctactegarantia")
    private Long idctactegarantia;
    @Column(name = "idctactebancoprestamotipo")
    private Long idctactebancoprestamotipo;
    @Size(max = 11)
    @Column(name = "timbrado")
    private String timbrado;
    @Column(name = "timbrado_tipo")
    private Character timbradoTipo;
    @Size(max = 7)
    @Column(name = "secuencia")
    private String secuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nro")
    private String nro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalmonto")
    private BigDecimal totalmonto;
    @Column(name = "totalmora")
    private BigDecimal totalmora;
    @Column(name = "totalinteres")
    private BigDecimal totalinteres;
    @Column(name = "totaldescuento")
    private BigDecimal totaldescuento;
    @Column(name = "totalcobranzarecargo")
    private BigDecimal totalcobranzarecargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio")
    private BigDecimal cambio;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventanilla")
    private boolean ventanilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmado")
    private boolean confirmado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anulado")
    private boolean anulado;
    @Column(name = "ctacteafecta")
    private Short ctacteafecta;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 15)
    @Column(name = "audit_uk")
    private String auditUk;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "idempresasucursal")
    private String idempresasucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sucursalnombre")
    private String sucursalnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ctacte")
    private String ctacte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ctactenombre")
    private String ctactenombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escliente")
    private short escliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esproveedor")
    private short esproveedor;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "ctactesub")
    private String ctactesub;
    @Size(max = 50)
    @Column(name = "ctactesubnombre")
    private String ctactesubnombre;
    @Size(max = 11)
    @Column(name = "ctactesubruc")
    private String ctactesubruc;
    @Size(max = 15)
    @Column(name = "tarjprepaga")
    private String tarjprepaga;
    @Size(max = 11)
    @Column(name = "cobrador")
    private String cobrador;
    @Size(max = 50)
    @Column(name = "cobradornombre")
    private String cobradornombre;
    @Column(name = "cobradorcomision")
    private BigDecimal cobradorcomision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 2)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 30)
    @Column(name = "conceptonombre")
    private String conceptonombre;
    @Size(max = 2)
    @Column(name = "subrubro")
    private String subrubro;
    @Size(max = 50)
    @Column(name = "subrubronombre")
    private String subrubronombre;
    @Column(name = "idrubro")
    private Long idrubro;
    @Size(max = 2)
    @Column(name = "rubro")
    private String rubro;
    @Size(max = 50)
    @Column(name = "rubronombre")
    private String rubronombre;
    @Size(max = 15)
    @Column(name = "ctbcuenta")
    private String ctbcuenta;
    @Size(max = 50)
    @Column(name = "ctbcuentanombre")
    private String ctbcuentanombre;
    @Size(max = 11)
    @Column(name = "vendedor")
    private String vendedor;
    @Size(max = 50)
    @Column(name = "vendedornombre")
    private String vendedornombre;
    @Size(max = 2)
    @Column(name = "ctactetipo")
    private String ctactetipo;
    @Size(max = 30)
    @Column(name = "ctactetiponombre")
    private String ctactetiponombre;
    @Size(max = 10)
    @Column(name = "shp_local")
    private String shpLocal;
    @Size(max = 50)
    @Column(name = "shp_localnombre")
    private String shpLocalnombre;
    @Size(max = 3)
    @Column(name = "itemmovcondicion")
    private String itemmovcondicion;
    @Size(max = 50)
    @Column(name = "itemmovcondicionnombre")
    private String itemmovcondicionnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documentonombre")
    private String documentonombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documentotiponombre")
    private String documentotiponombre;
    @Size(max = 2)
    @Column(name = "ctactebancoprestamotipo")
    private String ctactebancoprestamotipo;
    @Size(max = 30)
    @Column(name = "ctactebancoprestamotiponombre")
    private String ctactebancoprestamotiponombre;
    @Size(max = 10)
    @Column(name = "ctactegarantia")
    private String ctactegarantia;
    @Size(max = 100)
    @Column(name = "ctactegarantianombre")
    private String ctactegarantianombre;

    public CtactemovimientoView() {
    }

    public long getIdctactemovimiento() {
        return idctactemovimiento;
    }

    public void setIdctactemovimiento(long idctactemovimiento) {
        this.idctactemovimiento = idctactemovimiento;
    }

    public String getIdnro() {
        return idnro;
    }

    public void setIdnro(String idnro) {
        this.idnro = idnro;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(long idperiodo) {
        this.idperiodo = idperiodo;
    }

    public long getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(long idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getIddocumentotipo() {
        return iddocumentotipo;
    }

    public void setIddocumentotipo(String iddocumentotipo) {
        this.iddocumentotipo = iddocumentotipo;
    }

    public long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(long idctacte) {
        this.idctacte = idctacte;
    }

    public Long getIdctactesub() {
        return idctactesub;
    }

    public void setIdctactesub(Long idctactesub) {
        this.idctactesub = idctactesub;
    }

    public Long getIdcobrador() {
        return idcobrador;
    }

    public void setIdcobrador(Long idcobrador) {
        this.idcobrador = idcobrador;
    }

    public long getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Long getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Long idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Long getIdsubrubro() {
        return idsubrubro;
    }

    public void setIdsubrubro(Long idsubrubro) {
        this.idsubrubro = idsubrubro;
    }

    public Long getIdctbcuenta() {
        return idctbcuenta;
    }

    public void setIdctbcuenta(Long idctbcuenta) {
        this.idctbcuenta = idctbcuenta;
    }

    public Long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Long getIdshpLocal() {
        return idshpLocal;
    }

    public void setIdshpLocal(Long idshpLocal) {
        this.idshpLocal = idshpLocal;
    }

    public Long getIdtarjprepaga() {
        return idtarjprepaga;
    }

    public void setIdtarjprepaga(Long idtarjprepaga) {
        this.idtarjprepaga = idtarjprepaga;
    }

    public Long getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(Long iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public Long getIdctactegarantia() {
        return idctactegarantia;
    }

    public void setIdctactegarantia(Long idctactegarantia) {
        this.idctactegarantia = idctactegarantia;
    }

    public Long getIdctactebancoprestamotipo() {
        return idctactebancoprestamotipo;
    }

    public void setIdctactebancoprestamotipo(Long idctactebancoprestamotipo) {
        this.idctactebancoprestamotipo = idctactebancoprestamotipo;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Character getTimbradoTipo() {
        return timbradoTipo;
    }

    public void setTimbradoTipo(Character timbradoTipo) {
        this.timbradoTipo = timbradoTipo;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotalmonto() {
        return totalmonto;
    }

    public void setTotalmonto(BigDecimal totalmonto) {
        this.totalmonto = totalmonto;
    }

    public BigDecimal getTotalmora() {
        return totalmora;
    }

    public void setTotalmora(BigDecimal totalmora) {
        this.totalmora = totalmora;
    }

    public BigDecimal getTotalinteres() {
        return totalinteres;
    }

    public void setTotalinteres(BigDecimal totalinteres) {
        this.totalinteres = totalinteres;
    }

    public BigDecimal getTotaldescuento() {
        return totaldescuento;
    }

    public void setTotaldescuento(BigDecimal totaldescuento) {
        this.totaldescuento = totaldescuento;
    }

    public BigDecimal getTotalcobranzarecargo() {
        return totalcobranzarecargo;
    }

    public void setTotalcobranzarecargo(BigDecimal totalcobranzarecargo) {
        this.totalcobranzarecargo = totalcobranzarecargo;
    }

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getVentanilla() {
        return ventanilla;
    }

    public void setVentanilla(boolean ventanilla) {
        this.ventanilla = ventanilla;
    }

    public boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public Short getCtacteafecta() {
        return ctacteafecta;
    }

    public void setCtacteafecta(Short ctacteafecta) {
        this.ctacteafecta = ctacteafecta;
    }

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getAuditUk() {
        return auditUk;
    }

    public void setAuditUk(String auditUk) {
        this.auditUk = auditUk;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getIdempresasucursal() {
        return idempresasucursal;
    }

    public void setIdempresasucursal(String idempresasucursal) {
        this.idempresasucursal = idempresasucursal;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getSucursalnombre() {
        return sucursalnombre;
    }

    public void setSucursalnombre(String sucursalnombre) {
        this.sucursalnombre = sucursalnombre;
    }

    public String getCtacte() {
        return ctacte;
    }

    public void setCtacte(String ctacte) {
        this.ctacte = ctacte;
    }

    public String getCtactenombre() {
        return ctactenombre;
    }

    public void setCtactenombre(String ctactenombre) {
        this.ctactenombre = ctactenombre;
    }

    public short getEscliente() {
        return escliente;
    }

    public void setEscliente(short escliente) {
        this.escliente = escliente;
    }

    public short getEsproveedor() {
        return esproveedor;
    }

    public void setEsproveedor(short esproveedor) {
        this.esproveedor = esproveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCtactesub() {
        return ctactesub;
    }

    public void setCtactesub(String ctactesub) {
        this.ctactesub = ctactesub;
    }

    public String getCtactesubnombre() {
        return ctactesubnombre;
    }

    public void setCtactesubnombre(String ctactesubnombre) {
        this.ctactesubnombre = ctactesubnombre;
    }

    public String getCtactesubruc() {
        return ctactesubruc;
    }

    public void setCtactesubruc(String ctactesubruc) {
        this.ctactesubruc = ctactesubruc;
    }

    public String getTarjprepaga() {
        return tarjprepaga;
    }

    public void setTarjprepaga(String tarjprepaga) {
        this.tarjprepaga = tarjprepaga;
    }

    public String getCobrador() {
        return cobrador;
    }

    public void setCobrador(String cobrador) {
        this.cobrador = cobrador;
    }

    public String getCobradornombre() {
        return cobradornombre;
    }

    public void setCobradornombre(String cobradornombre) {
        this.cobradornombre = cobradornombre;
    }

    public BigDecimal getCobradorcomision() {
        return cobradorcomision;
    }

    public void setCobradorcomision(BigDecimal cobradorcomision) {
        this.cobradorcomision = cobradorcomision;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConceptonombre() {
        return conceptonombre;
    }

    public void setConceptonombre(String conceptonombre) {
        this.conceptonombre = conceptonombre;
    }

    public String getSubrubro() {
        return subrubro;
    }

    public void setSubrubro(String subrubro) {
        this.subrubro = subrubro;
    }

    public String getSubrubronombre() {
        return subrubronombre;
    }

    public void setSubrubronombre(String subrubronombre) {
        this.subrubronombre = subrubronombre;
    }

    public Long getIdrubro() {
        return idrubro;
    }

    public void setIdrubro(Long idrubro) {
        this.idrubro = idrubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRubronombre() {
        return rubronombre;
    }

    public void setRubronombre(String rubronombre) {
        this.rubronombre = rubronombre;
    }

    public String getCtbcuenta() {
        return ctbcuenta;
    }

    public void setCtbcuenta(String ctbcuenta) {
        this.ctbcuenta = ctbcuenta;
    }

    public String getCtbcuentanombre() {
        return ctbcuentanombre;
    }

    public void setCtbcuentanombre(String ctbcuentanombre) {
        this.ctbcuentanombre = ctbcuentanombre;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getVendedornombre() {
        return vendedornombre;
    }

    public void setVendedornombre(String vendedornombre) {
        this.vendedornombre = vendedornombre;
    }

    public String getCtactetipo() {
        return ctactetipo;
    }

    public void setCtactetipo(String ctactetipo) {
        this.ctactetipo = ctactetipo;
    }

    public String getCtactetiponombre() {
        return ctactetiponombre;
    }

    public void setCtactetiponombre(String ctactetiponombre) {
        this.ctactetiponombre = ctactetiponombre;
    }

    public String getShpLocal() {
        return shpLocal;
    }

    public void setShpLocal(String shpLocal) {
        this.shpLocal = shpLocal;
    }

    public String getShpLocalnombre() {
        return shpLocalnombre;
    }

    public void setShpLocalnombre(String shpLocalnombre) {
        this.shpLocalnombre = shpLocalnombre;
    }

    public String getItemmovcondicion() {
        return itemmovcondicion;
    }

    public void setItemmovcondicion(String itemmovcondicion) {
        this.itemmovcondicion = itemmovcondicion;
    }

    public String getItemmovcondicionnombre() {
        return itemmovcondicionnombre;
    }

    public void setItemmovcondicionnombre(String itemmovcondicionnombre) {
        this.itemmovcondicionnombre = itemmovcondicionnombre;
    }

    public String getDocumentonombre() {
        return documentonombre;
    }

    public void setDocumentonombre(String documentonombre) {
        this.documentonombre = documentonombre;
    }

    public String getDocumentotiponombre() {
        return documentotiponombre;
    }

    public void setDocumentotiponombre(String documentotiponombre) {
        this.documentotiponombre = documentotiponombre;
    }

    public String getCtactebancoprestamotipo() {
        return ctactebancoprestamotipo;
    }

    public void setCtactebancoprestamotipo(String ctactebancoprestamotipo) {
        this.ctactebancoprestamotipo = ctactebancoprestamotipo;
    }

    public String getCtactebancoprestamotiponombre() {
        return ctactebancoprestamotiponombre;
    }

    public void setCtactebancoprestamotiponombre(String ctactebancoprestamotiponombre) {
        this.ctactebancoprestamotiponombre = ctactebancoprestamotiponombre;
    }

    public String getCtactegarantia() {
        return ctactegarantia;
    }

    public void setCtactegarantia(String ctactegarantia) {
        this.ctactegarantia = ctactegarantia;
    }

    public String getCtactegarantianombre() {
        return ctactegarantianombre;
    }

    public void setCtactegarantianombre(String ctactegarantianombre) {
        this.ctactegarantianombre = ctactegarantianombre;
    }
    
}
