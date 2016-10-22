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
 * @author jenci_000
 */
@Entity
@Table(name = "gi_lotevta_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLotevtaView.findAll", query = "SELECT g FROM GiLotevtaView g where g.idempresa = :idempresa"),
    @NamedQuery(name = "GiLotevtaView.findByIdgiLotevta", query = "SELECT g FROM GiLotevtaView g WHERE g.idgiLotevta = :idgiLotevta"),
    @NamedQuery(name = "GiLotevtaView.findByVendedor",   query = "SELECT g FROM GiLotevtaView g where g.idempresa = :idempresa and g.idvendedor = :idvendedor"),    
    @NamedQuery(name = "GiLotevtaView.findByIdgiLote", query = "SELECT g FROM GiLotevtaView g WHERE g.idgiLote = :idgiLote"),
    @NamedQuery(name = "GiLotevtaView.findByIdempresa", query = "SELECT g FROM GiLotevtaView g WHERE g.idempresa = :idempresa"),
    @NamedQuery(name = "GiLotevtaView.findByCodigo", query = "SELECT g FROM GiLotevtaView g WHERE g.idempresa = :idempresa and trim(g.codigo) = :codigo"),
    @NamedQuery(name = "GiLotevtaView.findByGiFraccion", query = "SELECT g FROM GiLotevtaView g WHERE g.giFraccion = :giFraccion"),
    @NamedQuery(name = "GiLotevtaView.findByGiFracciontipo", query = "SELECT g FROM GiLotevtaView g WHERE g.giFracciontipo = :giFracciontipo"),
    @NamedQuery(name = "GiLotevtaView.findByCtacte", query = "SELECT g FROM GiLotevtaView g WHERE g.ctacte = :ctacte")})
