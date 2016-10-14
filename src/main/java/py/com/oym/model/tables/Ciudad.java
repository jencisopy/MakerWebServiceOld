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
import javax.persistence.CascadeType;
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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdciudad", query = "SELECT c FROM Ciudad c WHERE c.idciudad = :idciudad"),
    @NamedQuery(name = "Ciudad.findByCodigo", query = "SELECT c FROM Ciudad c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ciudad.findByLatitud", query = "SELECT c FROM Ciudad c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "Ciudad.findByLongitud", query = "SELECT c FROM Ciudad c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "Ciudad.findByFechareplicacion", query = "SELECT c FROM Ciudad c WHERE c.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Ciudad.findByFechamodificacion", query = "SELECT c FROM Ciudad c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ciudad.findByFechacreacion", query = "SELECT c FROM Ciudad c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Ciudad.findByFirma", query = "SELECT c FROM Ciudad c WHERE c.firma = :firma"),
    @NamedQuery(name = "Ciudad.findByAppuser", query = "SELECT c FROM Ciudad c WHERE c.appuser = :appuser")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idciudad")
    private Long idciudad;
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
    @JoinColumn(name = "idprovincia", referencedColumnName = "idprovincia")
    @ManyToOne(optional = false)
    private Provincia idprovincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idciudad")
    private List<Barrio> barrioList;
    @OneToMany(mappedBy = "idciudad")
    private List<GiFraccion> giFraccionList;
    @OneToMany(mappedBy = "idciudad")
    private List<Persona> personaList;

    public Ciudad() {
    }

    public Ciudad(Long idciudad) {
        this.idciudad = idciudad;
    }

    public Ciudad(Long idciudad, String codigo, String nombre) {
        this.idciudad = idciudad;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
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

    public Provincia getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Provincia idprovincia) {
        this.idprovincia = idprovincia;
    }

    @XmlTransient
    public List<Barrio> getBarrioList() {
        return barrioList;
    }

    public void setBarrioList(List<Barrio> barrioList) {
        this.barrioList = barrioList;
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
        hash += (idciudad != null ? idciudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idciudad == null && other.idciudad != null) || (this.idciudad != null && !this.idciudad.equals(other.idciudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Ciudad[ idciudad=" + idciudad + " ]";
    }
    
}
