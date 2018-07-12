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
 * @author mtrinidad
 */
@Entity
@Table(name = "ctactemovimientodetalle_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtactemovimientodetalleView.findAll", query = "SELECT c FROM CtactemovimientodetalleView c")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByIdempresa", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.idempresa = :idempresa")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByIdempresaDocumento", query = "SELECT d,c.fecha as fecha  FROM CtactemovimientodetalleView d LEFT OUTER JOIN CtactemovimientoView c  ON d.idctactemovimiento = c.idctactemovimiento WHERE c.idempresa = :idempresa and c.iddocumento = :iddocumento order by c.fecha desc ")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByIdctacte", query = "SELECT d,c.fecha FROM CtactemovimientodetalleView d LEFT OUTER JOIN CtactemovimientoView c ON d.idctactemovimiento = c.idctactemovimiento WHERE (c.ctacte = :search or c.ctactenombre like :search or c.nro= :search)  and c.iddocumento = :iddocumento order by c.fecha desc")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByIdctactemovimiento", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.idctactemovimiento = :idctactemovimiento")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByNro", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.nro = :nro")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByIddocumento", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.iddocumento = :iddocumento")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByMoneda", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.moneda = :moneda")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByNrodoc", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.nrodoc = :nrodoc")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByFechadoc", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.fechadoc = :fechadoc")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByFecVen", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.fecVen = :fecVen")
    , @NamedQuery(name = "CtactemovimientodetalleView.findByCuota", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.cuota = :cuota")
    , @NamedQuery(name = "CtactemovimientodetalleView.findBySaldo", query = "SELECT c FROM CtactemovimientodetalleView c WHERE c.saldo = :saldo")})
public class CtactemovimientodetalleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctactemovimiento")
    private long idctactemovimiento;
    @Id
    @Column(name = "idctactemovimientodetalle")
    private long idctactemovimientodetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nro")
    private String nro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iddocumento")
    private String iddocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nrodoc")
    private String nrodoc;
    @Transient
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadoc;
    @Column(name = "totalcuota")
    private Long totalcuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montodoc")
    private BigDecimal montodoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ven")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVen;
    @Column(name = "cuota")
    private Short cuota;
    @Column(name = "ultpago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private BigDecimal saldo;

    public CtactemovimientodetalleView() {
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIdctactemovimiento() {
        return idctactemovimiento;
    }

    public void setIdctactemovimiento(long idctactemovimiento) {
        this.idctactemovimiento = idctactemovimiento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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

    public Long getTotalcuota() {
        return totalcuota;
    }

    public void setTotalcuota(Long totalcuota) {
        this.totalcuota = totalcuota;
    }

    public BigDecimal getMontodoc() {
        return montodoc;
    }

    public void setMontodoc(BigDecimal montodoc) {
        this.montodoc = montodoc;
    }

    public Date getFecVen() {
        return fecVen;
    }

    public void setFecVen(Date fecVen) {
        this.fecVen = fecVen;
    }

    public Short getCuota() {
        return cuota;
    }

    public void setCuota(Short cuota) {
        this.cuota = cuota;
    }

    public Date getUltpago() {
        return ultpago;
    }

    public void setUltpago(Date ultpago) {
        this.ultpago = ultpago;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public long getIdctactemovimientodetalle() {
        return idctactemovimientodetalle;
    }

    public void setIdctactemovimientodetalle(long idctactemovimientodetalle) {
        this.idctactemovimientodetalle = idctactemovimientodetalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
