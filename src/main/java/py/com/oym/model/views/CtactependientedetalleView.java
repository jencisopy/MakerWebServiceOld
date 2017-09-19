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
@Table(name = "ctactependientedetalle_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtactependientedetalleView.findAll", query = "SELECT c FROM CtactependientedetalleView c")})
public class CtactependientedetalleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctactependientedetalle")
    private long idctactependientedetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctactependiente")
    private long idctactependiente;
    @Column(name = "idctactedeposito")
    private Long idctactedeposito;
    @Column(name = "cuota")
    private Short cuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotatipo")
    private short cuotatipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ven")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVen;
    @Column(name = "ultpago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultpago;
    @Column(name = "fechaestcancel")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaestcancel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "capital")
    private BigDecimal capital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoanterior")
    private BigDecimal saldoanterior;
    @Column(name = "interesdevengar")
    private BigDecimal interesdevengar;
    @Column(name = "impuestoporc")
    private BigDecimal impuestoporc;
    @Column(name = "impuestobase")
    private BigDecimal impuestobase;
    @Column(name = "montoimpuesto")
    private BigDecimal montoimpuesto;
    @Column(name = "montomora")
    private BigDecimal montomora;
    @Size(max = 50)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "nroentrega")
    private Long nroentrega;
    @Column(name = "fechaentrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrega;
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
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @Column(name = "interesdevengarrestar")
    private BigDecimal interesdevengarrestar;
    @Column(name = "totalcuotatipo")
    private Long totalcuotatipo;
    @Column(name = "descuentopagoantic")
    private BigDecimal descuentopagoantic;
    @Column(name = "interes")
    private BigDecimal interes;
    @Size(max = 30)
    @Column(name = "cuotatiponombre")
    private String cuotatiponombre;
    @Column(name = "no_recargos")
    private Boolean noRecargos;
    @Column(name = "totalcuota")
    private Long totalcuota;
    @Column(name = "primervto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primervto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalsaldo")
    private BigDecimal totalsaldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iddocumento")
    private String iddocumento;
    @Size(max = 2)
    @Column(name = "iddocumentotipo")
    private String iddocumentotipo;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalmonto")
    private BigDecimal totalmonto;
    @Size(max = 2)
    @Column(name = "sucursal")
    private String sucursal;
    @Size(max = 50)
    @Column(name = "sucursalnombre")
    private String sucursalnombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacte")
    private long idctacte;
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
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "idctactesub")
    private Long idctactesub;
    @Size(max = 10)
    @Column(name = "ctactesub")
    private String ctactesub;
    @Size(max = 50)
    @Column(name = "ctactesubnombre")
    private String ctactesubnombre;
    @Size(max = 11)
    @Column(name = "ctactesubruc")
    private String ctactesubruc;
    @Size(max = 100)
    @Column(name = "ctactesubdireccion")
    private String ctactesubdireccion;
    @Size(max = 30)
    @Column(name = "ctactesubtelefono")
    private String ctactesubtelefono;
    @Size(max = 11)
    @Column(name = "vendedor")
    private String vendedor;
    @Size(max = 50)
    @Column(name = "vendedornombre")
    private String vendedornombre;
    @Size(max = 2)
    @Column(name = "rubro")
    private String rubro;
    @Size(max = 2)
    @Column(name = "subrubro")
    private String subrubro;
    @Size(max = 50)
    @Column(name = "subrubronombre")
    private String subrubronombre;
    @Size(max = 3)
    @Column(name = "itemmovcondicion")
    private String itemmovcondicion;
    @Size(max = 2)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 30)
    @Column(name = "conceptonombre")
    private String conceptonombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 11)
    @Column(name = "cobrador")
    private String cobrador;
    @Size(max = 50)
    @Column(name = "cobradornombre")
    private String cobradornombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio")
    private BigDecimal cambio;
    @Column(name = "ctacteruta")
    private Long ctacteruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa")
    private BigDecimal tasa;
    @Column(name = "tasamoratoria")
    private BigDecimal tasamoratoria;
    @Column(name = "tolerancia")
    private Long tolerancia;
    @Column(name = "ctacteafecta")
    private Short ctacteafecta;
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
    @Size(max = 10)
    @Column(name = "ctactedeposito")
    private String ctactedeposito;
    @Size(max = 50)
    @Column(name = "ctactedepositonombre")
    private String ctactedepositonombre;
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

    public CtactependientedetalleView() {
    }

    public long getIdctactependientedetalle() {
        return idctactependientedetalle;
    }

    public void setIdctactependientedetalle(long idctactependientedetalle) {
        this.idctactependientedetalle = idctactependientedetalle;
    }

    public long getIdctactependiente() {
        return idctactependiente;
    }

    public void setIdctactependiente(long idctactependiente) {
        this.idctactependiente = idctactependiente;
    }

    public Long getIdctactedeposito() {
        return idctactedeposito;
    }

    public void setIdctactedeposito(Long idctactedeposito) {
        this.idctactedeposito = idctactedeposito;
    }

    public Short getCuota() {
        return cuota;
    }

    public void setCuota(Short cuota) {
        this.cuota = cuota;
    }

    public short getCuotatipo() {
        return cuotatipo;
    }

    public void setCuotatipo(short cuotatipo) {
        this.cuotatipo = cuotatipo;
    }

    public Date getFecVen() {
        return fecVen;
    }

    public void setFecVen(Date fecVen) {
        this.fecVen = fecVen;
    }

    public Date getUltpago() {
        return ultpago;
    }

    public void setUltpago(Date ultpago) {
        this.ultpago = ultpago;
    }

    public Date getFechaestcancel() {
        return fechaestcancel;
    }

    public void setFechaestcancel(Date fechaestcancel) {
        this.fechaestcancel = fechaestcancel;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldoanterior() {
        return saldoanterior;
    }

    public void setSaldoanterior(BigDecimal saldoanterior) {
        this.saldoanterior = saldoanterior;
    }

    public BigDecimal getInteresdevengar() {
        return interesdevengar;
    }

    public void setInteresdevengar(BigDecimal interesdevengar) {
        this.interesdevengar = interesdevengar;
    }

    public BigDecimal getImpuestoporc() {
        return impuestoporc;
    }

    public void setImpuestoporc(BigDecimal impuestoporc) {
        this.impuestoporc = impuestoporc;
    }

    public BigDecimal getImpuestobase() {
        return impuestobase;
    }

    public void setImpuestobase(BigDecimal impuestobase) {
        this.impuestobase = impuestobase;
    }

    public BigDecimal getMontoimpuesto() {
        return montoimpuesto;
    }

    public void setMontoimpuesto(BigDecimal montoimpuesto) {
        this.montoimpuesto = montoimpuesto;
    }

    public BigDecimal getMontomora() {
        return montomora;
    }

    public void setMontomora(BigDecimal montomora) {
        this.montomora = montomora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getNroentrega() {
        return nroentrega;
    }

    public void setNroentrega(Long nroentrega) {
        this.nroentrega = nroentrega;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
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

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public BigDecimal getInteresdevengarrestar() {
        return interesdevengarrestar;
    }

    public void setInteresdevengarrestar(BigDecimal interesdevengarrestar) {
        this.interesdevengarrestar = interesdevengarrestar;
    }

    public Long getTotalcuotatipo() {
        return totalcuotatipo;
    }

    public void setTotalcuotatipo(Long totalcuotatipo) {
        this.totalcuotatipo = totalcuotatipo;
    }

    public BigDecimal getDescuentopagoantic() {
        return descuentopagoantic;
    }

    public void setDescuentopagoantic(BigDecimal descuentopagoantic) {
        this.descuentopagoantic = descuentopagoantic;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public String getCuotatiponombre() {
        return cuotatiponombre;
    }

    public void setCuotatiponombre(String cuotatiponombre) {
        this.cuotatiponombre = cuotatiponombre;
    }

    public Boolean getNoRecargos() {
        return noRecargos;
    }

    public void setNoRecargos(Boolean noRecargos) {
        this.noRecargos = noRecargos;
    }

    public Long getTotalcuota() {
        return totalcuota;
    }

    public void setTotalcuota(Long totalcuota) {
        this.totalcuota = totalcuota;
    }

    public Date getPrimervto() {
        return primervto;
    }

    public void setPrimervto(Date primervto) {
        this.primervto = primervto;
    }

    public BigDecimal getTotalsaldo() {
        return totalsaldo;
    }

    public void setTotalsaldo(BigDecimal totalsaldo) {
        this.totalsaldo = totalsaldo;
    }

    public String getIdnro() {
        return idnro;
    }

    public void setIdnro(String idnro) {
        this.idnro = idnro;
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

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(long idctacte) {
        this.idctacte = idctacte;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getIdctactesub() {
        return idctactesub;
    }

    public void setIdctactesub(Long idctactesub) {
        this.idctactesub = idctactesub;
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

    public String getCtactesubdireccion() {
        return ctactesubdireccion;
    }

    public void setCtactesubdireccion(String ctactesubdireccion) {
        this.ctactesubdireccion = ctactesubdireccion;
    }

    public String getCtactesubtelefono() {
        return ctactesubtelefono;
    }

    public void setCtactesubtelefono(String ctactesubtelefono) {
        this.ctactesubtelefono = ctactesubtelefono;
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

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
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

    public String getItemmovcondicion() {
        return itemmovcondicion;
    }

    public void setItemmovcondicion(String itemmovcondicion) {
        this.itemmovcondicion = itemmovcondicion;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public Long getCtacteruta() {
        return ctacteruta;
    }

    public void setCtacteruta(Long ctacteruta) {
        this.ctacteruta = ctacteruta;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public void setTasa(BigDecimal tasa) {
        this.tasa = tasa;
    }

    public BigDecimal getTasamoratoria() {
        return tasamoratoria;
    }

    public void setTasamoratoria(BigDecimal tasamoratoria) {
        this.tasamoratoria = tasamoratoria;
    }

    public Long getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(Long tolerancia) {
        this.tolerancia = tolerancia;
    }

    public Short getCtacteafecta() {
        return ctacteafecta;
    }

    public void setCtacteafecta(Short ctacteafecta) {
        this.ctacteafecta = ctacteafecta;
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

    public String getCtactedeposito() {
        return ctactedeposito;
    }

    public void setCtactedeposito(String ctactedeposito) {
        this.ctactedeposito = ctactedeposito;
    }

    public String getCtactedepositonombre() {
        return ctactedepositonombre;
    }

    public void setCtactedepositonombre(String ctactedepositonombre) {
        this.ctactedepositonombre = ctactedepositonombre;
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
