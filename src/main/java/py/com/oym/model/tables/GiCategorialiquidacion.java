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
 * @author jenci_000
 */
@Entity
@Table(name = "gi_categorialiquidacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiCategorialiquidacion.findAll", query = "SELECT g FROM GiCategorialiquidacion g"),
    @NamedQuery(name = "GiCategorialiquidacion.findByIdgiCategorialiquidacion", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.idgiCategorialiquidacion = :idgiCategorialiquidacion"),
    @NamedQuery(name = "GiCategorialiquidacion.findByIdempresa", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.idempresa = :idempresa"),
    @NamedQuery(name = "GiCategorialiquidacion.findByCodigo", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "GiCategorialiquidacion.findByNombre", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GiCategorialiquidacion.findByInactivo", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.inactivo = :inactivo"),
    @NamedQuery(name = "GiCategorialiquidacion.findByFechacreacion", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "GiCategorialiquidacion.findByFechamodificacion", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiCategorialiquidacion.findByFechareplicacion", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "GiCategorialiquidacion.findByAppuser", query = "SELECT g FROM GiCategorialiquidacion g WHERE g.appuser = :appuser")})
public class GiCategorialiquidacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_categorialiquidacion")
    private Long idgiCategorialiquidacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inactivo")
    private boolean inactivo;
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
    @OneToMany(mappedBy = "idgiCategorialiquidacion")
    private List<GiLotevta> giLotevtaList;
    @JoinColumn(name = "idgi_fraccion", referencedColumnName = "idgi_fraccion")
    @ManyToOne(optional = false)
    private GiFraccion idgiFraccion;

    public GiCategorialiquidacion() {
    }

    public GiCategorialiquidacion(Long idgiCategorialiquidacion) {
        this.idgiCategorialiquidacion = idgiCategorialiquidacion;
    }

    public GiCategorialiquidacion(Long idgiCategorialiquidacion, long idempresa, String codigo, String nombre, boolean inactivo, Date fechacreacion, Date fechamodificacion) {
        this.idgiCategorialiquidacion = idgiCategorialiquidacion;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.inactivo = inactivo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public Long getIdgiCategorialiquidacion() {
        return idgiCategorialiquidacion;
    }

    public void setIdgiCategorialiquidacion(Long idgiCategorialiquidacion) {
        this.idgiCategorialiquidacion = idgiCategorialiquidacion;
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

    public boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
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

    public GiFraccion getIdgiFraccion() {
        return idgiFraccion;
    }

    public void setIdgiFraccion(GiFraccion idgiFraccion) {
        this.idgiFraccion = idgiFraccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiCategorialiquidacion != null ? idgiCategorialiquidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiCategorialiquidacion)) {
            return false;
        }
        GiCategorialiquidacion other = (GiCategorialiquidacion) object;
        if ((this.idgiCategorialiquidacion == null && other.idgiCategorialiquidacion != null) || (this.idgiCategorialiquidacion != null && !this.idgiCategorialiquidacion.equals(other.idgiCategorialiquidacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiCategorialiquidacion[ idgiCategorialiquidacion=" + idgiCategorialiquidacion + " ]";
    }
    
}
