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
import javax.persistence.CascadeType;
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
@Table(name = "impuestogrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuestogrupo.findAll", query = "SELECT i FROM Impuestogrupo i"),
    @NamedQuery(name = "Impuestogrupo.findByIdimpuestogrupo", query = "SELECT i FROM Impuestogrupo i WHERE i.idimpuestogrupo = :idimpuestogrupo"),
    @NamedQuery(name = "Impuestogrupo.findByCodigo", query = "SELECT i FROM Impuestogrupo i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Impuestogrupo.findByNombre", query = "SELECT i FROM Impuestogrupo i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Impuestogrupo.findByFechamodificacion", query = "SELECT i FROM Impuestogrupo i WHERE i.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Impuestogrupo.findByFechareplicacion", query = "SELECT i FROM Impuestogrupo i WHERE i.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Impuestogrupo.findByFechacreacion", query = "SELECT i FROM Impuestogrupo i WHERE i.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Impuestogrupo.findByFirma", query = "SELECT i FROM Impuestogrupo i WHERE i.firma = :firma"),
    @NamedQuery(name = "Impuestogrupo.findByAppuser", query = "SELECT i FROM Impuestogrupo i WHERE i.appuser = :appuser")})
public class Impuestogrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idimpuestogrupo")
    private Long idimpuestogrupo;
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
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Size(max = 32)
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @OneToMany(mappedBy = "idimpuestogrupo")
    private List<Ctacte> ctacteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idimpuestogrupo")
    private List<GiLotevta> giLotevtaList;
    @OneToMany(mappedBy = "idimpuestogrupo")
    private List<Item> itemList;

    public Impuestogrupo() {
    }

    public Impuestogrupo(Long idimpuestogrupo) {
        this.idimpuestogrupo = idimpuestogrupo;
    }

    public Impuestogrupo(Long idimpuestogrupo, String codigo, String nombre, Date fechamodificacion, Date fechacreacion) {
        this.idimpuestogrupo = idimpuestogrupo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechamodificacion = fechamodificacion;
        this.fechacreacion = fechacreacion;
    }

    public Long getIdimpuestogrupo() {
        return idimpuestogrupo;
    }

    public void setIdimpuestogrupo(Long idimpuestogrupo) {
        this.idimpuestogrupo = idimpuestogrupo;
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

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    @XmlTransient
    public List<GiLotevta> getGiLotevtaList() {
        return giLotevtaList;
    }

    public void setGiLotevtaList(List<GiLotevta> giLotevtaList) {
        this.giLotevtaList = giLotevtaList;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimpuestogrupo != null ? idimpuestogrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuestogrupo)) {
            return false;
        }
        Impuestogrupo other = (Impuestogrupo) object;
        if ((this.idimpuestogrupo == null && other.idimpuestogrupo != null) || (this.idimpuestogrupo != null && !this.idimpuestogrupo.equals(other.idimpuestogrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Impuestogrupo[ idimpuestogrupo=" + idimpuestogrupo + " ]";
    }
    
}
