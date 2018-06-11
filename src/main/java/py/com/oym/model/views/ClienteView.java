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
import javax.persistence.Lob;
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
@Table(name = "cliente_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteView.findAll",        query = "SELECT c FROM ClienteView c where c.idempresa = :idempresa"),
    @NamedQuery(name = "ClienteView.findByIdctacte", query = "SELECT c FROM ClienteView c WHERE c.idctacte  = :idctacte"),
    @NamedQuery(name = "ClienteView.findByIdempresa",query = "SELECT c FROM ClienteView c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "ClienteView.findByCodigo",   query = "SELECT c FROM ClienteView c WHERE c.idempresa = :idempresa and c.codigo = :codigo"),
    @NamedQuery(name = "ClienteView.findByRuc",      query = "SELECT c FROM ClienteView c WHERE c.ruc = :ruc")})
public class ClienteView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idctacte")
    private long idctacte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ctactenombre")
    private String ctactenombre;
    @Column(name = "idzona")
    private Long idzona;
    @Column(name = "iditemdescuentogrupo")
    private Long iditemdescuentogrupo;
    @Column(name = "idctactetipo")
    private Long idctactetipo;
    @Column(name = "idctbcliente")
    private Long idctbcliente;
    @Column(name = "idctbproveedor")
    private Long idctbproveedor;
    @Column(name = "idlistaprecio")
    private Long idlistaprecio;
    @Column(name = "idvendedor")
    private Long idvendedor;
    @Column(name = "idcobrador")
    private Long idcobrador;
    @Column(name = "idctacteramo")
    private Long idctacteramo;
    @Column(name = "idctactesegmento")
    private Long idctactesegmento;
    @Column(name = "idimpuestogrupo")
    private Long idimpuestogrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersonatitular")
    private long idpersonatitular;
    @Column(name = "idctacteruta")
    private Long idctacteruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esproveedor")
    private short esproveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escliente")
    private short escliente;
    @Column(name = "essocio")
    private Short essocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credito")
    private BigDecimal credito;
    @Size(max = 50)
    @Column(name = "contacto")
    private String contacto;
    @Size(max = 100)
    @Column(name = "direccionctacte")
    private String direccionctacte;
    @Size(max = 30)
    @Column(name = "telefonoctacte")
    private String telefonoctacte;
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;
    @Column(name = "fechaegreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaegreso;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "inactivo")
    private Boolean inactivo;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 50)
    @Column(name = "conyugue")
    private String conyugue;
    @Size(max = 10)
    @Column(name = "conyuguecedula")
    private String conyuguecedula;
    @Size(max = 50)
    @Column(name = "codeudor")
    private String codeudor;
    @Size(max = 10)
    @Column(name = "codeudorcedula")
    private String codeudorcedula;
    @Size(max = 30)
    @Column(name = "codeudortelefono")
    private String codeudortelefono;
    @Size(max = 100)
    @Column(name = "codeudordireccion")
    private String codeudordireccion;
    @Size(max = 15)
    @Column(name = "cuentabancaria")
    private String cuentabancaria;
    @Column(name = "descuentopuntos")
    private BigDecimal descuentopuntos;
    @Column(name = "bloquear_atraso")
    private Boolean bloquearAtraso;
    @Column(name = "bloquear_atraso_dias")
    private Long bloquearAtrasoDias;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Size(max = 3)
    @Column(name = "zona")
    private String zona;
    @Size(max = 3)
    @Column(name = "subzona")
    private String subzona;
    @Size(max = 50)
    @Column(name = "zonanombre")
    private String zonanombre;
    @Size(max = 3)
    @Column(name = "itemdescuentogrupo")
    private String itemdescuentogrupo;
    @Size(max = 50)
    @Column(name = "itemdescuentogruponombre")
    private String itemdescuentogruponombre;
    @Size(max = 2)
    @Column(name = "ctactetipo")
    private String ctactetipo;
    @Size(max = 30)
    @Column(name = "ctactetiponombre")
    private String ctactetiponombre;
    @Size(max = 5)
    @Column(name = "ctacteramo")
    private String ctacteramo;
    @Size(max = 50)
    @Column(name = "ctacteramonombre")
    private String ctacteramonombre;
    @Size(max = 5)
    @Column(name = "ctactesegmento")
    private String ctactesegmento;
    @Size(max = 50)
    @Column(name = "ctactesegmentonombre")
    private String ctactesegmentonombre;
    @Size(max = 2)
    @Column(name = "listaprecio")
    private String listaprecio;
    @Size(max = 50)
    @Column(name = "listaprecionombre")
    private String listaprecionombre;
    @Size(max = 15)
    @Column(name = "ctbcliente")
    private String ctbcliente;
    @Size(max = 50)
    @Column(name = "ctbclientenombre")
    private String ctbclientenombre;
    @Size(max = 15)
    @Column(name = "ctbproveedor")
    private String ctbproveedor;
    @Size(max = 50)
    @Column(name = "ctbproveedornombre")
    private String ctbproveedornombre;
    @Size(max = 11)
    @Column(name = "vendedor")
    private String vendedor;
    @Size(max = 50)
    @Column(name = "vendedornombre")
    private String vendedornombre;
    @Size(max = 11)
    @Column(name = "cobrador")
    private String cobrador;
    @Size(max = 50)
    @Column(name = "cobradornombre")
    private String cobradornombre;
    @Size(max = 3)
    @Column(name = "impuestogrupo")
    private String impuestogrupo;
    @Size(max = 50)
    @Column(name = "impuestogruponombre")
    private String impuestogruponombre;
    @Column(name = "ctacteruta")
    private Long ctacteruta;
    @Size(max = 50)
    @Column(name = "ctacterutanombre")
    private String ctacterutanombre;
    @Column(name = "iditemmovcondicion")
    private Long iditemmovcondicion;
    @Size(max = 3)
    @Column(name = "itemmovcondicion")
    private String itemmovcondicion;
    @Size(max = 50)
    @Column(name = "itemmovcondicionnombre")
    private String itemmovcondicionnombre;
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

    @Column(name = "ingresomensual")
    private Long ingresomensual;

    @Column(name = "egresomensual")
    private Long egresomensual;
    
    @Column(name = "hijos_cantidad")
    private Short hijos_cantidad;
    
    @Column(name = "fechaingresotrabajo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingresotrabajo;

    @Column(name = "debitoautomatico")
    private Boolean debitoautomatico;
    
    public ClienteView() {
    }

    public long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(long idctacte) {
        this.idctacte = idctacte;
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

    public String getCtactenombre() {
        return ctactenombre;
    }

    public void setCtactenombre(String ctactenombre) {
        this.ctactenombre = ctactenombre;
    }

    public Long getIdzona() {
        return idzona;
    }

    public void setIdzona(Long idzona) {
        this.idzona = idzona;
    }

    public Long getIditemdescuentogrupo() {
        return iditemdescuentogrupo;
    }

    public void setIditemdescuentogrupo(Long iditemdescuentogrupo) {
        this.iditemdescuentogrupo = iditemdescuentogrupo;
    }

    public Long getIdctactetipo() {
        return idctactetipo;
    }

    public void setIdctactetipo(Long idctactetipo) {
        this.idctactetipo = idctactetipo;
    }

    public Long getIdctbcliente() {
        return idctbcliente;
    }

    public void setIdctbcliente(Long idctbcliente) {
        this.idctbcliente = idctbcliente;
    }

    public Long getIdctbproveedor() {
        return idctbproveedor;
    }

    public void setIdctbproveedor(Long idctbproveedor) {
        this.idctbproveedor = idctbproveedor;
    }

    public Long getIdlistaprecio() {
        return idlistaprecio;
    }

    public void setIdlistaprecio(Long idlistaprecio) {
        this.idlistaprecio = idlistaprecio;
    }

    public Long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Long getIdcobrador() {
        return idcobrador;
    }

    public void setIdcobrador(Long idcobrador) {
        this.idcobrador = idcobrador;
    }

    public Long getIdctacteramo() {
        return idctacteramo;
    }

    public void setIdctacteramo(Long idctacteramo) {
        this.idctacteramo = idctacteramo;
    }

    public Long getIdctactesegmento() {
        return idctactesegmento;
    }

    public void setIdctactesegmento(Long idctactesegmento) {
        this.idctactesegmento = idctactesegmento;
    }

    public Long getIdimpuestogrupo() {
        return idimpuestogrupo;
    }

    public void setIdimpuestogrupo(Long idimpuestogrupo) {
        this.idimpuestogrupo = idimpuestogrupo;
    }

    public long getIdpersonatitular() {
        return idpersonatitular;
    }

    public void setIdpersonatitular(long idpersonatitular) {
        this.idpersonatitular = idpersonatitular;
    }

    public Long getIdctacteruta() {
        return idctacteruta;
    }

    public void setIdctacteruta(Long idctacteruta) {
        this.idctacteruta = idctacteruta;
    }

    public short getEsproveedor() {
        return esproveedor;
    }

    public void setEsproveedor(short esproveedor) {
        this.esproveedor = esproveedor;
    }

    public short getEscliente() {
        return escliente;
    }

    public void setEscliente(short escliente) {
        this.escliente = escliente;
    }

    public Short getEssocio() {
        return essocio;
    }

    public void setEssocio(Short essocio) {
        this.essocio = essocio;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccionctacte() {
        return direccionctacte;
    }

    public void setDireccionctacte(String direccionctacte) {
        this.direccionctacte = direccionctacte;
    }

    public String getTelefonoctacte() {
        return telefonoctacte;
    }

    public void setTelefonoctacte(String telefonoctacte) {
        this.telefonoctacte = telefonoctacte;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechaegreso() {
        return fechaegreso;
    }

    public void setFechaegreso(Date fechaegreso) {
        this.fechaegreso = fechaegreso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getConyugue() {
        return conyugue;
    }

    public void setConyugue(String conyugue) {
        this.conyugue = conyugue;
    }

    public String getConyuguecedula() {
        return conyuguecedula;
    }

    public void setConyuguecedula(String conyuguecedula) {
        this.conyuguecedula = conyuguecedula;
    }

    public String getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(String codeudor) {
        this.codeudor = codeudor;
    }

    public String getCodeudorcedula() {
        return codeudorcedula;
    }

    public void setCodeudorcedula(String codeudorcedula) {
        this.codeudorcedula = codeudorcedula;
    }

    public String getCodeudortelefono() {
        return codeudortelefono;
    }

    public void setCodeudortelefono(String codeudortelefono) {
        this.codeudortelefono = codeudortelefono;
    }

    public String getCodeudordireccion() {
        return codeudordireccion;
    }

    public void setCodeudordireccion(String codeudordireccion) {
        this.codeudordireccion = codeudordireccion;
    }

    public String getCuentabancaria() {
        return cuentabancaria;
    }

    public void setCuentabancaria(String cuentabancaria) {
        this.cuentabancaria = cuentabancaria;
    }

    public BigDecimal getDescuentopuntos() {
        return descuentopuntos;
    }

    public void setDescuentopuntos(BigDecimal descuentopuntos) {
        this.descuentopuntos = descuentopuntos;
    }

    public Boolean getBloquearAtraso() {
        return bloquearAtraso;
    }

    public void setBloquearAtraso(Boolean bloquearAtraso) {
        this.bloquearAtraso = bloquearAtraso;
    }

    public Long getBloquearAtrasoDias() {
        return bloquearAtrasoDias;
    }

    public void setBloquearAtrasoDias(Long bloquearAtrasoDias) {
        this.bloquearAtrasoDias = bloquearAtrasoDias;
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

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSubzona() {
        return subzona;
    }

    public void setSubzona(String subzona) {
        this.subzona = subzona;
    }

    public String getZonanombre() {
        return zonanombre;
    }

    public void setZonanombre(String zonanombre) {
        this.zonanombre = zonanombre;
    }

    public String getItemdescuentogrupo() {
        return itemdescuentogrupo;
    }

    public void setItemdescuentogrupo(String itemdescuentogrupo) {
        this.itemdescuentogrupo = itemdescuentogrupo;
    }

    public String getItemdescuentogruponombre() {
        return itemdescuentogruponombre;
    }

    public void setItemdescuentogruponombre(String itemdescuentogruponombre) {
        this.itemdescuentogruponombre = itemdescuentogruponombre;
    }

    public String getCtactetipo() {
        return ctactetipo;
    }

    public void setCtactetipo(String ctactetipo) {
        this.ctactetipo = ctactetipo;
    }

    public String getCtactetiponombre() {
        return ctactetiponombre;
    }

    public void setCtactetiponombre(String ctactetiponombre) {
        this.ctactetiponombre = ctactetiponombre;
    }

    public String getCtacteramo() {
        return ctacteramo;
    }

    public void setCtacteramo(String ctacteramo) {
        this.ctacteramo = ctacteramo;
    }

    public String getCtacteramonombre() {
        return ctacteramonombre;
    }

    public void setCtacteramonombre(String ctacteramonombre) {
        this.ctacteramonombre = ctacteramonombre;
    }

    public String getCtactesegmento() {
        return ctactesegmento;
    }

    public void setCtactesegmento(String ctactesegmento) {
        this.ctactesegmento = ctactesegmento;
    }

    public String getCtactesegmentonombre() {
        return ctactesegmentonombre;
    }

    public void setCtactesegmentonombre(String ctactesegmentonombre) {
        this.ctactesegmentonombre = ctactesegmentonombre;
    }

    public String getListaprecio() {
        return listaprecio;
    }

    public void setListaprecio(String listaprecio) {
        this.listaprecio = listaprecio;
    }

    public String getListaprecionombre() {
        return listaprecionombre;
    }

    public void setListaprecionombre(String listaprecionombre) {
        this.listaprecionombre = listaprecionombre;
    }

    public String getCtbcliente() {
        return ctbcliente;
    }

    public void setCtbcliente(String ctbcliente) {
        this.ctbcliente = ctbcliente;
    }

    public String getCtbclientenombre() {
        return ctbclientenombre;
    }

    public void setCtbclientenombre(String ctbclientenombre) {
        this.ctbclientenombre = ctbclientenombre;
    }

    public String getCtbproveedor() {
        return ctbproveedor;
    }

    public void setCtbproveedor(String ctbproveedor) {
        this.ctbproveedor = ctbproveedor;
    }

    public String getCtbproveedornombre() {
        return ctbproveedornombre;
    }

    public void setCtbproveedornombre(String ctbproveedornombre) {
        this.ctbproveedornombre = ctbproveedornombre;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getVendedornombre() {
        return vendedornombre;
    }

    public void setVendedornombre(String vendedornombre) {
        this.vendedornombre = vendedornombre;
    }

    public String getCobrador() {
        return cobrador;
    }

    public void setCobrador(String cobrador) {
        this.cobrador = cobrador;
    }

    public String getCobradornombre() {
        return cobradornombre;
    }

    public void setCobradornombre(String cobradornombre) {
        this.cobradornombre = cobradornombre;
    }

    public String getImpuestogrupo() {
        return impuestogrupo;
    }

    public void setImpuestogrupo(String impuestogrupo) {
        this.impuestogrupo = impuestogrupo;
    }

    public String getImpuestogruponombre() {
        return impuestogruponombre;
    }

    public void setImpuestogruponombre(String impuestogruponombre) {
        this.impuestogruponombre = impuestogruponombre;
    }

    public Long getCtacteruta() {
        return ctacteruta;
    }

    public void setCtacteruta(Long ctacteruta) {
        this.ctacteruta = ctacteruta;
    }

    public String getCtacterutanombre() {
        return ctacterutanombre;
    }

    public void setCtacterutanombre(String ctacterutanombre) {
        this.ctacterutanombre = ctacterutanombre;
    }

    public Long getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(Long iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public String getItemmovcondicion() {
        return itemmovcondicion;
    }

    public void setItemmovcondicion(String itemmovcondicion) {
        this.itemmovcondicion = itemmovcondicion;
    }

    public String getItemmovcondicionnombre() {
        return itemmovcondicionnombre;
    }

    public void setItemmovcondicionnombre(String itemmovcondicionnombre) {
        this.itemmovcondicionnombre = itemmovcondicionnombre;
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

    public Long getIngresomensual() {
        return ingresomensual;
    }

    public void setIngresomensual(Long ingresomensual) {
        this.ingresomensual = ingresomensual;
    }

    public Long getEgresomensual() {
        return egresomensual;
    }

    public void setEgresomensual(Long egresomensual) {
        this.egresomensual = egresomensual;
    }

    public Short getHijos_cantidad() {
        return hijos_cantidad;
    }

    public void setHijos_cantidad(Short hijos_cantidad) {
        this.hijos_cantidad = hijos_cantidad;
    }

    public Date getFechaingresotrabajo() {
        return fechaingresotrabajo;
    }

    public void setFechaingresotrabajo(Date fechaingresotrabajo) {
        this.fechaingresotrabajo = fechaingresotrabajo;
    }

    public Boolean getDebitoautomatico() {
        return debitoautomatico;
}

    public void setDebitoautomatico(Boolean debitoautomatico) {
        this.debitoautomatico = debitoautomatico;
    }
    
}
