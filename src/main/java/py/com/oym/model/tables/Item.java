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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIditem", query = "SELECT i FROM Item i WHERE i.iditem = :iditem"),
    @NamedQuery(name = "Item.findByIdempresa", query = "SELECT i FROM Item i WHERE i.idempresa = :idempresa"),
    @NamedQuery(name = "Item.findByCodigo", query = "SELECT i FROM Item i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Item.findByNombre", query = "SELECT i FROM Item i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Item.findByItemelemento", query = "SELECT i FROM Item i WHERE i.itemelemento = :itemelemento"),
    @NamedQuery(name = "Item.findByMedida", query = "SELECT i FROM Item i WHERE i.medida = :medida"),
    @NamedQuery(name = "Item.findByInactivo", query = "SELECT i FROM Item i WHERE i.inactivo = :inactivo"),
    @NamedQuery(name = "Item.findByFechareplicacion", query = "SELECT i FROM Item i WHERE i.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Item.findByFechamodificacion", query = "SELECT i FROM Item i WHERE i.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Item.findByFechacreacion", query = "SELECT i FROM Item i WHERE i.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Item.findByFirma", query = "SELECT i FROM Item i WHERE i.firma = :firma"),
    @NamedQuery(name = "Item.findByAppuser", query = "SELECT i FROM Item i WHERE i.appuser = :appuser")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private Long iditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemelemento")
    private Character itemelemento;
    @Size(max = 10)
    @Column(name = "medida")
    private String medida;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
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
    @JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda")
    @ManyToOne
    private Moneda idmoneda;
    @JoinColumn(name = "idimpuestogrupo", referencedColumnName = "idimpuestogrupo")
    @ManyToOne
    private Impuestogrupo idimpuestogrupo;
    @JoinColumn(name = "idfamiliagrupo", referencedColumnName = "idfamiliagrupo")
    @ManyToOne
    private Familiagrupo idfamiliagrupo;
    @JoinColumn(name = "idctbcuenta", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuenta;
    @OneToMany(mappedBy = "iditem")
    private List<GiFraccion> giFraccionList;

    public Item() {
    }

    public Item(Long iditem) {
        this.iditem = iditem;
    }

    public Item(Long iditem, long idempresa, String codigo, String nombre, Character itemelemento) {
        this.iditem = iditem;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.itemelemento = itemelemento;
    }

    public Long getIditem() {
        return iditem;
    }

    public void setIditem(Long iditem) {
        this.iditem = iditem;
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

    public Character getItemelemento() {
        return itemelemento;
    }

    public void setItemelemento(Character itemelemento) {
        this.itemelemento = itemelemento;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Moneda getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Moneda idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Impuestogrupo getIdimpuestogrupo() {
        return idimpuestogrupo;
    }

    public void setIdimpuestogrupo(Impuestogrupo idimpuestogrupo) {
        this.idimpuestogrupo = idimpuestogrupo;
    }

    public Familiagrupo getIdfamiliagrupo() {
        return idfamiliagrupo;
    }

    public void setIdfamiliagrupo(Familiagrupo idfamiliagrupo) {
        this.idfamiliagrupo = idfamiliagrupo;
    }

    public Ctbcuenta getIdctbcuenta() {
        return idctbcuenta;
    }

    public void setIdctbcuenta(Ctbcuenta idctbcuenta) {
        this.idctbcuenta = idctbcuenta;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList() {
        return giFraccionList;
    }

    public void setGiFraccionList(List<GiFraccion> giFraccionList) {
        this.giFraccionList = giFraccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Item[ iditem=" + iditem + " ]";
    }
    
}
