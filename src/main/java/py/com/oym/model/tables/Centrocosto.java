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
@Table(name = "centrocosto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centrocosto.findAll", query = "SELECT c FROM Centrocosto c"),
    @NamedQuery(name = "Centrocosto.findByIdcentrocosto", query = "SELECT c FROM Centrocosto c WHERE c.idcentrocosto = :idcentrocosto"),
    @NamedQuery(name = "Centrocosto.findByIdempresa", query = "SELECT c FROM Centrocosto c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Centrocosto.findByCodigo", query = "SELECT c FROM Centrocosto c WHERE c.idempresa = :idempresa and c.codigo = :codigo")})
public class Centrocosto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcentrocosto")
    private Long idcentrocosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "inactivo")
    private Boolean inactivo;
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
    @OneToMany(mappedBy = "idcentrocosto")
    private List<GiFraccion> giFraccionList;
    @JoinColumn(name = "idempresaunidad", referencedColumnName = "idempresaunidad")
    @ManyToOne
    private Empresaunidad idempresaunidad;
    @OneToMany(mappedBy = "idcentrocostopadre")
    private List<Centrocosto> centrocostoList;
    @JoinColumn(name = "idcentrocostopadre", referencedColumnName = "idcentrocosto")
    @ManyToOne
    private Centrocosto idcentrocostopadre;

    public Centrocosto() {
    }

    public Centrocosto(Long idcentrocosto) {
        this.idcentrocosto = idcentrocosto;
    }

    public Centrocosto(Long idcentrocosto, long idempresa, String codigo, String nombre) {
        this.idcentrocosto = idcentrocosto;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdcentrocosto() {
        return idcentrocosto;
    }

    public void setIdcentrocosto(Long idcentrocosto) {
        this.idcentrocosto = idcentrocosto;
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

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
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

    public Empresaunidad getIdempresaunidad() {
        return idempresaunidad;
    }

    public void setIdempresaunidad(Empresaunidad idempresaunidad) {
        this.idempresaunidad = idempresaunidad;
    }

    @XmlTransient
    public List<Centrocosto> getCentrocostoList() {
        return centrocostoList;
    }

    public void setCentrocostoList(List<Centrocosto> centrocostoList) {
        this.centrocostoList = centrocostoList;
    }

    public Centrocosto getIdcentrocostopadre() {
        return idcentrocostopadre;
    }

    public void setIdcentrocostopadre(Centrocosto idcentrocostopadre) {
        this.idcentrocostopadre = idcentrocostopadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcentrocosto != null ? idcentrocosto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centrocosto)) {
            return false;
        }
        Centrocosto other = (Centrocosto) object;
        if ((this.idcentrocosto == null && other.idcentrocosto != null) || (this.idcentrocosto != null && !this.idcentrocosto.equals(other.idcentrocosto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Centrocosto[ idcentrocosto=" + idcentrocosto + " ]";
    }
    
}
