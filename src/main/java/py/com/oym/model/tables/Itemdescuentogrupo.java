/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "itemdescuentogrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemdescuentogrupo.findAll", query = "SELECT i FROM Itemdescuentogrupo i"),
    @NamedQuery(name = "Itemdescuentogrupo.findByIditemdescuentogrupo", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.iditemdescuentogrupo = :iditemdescuentogrupo"),
    @NamedQuery(name = "Itemdescuentogrupo.findByIdempresa", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.idempresa = :idempresa"),
    @NamedQuery(name = "Itemdescuentogrupo.findByCodigo", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Itemdescuentogrupo.findByNombre", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Itemdescuentogrupo.findByFechacreacion", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Itemdescuentogrupo.findByFechamodificacion", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Itemdescuentogrupo.findByFirma", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.firma = :firma"),
    @NamedQuery(name = "Itemdescuentogrupo.findByAppuser", query = "SELECT i FROM Itemdescuentogrupo i WHERE i.appuser = :appuser")})
public class Itemdescuentogrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditemdescuentogrupo")
    private Long iditemdescuentogrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
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
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @OneToMany(mappedBy = "iditemdescuentogrupo")
    private List<Ctacte> ctacteList;

    public Itemdescuentogrupo() {
    }

    public Itemdescuentogrupo(Long iditemdescuentogrupo) {
        this.iditemdescuentogrupo = iditemdescuentogrupo;
    }

    public Itemdescuentogrupo(Long iditemdescuentogrupo, long idempresa, String codigo, String nombre, Date fechacreacion, Date fechamodificacion) {
        this.iditemdescuentogrupo = iditemdescuentogrupo;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public Long getIditemdescuentogrupo() {
        return iditemdescuentogrupo;
    }

    public void setIditemdescuentogrupo(Long iditemdescuentogrupo) {
        this.iditemdescuentogrupo = iditemdescuentogrupo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (iditemdescuentogrupo != null ? iditemdescuentogrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemdescuentogrupo)) {
            return false;
        }
        Itemdescuentogrupo other = (Itemdescuentogrupo) object;
        if ((this.iditemdescuentogrupo == null && other.iditemdescuentogrupo != null) || (this.iditemdescuentogrupo != null && !this.iditemdescuentogrupo.equals(other.iditemdescuentogrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Itemdescuentogrupo[ iditemdescuentogrupo=" + iditemdescuentogrupo + " ]";
    }
    
}
