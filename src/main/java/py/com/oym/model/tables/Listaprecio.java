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
@Table(name = "listaprecio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listaprecio.findAll", query = "SELECT l FROM Listaprecio l"),
    @NamedQuery(name = "Listaprecio.findByIdlistaprecio", query = "SELECT l FROM Listaprecio l WHERE l.idlistaprecio = :idlistaprecio"),
    @NamedQuery(name = "Listaprecio.findByIdempresa", query = "SELECT l FROM Listaprecio l WHERE l.idempresa = :idempresa"),
    @NamedQuery(name = "Listaprecio.findByCodigo", query = "SELECT l FROM Listaprecio l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Listaprecio.findByNombre", query = "SELECT l FROM Listaprecio l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Listaprecio.findByLimitedescuento", query = "SELECT l FROM Listaprecio l WHERE l.limitedescuento = :limitedescuento"),
    @NamedQuery(name = "Listaprecio.findByInactivo", query = "SELECT l FROM Listaprecio l WHERE l.inactivo = :inactivo"),
    @NamedQuery(name = "Listaprecio.findByFechareplicacion", query = "SELECT l FROM Listaprecio l WHERE l.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Listaprecio.findByFechamodificacion", query = "SELECT l FROM Listaprecio l WHERE l.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Listaprecio.findByFechacreacion", query = "SELECT l FROM Listaprecio l WHERE l.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Listaprecio.findByFirma", query = "SELECT l FROM Listaprecio l WHERE l.firma = :firma"),
    @NamedQuery(name = "Listaprecio.findByAppuser", query = "SELECT l FROM Listaprecio l WHERE l.appuser = :appuser")})
public class Listaprecio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlistaprecio")
    private Long idlistaprecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limitedescuento")
    private BigDecimal limitedescuento;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "inactivo")
    private Boolean inactivo;
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
    @OneToMany(mappedBy = "idlistaprecio")
    private List<Ctacte> ctacteList;
    @JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda")
    @ManyToOne(optional = false)
    private Moneda idmoneda;

    public Listaprecio() {
    }

    public Listaprecio(Long idlistaprecio) {
        this.idlistaprecio = idlistaprecio;
    }

    public Listaprecio(Long idlistaprecio, long idempresa, String codigo, String nombre) {
        this.idlistaprecio = idlistaprecio;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdlistaprecio() {
        return idlistaprecio;
    }

    public void setIdlistaprecio(Long idlistaprecio) {
        this.idlistaprecio = idlistaprecio;
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

    public BigDecimal getLimitedescuento() {
        return limitedescuento;
    }

    public void setLimitedescuento(BigDecimal limitedescuento) {
        this.limitedescuento = limitedescuento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    public Moneda getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Moneda idmoneda) {
        this.idmoneda = idmoneda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistaprecio != null ? idlistaprecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listaprecio)) {
            return false;
        }
        Listaprecio other = (Listaprecio) object;
        if ((this.idlistaprecio == null && other.idlistaprecio != null) || (this.idlistaprecio != null && !this.idlistaprecio.equals(other.idlistaprecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Listaprecio[ idlistaprecio=" + idlistaprecio + " ]";
    }
    
}
