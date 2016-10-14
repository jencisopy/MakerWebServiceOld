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
@Table(name = "gi_loteestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLoteestado.findAll", query = "SELECT g FROM GiLoteestado g"),
    @NamedQuery(name = "GiLoteestado.findByIdgiLoteestado", query = "SELECT g FROM GiLoteestado g WHERE g.idgiLoteestado = :idgiLoteestado"),
    @NamedQuery(name = "GiLoteestado.findByNombre", query = "SELECT g FROM GiLoteestado g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GiLoteestado.findByFechacreacion", query = "SELECT g FROM GiLoteestado g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "GiLoteestado.findByFechamodificacion", query = "SELECT g FROM GiLoteestado g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiLoteestado.findByFechareplicacion", query = "SELECT g FROM GiLoteestado g WHERE g.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "GiLoteestado.findByAppuser", query = "SELECT g FROM GiLoteestado g WHERE g.appuser = :appuser")})
public class GiLoteestado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "idgi_loteestado")
    private String idgiLoteestado;
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
    @OneToMany(mappedBy = "idgiLoteestado")
    private List<GiLote> giLoteList;

    public GiLoteestado() {
    }

    public GiLoteestado(String idgiLoteestado) {
        this.idgiLoteestado = idgiLoteestado;
    }

    public GiLoteestado(String idgiLoteestado, String nombre, Date fechacreacion, Date fechamodificacion) {
        this.idgiLoteestado = idgiLoteestado;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public String getIdgiLoteestado() {
        return idgiLoteestado;
    }

    public void setIdgiLoteestado(String idgiLoteestado) {
        this.idgiLoteestado = idgiLoteestado;
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
    public List<GiLote> getGiLoteList() {
        return giLoteList;
    }

    public void setGiLoteList(List<GiLote> giLoteList) {
        this.giLoteList = giLoteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiLoteestado != null ? idgiLoteestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLoteestado)) {
            return false;
        }
        GiLoteestado other = (GiLoteestado) object;
        if ((this.idgiLoteestado == null && other.idgiLoteestado != null) || (this.idgiLoteestado != null && !this.idgiLoteestado.equals(other.idgiLoteestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiLoteestado[ idgiLoteestado=" + idgiLoteestado + " ]";
    }
    
}
