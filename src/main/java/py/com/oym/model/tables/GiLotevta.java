/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "gi_lotevta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLotevta.findAll", query = "SELECT g FROM GiLotevta g"),
    @NamedQuery(name = "GiLotevta.findByIdgiLotevta", query = "SELECT g FROM GiLotevta g WHERE g.idgiLotevta = :idgiLotevta"),
    @NamedQuery(name = "GiLotevta.findByIdnro", query = "SELECT g FROM GiLotevta g WHERE g.idnro = :idnro"),
    @NamedQuery(name = "GiLotevta.findByIdctactemovimiento", query = "SELECT g FROM GiLotevta g WHERE g.idctactemovimiento = :idctactemovimiento"),
    @NamedQuery(name = "GiLotevta.findByCodigo", query = "SELECT g FROM GiLotevta g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "GiLotevta.findByFecha", query = "SELECT g FROM GiLotevta g WHERE g.fecha = :fecha"),
    @NamedQuery(name = "GiLotevta.findByNrovta", query = "SELECT g FROM GiLotevta g WHERE g.nrovta = :nrovta"),
    @NamedQuery(name = "GiLotevta.findByRecibonro", query = "SELECT g FROM GiLotevta g WHERE g.recibonro = :recibonro"),
    @NamedQuery(name = "GiLotevta.findByCambio", query = "SELECT g FROM GiLotevta g WHERE g.cambio = :cambio"),
    @NamedQuery(name = "GiLotevta.findByImportesena", query = "SELECT g FROM GiLotevta g WHERE g.importesena = :importesena"),
    @NamedQuery(name = "GiLotevta.findByImporteinicial", query = "SELECT g FROM GiLotevta g WHERE g.importeinicial = :importeinicial"),
    @NamedQuery(name = "GiLotevta.findByImportecuota", query = "SELECT g FROM GiLotevta g WHERE g.importecuota = :importecuota"),
    @NamedQuery(name = "GiLotevta.findByFechaprimervto", query = "SELECT g FROM GiLotevta g WHERE g.fechaprimervto = :fechaprimervto"),
    @NamedQuery(name = "GiLotevta.findByCuotasCnt", query = "SELECT g FROM GiLotevta g WHERE g.cuotasCnt = :cuotasCnt"),
    @NamedQuery(name = "GiLotevta.findByConfirmado", query = "SELECT g FROM GiLotevta g WHERE g.confirmado = :confirmado"),
    @NamedQuery(name = "GiLotevta.findByFecharecupero", query = "SELECT g FROM GiLotevta g WHERE g.fecharecupero = :fecharecupero")})
