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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alberto
 */
@Entity
@Table(name = "itemmovplndetalle_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemmovplndetalleView.findAll", query = "SELECT i FROM ItemmovplndetalleView i")
    , @NamedQuery(name = "ItemmovplndetalleView.findByIditemmovplndetalle", query = "SELECT i FROM ItemmovplndetalleView i WHERE i.iditemmovplndetalle = :iditemmovplndetalle")
    , @NamedQuery(name = "ItemmovplndetalleView.findByIditemmovpln", query = "SELECT i FROM ItemmovplndetalleView i WHERE i.iditemmovpln = :iditemmovpln")
    , @NamedQuery(name = "ItemmovplndetalleView.findByIditemmovimiento", query = "SELECT i FROM ItemmovplndetalleView i WHERE i.iditemmovimiento = :iditemmovimiento")
    , @NamedQuery(name = "ItemmovplndetalleView.findByItem", query = "SELECT i FROM ItemmovplndetalleView i WHERE i.item = :item")
    , @NamedQuery(name = "ItemmovplndetalleView.findByItemnombre", query = "SELECT i FROM ItemmovplndetalleView i WHERE i.itemnombre = :itemnombre")
})
public class ItemmovplndetalleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "iditemmovplndetalle")
    private long iditemmovplndetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemmovpln")
    private long iditemmovpln;
    @Column(name = "iditemmovimiento")
    private Long iditemmovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorden")
    private long idorden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacte")
    private long idctacte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private long iditem;
    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "idcentrocosto")
    private Long idcentrocosto;
    @Column(name = "idsubrubro")
    private Long idsubrubro;
    @Column(name = "idempresaunidad")
    private Long idempresaunidad;
    @Column(name = "idcrm_proyecto")
    private Long idcrmProyecto;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "secuencia")
    private String secuencia;
    @Size(max = 3)
    @Column(name = "iddocumento")
    private String iddocumento;
    @Size(max = 2)
    @Column(name = "iddocumentotipo")
    private String iddocumentotipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nrodoc")
    private String nrodoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadoc;
    @Size(max = 11)
    @Column(name = "timbrado")
    private String timbrado;
    @Column(name = "timbrado_vto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timbradoVto;
    @Column(name = "timbrado_tipo")
    private Character timbradoTipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "aprobado")
    private Boolean aprobado;
    @Column(name = "reembolsable")
    private Boolean reembolsable;
    @Column(name = "afecta_costo")
    private Character afectaCosto;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
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
    @Size(max = 15)
    @Column(name = "audit_uk")
    private String auditUk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nro")
    private String nro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Size(max = 35)
    @Column(name = "itemmovimiento")
    private String itemmovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ctacte")
    private String ctacte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escliente")
    private short escliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esproveedor")
    private short esproveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ctactenombre")
    private String ctactenombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemelemento")
    private Character itemelemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "itemnombre")
    private String itemnombre;
    @Size(max = 2)
    @Column(name = "empresaunidad")
    private String empresaunidad;
    @Size(max = 50)
    @Column(name = "empresaunidadnombre")
    private String empresaunidadnombre;
    @Size(max = 8)
    @Column(name = "centrocosto")
    private String centrocosto;
    @Size(max = 50)
    @Column(name = "centrocostonombre")
    private String centrocostonombre;
    @Size(max = 8)
    @Column(name = "crm_proyecto")
    private String crmProyecto;
    @Size(max = 50)
    @Column(name = "crm_proyectonombre")
    private String crmProyectonombre;
    @Column(name = "idrubro")
    private Long idrubro;
    @Size(max = 2)
    @Column(name = "rubro")
    private String rubro;
    @Size(max = 50)
    @Column(name = "rubronombre")
    private String rubronombre;
    @Size(max = 2)
    @Column(name = "subrubro")
    private String subrubro;
    @Size(max = 50)
    @Column(name = "subrubronombre")
    private String subrubronombre;
    @Column(name = "preciounitario")
    private BigDecimal preciounitario;

    public ItemmovplndetalleView() {
    }

    public long getIditemmovplndetalle() {
        return iditemmovplndetalle;
    }

    public void setIditemmovplndetalle(long iditemmovplndetalle) {
        this.iditemmovplndetalle = iditemmovplndetalle;
    }

    public long getIditemmovpln() {
        return iditemmovpln;
    }

    public void setIditemmovpln(long iditemmovpln) {
        this.iditemmovpln = iditemmovpln;
    }

    public Long getIditemmovimiento() {
        return iditemmovimiento;
    }

    public void setIditemmovimiento(Long iditemmovimiento) {
        this.iditemmovimiento = iditemmovimiento;
    }

    public long getIdorden() {
        return idorden;
    }

    public void setIdorden(long idorden) {
        this.idorden = idorden;
    }

    public long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(long idctacte) {
        this.idctacte = idctacte;
    }

    public long getIditem() {
        return iditem;
    }

    public void setIditem(long iditem) {
        this.iditem = iditem;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    

    public Long getIdcentrocosto() {
        return idcentrocosto;
    }

    public void setIdcentrocosto(Long idcentrocosto) {
        this.idcentrocosto = idcentrocosto;
    }

    public Long getIdsubrubro() {
        return idsubrubro;
    }

    public void setIdsubrubro(Long idsubrubro) {
        this.idsubrubro = idsubrubro;
    }

    public Long getIdempresaunidad() {
        return idempresaunidad;
    }

    public void setIdempresaunidad(Long idempresaunidad) {
        this.idempresaunidad = idempresaunidad;
    }

    public Long getIdcrmProyecto() {
        return idcrmProyecto;
    }

    public void setIdcrmProyecto(Long idcrmProyecto) {
        this.idcrmProyecto = idcrmProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getIddocumentotipo() {
        return iddocumentotipo;
    }

    public void setIddocumentotipo(String iddocumentotipo) {
        this.iddocumentotipo = iddocumentotipo;
    }

    public String getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    public Date getFechadoc() {
        return fechadoc;
    }

    public void setFechadoc(Date fechadoc) {
        this.fechadoc = fechadoc;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Date getTimbradoVto() {
        return timbradoVto;
    }

    public void setTimbradoVto(Date timbradoVto) {
        this.timbradoVto = timbradoVto;
    }

    public Character getTimbradoTipo() {
        return timbradoTipo;
    }

    public void setTimbradoTipo(Character timbradoTipo) {
        this.timbradoTipo = timbradoTipo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Boolean getReembolsable() {
        return reembolsable;
    }

    public void setReembolsable(Boolean reembolsable) {
        this.reembolsable = reembolsable;
    }

    public Character getAfectaCosto() {
        return afectaCosto;
    }

    public void setAfectaCosto(Character afectaCosto) {
        this.afectaCosto = afectaCosto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getAuditUk() {
        return auditUk;
    }

    public void setAuditUk(String auditUk) {
        this.auditUk = auditUk;
    }

    public String getIdnro() {
        return idnro;
    }

    public void setIdnro(String idnro) {
        this.idnro = idnro;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public String getItemmovimiento() {
        return itemmovimiento;
    }

    public void setItemmovimiento(String itemmovimiento) {
        this.itemmovimiento = itemmovimiento;
    }

    public String getCtacte() {
        return ctacte;
    }

    public void setCtacte(String ctacte) {
        this.ctacte = ctacte;
    }

    public short getEscliente() {
        return escliente;
    }

    public void setEscliente(short escliente) {
        this.escliente = escliente;
    }

    public short getEsproveedor() {
        return esproveedor;
    }

    public void setEsproveedor(short esproveedor) {
        this.esproveedor = esproveedor;
    }

    public String getCtactenombre() {
        return ctactenombre;
    }

    public void setCtactenombre(String ctactenombre) {
        this.ctactenombre = ctactenombre;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Character getItemelemento() {
        return itemelemento;
    }

    public void setItemelemento(Character itemelemento) {
        this.itemelemento = itemelemento;
    }

    public String getItemnombre() {
        return itemnombre;
    }

    public void setItemnombre(String itemnombre) {
        this.itemnombre = itemnombre;
    }

    public String getEmpresaunidad() {
        return empresaunidad;
    }

    public void setEmpresaunidad(String empresaunidad) {
        this.empresaunidad = empresaunidad;
    }

    public String getEmpresaunidadnombre() {
        return empresaunidadnombre;
    }

    public void setEmpresaunidadnombre(String empresaunidadnombre) {
        this.empresaunidadnombre = empresaunidadnombre;
    }

    public String getCentrocosto() {
        return centrocosto;
    }

    public void setCentrocosto(String centrocosto) {
        this.centrocosto = centrocosto;
    }

    public String getCentrocostonombre() {
        return centrocostonombre;
    }

    public void setCentrocostonombre(String centrocostonombre) {
        this.centrocostonombre = centrocostonombre;
    }

    public String getCrmProyecto() {
        return crmProyecto;
    }

    public void setCrmProyecto(String crmProyecto) {
        this.crmProyecto = crmProyecto;
    }

    public String getCrmProyectonombre() {
        return crmProyectonombre;
    }

    public void setCrmProyectonombre(String crmProyectonombre) {
        this.crmProyectonombre = crmProyectonombre;
    }

    public Long getIdrubro() {
        return idrubro;
    }

    public void setIdrubro(Long idrubro) {
        this.idrubro = idrubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRubronombre() {
        return rubronombre;
    }

    public void setRubronombre(String rubronombre) {
        this.rubronombre = rubronombre;
    }

    public String getSubrubro() {
        return subrubro;
    }

    public void setSubrubro(String subrubro) {
        this.subrubro = subrubro;
    }

    public String getSubrubronombre() {
        return subrubronombre;
    }

    public void setSubrubronombre(String subrubronombre) {
        this.subrubronombre = subrubronombre;
    }

    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

}
