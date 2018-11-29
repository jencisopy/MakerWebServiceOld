/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "gi_lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLote.findAll",        query = "SELECT g FROM GiLote g"),
    @NamedQuery(name = "GiLote.findByIdgiLote", query = "SELECT g FROM GiLote g WHERE g.idgiLote = :idgiLote"),
    @NamedQuery(name = "GiLote.findByCodigo",   query = "SELECT g FROM GiLote g WHERE TRIM(g.codigo) = TRIM(:codigo) and g.giManzana.giFraccion.codigo = :giFraccion and TRIM(g.giManzana.codigo) = TRIM(:giManzana) and  g.giManzana.giFraccion.idempresa = :idempresa"),
    @NamedQuery(name = "GiLote.findByNombre",   query = "SELECT g FROM GiLote g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GiLote.findByAppuser",  query = "SELECT g FROM GiLote g WHERE g.appuser = :appuser"),
    @NamedQuery(name = "GiLote.findByTipo",     query = "SELECT g FROM GiLote g WHERE g.tipo = :tipo")})
public class GiLote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idgi_lote")
    private Long idgiLote;
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
    @JoinColumn(name = "idvendedorreserva", referencedColumnName = "idvendedor")
    @ManyToOne
    private Vendedor idvendedorreserva;
    @JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda")
    @ManyToOne(optional = false)
    private Moneda idmoneda;
    @JoinColumn(name = "iditem", referencedColumnName = "iditem")
    @ManyToOne
    private Item iditem;
    @JoinColumn(name = "idgi_manzana", referencedColumnName = "idgi_manzana")
    @ManyToOne(optional = false)
    private GiManzana giManzana;
    @JoinColumn(name = "idgi_loteestado", referencedColumnName = "idgi_loteestado")
    @ManyToOne
    private GiLoteestado idgiLoteestado;
    @Column(name = "idgi_loteestadoant")
    private String idgiLoteestadoAnt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgiLote")
    private List<GiLotevta> giLotevtaList;

    public GiLote() {
    }

    public GiLote(Long idgiLote) {
        this.idgiLote = idgiLote;
    }

    public GiLote(Long idgiLote, String codigo, BigDecimal preciocosto, BigDecimal preciovtacontado, BigDecimal porcadminvtacontado, BigDecimal importeinicial, BigDecimal importecuota, long cuotasCnt, String nroctactecatastral) {
        this.idgiLote = idgiLote;
        this.codigo = codigo;
        this.preciocosto = preciocosto;
        this.preciovtacontado = preciovtacontado;
        this.porcadminvtacontado = porcadminvtacontado;
        this.importeinicial = importeinicial;
        this.importecuota = importecuota;
        this.cuotasCnt = cuotasCnt;
        this.nroctactecatastral = nroctactecatastral;
    }

    public Long getIdgiLote() {
        return idgiLote;
    }

    public void setIdgiLote(Long idgiLote) {
        this.idgiLote = idgiLote;
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

    public Vendedor getIdvendedorreserva() {
        return idvendedorreserva;
    }

    public void setIdvendedorreserva(Vendedor idvendedorreserva) {
        this.idvendedorreserva = idvendedorreserva;
    }

    public Moneda getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Moneda idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Item getIditem() {
        return iditem;
    }

    public void setIditem(Item iditem) {
        this.iditem = iditem;
    }

    public GiManzana getGiManzana() {
        return giManzana;
    }

    public void setGiManzana(GiManzana giManzana) {
        this.giManzana = giManzana;
    }

    public GiLoteestado getIdgiLoteestado() {
        return idgiLoteestado;
    }

    public void setIdgiLoteestado(GiLoteestado idgiLoteestado) {
        this.idgiLoteestado = idgiLoteestado;
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

    public String getIdgiLoteestadoAnt() {
        return idgiLoteestadoAnt;
    }

    public void setIdgiLoteestadoAnt(String idgiLoteestadoAnt) {
        this.idgiLoteestadoAnt = idgiLoteestadoAnt;
    }
    
    

    @XmlTransient
    public List<GiLotevta> getGiLotevtaList() {
        return giLotevtaList;
    }

    public void setGiLotevtaList(List<GiLotevta> giLotevtaList) {
        this.giLotevtaList = giLotevtaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiLote != null ? idgiLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLote)) {
            return false;
        }
        GiLote other = (GiLote) object;
        if ((this.idgiLote == null && other.idgiLote != null) || (this.idgiLote != null && !this.idgiLote.equals(other.idgiLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiLote[ idgiLote=" + idgiLote + " ]";
    }
    
}
