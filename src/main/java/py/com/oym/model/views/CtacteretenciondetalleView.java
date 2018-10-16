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
@Table(name = "ctacteretenciondetalle_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtacteretenciondetalleView.findAll", query = "SELECT c FROM CtacteretenciondetalleView c")
    , @NamedQuery(name = "CtacteretenciondetalleView.findByIdctacteretenciondetalle", query = "SELECT c FROM CtacteretenciondetalleView c WHERE c.idctacteretenciondetalle = :idctacteretenciondetalle")
    , @NamedQuery(name = "CtacteretenciondetalleView.findByIdctactemovimiento", query = "SELECT c FROM CtacteretenciondetalleView c WHERE c.idctactemovimiento = :idctactemovimiento")
    , @NamedQuery(name = "CtacteretenciondetalleView.findByFechafactura", query = "SELECT c FROM CtacteretenciondetalleView c WHERE c.fechafactura = :fechafactura")
})
public class CtacteretenciondetalleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idctacteretenciondetalle")
    private long idctacteretenciondetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctactemovimiento")
    private long idctactemovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "secfactura")
    private String secfactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nrofactura")
    private String nrofactura;
    @Column(name = "fechafactura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafactura;
    @Size(max = 11)
    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "timbradofactura")
    private String timbradofactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montofacturatotal")
    private BigDecimal montofacturatotal;
    @Column(name = "montofacturaimpuesto")
    private BigDecimal montofacturaimpuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoimponible")
    private BigDecimal montoimponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoretencion")
    private BigDecimal montoretencion;
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
    @Column(name = "porcontabilidad")
    private Boolean porcontabilidad;
    @Column(name = "idctbivapy")
    private Long idctbivapy;
    @Column(name = "iditemmovimiento")
    private Long iditemmovimiento;
    @Size(max = 15)
    @Column(name = "audit_uk")
    private String auditUk;
    @Column(name = "porcretencion")
    private BigDecimal porcretencion;

    public CtacteretenciondetalleView() {
    }

    public String getIdnro() {
        return idnro;
    }

    public void setIdnro(String idnro) {
        this.idnro = idnro;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    public long getIdctacteretenciondetalle() {
        return idctacteretenciondetalle;
    }

    public void setIdctacteretenciondetalle(long idctacteretenciondetalle) {
        this.idctacteretenciondetalle = idctacteretenciondetalle;
    }

    public long getIdctactemovimiento() {
        return idctactemovimiento;
    }

    public void setIdctactemovimiento(long idctactemovimiento) {
        this.idctactemovimiento = idctactemovimiento;
    }

    public String getSecfactura() {
        return secfactura;
    }

    public void setSecfactura(String secfactura) {
        this.secfactura = secfactura;
    }

    public String getNrofactura() {
        return nrofactura;
    }

    public void setNrofactura(String nrofactura) {
        this.nrofactura = nrofactura;
    }

    public Date getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    public String getTimbradofactura() {
        return timbradofactura;
    }

    public void setTimbradofactura(String timbradofactura) {
        this.timbradofactura = timbradofactura;
    }

    public BigDecimal getMontofacturatotal() {
        return montofacturatotal;
    }

    public void setMontofacturatotal(BigDecimal montofacturatotal) {
        this.montofacturatotal = montofacturatotal;
    }

    public BigDecimal getMontofacturaimpuesto() {
        return montofacturaimpuesto;
    }

    public void setMontofacturaimpuesto(BigDecimal montofacturaimpuesto) {
        this.montofacturaimpuesto = montofacturaimpuesto;
    }

    public BigDecimal getMontoimponible() {
        return montoimponible;
    }

    public void setMontoimponible(BigDecimal montoimponible) {
        this.montoimponible = montoimponible;
    }

    public BigDecimal getMontoretencion() {
        return montoretencion;
    }

    public void setMontoretencion(BigDecimal montoretencion) {
        this.montoretencion = montoretencion;
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

    public Boolean getPorcontabilidad() {
        return porcontabilidad;
    }

    public void setPorcontabilidad(Boolean porcontabilidad) {
        this.porcontabilidad = porcontabilidad;
    }

    public Long getIdctbivapy() {
        return idctbivapy;
    }

    public void setIdctbivapy(Long idctbivapy) {
        this.idctbivapy = idctbivapy;
    }

    public Long getIditemmovimiento() {
        return iditemmovimiento;
    }

    public void setIditemmovimiento(Long iditemmovimiento) {
        this.iditemmovimiento = iditemmovimiento;
    }

    public String getAuditUk() {
        return auditUk;
    }

    public void setAuditUk(String auditUk) {
        this.auditUk = auditUk;
    }

    public BigDecimal getPorcretencion() {
        return porcretencion;
    }

    public void setPorcretencion(BigDecimal porcretencion) {
        this.porcretencion = porcretencion;
    }

}
