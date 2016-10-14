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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gi_lotevtacuotaparam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLotevtacuotaparam.findAll", query = "SELECT g FROM GiLotevtacuotaparam g"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByIdgiLotevtacuotaparam", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.idgiLotevtacuotaparam = :idgiLotevtacuotaparam"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByCuotatipo", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.cuotatipo = :cuotatipo"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByMonto", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.monto = :monto"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByCuotasCnt", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.cuotasCnt = :cuotasCnt"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByIntervalo", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.intervalo = :intervalo"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByPrimervto", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.primervto = :primervto"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByTasamora", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.tasamora = :tasamora"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByFechamodificacion", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByFechacreacion", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByFirma", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.firma = :firma"),
    @NamedQuery(name = "GiLotevtacuotaparam.findByAppuser", query = "SELECT g FROM GiLotevtacuotaparam g WHERE g.appuser = :appuser")})
public class GiLotevtacuotaparam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "idgi_lotevtacuotaparam")
    private Long idgiLotevtacuotaparam;
    
    @Basic(optional = false)
    @JoinColumn(name = "idgi_lotevta", referencedColumnName = "idgi_lotevta")
    @ManyToOne
    private GiLotevta idgiLotevta;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotatipo")
    private short cuotatipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas_cnt")
    private short cuotasCnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intervalo")
    private short intervalo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "primervto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primervto;
    @Column(name = "tasamora")
    private BigDecimal tasamora;
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

    public GiLotevtacuotaparam() {
    }

    public GiLotevtacuotaparam(Long idgiLotevtacuotaparam) {
        this.idgiLotevtacuotaparam = idgiLotevtacuotaparam;
    }

    public GiLotevtacuotaparam(Long idgiLotevtacuotaparam, short cuotatipo, BigDecimal monto, short cuotasCnt, short intervalo, Date primervto) {
        this.idgiLotevtacuotaparam = idgiLotevtacuotaparam;
        this.cuotatipo = cuotatipo;
        this.monto = monto;
        this.cuotasCnt = cuotasCnt;
        this.intervalo = intervalo;
        this.primervto = primervto;
    }

    public Long getIdgiLotevtacuotaparam() {
        return idgiLotevtacuotaparam;
    }

    public void setIdgiLotevtacuotaparam(Long idgiLotevtacuotaparam) {
        this.idgiLotevtacuotaparam = idgiLotevtacuotaparam;
    }

    public short getCuotatipo() {
        return cuotatipo;
    }

    public void setCuotatipo(short cuotatipo) {
        this.cuotatipo = cuotatipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public short getCuotasCnt() {
        return cuotasCnt;
    }

    public void setCuotasCnt(short cuotasCnt) {
        this.cuotasCnt = cuotasCnt;
    }

    public short getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(short intervalo) {
        this.intervalo = intervalo;
    }

    public Date getPrimervto() {
        return primervto;
    }

    public void setPrimervto(Date primervto) {
        this.primervto = primervto;
    }

    public BigDecimal getTasamora() {
        return tasamora;
    }

    public void setTasamora(BigDecimal tasamora) {
        this.tasamora = tasamora;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiLotevtacuotaparam != null ? idgiLotevtacuotaparam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLotevtacuotaparam)) {
            return false;
        }
        GiLotevtacuotaparam other = (GiLotevtacuotaparam) object;
        if ((this.idgiLotevtacuotaparam == null && other.idgiLotevtacuotaparam != null) || (this.idgiLotevtacuotaparam != null && !this.idgiLotevtacuotaparam.equals(other.idgiLotevtacuotaparam))) {
            return false;
        }
        return true;
    }

    public GiLotevta getIdgiLotevta() {
        return idgiLotevta;
    }

    public void setIdgiLotevta(GiLotevta idgiLotevta) {
        this.idgiLotevta = idgiLotevta;
    }

    
    
    @Override
    public String toString() {
        return "py.com.oym.webservices.model.GiLotevtacuotaparam[ idgiLotevtacuotaparam=" + idgiLotevtacuotaparam + " ]";
    }
}