public class GiLotevtaView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idgi_lotevta")
    private long idgiLotevta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;
    @Column(name = "idctactemovimiento")
    private Long idctactemovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_lote")
    private long idgiLote;
    @Basic(optional = false)
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperiodo")
    private long idperiodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idimpuestogrupo")
    private long idimpuestogrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacte")
    private long idctacte;
    @Column(name = "idcanalvta")
    private Long idcanalvta;
    @Column(name = "idcanalpublicidad")
    private Long idcanalpublicidad;
    @Column(name = "idvendedor")
    private Long idvendedor;
    @Column(name = "idvendedorjefe")
    private Long idvendedorjefe;
    @Column(name = "idconductor")
    private Long idconductor;
    @Column(name = "idgi_lotevtaestado")
    private Character idgiLotevtaestado;
    @Column(name = "idconcepto")
    private Long idconcepto;
    @Column(name = "iditemmovcondicion")
    private Long iditemmovcondicion;
    @Column(name = "idgi_categorialiquidacion")
    private Long idgiCategorialiquidacion;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "nrovta")
    private Short nrovta;
    @Column(name = "recibonro")
    private Long recibonro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cambio")
    private BigDecimal cambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciovtacontado")
    private BigDecimal preciovtacontado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcadminvtacontado")
    private BigDecimal porcadminvtacontado;
    @Column(name = "importesena")
    private BigDecimal importesena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importeinicial")
    private BigDecimal importeinicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importecuota")
    private BigDecimal importecuota;
    @Column(name = "fechaprimervto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaprimervto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas_cnt")
    private short cuotasCnt;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmado")
    private boolean confirmado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anulado")
    private boolean anulado;
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
    @Column(name = "fecharecupero")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecupero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmoneda")
    private long idmoneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_fraccion")
    private long idgiFraccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gi_fraccion")
    private long giFraccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gi_fraccionnombre")
    private String giFraccionnombre;
    @Column(name = "idgi_fracciontipo")
    private Long idgiFracciontipo;
    @Size(max = 5)
    @Column(name = "gi_fracciontipo")
    private String giFracciontipo;
    @Size(max = 50)
    @Column(name = "gi_fracciontiponombre")
    private String giFracciontiponombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "gi_manzana")
    private String giManzana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gi_lote")
    private String giLote;
    @Size(max = 50)
    @Column(name = "gi_lotenombre")
    private String giLotenombre;
    @Column(name = "superficie_m2")
    private BigDecimal superficieM2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nroctactecatastral")
    private String nroctactecatastral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "impuestogrupo")
    private String impuestogrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "impuestogruponombre")
    private String impuestogruponombre;
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
    @Column(name = "vendedor")
    private String vendedor;
    @Size(max = 50)
    @Column(name = "vendedornombre")
    private String vendedornombre;
    @Size(max = 11)
    @Column(name = "vendedorjefe")
    private String vendedorjefe;
    @Size(max = 50)
    @Column(name = "vendedorjefenombre")
    private String vendedorjefenombre;
    @Size(max = 11)
    @Column(name = "conductor")
    private String conductor;
    @Size(max = 50)
    @Column(name = "conductornombre")
    private String conductornombre;
    @Column(name = "totalmonto")
    private BigDecimal totalmonto;
    @Size(max = 5)
    @Column(name = "canalvta")
    private String canalvta;
    @Size(max = 50)
    @Column(name = "canalvtanombre")
    private String canalvtanombre;
    @Size(max = 5)
    @Column(name = "canalpublicidad")
    private String canalpublicidad;
    @Size(max = 50)
    @Column(name = "canalpublicidadnombre")
    private String canalpublicidadnombre;
    @Size(max = 2)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 3)
    @Column(name = "itemmovcondicion")
    private String itemmovcondicion;
    @Size(max = 50)
    @Column(name = "itemmovcondicionnombre")
    private String itemmovcondicionnombre;
    @Size(max = 30)
    @Column(name = "conceptonombre")
    private String conceptonombre;
    @Size(max = 30)
    @Column(name = "gi_lotevtaestado")
    private String giLotevtaestado;
    @Size(max = 4)
    @Column(name = "gi_categorialiquidacion")
    private String giCategorialiquidacion;
    @Size(max = 50)
    @Column(name = "gi_categorialiquidacionnombre")
    private String giCategorialiquidacionnombre;

    public GiLotevtaView() {
    }

    public long getIdgiLotevta() {
        return idgiLotevta;
    }

    public void setIdgiLotevta(long idgiLotevta) {
        this.idgiLotevta = idgiLotevta;
    }

    public String getIdnro() {
        return idnro;
    }

    public void setIdnro(String idnro) {
        this.idnro = idnro;
    }

    public Long getIdctactemovimiento() {
        return idctactemovimiento;
    }

    public void setIdctactemovimiento(Long idctactemovimiento) {
        this.idctactemovimiento = idctactemovimiento;
    }

    public long getIdgiLote() {
        return idgiLote;
    }

    public void setIdgiLote(long idgiLote) {
        this.idgiLote = idgiLote;
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

    public long getIdimpuestogrupo() {
        return idimpuestogrupo;
    }

    public void setIdimpuestogrupo(long idimpuestogrupo) {
        this.idimpuestogrupo = idimpuestogrupo;
    }

    public long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(long idctacte) {
        this.idctacte = idctacte;
    }

    public Long getIdcanalvta() {
        return idcanalvta;
    }

    public void setIdcanalvta(Long idcanalvta) {
        this.idcanalvta = idcanalvta;
    }

    public Long getIdcanalpublicidad() {
        return idcanalpublicidad;
    }

    public void setIdcanalpublicidad(Long idcanalpublicidad) {
        this.idcanalpublicidad = idcanalpublicidad;
    }

    public Long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Long getIdvendedorjefe() {
        return idvendedorjefe;
    }

    public void setIdvendedorjefe(Long idvendedorjefe) {
        this.idvendedorjefe = idvendedorjefe;
    }

    public Long getIdconductor() {
        return idconductor;
    }

    public void setIdconductor(Long idconductor) {
        this.idconductor = idconductor;
    }

    public Character getIdgiLotevtaestado() {
        return idgiLotevtaestado;
    }

    public void setIdgiLotevtaestado(Character idgiLotevtaestado) {
        this.idgiLotevtaestado = idgiLotevtaestado;
    }

    public Long getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Long idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Long getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(Long iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public Long getIdgiCategorialiquidacion() {
        return idgiCategorialiquidacion;
    }

    public void setIdgiCategorialiquidacion(Long idgiCategorialiquidacion) {
        this.idgiCategorialiquidacion = idgiCategorialiquidacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Short getNrovta() {
        return nrovta;
    }

    public void setNrovta(Short nrovta) {
        this.nrovta = nrovta;
    }

    public Long getRecibonro() {
        return recibonro;
    }

    public void setRecibonro(Long recibonro) {
        this.recibonro = recibonro;
    }

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public BigDecimal getPreciovtacontado() {
        return preciovtacontado;
    }

    public void setPreciovtacontado(BigDecimal preciovtacontado) {
        this.preciovtacontado = preciovtacontado;
    }

    public BigDecimal getPorcadminvtacontado() {
        return porcadminvtacontado;
    }

    public void setPorcadminvtacontado(BigDecimal porcadminvtacontado) {
        this.porcadminvtacontado = porcadminvtacontado;
    }

    public BigDecimal getImportesena() {
        return importesena;
    }

    public void setImportesena(BigDecimal importesena) {
        this.importesena = importesena;
    }

    public BigDecimal getImporteinicial() {
        return importeinicial;
    }

    public void setImporteinicial(BigDecimal importeinicial) {
        this.importeinicial = importeinicial;
    }

    public BigDecimal getImportecuota() {
        return importecuota;
    }

    public void setImportecuota(BigDecimal importecuota) {
        this.importecuota = importecuota;
    }

    public Date getFechaprimervto() {
        return fechaprimervto;
    }

    public void setFechaprimervto(Date fechaprimervto) {
        this.fechaprimervto = fechaprimervto;
    }

    public Short getCuotasCnt() {
        return cuotasCnt;
    }

    public void setCuotasCnt(short cuotasCnt) {
        this.cuotasCnt = cuotasCnt;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Date getFecharecupero() {
        return fecharecupero;
    }

    public void setFecharecupero(Date fecharecupero) {
        this.fecharecupero = fecharecupero;
    }

    public long getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public long getIdgiFraccion() {
        return idgiFraccion;
    }

    public void setIdgiFraccion(long idgiFraccion) {
        this.idgiFraccion = idgiFraccion;
    }

    public long getGiFraccion() {
        return giFraccion;
    }

    public void setGiFraccion(long giFraccion) {
        this.giFraccion = giFraccion;
    }

    public String getGiFraccionnombre() {
        return giFraccionnombre;
    }

    public void setGiFraccionnombre(String giFraccionnombre) {
        this.giFraccionnombre = giFraccionnombre;
    }

    public Long getIdgiFracciontipo() {
        return idgiFracciontipo;
    }

    public void setIdgiFracciontipo(Long idgiFracciontipo) {
        this.idgiFracciontipo = idgiFracciontipo;
    }

    public String getGiFracciontipo() {
        return giFracciontipo;
    }

    public void setGiFracciontipo(String giFracciontipo) {
        this.giFracciontipo = giFracciontipo;
    }

    public String getGiFracciontiponombre() {
        return giFracciontiponombre;
    }

    public void setGiFracciontiponombre(String giFracciontiponombre) {
        this.giFracciontiponombre = giFracciontiponombre;
    }

    public String getGiManzana() {
        return giManzana.trim();
    }

    public void setGiManzana(String giManzana) {
        this.giManzana = giManzana;
    }

    public String getGiLote() {
        return giLote;
    }

    public void setGiLote(String giLote) {
        this.giLote = giLote;
    }

    public String getGiLotenombre() {
        return giLotenombre;
    }

    public void setGiLotenombre(String giLotenombre) {
        this.giLotenombre = giLotenombre;
    }

    public BigDecimal getSuperficieM2() {
        return superficieM2;
    }

    public void setSuperficieM2(BigDecimal superficieM2) {
        this.superficieM2 = superficieM2;
    }

    public String getNroctactecatastral() {
        return nroctactecatastral;
    }

    public void setNroctactecatastral(String nroctactecatastral) {
        this.nroctactecatastral = nroctactecatastral;
    }

    public String getImpuestogrupo() {
        return impuestogrupo;
    }

    public void setImpuestogrupo(String impuestogrupo) {
        this.impuestogrupo = impuestogrupo;
    }

    public String getImpuestogruponombre() {
        return impuestogruponombre;
    }

    public void setImpuestogruponombre(String impuestogruponombre) {
        this.impuestogruponombre = impuestogruponombre;
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

    public String getVendedorjefe() {
        return vendedorjefe;
    }

    public void setVendedorjefe(String vendedorjefe) {
        this.vendedorjefe = vendedorjefe;
    }

    public String getVendedorjefenombre() {
        return vendedorjefenombre;
    }

    public void setVendedorjefenombre(String vendedorjefenombre) {
        this.vendedorjefenombre = vendedorjefenombre;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getConductornombre() {
        return conductornombre;
    }

    public void setConductornombre(String conductornombre) {
        this.conductornombre = conductornombre;
    }

    public BigDecimal getTotalmonto() {
        return totalmonto;
    }

    public void setTotalmonto(BigDecimal totalmonto) {
        this.totalmonto = totalmonto;
    }

    public String getCanalvta() {
        return canalvta;
    }

    public void setCanalvta(String canalvta) {
        this.canalvta = canalvta;
    }

    public String getCanalvtanombre() {
        return canalvtanombre;
    }

    public void setCanalvtanombre(String canalvtanombre) {
        this.canalvtanombre = canalvtanombre;
    }

    public String getCanalpublicidad() {
        return canalpublicidad;
    }

    public void setCanalpublicidad(String canalpublicidad) {
        this.canalpublicidad = canalpublicidad;
    }

    public String getCanalpublicidadnombre() {
        return canalpublicidadnombre;
    }

    public void setCanalpublicidadnombre(String canalpublicidadnombre) {
        this.canalpublicidadnombre = canalpublicidadnombre;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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

    public String getConceptonombre() {
        return conceptonombre;
    }

    public void setConceptonombre(String conceptonombre) {
        this.conceptonombre = conceptonombre;
    }

    public String getGiLotevtaestado() {
        return giLotevtaestado;
    }

    public void setGiLotevtaestado(String giLotevtaestado) {
        this.giLotevtaestado = giLotevtaestado;
    }

    public String getGiCategorialiquidacion() {
        return giCategorialiquidacion;
    }

    public void setGiCategorialiquidacion(String giCategorialiquidacion) {
        this.giCategorialiquidacion = giCategorialiquidacion;
    }

    public String getGiCategorialiquidacionnombre() {
        return giCategorialiquidacionnombre;
    }

    public void setGiCategorialiquidacionnombre(String giCategorialiquidacionnombre) {
        this.giCategorialiquidacionnombre = giCategorialiquidacionnombre;
    }
    
}
