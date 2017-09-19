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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author jenci_000
 */
@Entity
@Table(name = "gi_fraccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiFraccion.findAll", query = "SELECT g FROM GiFraccion g  order by g.nombre"),
    @NamedQuery(name = "GiFraccion.findByIdgiFraccion", query = "SELECT g FROM GiFraccion g WHERE g.idgiFraccion = :idgiFraccion"),
    @NamedQuery(name = "GiFraccion.findByIdempresa", query = "SELECT g FROM GiFraccion g WHERE g.idempresa = :idempresa"),
    @NamedQuery(name = "GiFraccion.findByCodigo", query = "SELECT g FROM GiFraccion g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "GiFraccion.findByNombre", query = "SELECT g FROM GiFraccion g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GiFraccion.findBySuperficieM2", query = "SELECT g FROM GiFraccion g WHERE g.superficieM2 = :superficieM2"),
    @NamedQuery(name = "GiFraccion.findByNrofinca", query = "SELECT g FROM GiFraccion g WHERE g.nrofinca = :nrofinca"),
    @NamedQuery(name = "GiFraccion.findByNroasiento", query = "SELECT g FROM GiFraccion g WHERE g.nroasiento = :nroasiento"),
    @NamedQuery(name = "GiFraccion.findByNropadron", query = "SELECT g FROM GiFraccion g WHERE g.nropadron = :nropadron"),
    @NamedQuery(name = "GiFraccion.findByNroseccion", query = "SELECT g FROM GiFraccion g WHERE g.nroseccion = :nroseccion"),
    @NamedQuery(name = "GiFraccion.findByNroaprobacion", query = "SELECT g FROM GiFraccion g WHERE g.nroaprobacion = :nroaprobacion"),
    @NamedQuery(name = "GiFraccion.findByFechaaprobacion", query = "SELECT g FROM GiFraccion g WHERE g.fechaaprobacion = :fechaaprobacion"),
    @NamedQuery(name = "GiFraccion.findByNroctactecatastral", query = "SELECT g FROM GiFraccion g WHERE g.nroctactecatastral = :nroctactecatastral"),
    @NamedQuery(name = "GiFraccion.findByFechactactecatastral", query = "SELECT g FROM GiFraccion g WHERE g.fechactactecatastral = :fechactactecatastral"),
    @NamedQuery(name = "GiFraccion.findByEstado", query = "SELECT g FROM GiFraccion g WHERE g.estado = :estado"),
    @NamedQuery(name = "GiFraccion.findByFechareplicacion", query = "SELECT g FROM GiFraccion g WHERE g.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "GiFraccion.findByFechamodificacion", query = "SELECT g FROM GiFraccion g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiFraccion.findByFechacreacion", query = "SELECT g FROM GiFraccion g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "GiFraccion.findByFirma", query = "SELECT g FROM GiFraccion g WHERE g.firma = :firma"),
    @NamedQuery(name = "GiFraccion.findByAppuser", query = "SELECT g FROM GiFraccion g WHERE g.appuser = :appuser"),
    @NamedQuery(name = "GiFraccion.findByGenFacturaPorvtalote", query = "SELECT g FROM GiFraccion g WHERE g.genFacturaPorvtalote = :genFacturaPorvtalote")})
