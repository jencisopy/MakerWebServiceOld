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
@Table(name = "ctbgrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctbgrupo.findAll", query = "SELECT c FROM Ctbgrupo c"),
    @NamedQuery(name = "Ctbgrupo.findByIdctbgrupo", query = "SELECT c FROM Ctbgrupo c WHERE c.idctbgrupo = :idctbgrupo"),
    @NamedQuery(name = "Ctbgrupo.findByIdempresa", query = "SELECT c FROM Ctbgrupo c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Ctbgrupo.findByCodigo", query = "SELECT c FROM Ctbgrupo c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Ctbgrupo.findByNombre", query = "SELECT c FROM Ctbgrupo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ctbgrupo.findByTipo", query = "SELECT c FROM Ctbgrupo c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Ctbgrupo.findByNaturaleza", query = "SELECT c FROM Ctbgrupo c WHERE c.naturaleza = :naturaleza"),
    @NamedQuery(name = "Ctbgrupo.findByFechareplicacion", query = "SELECT c FROM Ctbgrupo c WHERE c.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Ctbgrupo.findByFechamodificacion", query = "SELECT c FROM Ctbgrupo c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ctbgrupo.findByFechacreacion", query = "SELECT c FROM Ctbgrupo c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Ctbgrupo.findByFirma", query = "SELECT c FROM Ctbgrupo c WHERE c.firma = :firma"),
    @NamedQuery(name = "Ctbgrupo.findByAppuser", query = "SELECT c FROM Ctbgrupo c WHERE c.appuser = :appuser")})
public class Ctbgrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctbgrupo")
    private Long idctbgrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Character codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "naturaleza")
    private Character naturaleza;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idctbgrupo")
    private List<Ctbcuenta> ctbcuentaList;

    public Ctbgrupo() {
    }

    public Ctbgrupo(Long idctbgrupo) {
        this.idctbgrupo = idctbgrupo;
    }

    public Ctbgrupo(Long idctbgrupo, long idempresa, Character codigo, String nombre, Character tipo) {
        this.idctbgrupo = idctbgrupo;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getIdctbgrupo() {
        return idctbgrupo;
    }

    public void setIdctbgrupo(Long idctbgrupo) {
        this.idctbgrupo = idctbgrupo;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Character getCodigo() {
        return codigo;
    }

    public void setCodigo(Character codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Character getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(Character naturaleza) {
        this.naturaleza = naturaleza;
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

    @XmlTransient
    public List<Ctbcuenta> getCtbcuentaList() {
        return ctbcuentaList;
    }

    public void setCtbcuentaList(List<Ctbcuenta> ctbcuentaList) {
        this.ctbcuentaList = ctbcuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idctbgrupo != null ? idctbgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctbgrupo)) {
            return false;
        }
        Ctbgrupo other = (Ctbgrupo) object;
        if ((this.idctbgrupo == null && other.idctbgrupo != null) || (this.idctbgrupo != null && !this.idctbgrupo.equals(other.idctbgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Ctbgrupo[ idctbgrupo=" + idctbgrupo + " ]";
    }
    
}
