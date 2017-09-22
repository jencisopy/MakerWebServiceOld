/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "boca_cobranza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BocaCobranza.findAll", query = "SELECT b FROM BocaCobranza b")
    , @NamedQuery(name = "BocaCobranza.findByIdbocaCobranza", query = "SELECT b FROM BocaCobranza b WHERE b.idbocaCobranza = :idbocaCobranza")
    , @NamedQuery(name = "BocaCobranza.findByIdempresa", query = "SELECT b FROM BocaCobranza b WHERE b.idempresa = :idempresa")
    , @NamedQuery(name = "BocaCobranza.findByIdctactemovimientodetalle", query = "SELECT b FROM BocaCobranza b WHERE b.idctactemovimientodetalle = :idctactemovimientodetalle")
    , @NamedQuery(name = "BocaCobranza.findByNumeroOperacion", query = "SELECT b FROM BocaCobranza b WHERE b.idempresa = :idempresa and  b.numeroOperacion = :numeroOperacion")
    , @NamedQuery(name = "BocaCobranza.findByNumBoleta", query = "SELECT b FROM BocaCobranza b WHERE b.numBoleta = :numBoleta")
    , @NamedQuery(name = "BocaCobranza.findByDescripcionOperacion", query = "SELECT b FROM BocaCobranza b WHERE b.descripcionOperacion = :descripcionOperacion")
    , @NamedQuery(name = "BocaCobranza.findByMontocuota", query = "SELECT b FROM BocaCobranza b WHERE b.montocuota = :montocuota")
    , @NamedQuery(name = "BocaCobranza.findByMontointeres", query = "SELECT b FROM BocaCobranza b WHERE b.montointeres = :montointeres")
    , @NamedQuery(name = "BocaCobranza.findByMontorecargo", query = "SELECT b FROM BocaCobranza b WHERE b.montorecargo = :montorecargo")
    , @NamedQuery(name = "BocaCobranza.findByMontopagado", query = "SELECT b FROM BocaCobranza b WHERE b.montopagado = :montopagado")
    , @NamedQuery(name = "BocaCobranza.findByEstado", query = "SELECT b FROM BocaCobranza b WHERE b.estado = :estado")
    , @NamedQuery(name = "BocaCobranza.findByFechaPago", query = "SELECT b FROM BocaCobranza b WHERE b.fechaPago = :fechaPago")
    , @NamedQuery(name = "BocaCobranza.findByReferencia", query = "SELECT b FROM BocaCobranza b WHERE b.referencia = :referencia")
    , @NamedQuery(name = "BocaCobranza.findByFechacreacion", query = "SELECT b FROM BocaCobranza b WHERE b.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "BocaCobranza.findByFechamodificacion", query = "SELECT b FROM BocaCobranza b WHERE b.fechamodificacion = :fechamodificacion")
    , @NamedQuery(name = "BocaCobranza.findByFechareplicacion", query = "SELECT b FROM BocaCobranza b WHERE b.fechareplicacion = :fechareplicacion")
    , @NamedQuery(name = "BocaCobranza.findByFirma", query = "SELECT b FROM BocaCobranza b WHERE b.firma = :firma")
    , @NamedQuery(name = "BocaCobranza.findByAppuser", query = "SELECT b FROM BocaCobranza b WHERE b.appuser = :appuser")})
public class BocaCobranza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    @Basic(optional = false)
    @Column(name = "idboca_cobranza")
    private Long idbocaCobranza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Column(name = "idcaja")
    private Long idcaja;
    @Column(name = "idctactependientedetalle")
    private Long idctactependientedetalle;
    @Column(name = "idctactemovimientodetalle")
    private Long idctactemovimientodetalle;
    @Column(name = "numero_operacion")
    private Long numeroOperacion;
    @Size(max = 15)
    @Column(name = "num_boleta")
    private String numBoleta;
    @Size(max = 100)
    @Column(name = "descripcion_operacion")
    private String descripcionOperacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montocuota")
    private BigDecimal montocuota;
    @Column(name = "montointeres")
    private BigDecimal montointeres;
    @Column(name = "montorecargo")
    private BigDecimal montorecargo;
    @Column(name = "montopagado")
    private BigDecimal montopagado;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Size(max = 10)
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;

    public BocaCobranza() {
    }

    public BocaCobranza(Long idbocaCobranza) {
        this.idbocaCobranza = idbocaCobranza;
    }

    public BocaCobranza(Long idbocaCobranza, long idempresa, Date fechaPago) {
        this.idbocaCobranza = idbocaCobranza;
        this.idempresa = idempresa;
        this.fechaPago = fechaPago;
    }

    public Long getIdbocaCobranza() {
        return idbocaCobranza;
    }

    public void setIdbocaCobranza(Long idbocaCobranza) {
        this.idbocaCobranza = idbocaCobranza;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Long getIdctactemovimientodetalle() {
        return idctactemovimientodetalle;
    }

    public void setIdctactemovimientodetalle(Long idctactemovimientodetalle) {
        this.idctactemovimientodetalle = idctactemovimientodetalle;
    }

    public Long getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(Long numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getNumBoleta() {
        return numBoleta;
    }

    public void setNumBoleta(String numBoleta) {
        this.numBoleta = numBoleta;
    }

    public String getDescripcionOperacion() {
        return descripcionOperacion;
    }

    public void setDescripcionOperacion(String descripcionOperacion) {
        this.descripcionOperacion = descripcionOperacion;
    }

    public BigDecimal getMontocuota() {
        return montocuota;
    }

    public void setMontocuota(BigDecimal montocuota) {
        this.montocuota = montocuota;
    }

    public BigDecimal getMontointeres() {
        return montointeres;
    }

    public void setMontointeres(BigDecimal montointeres) {
        this.montointeres = montointeres;
    }

    public BigDecimal getMontorecargo() {
        return montorecargo;
    }

    public void setMontorecargo(BigDecimal montorecargo) {
        this.montorecargo = montorecargo;
    }

    public BigDecimal getMontopagado() {
        return montopagado;
    }

    public void setMontopagado(BigDecimal montopagado) {
        this.montopagado = montopagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbocaCobranza != null ? idbocaCobranza.hashCode() : 0);
        return hash;
    }

    public Long getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(Long idcaja) {
        this.idcaja = idcaja;
    }

    public Long getIdctactependientedetalle() {
        return idctactependientedetalle;
    }

    public void setIdctactependientedetalle(Long idctactependientedetalle) {
        this.idctactependientedetalle = idctactependientedetalle;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BocaCobranza)) {
            return false;
        }
        BocaCobranza other = (BocaCobranza) object;
        if ((this.idbocaCobranza == null && other.idbocaCobranza != null) || (this.idbocaCobranza != null && !this.idbocaCobranza.equals(other.idbocaCobranza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.BocaCobranza[ idbocaCobranza=" + idbocaCobranza + " ]";
    }
    
}