public class GiFraccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_fraccion")
    private Long idgiFraccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "superficie_m2")
    private BigDecimal superficieM2;
    @Size(max = 30)
    @Column(name = "nrofinca")
    private String nrofinca;
    @Size(max = 20)
    @Column(name = "nroasiento")
    private String nroasiento;
    @Size(max = 20)
    @Column(name = "nropadron")
    private String nropadron;
    @Size(max = 20)
    @Column(name = "nroseccion")
    private String nroseccion;
    @Size(max = 20)
    @Column(name = "nroaprobacion")
    private String nroaprobacion;
    @Column(name = "fechaaprobacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaaprobacion;
    @Size(max = 20)
    @Column(name = "nroctactecatastral")
    private String nroctactecatastral;
    @Column(name = "fechactactecatastral")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechactactecatastral;
    @Column(name = "estado")
    private Character estado;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
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
    @Column(name = "gen_factura_porvtalote")
    private Boolean genFacturaPorvtalote;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgiFraccion")
    private List<GiCategorialiquidacion> giCategorialiquidacionList;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne
    private Pais idpais;
    @JoinColumn(name = "iditem", referencedColumnName = "iditem")
    @ManyToOne
    private Item iditem;
    @JoinColumn(name = "idbarrio", referencedColumnName = "idbarrio")
    @ManyToOne
    private Barrio idbarrio;
    @JoinColumn(name = "idcentrocosto", referencedColumnName = "idcentrocosto")
    @ManyToOne
    private Centrocosto idcentrocosto;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne
    private Ciudad idciudad;
    @JoinColumn(name = "idctbcuentafraccion", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentafraccion;
    @JoinColumn(name = "idctbcuentacliente", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentacliente;
    @JoinColumn(name = "idctbcuentavta", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentavta;
    @JoinColumn(name = "idctbcuentacosto", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentacosto;
    @JoinColumn(name = "idctbcuentainteresmora", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentainteresmora;
    @JoinColumn(name = "idctbcuentadescuento", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentadescuento;
    @JoinColumn(name = "idctbcuentagastocobranza", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentagastocobranza;
    @JoinColumn(name = "iddeposito", referencedColumnName = "iddeposito")
    @ManyToOne
    private Deposito iddeposito;
    @JoinColumn(name = "idgi_fracciontipo", referencedColumnName = "idgi_fracciontipo")
    @ManyToOne
    private GiFracciontipo idgiFracciontipo;

    @Basic(optional = false)
    @Column(name = "noappmovil")
    private Boolean noappmovil=false;      


    public GiFraccion() {
    }

    public GiFraccion(Long idgiFraccion) {
        this.idgiFraccion = idgiFraccion;
    }

    public GiFraccion(Long idgiFraccion, long idempresa, long codigo, String nombre, BigDecimal superficieM2) {
        this.idgiFraccion = idgiFraccion;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.superficieM2 = superficieM2;
    }

    public Long getIdgiFraccion() {
        return idgiFraccion;
    }

    public void setIdgiFraccion(Long idgiFraccion) {
        this.idgiFraccion = idgiFraccion;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
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

    public String getNrofinca() {
        return nrofinca;
    }

    public void setNrofinca(String nrofinca) {
        this.nrofinca = nrofinca;
    }

    public String getNroasiento() {
        return nroasiento;
    }

    public void setNroasiento(String nroasiento) {
        this.nroasiento = nroasiento;
    }

    public String getNropadron() {
        return nropadron;
    }

    public void setNropadron(String nropadron) {
        this.nropadron = nropadron;
    }

    public String getNroseccion() {
        return nroseccion;
    }

    public void setNroseccion(String nroseccion) {
        this.nroseccion = nroseccion;
    }

    public String getNroaprobacion() {
        return nroaprobacion;
    }

    public void setNroaprobacion(String nroaprobacion) {
        this.nroaprobacion = nroaprobacion;
    }

    public Date getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(Date fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    public String getNroctactecatastral() {
        return nroctactecatastral;
    }

    public void setNroctactecatastral(String nroctactecatastral) {
        this.nroctactecatastral = nroctactecatastral;
    }

    public Date getFechactactecatastral() {
        return fechactactecatastral;
    }

    public void setFechactactecatastral(Date fechactactecatastral) {
        this.fechactactecatastral = fechactactecatastral;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Boolean getGenFacturaPorvtalote() {
        return genFacturaPorvtalote;
    }

    public void setGenFacturaPorvtalote(Boolean genFacturaPorvtalote) {
        this.genFacturaPorvtalote = genFacturaPorvtalote;
    }

    @XmlTransient
    public List<GiCategorialiquidacion> getGiCategorialiquidacionList() {
        return giCategorialiquidacionList;
    }

    public void setGiCategorialiquidacionList(List<GiCategorialiquidacion> giCategorialiquidacionList) {
        this.giCategorialiquidacionList = giCategorialiquidacionList;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    public Item getIditem() {
        return iditem;
    }

    public void setIditem(Item iditem) {
        this.iditem = iditem;
    }

    public Barrio getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Barrio idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Centrocosto getIdcentrocosto() {
        return idcentrocosto;
    }

    public void setIdcentrocosto(Centrocosto idcentrocosto) {
        this.idcentrocosto = idcentrocosto;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    public Ctbcuenta getIdctbcuentafraccion() {
        return idctbcuentafraccion;
    }

    public void setIdctbcuentafraccion(Ctbcuenta idctbcuentafraccion) {
        this.idctbcuentafraccion = idctbcuentafraccion;
    }

    public Ctbcuenta getIdctbcuentacliente() {
        return idctbcuentacliente;
    }

    public void setIdctbcuentacliente(Ctbcuenta idctbcuentacliente) {
        this.idctbcuentacliente = idctbcuentacliente;
    }

    public Ctbcuenta getIdctbcuentavta() {
        return idctbcuentavta;
    }

    public void setIdctbcuentavta(Ctbcuenta idctbcuentavta) {
        this.idctbcuentavta = idctbcuentavta;
    }

    public Ctbcuenta getIdctbcuentacosto() {
        return idctbcuentacosto;
    }

    public void setIdctbcuentacosto(Ctbcuenta idctbcuentacosto) {
        this.idctbcuentacosto = idctbcuentacosto;
    }

    public Ctbcuenta getIdctbcuentainteresmora() {
        return idctbcuentainteresmora;
    }

    public void setIdctbcuentainteresmora(Ctbcuenta idctbcuentainteresmora) {
        this.idctbcuentainteresmora = idctbcuentainteresmora;
    }

    public Ctbcuenta getIdctbcuentadescuento() {
        return idctbcuentadescuento;
    }

    public void setIdctbcuentadescuento(Ctbcuenta idctbcuentadescuento) {
        this.idctbcuentadescuento = idctbcuentadescuento;
    }

    public Ctbcuenta getIdctbcuentagastocobranza() {
        return idctbcuentagastocobranza;
    }

    public void setIdctbcuentagastocobranza(Ctbcuenta idctbcuentagastocobranza) {
        this.idctbcuentagastocobranza = idctbcuentagastocobranza;
    }

    public Deposito getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(Deposito iddeposito) {
        this.iddeposito = iddeposito;
    }

    public GiFracciontipo getIdgiFracciontipo() {
        return idgiFracciontipo;
    }

    public void setIdgiFracciontipo(GiFracciontipo idgiFracciontipo) {
        this.idgiFracciontipo = idgiFracciontipo;
    }

    public Boolean isNoappmovil() {
        return noappmovil;
    }

    public void setNoappmovil(boolean noappmovil) {
        this.noappmovil = noappmovil;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiFraccion != null ? idgiFraccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiFraccion)) {
            return false;
        }
        GiFraccion other = (GiFraccion) object;
        if ((this.idgiFraccion == null && other.idgiFraccion != null) || (this.idgiFraccion != null && !this.idgiFraccion.equals(other.idgiFraccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiFraccion[ idgiFraccion=" + idgiFraccion + " ]";
    }
    
}
