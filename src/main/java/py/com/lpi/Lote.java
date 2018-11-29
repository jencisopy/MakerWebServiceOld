/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lpi;

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

/**
 *
 * @author JORGE
 */
@Entity
@Table(name = "LOTES")
@NamedQueries({
    @NamedQuery(name = "Lotes.findAll", query = "SELECT l FROM Lote l")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOTE")
    private Integer idLote;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANZANA")
    private Integer idManzana;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FRACCION")
    private Integer idFraccion;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DIMENSION")
    private BigDecimal dimension;
    @Column(name = "DIMENSION_ESTE")
    private BigDecimal dimensionEste;
    @Column(name = "DIMENSION_NORTE")
    private BigDecimal dimensionNorte;
    @Column(name = "DIMENSION_OESTE")
    private BigDecimal dimensionOeste;
    @Column(name = "DIMENSION_SUR")
    private BigDecimal dimensionSur;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_ESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstado;
    @Size(max = 30)
    @Column(name = "LINDERO_ESTE")
    private String linderoEste;
    @Size(max = 30)
    @Column(name = "LINDERO_NORTE")
    private String linderoNorte;
    @Size(max = 30)
    @Column(name = "LINDERO_OESTE")
    private String linderoOeste;
    @Size(max = 30)
    @Column(name = "LINDERO_SUR")
    private String linderoSur;
    @Column(name = "IMPORTE_ENTREGA_INICIAL")
    private BigDecimal importeEntregaInicial;
    @Column(name = "CUOTA_ENTREGA_INICIAL")
    private Short cuotaEntregaInicial;
    @Column(name = "MONTO_CUOTA")
    private BigDecimal montoCuota;
    @Column(name = "IVA_CUOTA")
    private BigDecimal ivaCuota;
    @Size(max = 12)
    @Column(name = "NRO_FINCA")
    private String nroFinca;
    @Size(max = 15)
    @Column(name = "CTA_CTE_CTRAL")
    private String ctaCteCtral;
    @Column(name = "PLAZO")
    private Short plazo;
    @Column(name = "PRECIO_CONTADO")
    private BigDecimal precioContado;
    @Column(name = "PRECIO_FINANCIADO")
    private Long precioFinanciado;
    @Size(max = 3)
    @Column(name = "ID_MONEDA")
    private String idMoneda;
    @Column(name = "FECHA_VENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;

    public Lote() {
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public Integer getIdManzana() {
        return idManzana;
    }

    public void setIdManzana(Integer idManzana) {
        this.idManzana = idManzana;
    }

    public Integer getIdFraccion() {
        return idFraccion;
    }

    public void setIdFraccion(Integer idFraccion) {
        this.idFraccion = idFraccion;
    }


    public BigDecimal getDimension() {
        return dimension;
    }

    public void setDimension(BigDecimal dimension) {
        this.dimension = dimension;
    }

    public BigDecimal getDimensionEste() {
        return dimensionEste;
    }

    public void setDimensionEste(BigDecimal dimensionEste) {
        this.dimensionEste = dimensionEste;
    }

    public BigDecimal getDimensionNorte() {
        return dimensionNorte;
    }

    public void setDimensionNorte(BigDecimal dimensionNorte) {
        this.dimensionNorte = dimensionNorte;
    }

    public BigDecimal getDimensionOeste() {
        return dimensionOeste;
    }

    public void setDimensionOeste(BigDecimal dimensionOeste) {
        this.dimensionOeste = dimensionOeste;
    }

    public BigDecimal getDimensionSur() {
        return dimensionSur;
    }

    public void setDimensionSur(BigDecimal dimensionSur) {
        this.dimensionSur = dimensionSur;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public String getLinderoEste() {
        return linderoEste;
    }

    public void setLinderoEste(String linderoEste) {
        this.linderoEste = linderoEste;
    }

    public String getLinderoNorte() {
        return linderoNorte;
    }

    public void setLinderoNorte(String linderoNorte) {
        this.linderoNorte = linderoNorte;
    }

    public String getLinderoOeste() {
        return linderoOeste;
    }

    public void setLinderoOeste(String linderoOeste) {
        this.linderoOeste = linderoOeste;
    }

    public String getLinderoSur() {
        return linderoSur;
    }

    public void setLinderoSur(String linderoSur) {
        this.linderoSur = linderoSur;
    }

    public BigDecimal getImporteEntregaInicial() {
        return importeEntregaInicial;
    }

    public void setImporteEntregaInicial(BigDecimal importeEntregaInicial) {
        this.importeEntregaInicial = importeEntregaInicial;
    }

    public Short getCuotaEntregaInicial() {
        return cuotaEntregaInicial;
    }

    public void setCuotaEntregaInicial(Short cuotaEntregaInicial) {
        this.cuotaEntregaInicial = cuotaEntregaInicial;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public BigDecimal getIvaCuota() {
        return ivaCuota;
    }

    public void setIvaCuota(BigDecimal ivaCuota) {
        this.ivaCuota = ivaCuota;
    }

    public String getNroFinca() {
        return nroFinca;
    }

    public void setNroFinca(String nroFinca) {
        this.nroFinca = nroFinca;
    }

    public String getCtaCteCtral() {
        return ctaCteCtral;
    }

    public void setCtaCteCtral(String ctaCteCtral) {
        this.ctaCteCtral = ctaCteCtral;
    }

    public Short getPlazo() {
        return plazo;
    }

    public void setPlazo(Short plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getPrecioContado() {
        return precioContado;
    }

    public void setPrecioContado(BigDecimal precioContado) {
        this.precioContado = precioContado;
    }

    public Long getPrecioFinanciado() {
        return precioFinanciado;
    }

    public void setPrecioFinanciado(Long precioFinanciado) {
        this.precioFinanciado = precioFinanciado;
    }

    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
