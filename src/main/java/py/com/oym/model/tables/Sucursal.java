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
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdsucursal", query = "SELECT s FROM Sucursal s WHERE s.idsucursal = :idsucursal"),
    @NamedQuery(name = "Sucursal.findByIdempresa", query = "SELECT s FROM Sucursal s WHERE s.idempresa = :idempresa"),
    @NamedQuery(name = "Sucursal.findByCodigo", query = "SELECT s FROM Sucursal s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Sucursal.findByIdempresasucursal", query = "SELECT s FROM Sucursal s WHERE s.idempresasucursal = :idempresasucursal"),
    @NamedQuery(name = "Sucursal.findByNombre", query = "SELECT s FROM Sucursal s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sucursal.findByTelefono", query = "SELECT s FROM Sucursal s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Sucursal.findByDireccion", query = "SELECT s FROM Sucursal s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursal.findByEmail", query = "SELECT s FROM Sucursal s WHERE s.email = :email"),
    @NamedQuery(name = "Sucursal.findByNroregistropatron", query = "SELECT s FROM Sucursal s WHERE s.nroregistropatron = :nroregistropatron"),
    @NamedQuery(name = "Sucursal.findByFechareplicacion", query = "SELECT s FROM Sucursal s WHERE s.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Sucursal.findByFechamodificacion", query = "SELECT s FROM Sucursal s WHERE s.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Sucursal.findByFechacreacion", query = "SELECT s FROM Sucursal s WHERE s.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Sucursal.findByFirma", query = "SELECT s FROM Sucursal s WHERE s.firma = :firma"),
    @NamedQuery(name = "Sucursal.findByAppuser", query = "SELECT s FROM Sucursal s WHERE s.appuser = :appuser")})
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsucursal")
    private Long idsucursal;
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
    @Size(min = 1, max = 11)
    @Column(name = "idempresasucursal")
    private String idempresasucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "nroregistropatron")
    private String nroregistropatron;
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
    @JoinColumn(name = "idprovincia", referencedColumnName = "idprovincia")
    @ManyToOne
    private Provincia idprovincia;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false)
    private Pais idpais;
    @OneToMany(mappedBy = "idsucursal")
    private List<Vendedor> vendedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsucursal")
    private List<Deposito> depositoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsucursal")
    private List<Ctacteruta> ctacterutaList;

    public Sucursal() {
    }

    public Sucursal(Long idsucursal) {
        this.idsucursal = idsucursal;
    }

    public Sucursal(Long idsucursal, long idempresa, String codigo, String idempresasucursal, String nombre) {
        this.idsucursal = idsucursal;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.idempresasucursal = idempresasucursal;
        this.nombre = nombre;
    }

    public Long getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Long idsucursal) {
        this.idsucursal = idsucursal;
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

    public String getIdempresasucursal() {
        return idempresasucursal;
    }

    public void setIdempresasucursal(String idempresasucursal) {
        this.idempresasucursal = idempresasucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNroregistropatron() {
        return nroregistropatron;
    }

    public void setNroregistropatron(String nroregistropatron) {
        this.nroregistropatron = nroregistropatron;
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

    public Provincia getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Provincia idprovincia) {
        this.idprovincia = idprovincia;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    @XmlTransient
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    @XmlTransient
    public List<Deposito> getDepositoList() {
        return depositoList;
    }

    public void setDepositoList(List<Deposito> depositoList) {
        this.depositoList = depositoList;
    }

    @XmlTransient
    public List<Ctacteruta> getCtacterutaList() {
        return ctacterutaList;
    }

    public void setCtacterutaList(List<Ctacteruta> ctacterutaList) {
        this.ctacterutaList = ctacterutaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursal != null ? idsucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idsucursal == null && other.idsucursal != null) || (this.idsucursal != null && !this.idsucursal.equals(other.idsucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Sucursal[ idsucursal=" + idsucursal + " ]";
    }
    
}
