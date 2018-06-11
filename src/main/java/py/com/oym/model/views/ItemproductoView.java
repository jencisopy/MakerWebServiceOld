/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "itemproducto_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemproductoView.findAll", query = "SELECT i FROM ItemproductoView i where i.idempresa = :idempresa order by i.nombre"),
    @NamedQuery(name = "ItemproductoView.findByCodigo", query = "SELECT i FROM ItemproductoView i WHERE i.idempresa = :idempresa and i.codigo = :codigo"),
    @NamedQuery(name = "ItemproductoView.findByCodeAndName", query = "SELECT i FROM ItemproductoView i WHERE i.idempresa = :idempresa and (i.nombre like :nombre or i.codigo like :codigo) order by i.nombre")})
public class ItemproductoView implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private long iditem;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "codigo")
    private String codigo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 10)
    @Column(name = "medida")
    private String medida;

    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "inactivo")
    private Boolean inactivo;

    @Column(name = "baseiva")
    private Integer baseiva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iva")
    private BigDecimal iva;
    @Size(max = 3)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 15)
    @Column(name = "ctbcuenta")
    private String ctbcuenta;
    @Size(max = 50)
    @Column(name = "ctbcuentanombre")
    private String ctbcuentanombre;
    @Size(max = 6)
    @Column(name = "familia")
    private String familia;
    @Size(max = 50)
    @Column(name = "familianombre")
    private String familianombre;
    @Size(max = 4)
    @Column(name = "familiagrupo")
    private String familiagrupo;
    @Size(max = 50)
    @Column(name = "familiagruponombre")
    private String familiagruponombre;
    @Size(max = 10)
    @Column(name = "itemmedida")
    private String itemmedida;
    @Size(max = 3)
    @Column(name = "impuestogrupo")
    private String impuestogrupo;
    @Size(max = 50)
    @Column(name = "impuestogruponombre")
    private String impuestogruponombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "item")
    private String item;
    @Size(max = 10)
    @Column(name = "itemproductoclase")
    private String itemproductoclase;
    @Size(max = 30)
    @Column(name = "itemproductoclasenombre")
    private String itemproductoclasenombre;
    @Size(max = 10)
    @Column(name = "itemproductomarca")
    private String itemproductomarca;
    @Size(max = 30)
    @Column(name = "itemproductomarcanombre")
    private String itemproductomarcanombre;

    @Size(max = 5)
    @Column(name = "itemorigen")
    private String itemorigen;
    @Size(max = 50)
    @Column(name = "itemorigennombre")
    private String itemorigennombre;

    @Size(max = 13)
    @Column(name = "codigobarra")
    private String codigobarra;
    @Size(max = 16)
    @Column(name = "codigoorigen")
    private String codigoorigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreorigen")
    private String nombreorigen;

    @Basic(optional = false)
    @NotNull
    @Column(name = "costofob")
    private BigDecimal costofob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costocif")
    private BigDecimal costocif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal costo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "stockporlote")
    private boolean stockporlote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockporserie")
    private boolean stockporserie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comision")
    private BigDecimal comision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bonificacion")
    private BigDecimal bonificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "utilidad")
    private BigDecimal utilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ult_costo")
    private BigDecimal ultCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cubicaje")
    private BigDecimal cubicaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasadespacho")
    private BigDecimal tasadespacho;

    @Column(name = "nofraccionable")
    private Boolean nofraccionable;
    @Column(name = "diasparavto")
    private Integer diasparavto;

    public ItemproductoView() {
    }

    public long getIditem() {
        return iditem;
    }

    public void setIditem(long iditem) {
        this.iditem = iditem;
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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
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

    public Integer getBaseiva() {
        return baseiva;
    }

    public void setBaseiva(Integer baseiva) {
        this.baseiva = baseiva;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
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

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getFamilianombre() {
        return familianombre;
    }

    public void setFamilianombre(String familianombre) {
        this.familianombre = familianombre;
    }

    public String getFamiliagrupo() {
        return familiagrupo;
    }

    public void setFamiliagrupo(String familiagrupo) {
        this.familiagrupo = familiagrupo;
    }

    public String getFamiliagruponombre() {
        return familiagruponombre;
    }

    public void setFamiliagruponombre(String familiagruponombre) {
        this.familiagruponombre = familiagruponombre;
    }

    public String getItemmedida() {
        return itemmedida;
    }

    public void setItemmedida(String itemmedida) {
        this.itemmedida = itemmedida;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemproductoclase() {
        return itemproductoclase;
    }

    public void setItemproductoclase(String itemproductoclase) {
        this.itemproductoclase = itemproductoclase;
    }

    public String getItemproductoclasenombre() {
        return itemproductoclasenombre;
    }

    public void setItemproductoclasenombre(String itemproductoclasenombre) {
        this.itemproductoclasenombre = itemproductoclasenombre;
    }

    public String getItemproductomarca() {
        return itemproductomarca;
    }

    public void setItemproductomarca(String itemproductomarca) {
        this.itemproductomarca = itemproductomarca;
    }

    public String getItemproductomarcanombre() {
        return itemproductomarcanombre;
    }

    public void setItemproductomarcanombre(String itemproductomarcanombre) {
        this.itemproductomarcanombre = itemproductomarcanombre;
    }

    public String getItemorigen() {
        return itemorigen;
    }

    public void setItemorigen(String itemorigen) {
        this.itemorigen = itemorigen;
    }

    public String getItemorigennombre() {
        return itemorigennombre;
    }

    public void setItemorigennombre(String itemorigennombre) {
        this.itemorigennombre = itemorigennombre;
    }


    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getCodigoorigen() {
        return codigoorigen;
    }

    public void setCodigoorigen(String codigoorigen) {
        this.codigoorigen = codigoorigen;
    }

    public String getNombreorigen() {
        return nombreorigen;
    }

    public void setNombreorigen(String nombreorigen) {
        this.nombreorigen = nombreorigen;
    }

    public BigDecimal getCostofob() {
        return costofob;
    }

    public void setCostofob(BigDecimal costofob) {
        this.costofob = costofob;
    }

    public BigDecimal getCostocif() {
        return costocif;
    }

    public void setCostocif(BigDecimal costocif) {
        this.costocif = costocif;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }


    public boolean getStockporlote() {
        return stockporlote;
    }

    public void setStockporlote(boolean stockporlote) {
        this.stockporlote = stockporlote;
    }

    public boolean getStockporserie() {
        return stockporserie;
    }

    public void setStockporserie(boolean stockporserie) {
        this.stockporserie = stockporserie;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public BigDecimal getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(BigDecimal bonificacion) {
        this.bonificacion = bonificacion;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public BigDecimal getUltCosto() {
        return ultCosto;
    }

    public void setUltCosto(BigDecimal ultCosto) {
        this.ultCosto = ultCosto;
    }

    public BigDecimal getCubicaje() {
        return cubicaje;
    }

    public void setCubicaje(BigDecimal cubicaje) {
        this.cubicaje = cubicaje;
    }

    public BigDecimal getTasadespacho() {
        return tasadespacho;
    }

    public void setTasadespacho(BigDecimal tasadespacho) {
        this.tasadespacho = tasadespacho;
    }


    public Boolean getNofraccionable() {
        return nofraccionable;
    }

    public void setNofraccionable(Boolean nofraccionable) {
        this.nofraccionable = nofraccionable;
    }

    public Integer getDiasparavto() {
        return diasparavto;
    }

    public void setDiasparavto(Integer diasparavto) {
        this.diasparavto = diasparavto;
    }
    
}
