/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "gi_lotevtaestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLotevtaestado.findAll", query = "SELECT g FROM GiLotevtaestado g"),
    @NamedQuery(name = "GiLotevtaestado.findByIdgiLotevtaestado", query = "SELECT g FROM GiLotevtaestado g WHERE g.idgiLotevtaestado = :idgiLotevtaestado"),
    @NamedQuery(name = "GiLotevtaestado.findByNombre", query = "SELECT g FROM GiLotevtaestado g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GiLotevtaestado.findByFechacreacion", query = "SELECT g FROM GiLotevtaestado g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "GiLotevtaestado.findByFechamodificacion", query = "SELECT g FROM GiLotevtaestado g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiLotevtaestado.findByFechareplicacion", query = "SELECT g FROM GiLotevtaestado g WHERE g.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "GiLotevtaestado.findByAppuser", query = "SELECT g FROM GiLotevtaestado g WHERE g.appuser = :appuser")})
public class GiLotevtaestado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "idgi_lotevtaestado")
    private String idgiLotevtaestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @OneToMany(mappedBy = "idgiLotevtaestado")
    private List<GiLotevta> giLotevtaList;

    public GiLotevtaestado() {
    }

    public GiLotevtaestado(String idgiLotevtaestado) {
        this.idgiLotevtaestado = idgiLotevtaestado;
    }

    public GiLotevtaestado(String idgiLotevtaestado, String nombre, Date fechacreacion, Date fechamodificacion) {
        this.idgiLotevtaestado = idgiLotevtaestado;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public String getIdgiLotevtaestado() {
        return idgiLotevtaestado;
    }

    public void setIdgiLotevtaestado(String idgiLotevtaestado) {
        this.idgiLotevtaestado = idgiLotevtaestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
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
        hash += (idgiLotevtaestado != null ? idgiLotevtaestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLotevtaestado)) {
            return false;
        }
        GiLotevtaestado other = (GiLotevtaestado) object;
        if ((this.idgiLotevtaestado == null && other.idgiLotevtaestado != null) || (this.idgiLotevtaestado != null && !this.idgiLotevtaestado.equals(other.idgiLotevtaestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiLotevtaestado[ idgiLotevtaestado=" + idgiLotevtaestado + " ]";
    }
    
}
