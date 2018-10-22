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
 * @author alberto
 */
@Entity
@Table(name = "itemmovpln_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemmovplnView.findAll", query = "SELECT i FROM ItemmovplnView i")
    , @NamedQuery(name = "ItemmovplnView.findByIditemmovpln", query = "SELECT i FROM ItemmovplnView i WHERE i.iditemmovpln = :iditemmovpln")
    , @NamedQuery(name = "ItemmovplnView.findByIdempresa", query = "SELECT i FROM ItemmovplnView i WHERE i.idempresa = :idempresa")
    , @NamedQuery(name = "ItemmovplnView.findByIdperiodo", query = "SELECT i FROM ItemmovplnView i WHERE i.idperiodo = :idperiodo")
    , @NamedQuery(name = "ItemmovplnView.findByIdconcepto", query = "SELECT i FROM ItemmovplnView i WHERE i.idconcepto = :idconcepto")
    
})
public class ItemmovplnView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "iditemmovpln")
    private long iditemmovpln;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperiodo")
    private long idperiodo;
    @Column(name = "idconcepto")
    private Long idconcepto;
    @Column(name = "idsubrubro")
    private Long idsubrubro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeposito")
    private long iddeposito;
    @Column(name = "idmoneda")
    private Long idmoneda;
    @Column(name = "idctbcuenta")
    private Long idctbcuenta;
    @Column(name = "idcajalog")
    private Long idcajalog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iddocumento")
    private String iddocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "iddocumentotipo")
    private String iddocumentotipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nro")
    private String nro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 10)
    @Column(name = "referencia")
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "montorecibido")
    private BigDecimal montorecibido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montootros")
    private BigDecimal montootros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalreembolsable")
    private BigDecimal totalreembolsable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalaprobado")
    private BigDecimal totalaprobado;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio")
    private BigDecimal cambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmado")
    private boolean confirmado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anulado")
    private boolean anulado;
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
    @Column(name = "idbancomovimiento")
    private Long idbancomovimiento;
    @Size(max = 2)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 30)
    @Column(name = "conceptonombre")
    private String conceptonombre;
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
    @Size(max = 4)
    @Column(name = "deposito")
    private String deposito;
    @Size(max = 30)
    @Column(name = "depositonombre")
    private String depositonombre;
    @Column(name = "idsucursal")
    private Long idsucursal;
    @Size(max = 2)
    @Column(name = "sucursal")
    private String sucursal;
    @Size(max = 50)
    @Column(name = "sucursalnombre")
    private String sucursalnombre;
    @Size(max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 15)
    @Column(name = "ctbcuenta")
    private String ctbcuenta;
    @Size(max = 50)
    @Column(name = "ctbcuentanombre")
    private String ctbcuentanombre;
    @Column(name = "montodevolver")
    private BigDecimal montodevolver;
    @Column(name = "cajalog")
    private Long cajalog;
    @Size(max = 2)
    @Column(name = "caja")
    private String caja;
    @Size(max = 35)
    @Column(name = "bancomovimiento")
    private String bancomovimiento;
    @Column(name = "chequenro")
    private Long chequenro;
    @Column(name = "idbancocuenta")
    private Long idbancocuenta;
    @Size(max = 15)
    @Column(name = "bancocuenta")
    private String bancocuenta;

    public ItemmovplnView() {
    }

    public long getIditemmovpln() {
        return iditemmovpln;
    }

    public void setIditemmovpln(long iditemmovpln) {
        this.iditemmovpln = iditemmovpln;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(long idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Long getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Long idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Long getIdsubrubro() {
        return idsubrubro;
    }

    public void setIdsubrubro(Long idsubrubro) {
        this.idsubrubro = idsubrubro;
    }

    public long getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(long iddeposito) {
        this.iddeposito = iddeposito;
    }

    public Long getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Long idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Long getIdctbcuenta() {
        return idctbcuenta;
    }

    public void setIdctbcuenta(Long idctbcuenta) {
        this.idctbcuenta = idctbcuenta;
    }

    public Long getIdcajalog() {
        return idcajalog;
    }

    public void setIdcajalog(Long idcajalog) {
        this.idcajalog = idcajalog;
    }

    public String getIdnro() {
        return idnro;
    }

    public void setIdnro(String idnro) {
        this.idnro = idnro;
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

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getMontorecibido() {
        return montorecibido;
    }

    public void setMontorecibido(BigDecimal montorecibido) {
        this.montorecibido = montorecibido;
    }

    public BigDecimal getMontootros() {
        return montootros;
    }

    public void setMontootros(BigDecimal montootros) {
        this.montootros = montootros;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalreembolsable() {
        return totalreembolsable;
    }

    public void setTotalreembolsable(BigDecimal totalreembolsable) {
        this.totalreembolsable = totalreembolsable;
    }

    public BigDecimal getTotalaprobado() {
        return totalaprobado;
    }

    public void setTotalaprobado(BigDecimal totalaprobado) {
        this.totalaprobado = totalaprobado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
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

    public Long getIdbancomovimiento() {
        return idbancomovimiento;
    }

    public void setIdbancomovimiento(Long idbancomovimiento) {
        this.idbancomovimiento = idbancomovimiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConceptonombre() {
        return conceptonombre;
    }

    public void setConceptonombre(String conceptonombre) {
        this.conceptonombre = conceptonombre;
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

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public String getDepositonombre() {
        return depositonombre;
    }

    public void setDepositonombre(String depositonombre) {
        this.depositonombre = depositonombre;
    }

    public Long getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Long idsucursal) {
        this.idsucursal = idsucursal;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getCtbcuenta() {
        return ctbcuenta;
    }

    public void setCtbcuenta(String ctbcuenta) {
        this.ctbcuenta = ctbcuenta;
    }

    public String getCtbcuentanombre() {
        return ctbcuentanombre;
    }

    public void setCtbcuentanombre(String ctbcuentanombre) {
        this.ctbcuentanombre = ctbcuentanombre;
    }

    public BigDecimal getMontodevolver() {
        return montodevolver;
    }

    public void setMontodevolver(BigDecimal montodevolver) {
        this.montodevolver = montodevolver;
    }

    public Long getCajalog() {
        return cajalog;
    }

    public void setCajalog(Long cajalog) {
        this.cajalog = cajalog;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getBancomovimiento() {
        return bancomovimiento;
    }

    public void setBancomovimiento(String bancomovimiento) {
        this.bancomovimiento = bancomovimiento;
    }

    public Long getChequenro() {
        return chequenro;
    }

    public void setChequenro(Long chequenro) {
        this.chequenro = chequenro;
    }

    public Long getIdbancocuenta() {
        return idbancocuenta;
    }

    public void setIdbancocuenta(Long idbancocuenta) {
        this.idbancocuenta = idbancocuenta;
    }

    public String getBancocuenta() {
        return bancocuenta;
    }

    public void setBancocuenta(String bancocuenta) {
        this.bancocuenta = bancocuenta;
    }
    
}
