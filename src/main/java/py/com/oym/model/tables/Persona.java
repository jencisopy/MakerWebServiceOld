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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona"),
    @NamedQuery(name = "Persona.findByIdempresa", query = "SELECT p FROM Persona p WHERE p.idempresa = :idempresa"),
    @NamedQuery(name = "Persona.findByDocumentotipo", query = "SELECT p FROM Persona p WHERE p.documentotipo = :documentotipo"),
    @NamedQuery(name = "Persona.findByDocumento", query = "SELECT p FROM Persona p WHERE p.documento = :documento"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByTipo", query = "SELECT p FROM Persona p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Persona.findByRuc", query = "SELECT p FROM Persona p WHERE p.ruc = :ruc"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByTelefonofax", query = "SELECT p FROM Persona p WHERE p.telefonofax = :telefonofax"),
    @NamedQuery(name = "Persona.findByTelefonocelular", query = "SELECT p FROM Persona p WHERE p.telefonocelular = :telefonocelular"),
    @NamedQuery(name = "Persona.findByWeb", query = "SELECT p FROM Persona p WHERE p.web = :web"),
    @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email"),
    @NamedQuery(name = "Persona.findByCodigopostal", query = "SELECT p FROM Persona p WHERE p.codigopostal = :codigopostal"),
    @NamedQuery(name = "Persona.findByNoenviarmail", query = "SELECT p FROM Persona p WHERE p.noenviarmail = :noenviarmail"),
    @NamedQuery(name = "Persona.findByInactivo", query = "SELECT p FROM Persona p WHERE p.inactivo = :inactivo"),
    @NamedQuery(name = "Persona.findByImagen", query = "SELECT p FROM Persona p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Persona.findByFechareplicacion", query = "SELECT p FROM Persona p WHERE p.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Persona.findByFechamodificacion", query = "SELECT p FROM Persona p WHERE p.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Persona.findByFechacreacion", query = "SELECT p FROM Persona p WHERE p.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Persona.findByFirma", query = "SELECT p FROM Persona p WHERE p.firma = :firma"),
    @NamedQuery(name = "Persona.findByAppuser", query = "SELECT p FROM Persona p WHERE p.appuser = :appuser")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Long idpersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "documentotipo")
    private String documentotipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private short tipo;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 15)
    @Column(name = "telefonofax")
    private String telefonofax;
    @Size(max = 15)
    @Column(name = "telefonocelular")
    private String telefonocelular;
    @Size(max = 100)
    @Column(name = "web")
    private String web;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "codigopostal")
    private String codigopostal;
    @Column(name = "noenviarmail")
    private Boolean noenviarmail;
    @Column(name = "inactivo")
    private Boolean inactivo;
    @Size(max = 200)
    @Column(name = "imagen")
    private String imagen;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<Vendedor> vendedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<Cobrador> cobradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonatitular")
    private List<Ctacte> ctacteList;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne
    private Pais idpais;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne
    private Ciudad idciudad;
    @JoinColumn(name = "idbarrio", referencedColumnName = "idbarrio")
    @ManyToOne
    private Barrio idbarrio;

    public Persona() {
    }

    public Persona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(Long idpersona, long idempresa, String documentotipo, String documento, String nombre, short tipo) {
        this.idpersona = idpersona;
        this.idempresa = idempresa;
        this.documentotipo = documentotipo;
        this.documento = documento;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public String getDocumentotipo() {
        return documentotipo;
    }

    public void setDocumentotipo(String documentotipo) {
        this.documentotipo = documentotipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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

    public String getTelefonofax() {
        return telefonofax;
    }

    public void setTelefonofax(String telefonofax) {
        this.telefonofax = telefonofax;
    }

    public String getTelefonocelular() {
        return telefonocelular;
    }

    public void setTelefonocelular(String telefonocelular) {
        this.telefonocelular = telefonocelular;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Boolean getNoenviarmail() {
        return noenviarmail;
    }

    public void setNoenviarmail(Boolean noenviarmail) {
        this.noenviarmail = noenviarmail;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    @XmlTransient
    public List<Cobrador> getCobradorList() {
        return cobradorList;
    }

    public void setCobradorList(List<Cobrador> cobradorList) {
        this.cobradorList = cobradorList;
    }

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    public Barrio getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Barrio idbarrio) {
        this.idbarrio = idbarrio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Persona[ idpersona=" + idpersona + " ]";
    }
    
}
