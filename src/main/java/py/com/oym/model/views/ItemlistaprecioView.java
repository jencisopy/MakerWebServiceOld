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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jenci_000
 */
@Entity
@Table(name = "itemlistaprecio_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemlistaprecioView.findAll", query = "SELECT i FROM ItemlistaprecioView i where i.iditem = :iditem")})
public class ItemlistaprecioView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private long iditem;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlistaprecio")
    private long idlistaprecio;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "limitedescuento")
    private BigDecimal limitedescuento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "listaprecio")
    private String listaprecio;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "listaprecionombre")
    private String listaprecionombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "moneda")
    private String moneda;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "item")
    private String item;

    @Column(name = "baseiva")
    private Integer baseiva;

    @Size(max = 10)
    @Column(name = "itemmedida")
    private String itemmedida;
    @Column(name = "iva")
    private BigDecimal iva;
    @Column(name = "precioconiva")
    private BigDecimal precioconiva;


    @Size(max = 10)
    @Column(name = "itemmedida2")
    private String itemmedida2;
    @Column(name = "conversion")
    private BigDecimal conversion;
    @Column(name = "precio2")
    private BigDecimal precio2;
    @Column(name = "precioconiva2")
    private BigDecimal precioconiva2;

    public ItemlistaprecioView() {
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIditem() {
        return iditem;
    }

    public void setIditem(long iditem) {
        this.iditem = iditem;
    }

    public long getIdlistaprecio() {
        return idlistaprecio;
    }

    public void setIdlistaprecio(long idlistaprecio) {
        this.idlistaprecio = idlistaprecio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getLimitedescuento() {
        return limitedescuento;
    }

    public void setLimitedescuento(BigDecimal limitedescuento) {
        this.limitedescuento = limitedescuento;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    public Integer getBaseiva() {
        return baseiva;
    }

    public void setBaseiva(Integer baseiva) {
        this.baseiva = baseiva;
    }


    public String getItemmedida() {
        return itemmedida;
    }

    public void setItemmedida(String itemmedida) {
        this.itemmedida = itemmedida;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getPrecioconiva() {
        return precioconiva;
    }

    public void setPrecioconiva(BigDecimal precioconiva) {
        this.precioconiva = precioconiva;
    }

    public String getItemmedida2() {
        return itemmedida2;
    }

    public void setItemmedida2(String itemmedida2) {
        this.itemmedida2 = itemmedida2;
    }

    public BigDecimal getConversion() {
        return conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public BigDecimal getPrecio2() {
        return precio2;
    }

    public void setPrecio2(BigDecimal precio2) {
        this.precio2 = precio2;
    }

    public BigDecimal getPrecioconiva2() {
        return precioconiva2;
    }

    public void setPrecioconiva2(BigDecimal precioconiva2) {
        this.precioconiva2 = precioconiva2;
    }
    
}
