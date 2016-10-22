/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jenci_000
 */
@Entity
@Table(name = "gi_lotevtapersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLotevtapersona.findAll", query = "SELECT g FROM GiLotevtapersona g"),
    @NamedQuery(name = "GiLotevtapersona.findByIdgiLotevtapersona", query = "SELECT g FROM GiLotevtapersona g WHERE g.idgiLotevtapersona = :idgiLotevtapersona"),
    @NamedQuery(name = "GiLotevtapersona.findByRol", query = "SELECT g FROM GiLotevtapersona g WHERE g.rol = :rol"),
    @NamedQuery(name = "GiLotevtapersona.findByFechareplicacion", query = "SELECT g FROM GiLotevtapersona g WHERE g.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "GiLotevtapersona.findByFechamodificacion", query = "SELECT g FROM GiLotevtapersona g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiLotevtapersona.findByAppuser", query = "SELECT g FROM GiLotevtapersona g WHERE g.appuser = :appuser")})
public class GiLotevtapersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    @Column(name = "idgi_lotevtapersona")
    private Long idgiLotevtapersona;
    
    @Basic(optional = false)
    @JoinColumn(name = "idgi_lotevta", referencedColumnName = "idgi_lotevta")
    @ManyToOne
    private GiLotevta idgiLotevta;

    @Column(name = "idpersona")
    private Long idpersona;
    
    @Size(max = 10)
    @Column(name = "rol")
    private String rol;
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

    public GiLotevtapersona() {
    }

    public GiLotevtapersona(Long idgiLotevtapersona) {
        this.idgiLotevtapersona = idgiLotevtapersona;
    }

    public Long getIdgiLotevtapersona() {
        return idgiLotevtapersona;
    }

    public void setIdgiLotevtapersona(Long idgiLotevtapersona) {
        this.idgiLotevtapersona = idgiLotevtapersona;
    }

    public Long getIdPersona() {
        return idpersona;
    }

    public void setIdPersona(Long idpersona) {
        this.idpersona = idpersona;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        hash += (idgiLotevtapersona != null ? idgiLotevtapersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLotevtapersona)) {
            return false;
        }
        GiLotevtapersona other = (GiLotevtapersona) object;
        if ((this.idgiLotevtapersona == null && other.idgiLotevtapersona != null) || (this.idgiLotevtapersona != null && !this.idgiLotevtapersona.equals(other.idgiLotevtapersona))) {
            return false;
        }
        return true;
    }

    public GiLotevta getIdgiLotevta() {
        return idgiLotevta;
    }

    public void setIdgiLotevta(GiLotevta idgiLotevta) {
        this.idgiLotevta = idgiLotevta;
    }
    
    @Override
    public String toString() {
        return "py.com.oym.webservices.model.GiLotevtapersona[ idgiLotevtapersona=" + idgiLotevtapersona + " ]";
    }

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }    
}
