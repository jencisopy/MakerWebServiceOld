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
@Table(name = "ctacteramo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctacteramo.findAll", query = "SELECT c FROM Ctacteramo c"),
    @NamedQuery(name = "Ctacteramo.findByIdctacteramo", query = "SELECT c FROM Ctacteramo c WHERE c.idctacteramo = :idctacteramo"),
    @NamedQuery(name = "Ctacteramo.findByIdempresa", query = "SELECT c FROM Ctacteramo c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Ctacteramo.findByCodigo", query = "SELECT c FROM Ctacteramo c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Ctacteramo.findByNombre", query = "SELECT c FROM Ctacteramo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ctacteramo.findByFechareplicacion", query = "SELECT c FROM Ctacteramo c WHERE c.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Ctacteramo.findByFechacreacion", query = "SELECT c FROM Ctacteramo c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Ctacteramo.findByFechamodificacion", query = "SELECT c FROM Ctacteramo c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ctacteramo.findByFirma", query = "SELECT c FROM Ctacteramo c WHERE c.firma = :firma"),
    @NamedQuery(name = "Ctacteramo.findByAppuser", query = "SELECT c FROM Ctacteramo c WHERE c.appuser = :appuser")})
public class Ctacteramo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacteramo")
    private Long idctacteramo;
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
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @OneToMany(mappedBy = "idctacteramo")
    private List<Ctacte> ctacteList;

    public Ctacteramo() {
    }

    public Ctacteramo(Long idctacteramo) {
        this.idctacteramo = idctacteramo;
    }

    public Ctacteramo(Long idctacteramo, long idempresa, String codigo, String nombre, Date fechacreacion, Date fechamodificacion) {
        this.idctacteramo = idctacteramo;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public Long getIdctacteramo() {
        return idctacteramo;
    }

    public void setIdctacteramo(Long idctacteramo) {
        this.idctacteramo = idctacteramo;
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

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idctacteramo != null ? idctacteramo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctacteramo)) {
            return false;
        }
        Ctacteramo other = (Ctacteramo) object;
        if ((this.idctacteramo == null && other.idctacteramo != null) || (this.idctacteramo != null && !this.idctacteramo.equals(other.idctacteramo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Ctacteramo[ idctacteramo=" + idctacteramo + " ]";
    }
    
}
