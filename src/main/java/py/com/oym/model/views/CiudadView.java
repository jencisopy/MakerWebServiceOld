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
@Table(name = "ciudad_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CiudadView.findAll", query = "SELECT c FROM CiudadView c WHERE c.idempresa = :idempresa order by c.nombre")
    , @NamedQuery(name = "CiudadView.findByIdempresa", query = "SELECT c FROM CiudadView c WHERE c.idempresa = :idempresa")
    , @NamedQuery(name = "CiudadView.findByIdciudad", query = "SELECT c FROM CiudadView c WHERE c.idciudad = :idciudad")
    , @NamedQuery(name = "CiudadView.findByIdprovincia", query = "SELECT c FROM CiudadView c WHERE c.idprovincia = :idprovincia order by c.nombre")
    , @NamedQuery(name = "CiudadView.findByCodigo", query = "SELECT c FROM CiudadView c WHERE c.idempresa=:idempresa and c.codigo = :codigo")
    , @NamedQuery(name = "CiudadView.findByNombre", query = "SELECT c FROM CiudadView c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CiudadView.findByLatitud", query = "SELECT c FROM CiudadView c WHERE c.latitud = :latitud")
    , @NamedQuery(name = "CiudadView.findByLongitud", query = "SELECT c FROM CiudadView c WHERE c.longitud = :longitud")
    , @NamedQuery(name = "CiudadView.findByProvincia", query = "SELECT c FROM CiudadView c WHERE c.provincia = :provincia")
    , @NamedQuery(name = "CiudadView.findByProvincianombre", query = "SELECT c FROM CiudadView c WHERE c.provincianombre = :provincianombre")
    , @NamedQuery(name = "CiudadView.findByIdpais", query = "SELECT c FROM CiudadView c WHERE c.idpais = :idpais")})
public class CiudadView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idciudad")
    private long idciudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprovincia")
    private long idprovincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private BigDecimal latitud;
    @Column(name = "longitud")
    private BigDecimal longitud;
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
    @Size(min = 1, max = 4)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "provincianombre")
    private String provincianombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpais")
    private long idpais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "paisnombre")
    private String paisnombre;

    public CiudadView() {
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(long idciudad) {
        this.idciudad = idciudad;
    }

    public long getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(long idprovincia) {
        this.idprovincia = idprovincia;
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

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
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

    public long getIdpais() {
        return idpais;
    }

    public void setIdpais(long idpais) {
        this.idpais = idpais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPaisnombre() {
        return paisnombre;
    }

    public void setPaisnombre(String paisnombre) {
        this.paisnombre = paisnombre;
    }
    
}
