/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jenci_000
 */
@Entity
@Table(name = "gi_manzana")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiManzana.findAll", query = "SELECT g FROM GiManzana g"),
    @NamedQuery(name = "GiManzana.findByIdgiManzana", query = "SELECT g FROM GiManzana g WHERE g.idgiManzana = :idgiManzana"),
    @NamedQuery(name = "GiManzana.findByCodigo", query = "SELECT g FROM GiManzana g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "GiManzana.findBySuperficieM2", query = "SELECT g FROM GiManzana g WHERE g.superficieM2 = :superficieM2"),
    @NamedQuery(name = "GiManzana.findByLotesCnt", query = "SELECT g FROM GiManzana g WHERE g.lotesCnt = :lotesCnt"),
    @NamedQuery(name = "GiManzana.findByFechareplicacion", query = "SELECT g FROM GiManzana g WHERE g.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "GiManzana.findByFechamodificacion", query = "SELECT g FROM GiManzana g WHERE g.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "GiManzana.findByFechacreacion", query = "SELECT g FROM GiManzana g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "GiManzana.findByFirma", query = "SELECT g FROM GiManzana g WHERE g.firma = :firma"),
    @NamedQuery(name = "GiManzana.findByAppuser", query = "SELECT g FROM GiManzana g WHERE g.appuser = :appuser")})
public class GiManzana implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_manzana")
    private Long idgiManzana;
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

    @JoinColumn(name = "idgi_fraccion", referencedColumnName = "idgi_fraccion")
    @ManyToOne(optional = false)
    private GiFraccion giFraccion;

    public GiManzana() {
    }

    public GiManzana(Long idgiManzana) {
        this.idgiManzana = idgiManzana;
    }

    public GiManzana(Long idgiManzana, String codigo) {
        this.idgiManzana = idgiManzana;
        this.codigo = codigo;
    }

    public Long getIdgiManzana() {
        return idgiManzana;
    }

    public void setIdgiManzana(Long idgiManzana) {
        this.idgiManzana = idgiManzana;
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

    public GiFraccion getGiFraccion() {
        return giFraccion;
    }

    public void setGiFraccion(GiFraccion giFraccion) {
        this.giFraccion = giFraccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiManzana != null ? idgiManzana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiManzana)) {
            return false;
        }
        GiManzana other = (GiManzana) object;
        if ((this.idgiManzana == null && other.idgiManzana != null) || (this.idgiManzana != null && !this.idgiManzana.equals(other.idgiManzana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.GiManzana[ idgiManzana=" + idgiManzana + " ]";
    }
    
}
