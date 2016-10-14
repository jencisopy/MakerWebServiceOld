/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b"),
    @NamedQuery(name = "Barrio.findByIdbarrio", query = "SELECT b FROM Barrio b WHERE b.idbarrio = :idbarrio"),
    @NamedQuery(name = "Barrio.findByCodigo", query = "SELECT b FROM Barrio b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Barrio.findByNombre", query = "SELECT b FROM Barrio b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Barrio.findByLatitud", query = "SELECT b FROM Barrio b WHERE b.latitud = :latitud"),
    @NamedQuery(name = "Barrio.findByLongitud", query = "SELECT b FROM Barrio b WHERE b.longitud = :longitud"),
    @NamedQuery(name = "Barrio.findByFechareplicacion", query = "SELECT b FROM Barrio b WHERE b.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Barrio.findByFechamodificacion", query = "SELECT b FROM Barrio b WHERE b.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Barrio.findByFechacreacion", query = "SELECT b FROM Barrio b WHERE b.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Barrio.findByFirma", query = "SELECT b FROM Barrio b WHERE b.firma = :firma"),
    @NamedQuery(name = "Barrio.findByAppuser", query = "SELECT b FROM Barrio b WHERE b.appuser = :appuser")})
public class Barrio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbarrio")
    private Long idbarrio;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private BigDecimal latitud;
    @Column(name = "longitud")
    private BigDecimal longitud;
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
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false)
    private Ciudad idciudad;
    @OneToMany(mappedBy = "idbarrio")
    private List<GiFraccion> giFraccionList;
    @OneToMany(mappedBy = "idbarrio")
    private List<Persona> personaList;

    public Barrio() {
    }

    public Barrio(Long idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Barrio(Long idbarrio, String codigo, String nombre) {
        this.idbarrio = idbarrio;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Long idbarrio) {
        this.idbarrio = idbarrio;
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

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
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

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList() {
        return giFraccionList;
    }

    public void setGiFraccionList(List<GiFraccion> giFraccionList) {
        this.giFraccionList = giFraccionList;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbarrio != null ? idbarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.idbarrio == null && other.idbarrio != null) || (this.idbarrio != null && !this.idbarrio.equals(other.idbarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Barrio[ idbarrio=" + idbarrio + " ]";
    }
    
}
