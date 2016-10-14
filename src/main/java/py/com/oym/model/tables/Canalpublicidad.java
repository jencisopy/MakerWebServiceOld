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
@Table(name = "canalpublicidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canalpublicidad.findAll", query = "SELECT c FROM Canalpublicidad c"),
    @NamedQuery(name = "Canalpublicidad.findByIdcanalpublicidad", query = "SELECT c FROM Canalpublicidad c WHERE c.idcanalpublicidad = :idcanalpublicidad"),
    @NamedQuery(name = "Canalpublicidad.findByIdempresa", query = "SELECT c FROM Canalpublicidad c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Canalpublicidad.findByCodigo", query = "SELECT c FROM Canalpublicidad c WHERE  c.idempresa = :idempresa and c.codigo = :codigo")})
public class Canalpublicidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcanalpublicidad")
    private Long idcanalpublicidad;
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
    @OneToMany(mappedBy = "idcanalpublicidad")
    private List<GiLotevta> giLotevtaList;

    public Canalpublicidad() {
    }

    public Canalpublicidad(Long idcanalpublicidad) {
        this.idcanalpublicidad = idcanalpublicidad;
    }

    public Canalpublicidad(Long idcanalpublicidad, long idempresa, String codigo, String nombre) {
        this.idcanalpublicidad = idcanalpublicidad;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdcanalpublicidad() {
        return idcanalpublicidad;
    }

    public void setIdcanalpublicidad(Long idcanalpublicidad) {
        this.idcanalpublicidad = idcanalpublicidad;
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
    public List<GiLotevta> getGiLotevtaList() {
        return giLotevtaList;
    }

    public void setGiLotevtaList(List<GiLotevta> giLotevtaList) {
        this.giLotevtaList = giLotevtaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcanalpublicidad != null ? idcanalpublicidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canalpublicidad)) {
            return false;
        }
        Canalpublicidad other = (Canalpublicidad) object;
        if ((this.idcanalpublicidad == null && other.idcanalpublicidad != null) || (this.idcanalpublicidad != null && !this.idcanalpublicidad.equals(other.idcanalpublicidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Canalpublicidad[ idcanalpublicidad=" + idcanalpublicidad + " ]";
    }
    
}
