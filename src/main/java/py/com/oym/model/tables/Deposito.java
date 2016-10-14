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
import javax.persistence.Lob;
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
@Table(name = "deposito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d"),
    @NamedQuery(name = "Deposito.findByIddeposito", query = "SELECT d FROM Deposito d WHERE d.iddeposito = :iddeposito"),
    @NamedQuery(name = "Deposito.findByIdempresa", query = "SELECT d FROM Deposito d WHERE d.idempresa = :idempresa"),
    @NamedQuery(name = "Deposito.findByCodigo", query = "SELECT d FROM Deposito d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Deposito.findByNombre", query = "SELECT d FROM Deposito d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Deposito.findByDireccion", query = "SELECT d FROM Deposito d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Deposito.findByTelefono", query = "SELECT d FROM Deposito d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Deposito.findByEmail", query = "SELECT d FROM Deposito d WHERE d.email = :email"),
    @NamedQuery(name = "Deposito.findByInactivo", query = "SELECT d FROM Deposito d WHERE d.inactivo = :inactivo"),
    @NamedQuery(name = "Deposito.findByFechareplicacion", query = "SELECT d FROM Deposito d WHERE d.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Deposito.findByFechamodificacion", query = "SELECT d FROM Deposito d WHERE d.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Deposito.findByFechacreacion", query = "SELECT d FROM Deposito d WHERE d.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Deposito.findByFirma", query = "SELECT d FROM Deposito d WHERE d.firma = :firma"),
    @NamedQuery(name = "Deposito.findByAppuser", query = "SELECT d FROM Deposito d WHERE d.appuser = :appuser")})
public class Deposito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeposito")
    private Long iddeposito;
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
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inactivo")
    private boolean inactivo;
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
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false)
    private Sucursal idsucursal;
    @OneToMany(mappedBy = "iddepositopadre")
    private List<Deposito> depositoList;
    @JoinColumn(name = "iddepositopadre", referencedColumnName = "iddeposito")
    @ManyToOne
    private Deposito iddepositopadre;
    @OneToMany(mappedBy = "iddeposito")
    private List<GiFraccion> giFraccionList;

    public Deposito() {
    }

    public Deposito(Long iddeposito) {
        this.iddeposito = iddeposito;
    }

    public Deposito(Long iddeposito, long idempresa, String codigo, String nombre, boolean inactivo) {
        this.iddeposito = iddeposito;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.inactivo = inactivo;
    }

    public Long getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(Long iddeposito) {
        this.iddeposito = iddeposito;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
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

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    @XmlTransient
    public List<Deposito> getDepositoList() {
        return depositoList;
    }

    public void setDepositoList(List<Deposito> depositoList) {
        this.depositoList = depositoList;
    }

    public Deposito getIddepositopadre() {
        return iddepositopadre;
    }

    public void setIddepositopadre(Deposito iddepositopadre) {
        this.iddepositopadre = iddepositopadre;
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
        hash += (iddeposito != null ? iddeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.iddeposito == null && other.iddeposito != null) || (this.iddeposito != null && !this.iddeposito.equals(other.iddeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Deposito[ iddeposito=" + iddeposito + " ]";
    }
    
}
