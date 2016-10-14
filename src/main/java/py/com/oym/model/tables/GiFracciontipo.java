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
@Table(name = "gi_fracciontipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiFracciontipo.findAll", query = "SELECT g FROM GiFracciontipo g"),
    @NamedQuery(name = "GiFracciontipo.findByIdgiFracciontipo", query = "SELECT g FROM GiFracciontipo g WHERE g.idgiFracciontipo = :idgiFracciontipo"),
    @NamedQuery(name = "GiFracciontipo.findByIdempresa", query = "SELECT g FROM GiFracciontipo g WHERE g.idempresa = :idempresa"),
    @NamedQuery(name = "GiFracciontipo.findByCodigo", query = "SELECT g FROM GiFracciontipo g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "GiFracciontipo.findByNombre", query = "SELECT g FROM GiFracciontipo g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GiFracciontipo.findByFechareplicacion", query = "SELECT g FROM GiFracciontipo g WHERE g.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "GiFracciontipo.findByFechamodificacion", query = "SELECT g FROM GiFracciontipo g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiFracciontipo.findByFechacreacion", query = "SELECT g FROM GiFracciontipo g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "GiFracciontipo.findByFirma", query = "SELECT g FROM GiFracciontipo g WHERE g.firma = :firma"),
    @NamedQuery(name = "GiFracciontipo.findByAppuser", query = "SELECT g FROM GiFracciontipo g WHERE g.appuser = :appuser")})
public class GiFracciontipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_fracciontipo")
    private Long idgiFracciontipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(mappedBy = "idgiFracciontipo")
    private List<GiFraccion> giFraccionList;

    public GiFracciontipo() {
    }

    public GiFracciontipo(Long idgiFracciontipo) {
        this.idgiFracciontipo = idgiFracciontipo;
    }

    public GiFracciontipo(Long idgiFracciontipo, long idempresa, String codigo, String nombre) {
        this.idgiFracciontipo = idgiFracciontipo;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdgiFracciontipo() {
        return idgiFracciontipo;
    }

    public void setIdgiFracciontipo(Long idgiFracciontipo) {
        this.idgiFracciontipo = idgiFracciontipo;
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
    public List<GiFraccion> getGiFraccionList() {
        return giFraccionList;
    }

    public void setGiFraccionList(List<GiFraccion> giFraccionList) {
        this.giFraccionList = giFraccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiFracciontipo != null ? idgiFracciontipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiFracciontipo)) {
            return false;
        }
        GiFracciontipo other = (GiFracciontipo) object;
        if ((this.idgiFracciontipo == null && other.idgiFracciontipo != null) || (this.idgiFracciontipo != null && !this.idgiFracciontipo.equals(other.idgiFracciontipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiFracciontipo[ idgiFracciontipo=" + idgiFracciontipo + " ]";
    }
    
}
