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
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f"),
    @NamedQuery(name = "Familia.findByIdfamilia", query = "SELECT f FROM Familia f WHERE f.idfamilia = :idfamilia"),
    @NamedQuery(name = "Familia.findByIdempresa", query = "SELECT f FROM Familia f WHERE f.idempresa = :idempresa"),
    @NamedQuery(name = "Familia.findByCodigo", query = "SELECT f FROM Familia f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Familia.findByNombre", query = "SELECT f FROM Familia f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Familia.findByFechareplicacion", query = "SELECT f FROM Familia f WHERE f.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Familia.findByFechamodificacion", query = "SELECT f FROM Familia f WHERE f.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Familia.findByFechacreacion", query = "SELECT f FROM Familia f WHERE f.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Familia.findByFirma", query = "SELECT f FROM Familia f WHERE f.firma = :firma"),
    @NamedQuery(name = "Familia.findByAppuser", query = "SELECT f FROM Familia f WHERE f.appuser = :appuser")})
public class Familia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfamilia")
    private Long idfamilia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfamilia")
    private List<Familiagrupo> familiagrupoList;

    public Familia() {
    }

    public Familia(Long idfamilia) {
        this.idfamilia = idfamilia;
    }

    public Familia(Long idfamilia, long idempresa, String codigo, String nombre) {
        this.idfamilia = idfamilia;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(Long idfamilia) {
        this.idfamilia = idfamilia;
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

    @XmlTransient
    public List<Familiagrupo> getFamiliagrupoList() {
        return familiagrupoList;
    }

    public void setFamiliagrupoList(List<Familiagrupo> familiagrupoList) {
        this.familiagrupoList = familiagrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfamilia != null ? idfamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.idfamilia == null && other.idfamilia != null) || (this.idfamilia != null && !this.idfamilia.equals(other.idfamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Familia[ idfamilia=" + idfamilia + " ]";
    }
    
}
