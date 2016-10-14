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
import javax.persistence.Lob;
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
@Table(name = "ctacteruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctacteruta.findAll", query = "SELECT c FROM Ctacteruta c"),
    @NamedQuery(name = "Ctacteruta.findByIdctacteruta", query = "SELECT c FROM Ctacteruta c WHERE c.idctacteruta = :idctacteruta"),
    @NamedQuery(name = "Ctacteruta.findByIdempresa", query = "SELECT c FROM Ctacteruta c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Ctacteruta.findByCodigo", query = "SELECT c FROM Ctacteruta c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Ctacteruta.findByNombre", query = "SELECT c FROM Ctacteruta c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ctacteruta.findByMontominimo", query = "SELECT c FROM Ctacteruta c WHERE c.montominimo = :montominimo"),
    @NamedQuery(name = "Ctacteruta.findByInactivo", query = "SELECT c FROM Ctacteruta c WHERE c.inactivo = :inactivo"),
    @NamedQuery(name = "Ctacteruta.findByFechacreacion", query = "SELECT c FROM Ctacteruta c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Ctacteruta.findByFechamodificacion", query = "SELECT c FROM Ctacteruta c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ctacteruta.findByFechareplicacion", query = "SELECT c FROM Ctacteruta c WHERE c.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Ctacteruta.findByFirma", query = "SELECT c FROM Ctacteruta c WHERE c.firma = :firma"),
    @NamedQuery(name = "Ctacteruta.findByAppuser", query = "SELECT c FROM Ctacteruta c WHERE c.appuser = :appuser")})
public class Ctacteruta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctacteruta")
    private Long idctacteruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "montominimo")
    private BigDecimal montominimo;
    @Column(name = "inactivo")
    private Boolean inactivo;
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
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @OneToMany(mappedBy = "idctacteruta")
    private List<Ctacte> ctacteList;
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false)
    private Sucursal idsucursal;

    public Ctacteruta() {
    }

    public Ctacteruta(Long idctacteruta) {
        this.idctacteruta = idctacteruta;
    }

    public Ctacteruta(Long idctacteruta, long idempresa, long codigo, String nombre, BigDecimal montominimo, Date fechacreacion, Date fechamodificacion) {
        this.idctacteruta = idctacteruta;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.montominimo = montominimo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public Long getIdctacteruta() {
        return idctacteruta;
    }

    public void setIdctacteruta(Long idctacteruta) {
        this.idctacteruta = idctacteruta;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getMontominimo() {
        return montominimo;
    }

    public void setMontominimo(BigDecimal montominimo) {
        this.montominimo = montominimo;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
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

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idctacteruta != null ? idctacteruta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctacteruta)) {
            return false;
        }
        Ctacteruta other = (Ctacteruta) object;
        if ((this.idctacteruta == null && other.idctacteruta != null) || (this.idctacteruta != null && !this.idctacteruta.equals(other.idctacteruta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Ctacteruta[ idctacteruta=" + idctacteruta + " ]";
    }
    
}
