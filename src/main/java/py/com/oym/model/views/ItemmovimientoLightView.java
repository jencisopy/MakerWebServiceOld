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
@Table(name = "itemmovimiento_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemmovimientoLightView.findAll", query = "SELECT i FROM ItemmovimientoLightView i"),
    @NamedQuery(name = "ItemmovimientoLightView.findFacturasByIdctacte", query = "SELECT i FROM ItemmovimientoLightView i where i.idctacte = :idctacte and i.iddocumento = 'V' order by i.fecha desc"),
    @NamedQuery(name = "ItemmovimientoLightView.findFacturasByRefDocumento", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'V' order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findFacturasByRefDocumentoFecha", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'V' and i.fecha between :fechaini and :fechafin  order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findPedidosByIdctacte", query = "SELECT i FROM ItemmovimientoLightView i where i.idctacte = :idctacte and i.iddocumento = 'VP' order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findOrdenesByIdctacte", query = "SELECT i FROM ItemmovimientoLightView i where i.idctacte = :idctacte and i.iddocumento = 'COR' order by i.fecha desc"),
    @NamedQuery(name = "ItemmovimientoLightView.findComprasByIdctacte", query = "SELECT i FROM ItemmovimientoLightView i where i.idctacte = :idctacte and i.iddocumento = 'C' order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findFacturasByIdempresa", query = "SELECT i FROM ItemmovimientoLightView i where i.idempresa = :idempresa and i.iddocumento = 'V' order by i.fecha desc"),
    @NamedQuery(name = "ItemmovimientoLightView.findPedidosByIdempresa", query = "SELECT i FROM ItemmovimientoLightView i where i.idempresa = :idempresa and i.iddocumento = 'VP' order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findPedidosByRefDocumento", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'VP' order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findPedidosByRefDocumentoFecha", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'VP' and i.fecha between :fechaini and :fechafin  order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findOrdenesByIdempresa", query = "SELECT i FROM ItemmovimientoLightView i where i.idempresa = :idempresa and i.iddocumento = 'COR' order by i.fecha desc"),
    @NamedQuery(name = "ItemmovimientoLightView.findOrdenesByRefDocumento", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'COR' order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findOrdenesByRefDocumentoFecha", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'COR' and i.fecha between :fechaini and :fechafin  order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findComprasByRefDocumento", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'C' order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findComprasByRefDocumentoFecha", query = "SELECT i FROM ItemmovimientoLightView i where (i.ctacte like :search or LOWER(i.ctactenombre) like LOWER(:search) or TRIM(i.nro) = :searchExact) and i.idempresa = :idempresa and i.iddocumento = 'C' and i.fecha between :fechaini and :fechafin  order by i.fecha desc"), 
    @NamedQuery(name = "ItemmovimientoLightView.findComprasByIdempresa", query = "SELECT i FROM ItemmovimientoLightView i where i.idempresa= :idempresa and i.iddocumento = 'C' order by i.fecha desc"), 
})
public class ItemmovimientoLightView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemmovimiento")
    private long iditemmovimiento;
    
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
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;

    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacte")
    private long idctacte;
    
    @Size(max = 7)
    @Column(name = "secuencia")
    private String secuencia;
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

    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private BigDecimal impuesto;
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmado")
    private boolean confirmado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anulado")
    private boolean anulado;
    @Column(name = "ctacteafecta")
    private Short ctacteafecta;

    @Column(name = "esimportacion")
    private Short esimportacion;

    @Size(max = 3)
    @Column(name = "moneda")
    private String moneda;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "deposito")
    private String deposito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "depositonombre")
    private String depositonombre;

    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documentotiponombre")
    private String documentotiponombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documentonombre")

    private String documentonombre;
    @Size(max = 20)
    @Column(name = "documentoestadonombre")
    private String documentoestadonombre;

    @Column(name = "cuotas")
    private Short cuotas;
    @Column(name = "saldo")
    private BigDecimal saldo;

    @Size(max = 11)
    @Column(name = "ctacte")
    private String ctacte;
    @Size(max = 50)
    @Column(name = "ctactenombre")
    private String ctactenombre;
    
    
    public ItemmovimientoLightView() {
    }

    public long getIditemmovimiento() {
        return iditemmovimiento;
    }

    public void setIditemmovimiento(long iditemmovimiento) {
        this.iditemmovimiento = iditemmovimiento;
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

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public Short getCtacteafecta() {
        return ctacteafecta;
    }

    public void setCtacteafecta(Short ctacteafecta) {
        this.ctacteafecta = ctacteafecta;
    }

    public Short getEsimportacion() {
        return esimportacion;
    }

    public void setEsimportacion(Short esimportacion) {
        this.esimportacion = esimportacion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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

    public String getDocumentotiponombre() {
        return documentotiponombre;
    }

    public void setDocumentotiponombre(String documentotiponombre) {
        this.documentotiponombre = documentotiponombre;
    }

    public String getDocumentonombre() {
        return documentonombre;
    }

    public void setDocumentonombre(String documentonombre) {
        this.documentonombre = documentonombre;
    }

    public String getDocumentoestadonombre() {
        return documentoestadonombre;
    }

    public void setDocumentoestadonombre(String documentoestadonombre) {
        this.documentoestadonombre = documentoestadonombre;
    }

    public Short getCuotas() {
        return cuotas;
    }

    public void setCuotas(Short cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
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

    public long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(long idctacte) {
        this.idctacte = idctacte;
    }

    public String getCtacte() {
        return ctacte;
    }

    public void setCtacte(String ctacte) {
        this.ctacte = ctacte;
    }

    public String getCtactenombre() {
        return ctactenombre;
    }

    public void setCtactenombre(String ctactenombre) {
        this.ctactenombre = ctactenombre;
    }
    
}
