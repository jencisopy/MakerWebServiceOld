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
@Table(name = "familiagrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familiagrupo.findAll", query = "SELECT f FROM Familiagrupo f"),
    @NamedQuery(name = "Familiagrupo.findByIdfamiliagrupo", query = "SELECT f FROM Familiagrupo f WHERE f.idfamiliagrupo = :idfamiliagrupo"),
    @NamedQuery(name = "Familiagrupo.findByCodigo", query = "SELECT f FROM Familiagrupo f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Familiagrupo.findByNombre", query = "SELECT f FROM Familiagrupo f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Familiagrupo.findByFechareplicacion", query = "SELECT f FROM Familiagrupo f WHERE f.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Familiagrupo.findByFechamodificacion", query = "SELECT f FROM Familiagrupo f WHERE f.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Familiagrupo.findByFechacreacion", query = "SELECT f FROM Familiagrupo f WHERE f.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Familiagrupo.findByFirma", query = "SELECT f FROM Familiagrupo f WHERE f.firma = :firma"),
    @NamedQuery(name = "Familiagrupo.findByAppuser", query = "SELECT f FROM Familiagrupo f WHERE f.appuser = :appuser")})
public class Familiagrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfamiliagrupo")
    private Long idfamiliagrupo;
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
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
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
    @JoinColumn(name = "idfamilia", referencedColumnName = "idfamilia")
    @ManyToOne(optional = false)
    private Familia idfamilia;
    @JoinColumn(name = "idctbcuenta_import", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentaImport;
    @JoinColumn(name = "idctbcuenta_vtacta2", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentaVtacta2;
    @JoinColumn(name = "idctbcuenta_vtacta", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentaVtacta;
    @JoinColumn(name = "idctbcuenta_costocta", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentaCostocta;
    @JoinColumn(name = "idctbcuenta_mercta", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentaMercta;
    @OneToMany(mappedBy = "idfamiliagrupo")
    private List<Item> itemList;

    public Familiagrupo() {
    }

    public Familiagrupo(Long idfamiliagrupo) {
        this.idfamiliagrupo = idfamiliagrupo;
    }

    public Familiagrupo(Long idfamiliagrupo, String codigo, String nombre) {
        this.idfamiliagrupo = idfamiliagrupo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdfamiliagrupo() {
        return idfamiliagrupo;
    }

    public void setIdfamiliagrupo(Long idfamiliagrupo) {
        this.idfamiliagrupo = idfamiliagrupo;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Familia getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(Familia idfamilia) {
        this.idfamilia = idfamilia;
    }

    public Ctbcuenta getIdctbcuentaImport() {
        return idctbcuentaImport;
    }

    public void setIdctbcuentaImport(Ctbcuenta idctbcuentaImport) {
        this.idctbcuentaImport = idctbcuentaImport;
    }

    public Ctbcuenta getIdctbcuentaVtacta2() {
        return idctbcuentaVtacta2;
    }

    public void setIdctbcuentaVtacta2(Ctbcuenta idctbcuentaVtacta2) {
        this.idctbcuentaVtacta2 = idctbcuentaVtacta2;
    }

    public Ctbcuenta getIdctbcuentaVtacta() {
        return idctbcuentaVtacta;
    }

    public void setIdctbcuentaVtacta(Ctbcuenta idctbcuentaVtacta) {
        this.idctbcuentaVtacta = idctbcuentaVtacta;
    }

    public Ctbcuenta getIdctbcuentaCostocta() {
        return idctbcuentaCostocta;
    }

    public void setIdctbcuentaCostocta(Ctbcuenta idctbcuentaCostocta) {
        this.idctbcuentaCostocta = idctbcuentaCostocta;
    }

    public Ctbcuenta getIdctbcuentaMercta() {
        return idctbcuentaMercta;
    }

    public void setIdctbcuentaMercta(Ctbcuenta idctbcuentaMercta) {
        this.idctbcuentaMercta = idctbcuentaMercta;
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
        hash += (idfamiliagrupo != null ? idfamiliagrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familiagrupo)) {
            return false;
        }
        Familiagrupo other = (Familiagrupo) object;
        if ((this.idfamiliagrupo == null && other.idfamiliagrupo != null) || (this.idfamiliagrupo != null && !this.idfamiliagrupo.equals(other.idfamiliagrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Familiagrupo[ idfamiliagrupo=" + idfamiliagrupo + " ]";
    }
    
}
