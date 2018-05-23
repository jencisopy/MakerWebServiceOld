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
@Table(name = "itemproductostock_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemproductostockView.findAll", query = "SELECT i FROM ItemproductostockView i where i.iditem = :iditem")})
public class ItemproductostockView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private long iditem;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperiodo")
    private long idperiodo;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeposito")
    private long iddeposito;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fchultent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fchultent;
    @Column(name = "fchultsal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fchultsal;

    
    /* principales datos a tener en cuenta */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "item")
    private String item;
    
    @Size(max = 13)
    @Column(name = "codigobarra")
    private String codigobarra;


    @Size(max = 10)
    @Column(name = "itemmedida")
    private String itemmedida;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ubicacion")
    private String ubicacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private BigDecimal stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockminimo")
    private BigDecimal stockminimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockmaximo")
    private BigDecimal stockmaximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costolocal")
    private BigDecimal costolocal;

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
    @Column(name = "conversion")
    private BigDecimal conversion;
    @Column(name = "costolocal2")
    private BigDecimal costolocal2;
    @Column(name = "stockminimo2")
    private BigDecimal stockminimo2;
    @Column(name = "stockmaximo2")
    private BigDecimal stockmaximo2;
    @Column(name = "stock2")
    private BigDecimal stock2;
    @Size(max = 10)
    @Column(name = "itemmedida2")
    private String itemmedida2;

    public ItemproductostockView() {
    }

    public long getIditem() {
        return iditem;
    }

    public void setIditem(long iditem) {
        this.iditem = iditem;
    }

    public long getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(long idperiodo) {
        this.idperiodo = idperiodo;
    }

    public long getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(long iddeposito) {
        this.iddeposito = iddeposito;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(BigDecimal stockminimo) {
        this.stockminimo = stockminimo;
    }

    public BigDecimal getStockmaximo() {
        return stockmaximo;
    }

    public void setStockmaximo(BigDecimal stockmaximo) {
        this.stockmaximo = stockmaximo;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCostolocal() {
        return costolocal;
    }

    public void setCostolocal(BigDecimal costolocal) {
        this.costolocal = costolocal;
    }


    public Date getFchultent() {
        return fchultent;
    }

    public void setFchultent(Date fchultent) {
        this.fchultent = fchultent;
    }

    public Date getFchultsal() {
        return fchultsal;
    }

    public void setFchultsal(Date fchultsal) {
        this.fchultsal = fchultsal;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    public String getItemmedida() {
        return itemmedida;
    }

    public void setItemmedida(String itemmedida) {
        this.itemmedida = itemmedida;
    }


    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public BigDecimal getConversion() {
        return conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public BigDecimal getCostolocal2() {
        return costolocal2;
    }

    public void setCostolocal2(BigDecimal costolocal2) {
        this.costolocal2 = costolocal2;
    }

    public BigDecimal getStockminimo2() {
        return stockminimo2;
    }

    public void setStockminimo2(BigDecimal stockminimo2) {
        this.stockminimo2 = stockminimo2;
    }

    public BigDecimal getStockmaximo2() {
        return stockmaximo2;
    }

    public void setStockmaximo2(BigDecimal stockmaximo2) {
        this.stockmaximo2 = stockmaximo2;
    }

    public BigDecimal getStock2() {
        return stock2;
    }

    public void setStock2(BigDecimal stock2) {
        this.stock2 = stock2;
    }

    public String getItemmedida2() {
        return itemmedida2;
    }

    public void setItemmedida2(String itemmedida2) {
        this.itemmedida2 = itemmedida2;
    }
}
