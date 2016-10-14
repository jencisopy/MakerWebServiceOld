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
@Table(name = "empresaunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresaunidad.findAll", query = "SELECT e FROM Empresaunidad e"),
    @NamedQuery(name = "Empresaunidad.findByIdempresaunidad", query = "SELECT e FROM Empresaunidad e WHERE e.idempresaunidad = :idempresaunidad"),
    @NamedQuery(name = "Empresaunidad.findByIdempresa", query = "SELECT e FROM Empresaunidad e WHERE e.idempresa = :idempresa"),
    @NamedQuery(name = "Empresaunidad.findByCodigo", query = "SELECT e FROM Empresaunidad e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Empresaunidad.findByNombre", query = "SELECT e FROM Empresaunidad e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empresaunidad.findByDivision", query = "SELECT e FROM Empresaunidad e WHERE e.division = :division"),
    @NamedQuery(name = "Empresaunidad.findByExplotacion", query = "SELECT e FROM Empresaunidad e WHERE e.explotacion = :explotacion"),
    @NamedQuery(name = "Empresaunidad.findByNroregistropatron", query = "SELECT e FROM Empresaunidad e WHERE e.nroregistropatron = :nroregistropatron"),
    @NamedQuery(name = "Empresaunidad.findByDireccion", query = "SELECT e FROM Empresaunidad e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresaunidad.findByTelefono", query = "SELECT e FROM Empresaunidad e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empresaunidad.findByEmail", query = "SELECT e FROM Empresaunidad e WHERE e.email = :email"),
    @NamedQuery(name = "Empresaunidad.findByWeb", query = "SELECT e FROM Empresaunidad e WHERE e.web = :web"),
    @NamedQuery(name = "Empresaunidad.findBySeguronro", query = "SELECT e FROM Empresaunidad e WHERE e.seguronro = :seguronro"),
    @NamedQuery(name = "Empresaunidad.findByLocalidad", query = "SELECT e FROM Empresaunidad e WHERE e.localidad = :localidad"),
    @NamedQuery(name = "Empresaunidad.findByDepartamento", query = "SELECT e FROM Empresaunidad e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "Empresaunidad.findByFechacreacion", query = "SELECT e FROM Empresaunidad e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Empresaunidad.findByFechamodificacion", query = "SELECT e FROM Empresaunidad e WHERE e.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Empresaunidad.findByFechareplicacion", query = "SELECT e FROM Empresaunidad e WHERE e.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Empresaunidad.findByFirma", query = "SELECT e FROM Empresaunidad e WHERE e.firma = :firma"),
    @NamedQuery(name = "Empresaunidad.findByAppuser", query = "SELECT e FROM Empresaunidad e WHERE e.appuser = :appuser")})
public class Empresaunidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresaunidad")
    private Long idempresaunidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "division")
    private String division;
    @Size(max = 50)
    @Column(name = "explotacion")
    private String explotacion;
    @Size(max = 20)
    @Column(name = "nroregistropatron")
    private String nroregistropatron;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "web")
    private String web;
    @Size(max = 15)
    @Column(name = "seguronro")
    private String seguronro;
    @Size(max = 30)
    @Column(name = "localidad")
    private String localidad;
    @Size(max = 30)
    @Column(name = "departamento")
    private String departamento;
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
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @OneToMany(mappedBy = "idempresaunidad")
    private List<Centrocosto> centrocostoList;

    public Empresaunidad() {
    }

    public Empresaunidad(Long idempresaunidad) {
        this.idempresaunidad = idempresaunidad;
    }

    public Empresaunidad(Long idempresaunidad, long idempresa, String codigo, String nombre, Date fechacreacion, Date fechamodificacion) {
        this.idempresaunidad = idempresaunidad;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public Long getIdempresaunidad() {
        return idempresaunidad;
    }

    public void setIdempresaunidad(Long idempresaunidad) {
        this.idempresaunidad = idempresaunidad;
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getExplotacion() {
        return explotacion;
    }

    public void setExplotacion(String explotacion) {
        this.explotacion = explotacion;
    }

    public String getNroregistropatron() {
        return nroregistropatron;
    }

    public void setNroregistropatron(String nroregistropatron) {
        this.nroregistropatron = nroregistropatron;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getSeguronro() {
        return seguronro;
    }

    public void setSeguronro(String seguronro) {
        this.seguronro = seguronro;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
    public List<Centrocosto> getCentrocostoList() {
        return centrocostoList;
    }

    public void setCentrocostoList(List<Centrocosto> centrocostoList) {
        this.centrocostoList = centrocostoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresaunidad != null ? idempresaunidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresaunidad)) {
            return false;
        }
        Empresaunidad other = (Empresaunidad) object;
        if ((this.idempresaunidad == null && other.idempresaunidad != null) || (this.idempresaunidad != null && !this.idempresaunidad.equals(other.idempresaunidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Empresaunidad[ idempresaunidad=" + idempresaunidad + " ]";
    }
    
}
