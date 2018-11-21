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
import javax.persistence.Lob;
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
@Table(name = "gi_fraccion_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiFraccionView.findAll",            query = "SELECT g FROM GiFraccionView g where g.idempresa = :idempresa and noappmovil <> 1 order by g.nombre"),
    @NamedQuery(name = "GiFraccionView.findByIdgiFraccion", query = "SELECT g FROM GiFraccionView g WHERE g.idgiFraccion = :idgiFraccion"),
    @NamedQuery(name = "GiFraccionView.findByIdempresa",    query = "SELECT g FROM GiFraccionView g WHERE g.idempresa = :idempresa  order by g.nombre"),
    @NamedQuery(name = "GiFraccionView.findByProvincia",    query = "SELECT g FROM GiFraccionView g WHERE g.idempresa = :idempresa and g.provincia = :provincia  and noappmovil <> 1  order by g.nombre"),
    @NamedQuery(name = "GiFraccionView.findByCodigo", query = "SELECT g FROM GiFraccionView g WHERE g.idempresa = :idempresa and g.codigo = :codigo"),
    @NamedQuery(name = "GiFraccionView.findByEstado", query = "SELECT g FROM GiFraccionView g WHERE g.idempresa = :idempresa and g.estado = :estado  order by g.nombre"),
    @NamedQuery(name = "GiFraccionView.findByGiFracciontipo", query = "SELECT g FROM GiFraccionView g WHERE g.idempresa = :idempresa and g.giFracciontipo = :giFracciontipo  order by g.nombre")}) 
