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
@Table(name = "zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z"),
    @NamedQuery(name = "Zona.findByIdzona", query = "SELECT z FROM Zona z WHERE z.idzona = :idzona"),
    @NamedQuery(name = "Zona.findByIdempresa", query = "SELECT z FROM Zona z WHERE z.idempresa = :idempresa"),
    @NamedQuery(name = "Zona.findByCodigo", query = "SELECT z FROM Zona z WHERE z.codigo = :codigo"),
    @NamedQuery(name = "Zona.findBySubzona", query = "SELECT z FROM Zona z WHERE z.subzona = :subzona"),
    @NamedQuery(name = "Zona.findByNombre", query = "SELECT z FROM Zona z WHERE z.nombre = :nombre"),
    @NamedQuery(name = "Zona.findByFechareplicacion", query = "SELECT z FROM Zona z WHERE z.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Zona.findByFechamodificacion", query = "SELECT z FROM Zona z WHERE z.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Zona.findByFechacreacion", query = "SELECT z FROM Zona z WHERE z.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Zona.findByFirma", query = "SELECT z FROM Zona z WHERE z.firma = :firma"),
    @NamedQuery(name = "Zona.findByAppuser", query = "SELECT z FROM Zona z WHERE z.appuser = :appuser")})
public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idzona")
    private Long idzona;
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
    @Size(min = 1, max = 3)
    @Column(name = "subzona")
    private String subzona;
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
    @OneToMany(mappedBy = "idzona")
    private List<Ctacte> ctacteList;

    public Zona() {
    }

    public Zona(Long idzona) {
        this.idzona = idzona;
    }

    public Zona(Long idzona, long idempresa, String codigo, String subzona, String nombre) {
        this.idzona = idzona;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.subzona = subzona;
        this.nombre = nombre;
    }

    public Long getIdzona() {
        return idzona;
    }

    public void setIdzona(Long idzona) {
        this.idzona = idzona;
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

    public String getSubzona() {
        return subzona;
    }

    public void setSubzona(String subzona) {
        this.subzona = subzona;
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
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idzona != null ? idzona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.idzona == null && other.idzona != null) || (this.idzona != null && !this.idzona.equals(other.idzona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Zona[ idzona=" + idzona + " ]";
    }
    
}
