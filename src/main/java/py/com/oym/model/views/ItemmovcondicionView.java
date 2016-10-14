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
@Table(name = "itemmovcondicion_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemmovcondicionView.findAll", query = "SELECT i FROM ItemmovcondicionView i where i.idempresa = :idempresa and i.inactivo = false"),
    @NamedQuery(name = "ItemmovcondicionView.findByIditemmovcondicion", query = "SELECT i FROM ItemmovcondicionView i WHERE i.iditemmovcondicion = :iditemmovcondicion"),
    @NamedQuery(name = "ItemmovcondicionView.findByIdempresa", query = "SELECT i FROM ItemmovcondicionView i WHERE i.idempresa = :idempresa"),
    @NamedQuery(name = "ItemmovcondicionView.findByCodigo",    query = "SELECT i FROM ItemmovcondicionView i WHERE i.idempresa = :idempresa and i.codigo = :codigo")})
public class ItemmovcondicionView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "iditemmovcondicion")
    private long iditemmovcondicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Column(name = "idctbcuenta")
    private Long idctbcuenta;
    @Column(name = "idctbcuentasocio")
    private Long idctbcuentasocio;
    @Column(name = "idctbcuentainteres")
    private Long idctbcuentainteres;
    @Column(name = "idctbcuentainteressocio")
    private Long idctbcuentainteressocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas")
    private long cuotas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasamoratoria")
    private BigDecimal tasamoratoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tolerancia")
    private long tolerancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chequetolerancia")
    private long chequetolerancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diascuota")
    private long diascuota;
    @Column(name = "primervtodias")
    private Long primervtodias;
    @Column(name = "vtosfijos")
    private Boolean vtosfijos;
    @Column(name = "inactivo")
    private Boolean inactivo;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 15)
    @Column(name = "ctbcuenta")
    private String ctbcuenta;
    @Size(max = 50)
    @Column(name = "ctbcuentanombre")
    private String ctbcuentanombre;
    @Size(max = 15)
    @Column(name = "ctbcuentasocio")
    private String ctbcuentasocio;
    @Size(max = 50)
    @Column(name = "ctbcuentasocionombre")
    private String ctbcuentasocionombre;
    @Size(max = 15)
    @Column(name = "ctbcuentainteres")
    private String ctbcuentainteres;
    @Size(max = 50)
    @Column(name = "ctbcuentainteresnombre")
    private String ctbcuentainteresnombre;
    @Size(max = 15)
    @Column(name = "ctbcuentainteressocio")
    private String ctbcuentainteressocio;
    @Size(max = 50)
    @Column(name = "ctbcuentainteressocionombre")
    private String ctbcuentainteressocionombre;

    public ItemmovcondicionView() {
    }

    public long getIditemmovcondicion() {
        return iditemmovcondicion;
    }

    public void setIditemmovcondicion(long iditemmovcondicion) {
        this.iditemmovcondicion = iditemmovcondicion;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Long getIdctbcuenta() {
        return idctbcuenta;
    }

    public void setIdctbcuenta(Long idctbcuenta) {
        this.idctbcuenta = idctbcuenta;
    }

    public Long getIdctbcuentasocio() {
        return idctbcuentasocio;
    }

    public void setIdctbcuentasocio(Long idctbcuentasocio) {
        this.idctbcuentasocio = idctbcuentasocio;
    }

    public Long getIdctbcuentainteres() {
        return idctbcuentainteres;
    }

    public void setIdctbcuentainteres(Long idctbcuentainteres) {
        this.idctbcuentainteres = idctbcuentainteres;
    }

    public Long getIdctbcuentainteressocio() {
        return idctbcuentainteressocio;
    }

    public void setIdctbcuentainteressocio(Long idctbcuentainteressocio) {
        this.idctbcuentainteressocio = idctbcuentainteressocio;
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

    public long getCuotas() {
        return cuotas;
    }

    public void setCuotas(long cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getTasamoratoria() {
        return tasamoratoria;
    }

    public void setTasamoratoria(BigDecimal tasamoratoria) {
        this.tasamoratoria = tasamoratoria;
    }

    public long getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(long tolerancia) {
        this.tolerancia = tolerancia;
    }

    public long getChequetolerancia() {
        return chequetolerancia;
    }

    public void setChequetolerancia(long chequetolerancia) {
        this.chequetolerancia = chequetolerancia;
    }

    public long getDiascuota() {
        return diascuota;
    }

    public void setDiascuota(long diascuota) {
        this.diascuota = diascuota;
    }

    public Long getPrimervtodias() {
        return primervtodias;
    }

    public void setPrimervtodias(Long primervtodias) {
        this.primervtodias = primervtodias;
    }

    public Boolean getVtosfijos() {
        return vtosfijos;
    }

    public void setVtosfijos(Boolean vtosfijos) {
        this.vtosfijos = vtosfijos;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
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

    public String getCtbcuentasocio() {
        return ctbcuentasocio;
    }

    public void setCtbcuentasocio(String ctbcuentasocio) {
        this.ctbcuentasocio = ctbcuentasocio;
    }

    public String getCtbcuentasocionombre() {
        return ctbcuentasocionombre;
    }

    public void setCtbcuentasocionombre(String ctbcuentasocionombre) {
        this.ctbcuentasocionombre = ctbcuentasocionombre;
    }

    public String getCtbcuentainteres() {
        return ctbcuentainteres;
    }

    public void setCtbcuentainteres(String ctbcuentainteres) {
        this.ctbcuentainteres = ctbcuentainteres;
    }

    public String getCtbcuentainteresnombre() {
        return ctbcuentainteresnombre;
    }

    public void setCtbcuentainteresnombre(String ctbcuentainteresnombre) {
        this.ctbcuentainteresnombre = ctbcuentainteresnombre;
    }

    public String getCtbcuentainteressocio() {
        return ctbcuentainteressocio;
    }

    public void setCtbcuentainteressocio(String ctbcuentainteressocio) {
        this.ctbcuentainteressocio = ctbcuentainteressocio;
    }

    public String getCtbcuentainteressocionombre() {
        return ctbcuentainteressocionombre;
    }

    public void setCtbcuentainteressocionombre(String ctbcuentainteressocionombre) {
        this.ctbcuentainteressocionombre = ctbcuentainteressocionombre;
    }
    
}