public class GiLotevta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgi_lotevta")
    private Long idgiLotevta;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;

    @Column(name = "idctactemovimiento")
    private Long idctactemovimiento;

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
    
    @Column(name = "boleta_deposito")
    private String boletadeposito;

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
    
    @Basic(optional = false)
    @Column(name = "judicializado")
    private Boolean judicializado;
    
    
    
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;

    @Transient
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

    @Column(name = "idempresa")
    private Long idempresa;

    @Column(name = "idperiodo")
    private Long idperiodo;
    

    @JoinColumn(name = "idconductor", referencedColumnName = "idvendedor")
    @ManyToOne
    private Vendedor idconductor;
    
    @JoinColumn(name = "idcanalpublicidad", referencedColumnName = "idcanalpublicidad")
    @ManyToOne
    private Canalpublicidad idcanalpublicidad;

    @JoinColumn(name = "idcanalvta", referencedColumnName = "idcanalvta")
    @ManyToOne
    private Canalvta idcanalvta;

    @JoinColumn(name = "idconcepto", referencedColumnName = "idconcepto")
    @ManyToOne
    private Concepto idconcepto;

    @JoinColumn(name = "idctacte", referencedColumnName = "idctacte")
    @ManyToOne(optional = false)
    private Ctacte idctacte;

    @JoinColumn(name = "idgi_categorialiquidacion", referencedColumnName = "idgi_categorialiquidacion")
    @ManyToOne
    private GiCategorialiquidacion idgiCategorialiquidacion;
    @JoinColumn(name = "idgi_lote", referencedColumnName = "idgi_lote")
    @ManyToOne(optional = false)
    private GiLote idgiLote;
    
    @Column(name = "idgi_lotevtaestado")
    @Size(max = 1)
    private String idgiLotevtaestado;
    
    @JoinColumn(name = "idimpuestogrupo", referencedColumnName = "idimpuestogrupo")
    @ManyToOne(optional = false)
    private Impuestogrupo idimpuestogrupo;
    @JoinColumn(name = "iditemmovcondicion", referencedColumnName = "iditemmovcondicion")
    @ManyToOne
    private Itemmovcondicion iditemmovcondicion;

    @JoinColumn(name = "idvendedor", referencedColumnName = "idvendedor")
    @ManyToOne
    private Vendedor idvendedor;

    @JoinColumn(name = "idvendedorjefe", referencedColumnName = "idvendedor")
    @ManyToOne
    private Vendedor idvendedorjefe;
    
    @OneToMany(mappedBy = "idgiLotevta",cascade = CascadeType.PERSIST)
    private List<GiLotevtacuotaparam> giLoteVtaCuotaParam;

    @OneToMany(mappedBy = "idgiLotevta",cascade = CascadeType.PERSIST)
    private List<GiLotevtapersona> giLoteVtaPersona;
    
    
    
    public GiLotevta() {
    }

    public GiLotevta(Long idgiLotevta) {
        this.idgiLotevta = idgiLotevta;
    }

    public GiLotevta(Long idgiLotevta, String idnro, Date fecha, BigDecimal preciovtacontado, BigDecimal porcadminvtacontado, BigDecimal importeinicial, BigDecimal importecuota, short cuotasCnt, boolean confirmado, boolean anulado) {
        this.idgiLotevta = idgiLotevta;
        this.idnro = idnro;
        this.fecha = fecha;
        this.preciovtacontado = preciovtacontado;
        this.porcadminvtacontado = porcadminvtacontado;
        this.importeinicial = importeinicial;
        this.importecuota = importecuota;
        this.cuotasCnt = cuotasCnt;
        this.confirmado = confirmado;
        this.anulado = anulado;
    }

    public Long getIdgiLotevta() {
        return idgiLotevta;
    }

    public void setIdgiLotevta(Long idgiLotevta) {
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

    public long getCuotasCnt() {
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

    public Vendedor getIdconductor() {
        return idconductor;
    }

    public void setIdconductor(Vendedor idconductor) {
        this.idconductor = idconductor;
    }

    public Canalpublicidad getIdcanalpublicidad() {
        return idcanalpublicidad;
    }

    public void setIdcanalpublicidad(Canalpublicidad idcanalpublicidad) {
        this.idcanalpublicidad = idcanalpublicidad;
    }

    public Canalvta getIdcanalvta() {
        return idcanalvta;
    }

    public void setIdcanalvta(Canalvta idcanalvta) {
        this.idcanalvta = idcanalvta;
    }

    public Concepto getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Concepto idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Ctacte getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(Ctacte idctacte) {
        this.idctacte = idctacte;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public void setIdperiodo(Long idperiodo) {
        this.idperiodo = idperiodo;
    }
    
    public GiCategorialiquidacion getIdgiCategorialiquidacion() {
        return idgiCategorialiquidacion;
    }

    public void setIdgiCategorialiquidacion(GiCategorialiquidacion idgiCategorialiquidacion) {
        this.idgiCategorialiquidacion = idgiCategorialiquidacion;
    }

    public GiLote getIdgiLote() {
        return idgiLote;
    }

    public void setIdgiLote(GiLote idgiLote) {
        this.idgiLote = idgiLote;
    }

    public String getIdgiLotevtaestado() {
        return idgiLotevtaestado;
    }

    public void setIdgiLotevtaestado(String idgiLotevtaestado) {
        this.idgiLotevtaestado = idgiLotevtaestado;
    }

    public Impuestogrupo getIdimpuestogrupo() {
        return idimpuestogrupo;
    }

    public void setIdimpuestogrupo(Impuestogrupo idimpuestogrupo) {
        this.idimpuestogrupo = idimpuestogrupo;
    }

    public Itemmovcondicion getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(Itemmovcondicion iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public Vendedor getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Vendedor idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Vendedor getIdvendedorjefe() {
        return idvendedorjefe;
    }

    public void setIdvendedorjefe(Vendedor idvendedorjefe) {
        this.idvendedorjefe = idvendedorjefe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiLotevta != null ? idgiLotevta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLotevta)) {
            return false;
        }
        GiLotevta other = (GiLotevta) object;
        if ((this.idgiLotevta == null && other.idgiLotevta != null) || (this.idgiLotevta != null && !this.idgiLotevta.equals(other.idgiLotevta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiLotevta[ idgiLotevta=" + idgiLotevta + " ]";
    }
    
    public List<GiLotevtacuotaparam> getGiLoteVtaCuotaParam() {
        return giLoteVtaCuotaParam;
    }

    public void setGiLoteVtaCuotaParam(List<GiLotevtacuotaparam> giLoteVtaCuotaParam) {
        this.giLoteVtaCuotaParam = giLoteVtaCuotaParam;
    }
    
    public void addCuotaParam(GiLotevtacuotaparam cuotaParam){
        if (getGiLoteVtaCuotaParam() == null){
            this.giLoteVtaCuotaParam = new ArrayList<>();
        }
        getGiLoteVtaCuotaParam().add(cuotaParam);
        cuotaParam.setIdgiLotevta(this);
    }

    public String getBoletadeposito() {
        return boletadeposito;
    }

    public void setBoletadeposito(String boletadeposito) {
        this.boletadeposito = boletadeposito;
    }

    
    public List<GiLotevtapersona> getGiLoteVtaPersona() {
        return giLoteVtaPersona;
    }

    public void setGiLoteVtaPersona(List<GiLotevtapersona> giLoteVtaPersona) {
        this.giLoteVtaPersona = giLoteVtaPersona;
    }
    
    public void addPersona(GiLotevtapersona persona){
        if (getGiLoteVtaPersona() == null){
            this.giLoteVtaPersona = new ArrayList<>();
        }
        getGiLoteVtaPersona().add(persona);
        persona.setIdgiLotevta(this);
    }    

    public boolean getJudicializado() {
        return judicializado;
    }

    public void setJudicializado(boolean judicializado) {
        this.judicializado = judicializado;
    }


    
    @PrePersist
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }    
}