public class GiFraccionView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idgi_fraccion")
    private long idgiFraccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Column(name = "idpais")
    private Long idpais;
    @Column(name = "idciudad")
    private Long idciudad;
    @Column(name = "idbarrio")
    private Long idbarrio;
    @Column(name = "idgi_fracciontipo")
    private Long idgiFracciontipo;
    @Column(name = "idcentrocosto")
    private Long idcentrocosto;
    @Column(name = "idctbcuentafraccion")
    private Long idctbcuentafraccion;
    @Column(name = "idctbcuentacliente")
    private Long idctbcuentacliente;
    @Column(name = "idctbcuentavta")
    private Long idctbcuentavta;
    @Column(name = "idctbcuentacosto")
    private Long idctbcuentacosto;
    @Column(name = "idctbcuentainteresmora")
    private Long idctbcuentainteresmora;
    @Column(name = "idctbcuentadescuento")
    private Long idctbcuentadescuento;
    @Column(name = "idctbcuentagastocobranza")
    private Long idctbcuentagastocobranza;
    @Column(name = "iddeposito")
    private Long iddeposito;
    @Column(name = "iditem")
    private Long iditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "superficie_m2")
    private BigDecimal superficieM2;
    @Size(max = 30)
    @Column(name = "nrofinca")
    private String nrofinca;
    @Size(max = 20)
    @Column(name = "nroasiento")
    private String nroasiento;
    @Size(max = 20)
    @Column(name = "nropadron")
    private String nropadron;
    @Size(max = 20)
    @Column(name = "nroseccion")
    private String nroseccion;
    @Size(max = 20)
    @Column(name = "nroaprobacion")
    private String nroaprobacion;
    @Column(name = "fechaaprobacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaaprobacion;
    @Size(max = 20)
    @Column(name = "nroctactecatastral")
    private String nroctactecatastral;
    @Column(name = "fechactactecatastral")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechactactecatastral;
    @Column(name = "estado")
    private Character estado;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
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
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @Column(name = "gen_factura_porvtalote")
    private Boolean genFacturaPorvtalote;
    @Size(max = 5)
    @Column(name = "gi_fracciontipo")
    private String giFracciontipo;
    @Size(max = 50)
    @Column(name = "gi_fracciontiponombre")
    private String giFracciontiponombre;
    @Size(max = 4)
    @Column(name = "pais")
    private String pais;
    @Size(max = 4)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 50)
    @Column(name = "provincianombre")
    private String provincianombre;
    @Size(max = 4)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 50)
    @Column(name = "ciudadnombre")
    private String ciudadnombre;
    @Size(max = 8)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 50)
    @Column(name = "barrionombre")
    private String barrionombre;
    @Size(max = 8)
    @Column(name = "centrocosto")
    private String centrocosto;
    @Size(max = 50)
    @Column(name = "centrocostonombre")
    private String centrocostonombre;
    @Size(max = 15)
    @Column(name = "ctbcuentafraccion")
    private String ctbcuentafraccion;
    @Size(max = 50)
    @Column(name = "ctbcuentafraccionnombre")
    private String ctbcuentafraccionnombre;
    @Size(max = 15)
    @Column(name = "ctbcuentacliente")
    private String ctbcuentacliente;
    @Size(max = 50)
    @Column(name = "ctbcuentaclientenombre")
    private String ctbcuentaclientenombre;
    @Size(max = 15)
    @Column(name = "ctbcuentavta")
    private String ctbcuentavta;
    @Size(max = 50)
    @Column(name = "ctbcuentavtanombre")
    private String ctbcuentavtanombre;
    @Size(max = 15)
    @Column(name = "ctbcuentacosto")
    private String ctbcuentacosto;
    @Size(max = 50)
    @Column(name = "ctbcuentacostonombre")
    private String ctbcuentacostonombre;
    @Size(max = 15)
    @Column(name = "ctbcuentainteresmora")
    private String ctbcuentainteresmora;
    @Size(max = 50)
    @Column(name = "ctbcuentainteresmoranombre")
    private String ctbcuentainteresmoranombre;
    @Size(max = 15)
    @Column(name = "ctbcuentadescuento")
    private String ctbcuentadescuento;
    @Size(max = 50)
    @Column(name = "ctbcuentadescuentonombre")
    private String ctbcuentadescuentonombre;
    @Size(max = 15)
    @Column(name = "ctbcuentagastocobranza")
    private String ctbcuentagastocobranza;
    @Size(max = 50)
    @Column(name = "ctbcuentagastocobranzanombre")
    private String ctbcuentagastocobranzanombre;
    @Size(max = 4)
    @Column(name = "deposito")
    private String deposito;
    @Size(max = 30)
    @Column(name = "depositonombre")
    private String depositonombre;
    @Size(max = 16)
    @Column(name = "item")
    private String item;
    @Column(name = "itemelemento")
    private Character itemelemento;
    @Size(max = 50)
    @Column(name = "itemnombre")
    private String itemnombre;

    public GiFraccionView() {
    }

    public long getIdgiFraccion() {
        return idgiFraccion;
    }

    public void setIdgiFraccion(long idgiFraccion) {
        this.idgiFraccion = idgiFraccion;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
    }

    public Long getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Long idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Long getIdgiFracciontipo() {
        return idgiFracciontipo;
    }

    public void setIdgiFracciontipo(Long idgiFracciontipo) {
        this.idgiFracciontipo = idgiFracciontipo;
    }

    public Long getIdcentrocosto() {
        return idcentrocosto;
    }

    public void setIdcentrocosto(Long idcentrocosto) {
        this.idcentrocosto = idcentrocosto;
    }

    public Long getIdctbcuentafraccion() {
        return idctbcuentafraccion;
    }

    public void setIdctbcuentafraccion(Long idctbcuentafraccion) {
        this.idctbcuentafraccion = idctbcuentafraccion;
    }

    public Long getIdctbcuentacliente() {
        return idctbcuentacliente;
    }

    public void setIdctbcuentacliente(Long idctbcuentacliente) {
        this.idctbcuentacliente = idctbcuentacliente;
    }

    public Long getIdctbcuentavta() {
        return idctbcuentavta;
    }

    public void setIdctbcuentavta(Long idctbcuentavta) {
        this.idctbcuentavta = idctbcuentavta;
    }

    public Long getIdctbcuentacosto() {
        return idctbcuentacosto;
    }

    public void setIdctbcuentacosto(Long idctbcuentacosto) {
        this.idctbcuentacosto = idctbcuentacosto;
    }

    public Long getIdctbcuentainteresmora() {
        return idctbcuentainteresmora;
    }

    public void setIdctbcuentainteresmora(Long idctbcuentainteresmora) {
        this.idctbcuentainteresmora = idctbcuentainteresmora;
    }

    public Long getIdctbcuentadescuento() {
        return idctbcuentadescuento;
    }

    public void setIdctbcuentadescuento(Long idctbcuentadescuento) {
        this.idctbcuentadescuento = idctbcuentadescuento;
    }

    public Long getIdctbcuentagastocobranza() {
        return idctbcuentagastocobranza;
    }

    public void setIdctbcuentagastocobranza(Long idctbcuentagastocobranza) {
        this.idctbcuentagastocobranza = idctbcuentagastocobranza;
    }

    public Long getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(Long iddeposito) {
        this.iddeposito = iddeposito;
    }

    public Long getIditem() {
        return iditem;
    }

    public void setIditem(Long iditem) {
        this.iditem = iditem;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSuperficieM2() {
        return superficieM2;
    }

    public void setSuperficieM2(BigDecimal superficieM2) {
        this.superficieM2 = superficieM2;
    }

    public String getNrofinca() {
        return nrofinca;
    }

    public void setNrofinca(String nrofinca) {
        this.nrofinca = nrofinca;
    }

    public String getNroasiento() {
        return nroasiento;
    }

    public void setNroasiento(String nroasiento) {
        this.nroasiento = nroasiento;
    }

    public String getNropadron() {
        return nropadron;
    }

    public void setNropadron(String nropadron) {
        this.nropadron = nropadron;
    }

    public String getNroseccion() {
        return nroseccion;
    }

    public void setNroseccion(String nroseccion) {
        this.nroseccion = nroseccion;
    }

    public String getNroaprobacion() {
        return nroaprobacion;
    }

    public void setNroaprobacion(String nroaprobacion) {
        this.nroaprobacion = nroaprobacion;
    }

    public Date getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(Date fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    public String getNroctactecatastral() {
        return nroctactecatastral;
    }

    public void setNroctactecatastral(String nroctactecatastral) {
        this.nroctactecatastral = nroctactecatastral;
    }

    public Date getFechactactecatastral() {
        return fechactactecatastral;
    }

    public void setFechactactecatastral(Date fechactactecatastral) {
        this.fechactactecatastral = fechactactecatastral;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Boolean getGenFacturaPorvtalote() {
        return genFacturaPorvtalote;
    }

    public void setGenFacturaPorvtalote(Boolean genFacturaPorvtalote) {
        this.genFacturaPorvtalote = genFacturaPorvtalote;
    }

    public String getGiFracciontipo() {
        return giFracciontipo;
    }

    public void setGiFracciontipo(String giFracciontipo) {
        this.giFracciontipo = giFracciontipo;
    }

    public String getGiFracciontiponombre() {
        return giFracciontiponombre;
    }

    public void setGiFracciontiponombre(String giFracciontiponombre) {
        this.giFracciontiponombre = giFracciontiponombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincianombre() {
        return provincianombre;
    }

    public void setProvincianombre(String provincianombre) {
        this.provincianombre = provincianombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudadnombre() {
        return ciudadnombre;
    }

    public void setCiudadnombre(String ciudadnombre) {
        this.ciudadnombre = ciudadnombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getBarrionombre() {
        return barrionombre;
    }

    public void setBarrionombre(String barrionombre) {
        this.barrionombre = barrionombre;
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

    public String getCtbcuentafraccion() {
        return ctbcuentafraccion;
    }

    public void setCtbcuentafraccion(String ctbcuentafraccion) {
        this.ctbcuentafraccion = ctbcuentafraccion;
    }

    public String getCtbcuentafraccionnombre() {
        return ctbcuentafraccionnombre;
    }

    public void setCtbcuentafraccionnombre(String ctbcuentafraccionnombre) {
        this.ctbcuentafraccionnombre = ctbcuentafraccionnombre;
    }

    public String getCtbcuentacliente() {
        return ctbcuentacliente;
    }

    public void setCtbcuentacliente(String ctbcuentacliente) {
        this.ctbcuentacliente = ctbcuentacliente;
    }

    public String getCtbcuentaclientenombre() {
        return ctbcuentaclientenombre;
    }

    public void setCtbcuentaclientenombre(String ctbcuentaclientenombre) {
        this.ctbcuentaclientenombre = ctbcuentaclientenombre;
    }

    public String getCtbcuentavta() {
        return ctbcuentavta;
    }

    public void setCtbcuentavta(String ctbcuentavta) {
        this.ctbcuentavta = ctbcuentavta;
    }

    public String getCtbcuentavtanombre() {
        return ctbcuentavtanombre;
    }

    public void setCtbcuentavtanombre(String ctbcuentavtanombre) {
        this.ctbcuentavtanombre = ctbcuentavtanombre;
    }

    public String getCtbcuentacosto() {
        return ctbcuentacosto;
    }

    public void setCtbcuentacosto(String ctbcuentacosto) {
        this.ctbcuentacosto = ctbcuentacosto;
    }

    public String getCtbcuentacostonombre() {
        return ctbcuentacostonombre;
    }

    public void setCtbcuentacostonombre(String ctbcuentacostonombre) {
        this.ctbcuentacostonombre = ctbcuentacostonombre;
    }

    public String getCtbcuentainteresmora() {
        return ctbcuentainteresmora;
    }

    public void setCtbcuentainteresmora(String ctbcuentainteresmora) {
        this.ctbcuentainteresmora = ctbcuentainteresmora;
    }

    public String getCtbcuentainteresmoranombre() {
        return ctbcuentainteresmoranombre;
    }

    public void setCtbcuentainteresmoranombre(String ctbcuentainteresmoranombre) {
        this.ctbcuentainteresmoranombre = ctbcuentainteresmoranombre;
    }

    public String getCtbcuentadescuento() {
        return ctbcuentadescuento;
    }

    public void setCtbcuentadescuento(String ctbcuentadescuento) {
        this.ctbcuentadescuento = ctbcuentadescuento;
    }

    public String getCtbcuentadescuentonombre() {
        return ctbcuentadescuentonombre;
    }

    public void setCtbcuentadescuentonombre(String ctbcuentadescuentonombre) {
        this.ctbcuentadescuentonombre = ctbcuentadescuentonombre;
    }

    public String getCtbcuentagastocobranza() {
        return ctbcuentagastocobranza;
    }

    public void setCtbcuentagastocobranza(String ctbcuentagastocobranza) {
        this.ctbcuentagastocobranza = ctbcuentagastocobranza;
    }

    public String getCtbcuentagastocobranzanombre() {
        return ctbcuentagastocobranzanombre;
    }

    public void setCtbcuentagastocobranzanombre(String ctbcuentagastocobranzanombre) {
        this.ctbcuentagastocobranzanombre = ctbcuentagastocobranzanombre;
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

    public Character getItemelemento() {
        return itemelemento;
    }

    public void setItemelemento(Character itemelemento) {
        this.itemelemento = itemelemento;
    }

    public String getItemnombre() {
        return itemnombre;
    }

    public void setItemnombre(String itemnombre) {
        this.itemnombre = itemnombre;
    }
}
