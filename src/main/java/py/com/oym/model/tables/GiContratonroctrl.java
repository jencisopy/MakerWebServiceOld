/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
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
@Table(name = "gi_contratonroctrl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiContratonroctrl.findAll", query = "SELECT g FROM GiContratonroctrl g")})
public class GiContratonroctrl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_contratonroctrl")
    private Long idgiContratonroctrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fraccion")
    private long fraccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ultimonro")
    private String ultimonro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;

    public GiContratonroctrl() {
    }

    public GiContratonroctrl(Long idgiContratonroctrl) {
        this.idgiContratonroctrl = idgiContratonroctrl;
    }

    public GiContratonroctrl(Long idgiContratonroctrl, long idempresa, long fraccion, String ultimonro, Date fechacreacion, Date fechamodificacion) {
        this.idgiContratonroctrl = idgiContratonroctrl;
        this.idempresa = idempresa;
        this.fraccion = fraccion;
        this.ultimonro = ultimonro;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public Long getIdgiContratonroctrl() {
        return idgiContratonroctrl;
    }

    public void setIdgiContratonroctrl(Long idgiContratonroctrl) {
        this.idgiContratonroctrl = idgiContratonroctrl;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getFraccion() {
        return fraccion;
    }

    public void setFraccion(long fraccion) {
        this.fraccion = fraccion;
    }

    public String getUltimonro() {
        return ultimonro;
    }

    public void setUltimonro(String ultimonro) {
        this.ultimonro = ultimonro;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiContratonroctrl != null ? idgiContratonroctrl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiContratonroctrl)) {
            return false;
        }
        GiContratonroctrl other = (GiContratonroctrl) object;
        if ((this.idgiContratonroctrl == null && other.idgiContratonroctrl != null) || (this.idgiContratonroctrl != null && !this.idgiContratonroctrl.equals(other.idgiContratonroctrl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.exceptions.GiContratonroctrl[ idgiContratonroctrl=" + idgiContratonroctrl + " ]";
    }
    
}
