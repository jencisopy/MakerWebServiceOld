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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ctacte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctacte.findAll", query = "SELECT c FROM Ctacte c"),
    @NamedQuery(name = "Ctacte.findByIdctacte", query = "SELECT c FROM Ctacte c WHERE c.idctacte = :idctacte"),
    @NamedQuery(name = "Ctacte.findByCodigo", query = "SELECT c FROM Ctacte c WHERE c.idempresa = :idempresa and c.codigo = :codigo and c.escliente = 1")})
public class Ctacte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "idctacte")
    private Long idctacte;
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
    @Column(name = "esproveedor")
    private short esproveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escliente")
    private short escliente;
    @Column(name = "essocio")
    private Short essocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ruc")
    private String ruc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credito")
    private BigDecimal credito;
    @Size(max = 19)
    @Column(name = "tarjeta")
    private String tarjeta;
    @Size(max = 5)
    @Column(name = "vencetarjeta")
    private String vencetarjeta;
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;
    @Column(name = "fechaegreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaegreso;
    @Size(max = 50)
    @Column(name = "contacto")
    private String contacto;
    @Size(max = 100)
    @Column(name = "direccionctacte")
    private String direccionctacte;
    @Size(max = 30)
    @Column(name = "telefonoctacte")
    private String telefonoctacte;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "inactivo")
    private Boolean inactivo;
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
    @Size(max = 100)
    @Column(name = "codeudordireccion")
    private String codeudordireccion;
    @Size(max = 30)
    @Column(name = "codeudortelefono")
    private String codeudortelefono;
    @Size(max = 15)
    @Column(name = "cuentabancaria")
    private String cuentabancaria;
    @Column(name = "descuentopuntos")
    private BigDecimal descuentopuntos;
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
    @Column(name = "bloquear_atraso")
    private Boolean bloquearAtraso;
    @Column(name = "bloquear_atraso_dias")
    private Long bloquearAtrasoDias;
    @JoinColumn(name = "idzona", referencedColumnName = "idzona")
    @ManyToOne
    private Zona idzona;
    @JoinColumn(name = "idvendedor", referencedColumnName = "idvendedor")
    @ManyToOne
    private Vendedor idvendedor;
    @JoinColumn(name = "idcobrador", referencedColumnName = "idcobrador")
    @ManyToOne
    private Cobrador idcobrador;
    @JoinColumn(name = "idctacteramo", referencedColumnName = "idctacteramo")
    @ManyToOne
    private Ctacteramo idctacteramo;
    @JoinColumn(name = "idctacteruta", referencedColumnName = "idctacteruta")
    @ManyToOne
    private Ctacteruta idctacteruta;
    @JoinColumn(name = "idctactesegmento", referencedColumnName = "idctactesegmento")
    @ManyToOne
    private Ctactesegmento idctactesegmento;
    @JoinColumn(name = "idctactetipo", referencedColumnName = "idctactetipo")
    @ManyToOne
    private Ctactetipo idctactetipo;
    @JoinColumn(name = "idctbcliente", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcliente;
    @JoinColumn(name = "idctbproveedor", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbproveedor;
    @JoinColumn(name = "idimpuestogrupo", referencedColumnName = "idimpuestogrupo")
    @ManyToOne
    private Impuestogrupo idimpuestogrupo;
    @JoinColumn(name = "iditemdescuentogrupo", referencedColumnName = "iditemdescuentogrupo")
    @ManyToOne
    private Itemdescuentogrupo iditemdescuentogrupo;
    @JoinColumn(name = "iditemmovcondicion", referencedColumnName = "iditemmovcondicion")
    @ManyToOne
    private Itemmovcondicion iditemmovcondicion;
    @JoinColumn(name = "idlistaprecio", referencedColumnName = "idlistaprecio")
    @ManyToOne
    private Listaprecio idlistaprecio;
    @JoinColumn(name = "idpersonatitular", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonatitular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idctacte")
    private List<GiLotevta> giLotevtaList;

    public Ctacte() {
    }

    public Ctacte(Long idctacte) {
        this.idctacte = idctacte;
    }

    public Ctacte(Long idctacte, long idempresa, String codigo, short esproveedor, short escliente, String nombre, String ruc, BigDecimal descuento, BigDecimal credito) {
        this.idctacte = idctacte;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.esproveedor = esproveedor;
        this.escliente = escliente;
        this.nombre = nombre;
        this.ruc = ruc;
        this.descuento = descuento;
        this.credito = credito;
    }

    public Long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(Long idctacte) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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

    public String getCodeudordireccion() {
        return codeudordireccion;
    }

    public void setCodeudordireccion(String codeudordireccion) {
        this.codeudordireccion = codeudordireccion;
    }

    public String getCodeudortelefono() {
        return codeudortelefono;
    }

    public void setCodeudortelefono(String codeudortelefono) {
        this.codeudortelefono = codeudortelefono;
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

    public Zona getIdzona() {
        return idzona;
    }

    public void setIdzona(Zona idzona) {
        this.idzona = idzona;
    }

    public Vendedor getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Vendedor idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Cobrador getIdcobrador() {
        return idcobrador;
    }

    public void setIdcobrador(Cobrador idcobrador) {
        this.idcobrador = idcobrador;
    }

    public Ctacteramo getIdctacteramo() {
        return idctacteramo;
    }

    public void setIdctacteramo(Ctacteramo idctacteramo) {
        this.idctacteramo = idctacteramo;
    }

    public Ctacteruta getIdctacteruta() {
        return idctacteruta;
    }

    public void setIdctacteruta(Ctacteruta idctacteruta) {
        this.idctacteruta = idctacteruta;
    }

    public Ctactesegmento getIdctactesegmento() {
        return idctactesegmento;
    }

    public void setIdctactesegmento(Ctactesegmento idctactesegmento) {
        this.idctactesegmento = idctactesegmento;
    }

    public Ctactetipo getIdctactetipo() {
        return idctactetipo;
    }

    public void setIdctactetipo(Ctactetipo idctactetipo) {
        this.idctactetipo = idctactetipo;
    }

    public Ctbcuenta getIdctbcliente() {
        return idctbcliente;
    }

    public void setIdctbcliente(Ctbcuenta idctbcliente) {
        this.idctbcliente = idctbcliente;
    }

    public Ctbcuenta getIdctbproveedor() {
        return idctbproveedor;
    }

    public void setIdctbproveedor(Ctbcuenta idctbproveedor) {
        this.idctbproveedor = idctbproveedor;
    }

    public Impuestogrupo getIdimpuestogrupo() {
        return idimpuestogrupo;
    }

    public void setIdimpuestogrupo(Impuestogrupo idimpuestogrupo) {
        this.idimpuestogrupo = idimpuestogrupo;
    }

    public Itemdescuentogrupo getIditemdescuentogrupo() {
        return iditemdescuentogrupo;
    }

    public void setIditemdescuentogrupo(Itemdescuentogrupo iditemdescuentogrupo) {
        this.iditemdescuentogrupo = iditemdescuentogrupo;
    }

    public Itemmovcondicion getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(Itemmovcondicion iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public Listaprecio getIdlistaprecio() {
        return idlistaprecio;
    }

    public void setIdlistaprecio(Listaprecio idlistaprecio) {
        this.idlistaprecio = idlistaprecio;
    }

    public Persona getIdpersonatitular() {
        return idpersonatitular;
    }

    public void setIdpersonatitular(Persona idpersonatitular) {
        this.idpersonatitular = idpersonatitular;
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
        hash += (idctacte != null ? idctacte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctacte)) {
            return false;
        }
        Ctacte other = (Ctacte) object;
        if ((this.idctacte == null && other.idctacte != null) || (this.idctacte != null && !this.idctacte.equals(other.idctacte))) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Ctacte[ idctacte=" + idctacte + " ]";
    }
    
}
