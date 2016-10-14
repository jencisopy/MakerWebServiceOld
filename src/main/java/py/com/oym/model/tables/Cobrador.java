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
@Table(name = "cobrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobrador.findAll", query = "SELECT c FROM Cobrador c"),
    @NamedQuery(name = "Cobrador.findByIdcobrador", query = "SELECT c FROM Cobrador c WHERE c.idcobrador = :idcobrador"),
    @NamedQuery(name = "Cobrador.findByIdempresa", query = "SELECT c FROM Cobrador c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Cobrador.findByCodigo", query = "SELECT c FROM Cobrador c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cobrador.findByPersonanombre", query = "SELECT c FROM Cobrador c WHERE c.personanombre = :personanombre"),
    @NamedQuery(name = "Cobrador.findByComision", query = "SELECT c FROM Cobrador c WHERE c.comision = :comision"),
    @NamedQuery(name = "Cobrador.findByInactivo", query = "SELECT c FROM Cobrador c WHERE c.inactivo = :inactivo"),
    @NamedQuery(name = "Cobrador.findByFechareplicacion", query = "SELECT c FROM Cobrador c WHERE c.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Cobrador.findByFechamodificacion", query = "SELECT c FROM Cobrador c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cobrador.findByFechacreacion", query = "SELECT c FROM Cobrador c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Cobrador.findByFirma", query = "SELECT c FROM Cobrador c WHERE c.firma = :firma"),
    @NamedQuery(name = "Cobrador.findByAppuser", query = "SELECT c FROM Cobrador c WHERE c.appuser = :appuser")})
public class Cobrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcobrador")
    private Long idcobrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 50)
    @Column(name = "personanombre")
    private String personanombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "comision")
    private BigDecimal comision;
    @Column(name = "inactivo")
    private Boolean inactivo;
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
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @OneToMany(mappedBy = "idcobrador")
    private List<Ctacte> ctacteList;

    public Cobrador() {
    }

    public Cobrador(Long idcobrador) {
        this.idcobrador = idcobrador;
    }

    public Cobrador(Long idcobrador, long idempresa, String codigo, BigDecimal comision) {
        this.idcobrador = idcobrador;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.comision = comision;
    }

    public Long getIdcobrador() {
        return idcobrador;
    }

    public void setIdcobrador(Long idcobrador) {
        this.idcobrador = idcobrador;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPersonanombre() {
        return personanombre;
    }

    public void setPersonanombre(String personanombre) {
        this.personanombre = personanombre;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
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

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcobrador != null ? idcobrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobrador)) {
            return false;
        }
        Cobrador other = (Cobrador) object;
        if ((this.idcobrador == null && other.idcobrador != null) || (this.idcobrador != null && !this.idcobrador.equals(other.idcobrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Cobrador[ idcobrador=" + idcobrador + " ]";
    }
    
}
