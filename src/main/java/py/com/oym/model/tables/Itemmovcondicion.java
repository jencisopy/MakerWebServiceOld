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
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "itemmovcondicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemmovcondicion.findAll", query = "SELECT i FROM Itemmovcondicion i"),
    @NamedQuery(name = "Itemmovcondicion.findByIditemmovcondicion", query = "SELECT i FROM Itemmovcondicion i WHERE i.iditemmovcondicion = :iditemmovcondicion"),
    @NamedQuery(name = "Itemmovcondicion.findByIdempresa", query = "SELECT i FROM Itemmovcondicion i WHERE i.idempresa = :idempresa"),
    @NamedQuery(name = "Itemmovcondicion.findByCuotas", query = "SELECT i FROM Itemmovcondicion i WHERE i.idempresa = :idempresa and cuotas = :cuotas"),    
    @NamedQuery(name = "Itemmovcondicion.findByCodigo", query = "SELECT i FROM Itemmovcondicion i WHERE i.idempresa = :idempresa and i.codigo = :codigo")})
public class Itemmovcondicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemmovcondicion")
    private Long iditemmovcondicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas")
    private long cuotas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasamoratoria")
    private BigDecimal tasamoratoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tolerancia")
    private long tolerancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chequetolerancia")
    private long chequetolerancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diascuota")
    private long diascuota;
    @Column(name = "primervtodias")
    private Long primervtodias;
    @Column(name = "vtosfijos")
    private Boolean vtosfijos;
    @Column(name = "inactivo")
    private Boolean inactivo;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @JoinColumn(name = "idctbcuentainteressocio", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentainteressocio;
    @JoinColumn(name = "idctbcuentainteres", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentainteres;
    @JoinColumn(name = "idctbcuenta", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuenta;
    @JoinColumn(name = "idctbcuentasocio", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentasocio;
    @OneToMany(mappedBy = "iditemmovcondicion")
    private List<Ctacte> ctacteList;
    @OneToMany(mappedBy = "iditemmovcondicion")
    private List<GiLotevta> giLotevtaList;

    public Itemmovcondicion() {
    }

    public Itemmovcondicion(Long iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public Itemmovcondicion(Long iditemmovcondicion, long idempresa, String codigo, String nombre, long cuotas, BigDecimal tasamoratoria, long tolerancia, long chequetolerancia, long diascuota) {
        this.iditemmovcondicion = iditemmovcondicion;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuotas = cuotas;
        this.tasamoratoria = tasamoratoria;
        this.tolerancia = tolerancia;
        this.chequetolerancia = chequetolerancia;
        this.diascuota = diascuota;
    }

    public Long getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(Long iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public String getCodigo() {
        return codigo;
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

    public long getCuotas() {
        return cuotas;
    }

    public void setCuotas(long cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getTasamoratoria() {
        return tasamoratoria;
    }

    public void setTasamoratoria(BigDecimal tasamoratoria) {
        this.tasamoratoria = tasamoratoria;
    }

    public long getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(long tolerancia) {
        this.tolerancia = tolerancia;
    }

    public long getChequetolerancia() {
        return chequetolerancia;
    }

    public void setChequetolerancia(long chequetolerancia) {
        this.chequetolerancia = chequetolerancia;
    }

    public long getDiascuota() {
        return diascuota;
    }

    public void setDiascuota(long diascuota) {
        this.diascuota = diascuota;
    }

    public Long getPrimervtodias() {
        return primervtodias;
    }

    public void setPrimervtodias(Long primervtodias) {
        this.primervtodias = primervtodias;
    }

    public Boolean getVtosfijos() {
        return vtosfijos;
    }

    public void setVtosfijos(Boolean vtosfijos) {
        this.vtosfijos = vtosfijos;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
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

    public Ctbcuenta getIdctbcuentainteressocio() {
        return idctbcuentainteressocio;
    }

    public void setIdctbcuentainteressocio(Ctbcuenta idctbcuentainteressocio) {
        this.idctbcuentainteressocio = idctbcuentainteressocio;
    }

    public Ctbcuenta getIdctbcuentainteres() {
        return idctbcuentainteres;
    }

    public void setIdctbcuentainteres(Ctbcuenta idctbcuentainteres) {
        this.idctbcuentainteres = idctbcuentainteres;
    }

    public Ctbcuenta getIdctbcuenta() {
        return idctbcuenta;
    }

    public void setIdctbcuenta(Ctbcuenta idctbcuenta) {
        this.idctbcuenta = idctbcuenta;
    }

    public Ctbcuenta getIdctbcuentasocio() {
        return idctbcuentasocio;
    }

    public void setIdctbcuentasocio(Ctbcuenta idctbcuentasocio) {
        this.idctbcuentasocio = idctbcuentasocio;
    }

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
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
        hash += (iditemmovcondicion != null ? iditemmovcondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemmovcondicion)) {
            return false;
        }
        Itemmovcondicion other = (Itemmovcondicion) object;
        if ((this.iditemmovcondicion == null && other.iditemmovcondicion != null) || (this.iditemmovcondicion != null && !this.iditemmovcondicion.equals(other.iditemmovcondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Itemmovcondicion[ iditemmovcondicion=" + iditemmovcondicion + " ]";
    }
    
}
