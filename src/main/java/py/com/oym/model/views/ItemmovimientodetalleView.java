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
@Table(name = "itemmovimientodetalle_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemmovimientodetalleView.findAll", query = "SELECT i FROM ItemmovimientodetalleView i")
    , @NamedQuery(name = "ItemmovimientodetalleView.findByIditemmovimientodetalle", query = "SELECT i FROM ItemmovimientodetalleView i WHERE i.iditemmovimientodetalle = :iditemmovimientodetalle")
    , @NamedQuery(name = "ItemmovimientodetalleView.findByIditemmovimiento", query = "SELECT i FROM ItemmovimientodetalleView i WHERE i.iditemmovimiento = :iditemmovimiento")
    })
public class ItemmovimientodetalleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seleccion")
    private int seleccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "idnro")
    private String idnro;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemmovimientodetalle")
    private long iditemmovimientodetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemmovimiento")
    private long iditemmovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorden")
    private long idorden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private long iditem;
    @Column(name = "id1")
    private Long id1;
    @Column(name = "id2")
    private Long id2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeposito")
    private long iddeposito;
    @Column(name = "iddepdest")
    private Long iddepdest;
    @Column(name = "idlistaprecio")
    private Long idlistaprecio;
    @Column(name = "iditemactivofijonro")
    private Long iditemactivofijonro;
    @Column(name = "idcentrocosto")
    private Long idcentrocosto;
    @Column(name = "iditemcolor")
    private Long iditemcolor;
    @Column(name = "iditemtalle")
    private Long iditemtalle;
    @Column(name = "iditembonificacion")
    private Long iditembonificacion;
    @Column(name = "iditemproductonro")
    private Long iditemproductonro;
    @Size(max = 15)
    @Column(name = "itemproductonro")
    private String itemproductonro;
    @Column(name = "itemproductonrovto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemproductonrovto;
    @Size(max = 15)
    @Column(name = "itemactivofijonro")
    private String itemactivofijonro;
    @Column(name = "idperiodo")
    private Long idperiodo;
    @Column(name = "idctbejercicio")
    private Long idctbejercicio;
    @Column(name = "iditemprod")
    private Long iditemprod;
    @Column(name = "idempresaunidad")
    private Long idempresaunidad;
    @Column(name = "idempresaunidaddest")
    private Long idempresaunidaddest;
    @Column(name = "idcrm_proyecto")
    private Long idcrmProyecto;
    @Size(max = 10)
    @Column(name = "nro")
    private String nro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadpedido")
    private BigDecimal cantidadpedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conversion")
    private BigDecimal conversion;
    @Size(max = 10)
    @Column(name = "itemmedida")
    private String itemmedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadbonificacion")
    private BigDecimal cantidadbonificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciobruto")
    private BigDecimal preciobruto;
    @Column(name = "preciobrutotax")
    private BigDecimal preciobrutotax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioneto")
    private BigDecimal precioneto;
    @Column(name = "precionetotax")
    private BigDecimal precionetotax;
    @Column(name = "preciolista")
    private BigDecimal preciolista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ldescuento")
    private BigDecimal ldescuento;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private BigDecimal impuesto;
    @Column(name = "impuestoporc")
    private BigDecimal impuestoporc;
    @Column(name = "impuestobaseimponible")
    private BigDecimal impuestobaseimponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible")
    private BigDecimal disponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cambiodia")
    private BigDecimal cambiodia;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal costo;
    @Column(name = "costolocal")
    private BigDecimal costolocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pendiente")
    private BigDecimal pendiente;
    @Column(name = "merma_porc")
    private BigDecimal mermaPorc;
    @Column(name = "cantidad_componente")
    private BigDecimal cantidadComponente;
    @Column(name = "stockafecta")
    private Short stockafecta;
    @Column(name = "noedit")
    private Boolean noedit;
    @Column(name = "merma_porchist")
    private BigDecimal mermaPorchist;
    @Column(name = "coef_id")
    private Short coefId;
    @Column(name = "afecta_costo")
    private Character afectaCosto;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 15)
    @Column(name = "audit_uk")
    private String auditUk;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @Column(name = "costounitario")
    private BigDecimal costounitario;
    @Column(name = "descuentomontoTax")
    private BigDecimal descuentomontoTax;
    @Column(name = "descuentomonto")
    private BigDecimal descuentomonto;
    @Column(name = "totalbruto")
    private BigDecimal totalbruto;
    @Size(max = 8)
    @Column(name = "centrocosto")
    private String centrocosto;
    @Size(max = 50)
    @Column(name = "centrocostonombre")
    private String centrocostonombre;
    @Size(max = 2)
    @Column(name = "empresaunidad")
    private String empresaunidad;
    @Size(max = 50)
    @Column(name = "empresaunidadnombre")
    private String empresaunidadnombre;
    @Size(max = 2)
    @Column(name = "empresaunidaddest")
    private String empresaunidaddest;
    @Size(max = 50)
    @Column(name = "empresaunidaddestnombre")
    private String empresaunidaddestnombre;
    @Size(max = 8)
    @Column(name = "crm_proyecto")
    private String crmProyecto;
    @Size(max = 50)
    @Column(name = "crm_proyectonombre")
    private String crmProyectonombre;
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
    @Size(max = 13)
    @Column(name = "codigobarra")
    private String codigobarra;
    @Column(name = "cubicaje")
    private BigDecimal cubicaje;
    @Size(max = 2)
    @Column(name = "itemproductotipo")
    private String itemproductotipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "itemnombre")
    private String itemnombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemelemento")
    private Character itemelemento;
    @Column(name = "idfamiliagrupo")
    private Long idfamiliagrupo;
    @Size(max = 10)
    @Column(name = "itemmedida2")
    private String itemmedida2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conversion2")
    private BigDecimal conversion2;
    @Size(max = 5)
    @Column(name = "itemcolor")
    private String itemcolor;
    @Size(max = 5)
    @Column(name = "itemtalle")
    private String itemtalle;
    @Size(max = 5)
    @Column(name = "itemtalle2")
    private String itemtalle2;
    @Size(max = 5)
    @Column(name = "itemtalle3")
    private String itemtalle3;
    @Size(max = 5)
    @Column(name = "itemtalle4")
    private String itemtalle4;
    @Size(max = 5)
    @Column(name = "itembonificacion")
    private String itembonificacion;
    @Size(max = 2)
    @Column(name = "listaprecio")
    private String listaprecio;
    @Size(max = 4)
    @Column(name = "deposito")
    private String deposito;
    @Size(max = 30)
    @Column(name = "depositonombre")
    private String depositonombre;
    @Size(max = 4)
    @Column(name = "depdest")
    private String depdest;
    @Size(max = 30)
    @Column(name = "depdestnombre")
    private String depdestnombre;
    @Column(name = "limitedescuento")
    private BigDecimal limitedescuento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sucursal")
    private String sucursal;
    @Column(name = "id1_ctrllineacredito")
    private Boolean id1Ctrllineacredito;

    public ItemmovimientodetalleView() {
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdnro() {
        return idnro;
    }

    public void setIdnro(String idnro) {
        this.idnro = idnro;
    }

    public long getIditemmovimientodetalle() {
        return iditemmovimientodetalle;
    }

    public void setIditemmovimientodetalle(long iditemmovimientodetalle) {
        this.iditemmovimientodetalle = iditemmovimientodetalle;
    }

    public long getIditemmovimiento() {
        return iditemmovimiento;
    }

    public void setIditemmovimiento(long iditemmovimiento) {
        this.iditemmovimiento = iditemmovimiento;
    }

    public long getIdorden() {
        return idorden;
    }

    public void setIdorden(long idorden) {
        this.idorden = idorden;
    }

    public long getIditem() {
        return iditem;
    }

    public void setIditem(long iditem) {
        this.iditem = iditem;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public long getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(long iddeposito) {
        this.iddeposito = iddeposito;
    }

    public Long getIddepdest() {
        return iddepdest;
    }

    public void setIddepdest(Long iddepdest) {
        this.iddepdest = iddepdest;
    }

    public Long getIdlistaprecio() {
        return idlistaprecio;
    }

    public void setIdlistaprecio(Long idlistaprecio) {
        this.idlistaprecio = idlistaprecio;
    }

    public Long getIditemactivofijonro() {
        return iditemactivofijonro;
    }

    public void setIditemactivofijonro(Long iditemactivofijonro) {
        this.iditemactivofijonro = iditemactivofijonro;
    }

    public Long getIdcentrocosto() {
        return idcentrocosto;
    }

    public void setIdcentrocosto(Long idcentrocosto) {
        this.idcentrocosto = idcentrocosto;
    }

    public Long getIditemcolor() {
        return iditemcolor;
    }

    public void setIditemcolor(Long iditemcolor) {
        this.iditemcolor = iditemcolor;
    }

    public Long getIditemtalle() {
        return iditemtalle;
    }

    public void setIditemtalle(Long iditemtalle) {
        this.iditemtalle = iditemtalle;
    }

    public Long getIditembonificacion() {
        return iditembonificacion;
    }

    public void setIditembonificacion(Long iditembonificacion) {
        this.iditembonificacion = iditembonificacion;
    }

    public Long getIditemproductonro() {
        return iditemproductonro;
    }

    public void setIditemproductonro(Long iditemproductonro) {
        this.iditemproductonro = iditemproductonro;
    }

    public String getItemproductonro() {
        return itemproductonro;
    }

    public void setItemproductonro(String itemproductonro) {
        this.itemproductonro = itemproductonro;
    }

    public Date getItemproductonrovto() {
        return itemproductonrovto;
    }

    public void setItemproductonrovto(Date itemproductonrovto) {
        this.itemproductonrovto = itemproductonrovto;
    }

    public String getItemactivofijonro() {
        return itemactivofijonro;
    }

    public void setItemactivofijonro(String itemactivofijonro) {
        this.itemactivofijonro = itemactivofijonro;
    }

    public Long getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Long idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Long getIdctbejercicio() {
        return idctbejercicio;
    }

    public void setIdctbejercicio(Long idctbejercicio) {
        this.idctbejercicio = idctbejercicio;
    }

    public Long getIditemprod() {
        return iditemprod;
    }

    public void setIditemprod(Long iditemprod) {
        this.iditemprod = iditemprod;
    }

    public Long getIdempresaunidad() {
        return idempresaunidad;
    }

    public void setIdempresaunidad(Long idempresaunidad) {
        this.idempresaunidad = idempresaunidad;
    }

    public Long getIdempresaunidaddest() {
        return idempresaunidaddest;
    }

    public void setIdempresaunidaddest(Long idempresaunidaddest) {
        this.idempresaunidaddest = idempresaunidaddest;
    }

    public Long getIdcrmProyecto() {
        return idcrmProyecto;
    }

    public void setIdcrmProyecto(Long idcrmProyecto) {
        this.idcrmProyecto = idcrmProyecto;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public BigDecimal getCantidadpedido() {
        return cantidadpedido;
    }

    public void setCantidadpedido(BigDecimal cantidadpedido) {
        this.cantidadpedido = cantidadpedido;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getConversion() {
        return conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public String getItemmedida() {
        return itemmedida;
    }

    public void setItemmedida(String itemmedida) {
        this.itemmedida = itemmedida;
    }

    public BigDecimal getCantidadbonificacion() {
        return cantidadbonificacion;
    }

    public void setCantidadbonificacion(BigDecimal cantidadbonificacion) {
        this.cantidadbonificacion = cantidadbonificacion;
    }

    public BigDecimal getPreciobruto() {
        return preciobruto;
    }

    public void setPreciobruto(BigDecimal preciobruto) {
        this.preciobruto = preciobruto;
    }

    public BigDecimal getPreciobrutotax() {
        return preciobrutotax;
    }

    public void setPreciobrutotax(BigDecimal preciobrutotax) {
        this.preciobrutotax = preciobrutotax;
    }

    public BigDecimal getPrecioneto() {
        return precioneto;
    }

    public void setPrecioneto(BigDecimal precioneto) {
        this.precioneto = precioneto;
    }

    public BigDecimal getPrecionetotax() {
        return precionetotax;
    }

    public void setPrecionetotax(BigDecimal precionetotax) {
        this.precionetotax = precionetotax;
    }

    public BigDecimal getPreciolista() {
        return preciolista;
    }

    public void setPreciolista(BigDecimal preciolista) {
        this.preciolista = preciolista;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getLdescuento() {
        return ldescuento;
    }

    public void setLdescuento(BigDecimal ldescuento) {
        this.ldescuento = ldescuento;
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

    public BigDecimal getImpuestoporc() {
        return impuestoporc;
    }

    public void setImpuestoporc(BigDecimal impuestoporc) {
        this.impuestoporc = impuestoporc;
    }

    public BigDecimal getImpuestobaseimponible() {
        return impuestobaseimponible;
    }

    public void setImpuestobaseimponible(BigDecimal impuestobaseimponible) {
        this.impuestobaseimponible = impuestobaseimponible;
    }

    public BigDecimal getDisponible() {
        return disponible;
    }

    public void setDisponible(BigDecimal disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getCambiodia() {
        return cambiodia;
    }

    public void setCambiodia(BigDecimal cambiodia) {
        this.cambiodia = cambiodia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public BigDecimal getPendiente() {
        return pendiente;
    }

    public void setPendiente(BigDecimal pendiente) {
        this.pendiente = pendiente;
    }

    public BigDecimal getMermaPorc() {
        return mermaPorc;
    }

    public void setMermaPorc(BigDecimal mermaPorc) {
        this.mermaPorc = mermaPorc;
    }

    public BigDecimal getCantidadComponente() {
        return cantidadComponente;
    }

    public void setCantidadComponente(BigDecimal cantidadComponente) {
        this.cantidadComponente = cantidadComponente;
    }

    public Short getStockafecta() {
        return stockafecta;
    }

    public void setStockafecta(Short stockafecta) {
        this.stockafecta = stockafecta;
    }

    public Boolean getNoedit() {
        return noedit;
    }

    public void setNoedit(Boolean noedit) {
        this.noedit = noedit;
    }

    public BigDecimal getMermaPorchist() {
        return mermaPorchist;
    }

    public void setMermaPorchist(BigDecimal mermaPorchist) {
        this.mermaPorchist = mermaPorchist;
    }

    public Short getCoefId() {
        return coefId;
    }

    public void setCoefId(Short coefId) {
        this.coefId = coefId;
    }

    public Character getAfectaCosto() {
        return afectaCosto;
    }

    public void setAfectaCosto(Character afectaCosto) {
        this.afectaCosto = afectaCosto;
    }

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getAuditUk() {
        return auditUk;
    }

    public void setAuditUk(String auditUk) {
        this.auditUk = auditUk;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public BigDecimal getCostounitario() {
        return costounitario;
    }

    public void setCostounitario(BigDecimal costounitario) {
        this.costounitario = costounitario;
    }

    public BigDecimal getDescuentomontoTax() {
        return descuentomontoTax;
    }

    public void setDescuentomontoTax(BigDecimal descuentomontoTax) {
        this.descuentomontoTax = descuentomontoTax;
    }

    public BigDecimal getDescuentomonto() {
        return descuentomonto;
    }

    public void setDescuentomonto(BigDecimal descuentomonto) {
        this.descuentomonto = descuentomonto;
    }

    public BigDecimal getTotalbruto() {
        return totalbruto;
    }

    public void setTotalbruto(BigDecimal totalbruto) {
        this.totalbruto = totalbruto;
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

    public String getEmpresaunidaddest() {
        return empresaunidaddest;
    }

    public void setEmpresaunidaddest(String empresaunidaddest) {
        this.empresaunidaddest = empresaunidaddest;
    }

    public String getEmpresaunidaddestnombre() {
        return empresaunidaddestnombre;
    }

    public void setEmpresaunidaddestnombre(String empresaunidaddestnombre) {
        this.empresaunidaddestnombre = empresaunidaddestnombre;
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

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public BigDecimal getCubicaje() {
        return cubicaje;
    }

    public void setCubicaje(BigDecimal cubicaje) {
        this.cubicaje = cubicaje;
    }

    public String getItemproductotipo() {
        return itemproductotipo;
    }

    public void setItemproductotipo(String itemproductotipo) {
        this.itemproductotipo = itemproductotipo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemnombre() {
        return itemnombre;
    }

    public void setItemnombre(String itemnombre) {
        this.itemnombre = itemnombre;
    }

    public Character getItemelemento() {
        return itemelemento;
    }

    public void setItemelemento(Character itemelemento) {
        this.itemelemento = itemelemento;
    }

    public Long getIdfamiliagrupo() {
        return idfamiliagrupo;
    }

    public void setIdfamiliagrupo(Long idfamiliagrupo) {
        this.idfamiliagrupo = idfamiliagrupo;
    }

    public String getItemmedida2() {
        return itemmedida2;
    }

    public void setItemmedida2(String itemmedida2) {
        this.itemmedida2 = itemmedida2;
    }

    public BigDecimal getConversion2() {
        return conversion2;
    }

    public void setConversion2(BigDecimal conversion2) {
        this.conversion2 = conversion2;
    }

    public String getItemcolor() {
        return itemcolor;
    }

    public void setItemcolor(String itemcolor) {
        this.itemcolor = itemcolor;
    }

    public String getItemtalle() {
        return itemtalle;
    }

    public void setItemtalle(String itemtalle) {
        this.itemtalle = itemtalle;
    }

    public String getItemtalle2() {
        return itemtalle2;
    }

    public void setItemtalle2(String itemtalle2) {
        this.itemtalle2 = itemtalle2;
    }

    public String getItemtalle3() {
        return itemtalle3;
    }

    public void setItemtalle3(String itemtalle3) {
        this.itemtalle3 = itemtalle3;
    }

    public String getItemtalle4() {
        return itemtalle4;
    }

    public void setItemtalle4(String itemtalle4) {
        this.itemtalle4 = itemtalle4;
    }

    public String getItembonificacion() {
        return itembonificacion;
    }

    public void setItembonificacion(String itembonificacion) {
        this.itembonificacion = itembonificacion;
    }

    public String getListaprecio() {
        return listaprecio;
    }

    public void setListaprecio(String listaprecio) {
        this.listaprecio = listaprecio;
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

    public String getDepdest() {
        return depdest;
    }

    public void setDepdest(String depdest) {
        this.depdest = depdest;
    }

    public String getDepdestnombre() {
        return depdestnombre;
    }

    public void setDepdestnombre(String depdestnombre) {
        this.depdestnombre = depdestnombre;
    }

    public BigDecimal getLimitedescuento() {
        return limitedescuento;
    }

    public void setLimitedescuento(BigDecimal limitedescuento) {
        this.limitedescuento = limitedescuento;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Boolean getId1Ctrllineacredito() {
        return id1Ctrllineacredito;
    }

    public void setId1Ctrllineacredito(Boolean id1Ctrllineacredito) {
        this.id1Ctrllineacredito = id1Ctrllineacredito;
    }
    
}
