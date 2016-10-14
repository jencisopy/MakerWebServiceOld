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
 * @author jenci_000
 */
@Entity
@Table(name = "gi_manzana_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiManzanaView.findAll",           query = "SELECT g FROM GiManzanaView g WHERE g.idempresa   = :idempresa"),
    @NamedQuery(name = "GiManzanaView.findByIdgiManzana", query = "SELECT g FROM GiManzanaView g WHERE g.idgiManzana = :idgiManzana"),
    @NamedQuery(name = "GiManzanaView.findByIdgiFraccion",query = "SELECT g FROM GiManzanaView g WHERE g.idgiFraccion = :idgiFraccion"),
    @NamedQuery(name = "GiManzanaView.findByCodigo",      query = "SELECT g FROM GiManzanaView g WHERE g.idempresa = :idempresa and g.giFraccion = :giFraccion and g.codigo = :codigo"),
    @NamedQuery(name = "GiManzanaView.findByGiFraccion",  query = "SELECT g FROM GiManzanaView g WHERE g.idempresa = :idempresa and g.giFraccion = :giFraccion")})
public class GiManzanaView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @NotNull
    @Column(name = "idgi_manzana")
    private long idgiManzana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_fraccion")
    private long idgiFraccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "superficie_m2")
    private BigDecimal superficieM2;
    @Column(name = "lotes_cnt")
    private Long lotesCnt;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gi_fraccion")
    private long giFraccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gi_fraccionnombre")
    private String giFraccionnombre;
    @Size(max = 5)
    @Column(name = "gi_fracciontipo")
    private String giFracciontipo;
    @Size(max = 50)
    @Column(name = "gi_fracciontiponombre")
    private String giFracciontiponombre;
    @Column(name = "estado")
    private Character estado;

    public GiManzanaView() {
    }

    public long getIdgiManzana() {
        return idgiManzana;
    }

    public void setIdgiManzana(long idgiManzana) {
        this.idgiManzana = idgiManzana;
    }

    public long getIdgiFraccion() {
        return idgiFraccion;
    }

    public void setIdgiFraccion(long idgiFraccion) {
        this.idgiFraccion = idgiFraccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getSuperficieM2() {
        return superficieM2;
    }

    public void setSuperficieM2(BigDecimal superficieM2) {
        this.superficieM2 = superficieM2;
    }

    public Long getLotesCnt() {
        return lotesCnt;
    }

    public void setLotesCnt(Long lotesCnt) {
        this.lotesCnt = lotesCnt;
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

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getGiFraccion() {
        return giFraccion;
    }

    public void setGiFraccion(long giFraccion) {
        this.giFraccion = giFraccion;
    }

    public String getGiFraccionnombre() {
        return giFraccionnombre;
    }

    public void setGiFraccionnombre(String giFraccionnombre) {
        this.giFraccionnombre = giFraccionnombre;
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
    
}
