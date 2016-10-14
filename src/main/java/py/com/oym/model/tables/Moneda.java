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
import javax.persistence.Lob;
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
@Table(name = "moneda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m"),
    @NamedQuery(name = "Moneda.findByIdmoneda", query = "SELECT m FROM Moneda m WHERE m.idmoneda = :idmoneda"),
    @NamedQuery(name = "Moneda.findByIdempresa", query = "SELECT m FROM Moneda m WHERE m.idempresa = :idempresa"),
    @NamedQuery(name = "Moneda.findByCodigo", query = "SELECT m FROM Moneda m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Moneda.findByNombre", query = "SELECT m FROM Moneda m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Moneda.findByCambio", query = "SELECT m FROM Moneda m WHERE m.cambio = :cambio"),
    @NamedQuery(name = "Moneda.findByDecimalpoint", query = "SELECT m FROM Moneda m WHERE m.decimalpoint = :decimalpoint"),
    @NamedQuery(name = "Moneda.findByFechareplicacion", query = "SELECT m FROM Moneda m WHERE m.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Moneda.findByFechamodificacion", query = "SELECT m FROM Moneda m WHERE m.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Moneda.findByFechacreacion", query = "SELECT m FROM Moneda m WHERE m.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Moneda.findByFirma", query = "SELECT m FROM Moneda m WHERE m.firma = :firma"),
    @NamedQuery(name = "Moneda.findByAppuser", query = "SELECT m FROM Moneda m WHERE m.appuser = :appuser")})
public class Moneda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmoneda")
    private Long idmoneda;
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
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio")
    private BigDecimal cambio;
    @Column(name = "decimalpoint")
    private Short decimalpoint;
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

    public Moneda() {
    }

    public Moneda(Long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Moneda(Long idmoneda, long idempresa, String codigo, String nombre, BigDecimal cambio) {
        this.idmoneda = idmoneda;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cambio = cambio;
    }

    public Long getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Long idmoneda) {
        this.idmoneda = idmoneda;
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

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public Short getDecimalpoint() {
        return decimalpoint;
    }

    public void setDecimalpoint(Short decimalpoint) {
        this.decimalpoint = decimalpoint;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmoneda != null ? idmoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
        if ((this.idmoneda == null && other.idmoneda != null) || (this.idmoneda != null && !this.idmoneda.equals(other.idmoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Moneda[ idmoneda=" + idmoneda + " ]";
    }
    
}
