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
import javax.persistence.Lob;
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
 * @author JORGE
 */
@Entity
@Table(name = "itemmovimiento_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemmovimientoView.findAll", query = "SELECT i FROM ItemmovimientoView i")})
public class ItemmovimientoView implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemmovimiento")
    private long iditemmovimiento;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "iddocumentotipo")
    private String iddocumentotipo;

    @Column(name = "idctacte")
    private Long idctacte;
    @Column(name = "idctactesub")
    private Long idctactesub;
    @Column(name = "idpersonasitio_envio")
    private Long idpersonasitioEnvio;
    @Column(name = "idvendedor")
    private Long idvendedor;
    @Column(name = "idconcepto")
    private Long idconcepto;
    @Column(name = "idmoneda")
    private Long idmoneda;
    @Column(name = "idsubrubro")
    private Long idsubrubro;
    @Column(name = "iditemmovcondicion")
    private Long iditemmovcondicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeposito")
    private long iddeposito;
    @Column(name = "iddepdest")
    private Long iddepdest;
    @Column(name = "idlistaprecio")
    private Long idlistaprecio;
    @Column(name = "identregador")
    private Long identregador;
    @Column(name = "idshp_local")
    private Long idshpLocal;
    @Column(name = "iditemvtapuntocnf")
    private Long iditemvtapuntocnf;
    @Column(name = "idtarjprepaga")
    private Long idtarjprepaga;
    @Column(name = "idcajalog")
    private Long idcajalog;
    @Column(name = "idvehiculo")
    private Long idvehiculo;
    @Size(max = 3)
    @Column(name = "iddocumentoestado")
    private String iddocumentoestado;
    @Size(max = 11)
    @Column(name = "timbrado")
    private String timbrado;
    @Column(name = "timbrado_tipo")
    private Character timbradoTipo;
    @Column(name = "timbrado_vto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timbradoVto;
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
    @Column(name = "fechaentrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrega;
    @Column(name = "fechaafecta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaafecta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal costo;
    @Column(name = "costolocal")
    private BigDecimal costolocal;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private BigDecimal impuesto;
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Column(name = "cambio")
    private BigDecimal cambio;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "obstexto")
    private String obstexto;
    @Column(name = "vencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimiento;
    @Column(name = "nrosolicitud_credito")
    private Long nrosolicitudCredito;
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
    @Column(name = "esimportacion")
    private Short esimportacion;
    @Column(name = "esrecurrente")
    private Short esrecurrente;
    @Column(name = "norecordyet")
    private Boolean norecordyet;
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
    @Column(name = "descuentotax")
    private BigDecimal descuentotax;
    @Column(name = "descuentoporc")
    private BigDecimal descuentoporc;
    @Size(max = 11)
    @Column(name = "ctacte")
    private String ctacte;
    @Size(max = 50)
    @Column(name = "ctactenombre")
    private String ctactenombre;
    @Column(name = "idctactepais")
    private Long idctactepais;
    @Size(max = 4)
    @Column(name = "ctactepais")
    private String ctactepais;
    @Size(max = 30)
    @Column(name = "ctactepaisnombre")
    private String ctactepaisnombre;
    @Column(name = "escliente")
    private Short escliente;
    @Column(name = "esproveedor")
    private Short esproveedor;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "ctactesub")
    private String ctactesub;
    @Size(max = 50)
    @Column(name = "ctactesubnombre")
    private String ctactesubnombre;
    @Size(max = 15)
    @Column(name = "tarjprepaga")
    private String tarjprepaga;
    @Size(max = 11)
    @Column(name = "vendedor")
    private String vendedor;
    @Size(max = 50)
    @Column(name = "vendedornombre")
    private String vendedornombre;
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
    @Column(name = "idempresasucursal")
    private String idempresasucursal;
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
    @Size(max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "deposito")
    private String deposito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "depositonombre")
    private String depositonombre;
    @Size(max = 4)
    @Column(name = "depdest")
    private String depdest;
    @Size(max = 30)
    @Column(name = "depdestnombre")
    private String depdestnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documentotiponombre")
    private String documentotiponombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documentonombre")
    private String documentonombre;
    @Size(max = 20)
    @Column(name = "documentoestadonombre")
    private String documentoestadonombre;
    @Size(max = 2)
    @Column(name = "listaprecio")
    private String listaprecio;
    @Size(max = 50)
    @Column(name = "listaprecionombre")
    private String listaprecionombre;
    @Size(max = 11)
    @Column(name = "entregador")
    private String entregador;
    @Size(max = 50)
    @Column(name = "entregadornombre")
    private String entregadornombre;
    @Column(name = "idrubro")
    private Long idrubro;
    @Size(max = 2)
    @Column(name = "rubro")
    private String rubro;
    @Size(max = 50)
    @Column(name = "rubronombre")
    private String rubronombre;
    @Size(max = 3)
    @Column(name = "itemmovcondicion")
    private String itemmovcondicion;
    @Size(max = 50)
    @Column(name = "itemmovcondicionnombre")
    private String itemmovcondicionnombre;
    @Size(max = 10)
    @Column(name = "shp_local")
    private String shpLocal;
    @Size(max = 50)
    @Column(name = "shp_localnombre")
    private String shpLocalnombre;
    @Size(max = 3)
    @Column(name = "itemvtapuntocnf")
    private String itemvtapuntocnf;
    @Column(name = "tasamoratoria")
    private BigDecimal tasamoratoria;
    @Column(name = "entregainicial")
    private BigDecimal entregainicial;
    @Column(name = "cuotas")
    private Short cuotas;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "diascuota")
    private Integer diascuota;
    @Column(name = "escomprobanteinterno")
    private Boolean escomprobanteinterno;
    @Size(max = 2)
    @Column(name = "caja")
    private String caja;
    @Column(name = "cajalog")
    private Long cajalog;
    @Column(name = "ctbnro")
    private Integer ctbnro;
    @Size(max = 5)
    @Column(name = "vehiculo")
    private String vehiculo;
    @Size(max = 100)
    @Column(name = "vehiculonombre")
    private String vehiculonombre;

    public ItemmovimientoView() {
    }

    public long getIditemmovimiento() {
        return iditemmovimiento;
    }

    public void setIditemmovimiento(long iditemmovimiento) {
        this.iditemmovimiento = iditemmovimiento;
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

    public Long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(Long idctacte) {
        this.idctacte = idctacte;
    }

    public Long getIdctactesub() {
        return idctactesub;
    }

    public void setIdctactesub(Long idctactesub) {
        this.idctactesub = idctactesub;
    }

    public Long getIdpersonasitioEnvio() {
        return idpersonasitioEnvio;
    }

    public void setIdpersonasitioEnvio(Long idpersonasitioEnvio) {
        this.idpersonasitioEnvio = idpersonasitioEnvio;
    }

    public Long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Long getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Long idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Long getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Long getIdsubrubro() {
        return idsubrubro;
    }

    public void setIdsubrubro(Long idsubrubro) {
        this.idsubrubro = idsubrubro;
    }

    public Long getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(Long iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public long getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(long iddeposito) {
        this.iddeposito = iddeposito;
    }

    public Long getIddepdest() {
        return iddepdest;
    }

    public void setIddepdest(Long iddepdest) {
        this.iddepdest = iddepdest;
    }

    public Long getIdlistaprecio() {
        return idlistaprecio;
    }

    public void setIdlistaprecio(Long idlistaprecio) {
        this.idlistaprecio = idlistaprecio;
    }

    public Long getIdentregador() {
        return identregador;
    }

    public void setIdentregador(Long identregador) {
        this.identregador = identregador;
    }

    public Long getIdshpLocal() {
        return idshpLocal;
    }

    public void setIdshpLocal(Long idshpLocal) {
        this.idshpLocal = idshpLocal;
    }

    public Long getIditemvtapuntocnf() {
        return iditemvtapuntocnf;
    }

    public void setIditemvtapuntocnf(Long iditemvtapuntocnf) {
        this.iditemvtapuntocnf = iditemvtapuntocnf;
    }

    public Long getIdtarjprepaga() {
        return idtarjprepaga;
    }

    public void setIdtarjprepaga(Long idtarjprepaga) {
        this.idtarjprepaga = idtarjprepaga;
    }

    public Long getIdcajalog() {
        return idcajalog;
    }

    public void setIdcajalog(Long idcajalog) {
        this.idcajalog = idcajalog;
    }

    public Long getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Long idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getIddocumentoestado() {
        return iddocumentoestado;
    }

    public void setIddocumentoestado(String iddocumentoestado) {
        this.iddocumentoestado = iddocumentoestado;
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

    public Date getTimbradoVto() {
        return timbradoVto;
    }

    public void setTimbradoVto(Date timbradoVto) {
        this.timbradoVto = timbradoVto;
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

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public Date getFechaafecta() {
        return fechaafecta;
    }

    public void setFechaafecta(Date fechaafecta) {
        this.fechaafecta = fechaafecta;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCostolocal() {
        return costolocal;
    }

    public void setCostolocal(BigDecimal costolocal) {
        this.costolocal = costolocal;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
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

    public String getObstexto() {
        return obstexto;
    }

    public void setObstexto(String obstexto) {
        this.obstexto = obstexto;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Long getNrosolicitudCredito() {
        return nrosolicitudCredito;
    }

    public void setNrosolicitudCredito(Long nrosolicitudCredito) {
        this.nrosolicitudCredito = nrosolicitudCredito;
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

    public Short getEsimportacion() {
        return esimportacion;
    }

    public void setEsimportacion(Short esimportacion) {
        this.esimportacion = esimportacion;
    }

    public Short getEsrecurrente() {
        return esrecurrente;
    }

    public void setEsrecurrente(Short esrecurrente) {
        this.esrecurrente = esrecurrente;
    }

    public Boolean getNorecordyet() {
        return norecordyet;
    }

    public void setNorecordyet(Boolean norecordyet) {
        this.norecordyet = norecordyet;
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

    public BigDecimal getDescuentotax() {
        return descuentotax;
    }

    public void setDescuentotax(BigDecimal descuentotax) {
        this.descuentotax = descuentotax;
    }

    public BigDecimal getDescuentoporc() {
        return descuentoporc;
    }

    public void setDescuentoporc(BigDecimal descuentoporc) {
        this.descuentoporc = descuentoporc;
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

    public Long getIdctactepais() {
        return idctactepais;
    }

    public void setIdctactepais(Long idctactepais) {
        this.idctactepais = idctactepais;
    }

    public String getCtactepais() {
        return ctactepais;
    }

    public void setCtactepais(String ctactepais) {
        this.ctactepais = ctactepais;
    }

    public String getCtactepaisnombre() {
        return ctactepaisnombre;
    }

    public void setCtactepaisnombre(String ctactepaisnombre) {
        this.ctactepaisnombre = ctactepaisnombre;
    }

    public Short getEscliente() {
        return escliente;
    }

    public void setEscliente(Short escliente) {
        this.escliente = escliente;
    }

    public Short getEsproveedor() {
        return esproveedor;
    }

    public void setEsproveedor(Short esproveedor) {
        this.esproveedor = esproveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getTarjprepaga() {
        return tarjprepaga;
    }

    public void setTarjprepaga(String tarjprepaga) {
        this.tarjprepaga = tarjprepaga;
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

    public String getIdempresasucursal() {
        return idempresasucursal;
    }

    public void setIdempresasucursal(String idempresasucursal) {
        this.idempresasucursal = idempresasucursal;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public String getDepositonombre() {
        return depositonombre;
    }

    public void setDepositonombre(String depositonombre) {
        this.depositonombre = depositonombre;
    }

    public String getDepdest() {
        return depdest;
    }

    public void setDepdest(String depdest) {
        this.depdest = depdest;
    }

    public String getDepdestnombre() {
        return depdestnombre;
    }

    public void setDepdestnombre(String depdestnombre) {
        this.depdestnombre = depdestnombre;
    }

    public String getDocumentotiponombre() {
        return documentotiponombre;
    }

    public void setDocumentotiponombre(String documentotiponombre) {
        this.documentotiponombre = documentotiponombre;
    }

    public String getDocumentonombre() {
        return documentonombre;
    }

    public void setDocumentonombre(String documentonombre) {
        this.documentonombre = documentonombre;
    }

    public String getDocumentoestadonombre() {
        return documentoestadonombre;
    }

    public void setDocumentoestadonombre(String documentoestadonombre) {
        this.documentoestadonombre = documentoestadonombre;
    }

    public String getListaprecio() {
        return listaprecio;
    }

    public void setListaprecio(String listaprecio) {
        this.listaprecio = listaprecio;
    }

    public String getListaprecionombre() {
        return listaprecionombre;
    }

    public void setListaprecionombre(String listaprecionombre) {
        this.listaprecionombre = listaprecionombre;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public String getEntregadornombre() {
        return entregadornombre;
    }

    public void setEntregadornombre(String entregadornombre) {
        this.entregadornombre = entregadornombre;
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

    public String getItemvtapuntocnf() {
        return itemvtapuntocnf;
    }

    public void setItemvtapuntocnf(String itemvtapuntocnf) {
        this.itemvtapuntocnf = itemvtapuntocnf;
    }

    public BigDecimal getTasamoratoria() {
        return tasamoratoria;
    }

    public void setTasamoratoria(BigDecimal tasamoratoria) {
        this.tasamoratoria = tasamoratoria;
    }

    public BigDecimal getEntregainicial() {
        return entregainicial;
    }

    public void setEntregainicial(BigDecimal entregainicial) {
        this.entregainicial = entregainicial;
    }

    public Short getCuotas() {
        return cuotas;
    }

    public void setCuotas(Short cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getDiascuota() {
        return diascuota;
    }

    public void setDiascuota(Integer diascuota) {
        this.diascuota = diascuota;
    }

    public Boolean getEscomprobanteinterno() {
        return escomprobanteinterno;
    }

    public void setEscomprobanteinterno(Boolean escomprobanteinterno) {
        this.escomprobanteinterno = escomprobanteinterno;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public Long getCajalog() {
        return cajalog;
    }

    public void setCajalog(Long cajalog) {
        this.cajalog = cajalog;
    }

    public Integer getCtbnro() {
        return ctbnro;
    }

    public void setCtbnro(Integer ctbnro) {
        this.ctbnro = ctbnro;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getVehiculonombre() {
        return vehiculonombre;
    }

    public void setVehiculonombre(String vehiculonombre) {
        this.vehiculonombre = vehiculonombre;
    }
    
}
