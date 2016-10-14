/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "vendedor_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendedorView.findAll", query = "SELECT v FROM VendedorView v where v.idempresa=:idempresa"),
    @NamedQuery(name = "VendedorView.findByIdvendedor", query = "SELECT v FROM VendedorView v WHERE v.idvendedor = :idvendedor"),
    @NamedQuery(name = "VendedorView.findByIdempresa", query = "SELECT v FROM VendedorView v WHERE v.idempresa = :idempresa"),
    @NamedQuery(name = "VendedorView.findByCodigo", query = "SELECT v FROM VendedorView v WHERE v.idempresa=:idempresa and v.codigo = :codigo")})
public class VendedorView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idvendedor")
    private long idvendedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 50)
    @Column(name = "personanombre")
    private String personanombre;
    @Column(name = "idvendedorjefe")
    private Long idvendedorjefe;
    @Column(name = "idsucursal")
    private Long idsucursal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "comision")
    private BigDecimal comision;
    @Column(name = "inactivo")
    private Boolean inactivo;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
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
    @Column(name = "appuser")
    private String appuser;
    @Column(name = "idempleado")
    private Long idempleado;
    @Size(max = 11)
    @Column(name = "empleado")
    private String empleado;
    @Size(max = 11)
    @Column(name = "vendedorjefe")
    private String vendedorjefe;
    @Size(max = 2)
    @Column(name = "sucursal")
    private String sucursal;
    @Size(max = 50)
    @Column(name = "sucursalnombre")
    private String sucursalnombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersona")
    private long idpersona;
    @Size(max = 102)
    @Column(name = "nombreapellido")
    private String nombreapellido;
    @Column(name = "idciudad")
    private Long idciudad;
    @Column(name = "idbarrio")
    private Long idbarrio;
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
    @Column(name = "idpais")
    private Long idpais;
    @Size(max = 4)
    @Column(name = "pais")
    private String pais;
    @Size(max = 30)
    @Column(name = "paisnombre")
    private String paisnombre;
    @Size(max = 4)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 50)
    @Column(name = "ciudadnombre")
    private String ciudadnombre;
    @Size(max = 8)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 4)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 50)
    @Column(name = "barrionombre")
    private String barrionombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "idprofesion")
    private Long idprofesion;
    @Size(max = 15)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    @Size(max = 50)
    @Column(name = "empresatrabaja")
    private String empresatrabaja;
    @Size(max = 50)
    @Column(name = "direcciontrabajo")
    private String direcciontrabajo;
    @Size(max = 50)
    @Column(name = "telefonotrabajo")
    private String telefonotrabajo;
    @Size(max = 20)
    @Column(name = "tarjeta")
    private String tarjeta;
    @Size(max = 5)
    @Column(name = "vencetarjeta")
    private String vencetarjeta;
    @Size(max = 50)
    @Column(name = "profesion")
    private String profesion;
    @Column(name = "estadocivil")
    private Character estadocivil;
    @Column(name = "sexo")
    private Character sexo;
    @Size(max = 50)
    @Column(name = "lugar_de_nacimiento")
    private String lugarDeNacimiento;
    @Size(max = 15)
    @Column(name = "titulocortesia")
    private String titulocortesia;

    public VendedorView() {
    }

    public long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(long idvendedor) {
        this.idvendedor = idvendedor;
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

    public String getPersonanombre() {
        return personanombre;
    }

    public void setPersonanombre(String personanombre) {
        this.personanombre = personanombre;
    }

    public Long getIdvendedorjefe() {
        return idvendedorjefe;
    }

    public void setIdvendedorjefe(Long idvendedorjefe) {
        this.idvendedorjefe = idvendedorjefe;
    }

    public Long getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Long idsucursal) {
        this.idsucursal = idsucursal;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
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

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Long getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Long idempleado) {
        this.idempleado = idempleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getVendedorjefe() {
        return vendedorjefe;
    }

    public void setVendedorjefe(String vendedorjefe) {
        this.vendedorjefe = vendedorjefe;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getSucursalnombre() {
        return sucursalnombre;
    }

    public void setSucursalnombre(String sucursalnombre) {
        this.sucursalnombre = sucursalnombre;
    }

    public long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(long idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombreapellido() {
        return nombreapellido;
    }

    public void setNombreapellido(String nombreapellido) {
        this.nombreapellido = nombreapellido;
    }

    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
    }

    public Long getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Long idbarrio) {
        this.idbarrio = idbarrio;
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

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPaisnombre() {
        return paisnombre;
    }

    public void setPaisnombre(String paisnombre) {
        this.paisnombre = paisnombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudadnombre() {
        return ciudadnombre;
    }

    public void setCiudadnombre(String ciudadnombre) {
        this.ciudadnombre = ciudadnombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getBarrionombre() {
        return barrionombre;
    }

    public void setBarrionombre(String barrionombre) {
        this.barrionombre = barrionombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getIdprofesion() {
        return idprofesion;
    }

    public void setIdprofesion(Long idprofesion) {
        this.idprofesion = idprofesion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmpresatrabaja() {
        return empresatrabaja;
    }

    public void setEmpresatrabaja(String empresatrabaja) {
        this.empresatrabaja = empresatrabaja;
    }

    public String getDirecciontrabajo() {
        return direcciontrabajo;
    }

    public void setDirecciontrabajo(String direcciontrabajo) {
        this.direcciontrabajo = direcciontrabajo;
    }

    public String getTelefonotrabajo() {
        return telefonotrabajo;
    }

    public void setTelefonotrabajo(String telefonotrabajo) {
        this.telefonotrabajo = telefonotrabajo;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getVencetarjeta() {
        return vencetarjeta;
    }

    public void setVencetarjeta(String vencetarjeta) {
        this.vencetarjeta = vencetarjeta;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Character getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(Character estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    public String getTitulocortesia() {
        return titulocortesia;
    }

    public void setTitulocortesia(String titulocortesia) {
        this.titulocortesia = titulocortesia;
    }
    
}
