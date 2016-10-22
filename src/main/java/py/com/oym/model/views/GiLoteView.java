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
 * @author jenci_000
 */
@Entity
@Table(name = "gi_lote_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLoteView.findAll", query = "SELECT g FROM GiLoteView g where g.idempresa = :idempresa and g.tipo = 1"),
    @NamedQuery(name = "GiLoteView.findByCodigo", query = "SELECT g FROM GiLoteView g WHERE g.idempresa = :idempresa and TRIM(g.codigo) = TRIM(:codigo) and g.giFraccion = :giFraccion and g.giManzana = :giManzana  and g.tipo = 1"), 
    @NamedQuery(name = "GiLoteView.findByIdgiLote", query = "SELECT g FROM GiLoteView g WHERE g.idgiLote = :idgiLote"),
    @NamedQuery(name = "GiLoteView.findByIdgiManzana", query = "SELECT g FROM GiLoteView g WHERE g.idgiManzana = :idgiManzana"),
    @NamedQuery(name = "GiLoteView.findByIdempresa", query = "SELECT g FROM GiLoteView g WHERE g.idempresa = :idempresa and g.tipo = 1"),
    @NamedQuery(name = "GiLoteView.findByIdgiFraccion", query = "SELECT g FROM GiLoteView g WHERE g.idgiFraccion = :idgiFraccion  and g.tipo = 1"),
    @NamedQuery(name = "GiLoteView.findByGiFraccion", query = "SELECT g FROM GiLoteView g WHERE  g.idempresa = :idempresa and g.giFraccion = :giFraccion  and TRIM(g.giLoteestado) = TRIM(:giLoteestado)  and g.tipo = 1"),
    @NamedQuery(name = "GiLoteView.findByGiFracciontipo", query = "SELECT g FROM GiLoteView g WHERE  g.idempresa = :idempresa and g.giFracciontipo = :giFracciontipo  and g.tipo = 1"),
    @NamedQuery(name = "GiLoteView.findByGiLoteestado", query = "SELECT g FROM GiLoteView g WHERE g.giLoteestado = :giLoteestado  and g.tipo = 1")})
