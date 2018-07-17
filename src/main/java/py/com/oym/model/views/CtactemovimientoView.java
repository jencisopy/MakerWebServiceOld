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
 * @author mtrinidad
 */
@Entity
@Table(name = "ctactemovimiento_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtactemovimientoView.findAll", query = "SELECT c FROM CtactemovimientoView c"),
    @NamedQuery(name = "CtactemovimientoView.findByRefDocumento", query = "SELECT c FROM CtactemovimientoView c WHERE (c.ctacte like :search or LOWER(c.ctactenombre) like LOWER(:search) or TRIM(c.nro) = :searchExact)  and c.iddocumento = :iddocumento order by c.fecha desc") ,   
    @NamedQuery(name = "CtactemovimientoView.findByRefDocumentoFecha", query = "SELECT c FROM CtactemovimientoView c WHERE (c.ctacte like :search or LOWER(c.ctactenombre) like LOWER(:search) or TRIM(c.nro) = :searchExact)  and c.iddocumento = :iddocumento and c.fecha between :fechaini and :fechafin order by c.fecha desc") ,   
    @NamedQuery(name = "CtactemovimientoView.findByIdempresaDocumento", query = "SELECT c  FROM CtactemovimientoView c WHERE c.idempresa = :idempresa and c.iddocumento = :iddocumento order by c.fecha desc ")})
public class CtactemovimientoView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idctactemovimiento")
    private long idctactemovimiento;
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
    @Size(min = 1, max = 3)
    @Column(name = "iddocumento")
    private String iddocumento;
    @Size(max = 2)
    @Column(name = "iddocumentotipo")
    private String iddocumentotipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacte")
    private long idctacte;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalmonto")
    private BigDecimal totalmonto;
    @Column(name = "totalmora")
    private BigDecimal totalmora;
    @Column(name = "totalinteres")
    private BigDecimal totalinteres;
    @Column(name = "totaldescuento")
    private BigDecimal totaldescuento;
    @Column(name = "totalcobranzarecargo")
    private BigDecimal totalcobranzarecargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambio")
    private BigDecimal cambio;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmado")
    private boolean confirmado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anulado")
    private boolean anulado;
    @Column(name = "ctacte")
    private String ctacte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ctactenombre")
    private String ctactenombre;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 2)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 30)
    @Column(name = "conceptonombre")
    private String conceptonombre;
    @Column(name = "vendedor")
    private String vendedor;
    @Size(max = 50)
    @Column(name = "vendedornombre")
    private String vendedornombre;

    public CtactemovimientoView() {
    }

    public long getIdctactemovimiento() {
        return idctactemovimiento;
    }

    public void setIdctactemovimiento(long idctactemovimiento) {
        this.idctactemovimiento = idctactemovimiento;
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

    public BigDecimal getTotalmonto() {
        return totalmonto;
    }

    public void setTotalmonto(BigDecimal totalmonto) {
        this.totalmonto = totalmonto;
    }

    public BigDecimal getTotalmora() {
        return totalmora;
    }

    public void setTotalmora(BigDecimal totalmora) {
        this.totalmora = totalmora;
    }

    public BigDecimal getTotalinteres() {
        return totalinteres;
    }

    public void setTotalinteres(BigDecimal totalinteres) {
        this.totalinteres = totalinteres;
    }

    public BigDecimal getTotaldescuento() {
        return totaldescuento;
    }

    public void setTotaldescuento(BigDecimal totaldescuento) {
        this.totaldescuento = totaldescuento;
    }

    public BigDecimal getTotalcobranzarecargo() {
        return totalcobranzarecargo;
    }

    public void setTotalcobranzarecargo(BigDecimal totalcobranzarecargo) {
        this.totalcobranzarecargo = totalcobranzarecargo;
    }

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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
}