public class GiLoteView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idgi_lote")
    private long idgiLote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_manzana")
    private long idgiManzana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmoneda")
    private long idmoneda;
    @Column(name = "idgi_loteestado")
    private Character idgiLoteestado;
    @Column(name = "iditem")
    private Long iditem;
    @Column(name = "idvendedorreserva")
    private Long idvendedorreserva;
    @Basic(optional = false)
    @NotNull
    @Size(max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "superficie_m2")
    private BigDecimal superficieM2;
    @Column(name = "long_frente")
    private BigDecimal longFrente;
    @Column(name = "long_norte")
    private BigDecimal longNorte;
    @Column(name = "long_sur")
    private BigDecimal longSur;
    @Column(name = "long_este")
    private BigDecimal longEste;
    @Column(name = "long_oeste")
    private BigDecimal longOeste;
    @Size(max = 30)
    @Column(name = "lindero_norte")
    private String linderoNorte;
    @Size(max = 30)
    @Column(name = "lindero_sur")
    private String linderoSur;
    @Size(max = 30)
    @Column(name = "lindero_este")
    private String linderoEste;
    @Size(max = 30)
    @Column(name = "lindero_oeste")
    private String linderoOeste;
    @Column(name = "mojon1")
    private Boolean mojon1;
    @Column(name = "mojon2")
    private Boolean mojon2;
    @Column(name = "mojon3")
    private Boolean mojon3;
    @Column(name = "mojon4")
    private Boolean mojon4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciocosto")
    private BigDecimal preciocosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciovtacontado")
    private BigDecimal preciovtacontado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcadminvtacontado")
    private BigDecimal porcadminvtacontado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importeinicial")
    private BigDecimal importeinicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importecuota")
    private BigDecimal importecuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas_cnt")
    private long cuotasCnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nroctactecatastral")
    private String nroctactecatastral;
    @Column(name = "fechacambioestado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacambioestado;
    @Column(name = "importesena")
    private BigDecimal importesena;
    @Column(name = "fechareserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareserva;
    
    @Column(name = "concasa")
    private Boolean concasa;

    @Column(name = "otrasmejoras")
    private Boolean otrasmejoras;

    @Size(max = 20)
    @Column(name = "matricula")
    private String matricula;
    
    
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
    @Column(name = "tipo")
    private Short tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
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
    @Size(min = 1, max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 30)
    @Column(name = "gi_loteestado")
    private String giLoteestado;
    @Size(max = 16)
    @Column(name = "item")
    private String item;
    @Column(name = "itemelemento")
    private Character itemelemento;
    @Size(max = 11)
    @Column(name = "vendedorreserva")
    private String vendedorreserva;
    @Size(max = 50)
    @Column(name = "vendedorreservanombre")
    private String vendedorreservanombre;

    public GiLoteView() {
    }

    public long getIdgiLote() {
        return idgiLote;
    }

    public void setIdgiLote(long idgiLote) {
        this.idgiLote = idgiLote;
    }

    public long getIdgiManzana() {
        return idgiManzana;
    }

    public void setIdgiManzana(long idgiManzana) {
        this.idgiManzana = idgiManzana;
    }

    public long getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Character getIdgiLoteestado() {
        return idgiLoteestado;
    }

    public void setIdgiLoteestado(Character idgiLoteestado) {
        this.idgiLoteestado = idgiLoteestado;
    }

    public Long getIditem() {
        return iditem;
    }

    public void setIditem(Long iditem) {
        this.iditem = iditem;
    }

    public Long getIdvendedorreserva() {
        return idvendedorreserva;
    }

    public void setIdvendedorreserva(Long idvendedorreserva) {
        this.idvendedorreserva = idvendedorreserva;
    }

    public String getCodigo() {
        return codigo.trim();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSuperficieM2() {
        return superficieM2;
    }

    public void setSuperficieM2(BigDecimal superficieM2) {
        this.superficieM2 = superficieM2;
    }

    public BigDecimal getLongFrente() {
        return longFrente;
    }

    public void setLongFrente(BigDecimal longFrente) {
        this.longFrente = longFrente;
    }

    public BigDecimal getLongNorte() {
        return longNorte;
    }

    public void setLongNorte(BigDecimal longNorte) {
        this.longNorte = longNorte;
    }

    public BigDecimal getLongSur() {
        return longSur;
    }

    public void setLongSur(BigDecimal longSur) {
        this.longSur = longSur;
    }

    public BigDecimal getLongEste() {
        return longEste;
    }

    public void setLongEste(BigDecimal longEste) {
        this.longEste = longEste;
    }

    public BigDecimal getLongOeste() {
        return longOeste;
    }

    public void setLongOeste(BigDecimal longOeste) {
        this.longOeste = longOeste;
    }

    public String getLinderoNorte() {
        return linderoNorte;
    }

    public void setLinderoNorte(String linderoNorte) {
        this.linderoNorte = linderoNorte;
    }

    public String getLinderoSur() {
        return linderoSur;
    }

    public void setLinderoSur(String linderoSur) {
        this.linderoSur = linderoSur;
    }

    public String getLinderoEste() {
        return linderoEste;
    }

    public void setLinderoEste(String linderoEste) {
        this.linderoEste = linderoEste;
    }

    public String getLinderoOeste() {
        return linderoOeste;
    }

    public void setLinderoOeste(String linderoOeste) {
        this.linderoOeste = linderoOeste;
    }

    public Boolean getMojon1() {
        return mojon1;
    }

    public void setMojon1(Boolean mojon1) {
        this.mojon1 = mojon1;
    }

    public Boolean getMojon2() {
        return mojon2;
    }

    public void setMojon2(Boolean mojon2) {
        this.mojon2 = mojon2;
    }

    public Boolean getMojon3() {
        return mojon3;
    }

    public void setMojon3(Boolean mojon3) {
        this.mojon3 = mojon3;
    }

    public Boolean getMojon4() {
        return mojon4;
    }

    public void setMojon4(Boolean mojon4) {
        this.mojon4 = mojon4;
    }

    public BigDecimal getPreciocosto() {
        return preciocosto;
    }

    public void setPreciocosto(BigDecimal preciocosto) {
        this.preciocosto = preciocosto;
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

    public long getCuotasCnt() {
        return cuotasCnt;
    }

    public void setCuotasCnt(long cuotasCnt) {
        this.cuotasCnt = cuotasCnt;
    }

    public String getNroctactecatastral() {
        return nroctactecatastral;
    }

    public void setNroctactecatastral(String nroctactecatastral) {
        this.nroctactecatastral = nroctactecatastral;
    }

    public Date getFechacambioestado() {
        return fechacambioestado;
    }

    public void setFechacambioestado(Date fechacambioestado) {
        this.fechacambioestado = fechacambioestado;
    }

    public BigDecimal getImportesena() {
        return importesena;
    }

    public void setImportesena(BigDecimal importesena) {
        this.importesena = importesena;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
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

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getGiLoteestado() {
        return giLoteestado;
    }

    public void setGiLoteestado(String giLoteestado) {
        this.giLoteestado = giLoteestado;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Character getItemelemento() {
        return itemelemento;
    }

    public void setItemelemento(Character itemelemento) {
        this.itemelemento = itemelemento;
    }

    public String getVendedorreserva() {
        return vendedorreserva;
    }

    public void setVendedorreserva(String vendedorreserva) {
        this.vendedorreserva = vendedorreserva;
    }

    public String getVendedorreservanombre() {
        return vendedorreservanombre;
    }

    public void setVendedorreservanombre(String vendedorreservanombre) {
        this.vendedorreservanombre = vendedorreservanombre;
    }

    public Boolean getConcasa() {
        return concasa;
    }

    public void setConcasa(Boolean concasa) {
        this.concasa = concasa;
    }

    public Boolean getOtrasmejoras() {
        return otrasmejoras;
    }

    public void setOtrasmejoras(Boolean otrasmejoras) {
        this.otrasmejoras = otrasmejoras;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
}
