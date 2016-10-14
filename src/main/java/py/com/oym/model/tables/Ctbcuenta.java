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
@Table(name = "ctbcuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctbcuenta.findAll", query = "SELECT c FROM Ctbcuenta c"),
    @NamedQuery(name = "Ctbcuenta.findByIdctbcuenta", query = "SELECT c FROM Ctbcuenta c WHERE c.idctbcuenta = :idctbcuenta"),
    @NamedQuery(name = "Ctbcuenta.findByIdempresa", query = "SELECT c FROM Ctbcuenta c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Ctbcuenta.findByCodigo", query = "SELECT c FROM Ctbcuenta c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Ctbcuenta.findByNombre", query = "SELECT c FROM Ctbcuenta c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ctbcuenta.findByNivel", query = "SELECT c FROM Ctbcuenta c WHERE c.nivel = :nivel"),
    @NamedQuery(name = "Ctbcuenta.findByAsentable", query = "SELECT c FROM Ctbcuenta c WHERE c.asentable = :asentable"),
    @NamedQuery(name = "Ctbcuenta.findByAjustecambio", query = "SELECT c FROM Ctbcuenta c WHERE c.ajustecambio = :ajustecambio"),
    @NamedQuery(name = "Ctbcuenta.findByFechareplicacion", query = "SELECT c FROM Ctbcuenta c WHERE c.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Ctbcuenta.findByFechamodificacion", query = "SELECT c FROM Ctbcuenta c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ctbcuenta.findByFechacreacion", query = "SELECT c FROM Ctbcuenta c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Ctbcuenta.findByFirma", query = "SELECT c FROM Ctbcuenta c WHERE c.firma = :firma"),
    @NamedQuery(name = "Ctbcuenta.findByAppuser", query = "SELECT c FROM Ctbcuenta c WHERE c.appuser = :appuser")})
public class Ctbcuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idctbcuenta")
    private Long idctbcuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private short nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asentable")
    private boolean asentable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ajustecambio")
    private short ajustecambio;
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
    @OneToMany(mappedBy = "idctbcuentainteressocio")
    private List<Itemmovcondicion> itemmovcondicionList;
    @OneToMany(mappedBy = "idctbcuentainteres")
    private List<Itemmovcondicion> itemmovcondicionList1;
    @OneToMany(mappedBy = "idctbcuenta")
    private List<Itemmovcondicion> itemmovcondicionList2;
    @OneToMany(mappedBy = "idctbcuentasocio")
    private List<Itemmovcondicion> itemmovcondicionList3;
    @JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda")
    @ManyToOne(optional = false)
    private Moneda idmoneda;
    @JoinColumn(name = "idctbgrupo", referencedColumnName = "idctbgrupo")
    @ManyToOne(optional = false)
    private Ctbgrupo idctbgrupo;
    @OneToMany(mappedBy = "idctbcuentapadre")
    private List<Ctbcuenta> ctbcuentaList;
    @JoinColumn(name = "idctbcuentapadre", referencedColumnName = "idctbcuenta")
    @ManyToOne
    private Ctbcuenta idctbcuentapadre;
    @OneToMany(mappedBy = "idctbcliente")
    private List<Ctacte> ctacteList;
    @OneToMany(mappedBy = "idctbproveedor")
    private List<Ctacte> ctacteList1;
    @OneToMany(mappedBy = "idctbcuentaImport")
    private List<Familiagrupo> familiagrupoList;
    @OneToMany(mappedBy = "idctbcuentaVtacta2")
    private List<Familiagrupo> familiagrupoList1;
    @OneToMany(mappedBy = "idctbcuentaVtacta")
    private List<Familiagrupo> familiagrupoList2;
    @OneToMany(mappedBy = "idctbcuentaCostocta")
    private List<Familiagrupo> familiagrupoList3;
    @OneToMany(mappedBy = "idctbcuentaMercta")
    private List<Familiagrupo> familiagrupoList4;
    @OneToMany(mappedBy = "idctbcuenta")
    private List<Item> itemList;
    @OneToMany(mappedBy = "idctbcuentafraccion")
    private List<GiFraccion> giFraccionList;
    @OneToMany(mappedBy = "idctbcuentacliente")
    private List<GiFraccion> giFraccionList1;
    @OneToMany(mappedBy = "idctbcuentavta")
    private List<GiFraccion> giFraccionList2;
    @OneToMany(mappedBy = "idctbcuentacosto")
    private List<GiFraccion> giFraccionList3;
    @OneToMany(mappedBy = "idctbcuentainteresmora")
    private List<GiFraccion> giFraccionList4;
    @OneToMany(mappedBy = "idctbcuentadescuento")
    private List<GiFraccion> giFraccionList5;
    @OneToMany(mappedBy = "idctbcuentagastocobranza")
    private List<GiFraccion> giFraccionList6;

    public Ctbcuenta() {
    }

    public Ctbcuenta(Long idctbcuenta) {
        this.idctbcuenta = idctbcuenta;
    }

    public Ctbcuenta(Long idctbcuenta, long idempresa, String codigo, String nombre, short nivel, boolean asentable, short ajustecambio) {
        this.idctbcuenta = idctbcuenta;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.asentable = asentable;
        this.ajustecambio = ajustecambio;
    }

    public Long getIdctbcuenta() {
        return idctbcuenta;
    }

    public void setIdctbcuenta(Long idctbcuenta) {
        this.idctbcuenta = idctbcuenta;
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

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    public boolean getAsentable() {
        return asentable;
    }

    public void setAsentable(boolean asentable) {
        this.asentable = asentable;
    }

    public short getAjustecambio() {
        return ajustecambio;
    }

    public void setAjustecambio(short ajustecambio) {
        this.ajustecambio = ajustecambio;
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
    public List<Itemmovcondicion> getItemmovcondicionList() {
        return itemmovcondicionList;
    }

    public void setItemmovcondicionList(List<Itemmovcondicion> itemmovcondicionList) {
        this.itemmovcondicionList = itemmovcondicionList;
    }

    @XmlTransient
    public List<Itemmovcondicion> getItemmovcondicionList1() {
        return itemmovcondicionList1;
    }

    public void setItemmovcondicionList1(List<Itemmovcondicion> itemmovcondicionList1) {
        this.itemmovcondicionList1 = itemmovcondicionList1;
    }

    @XmlTransient
    public List<Itemmovcondicion> getItemmovcondicionList2() {
        return itemmovcondicionList2;
    }

    public void setItemmovcondicionList2(List<Itemmovcondicion> itemmovcondicionList2) {
        this.itemmovcondicionList2 = itemmovcondicionList2;
    }

    @XmlTransient
    public List<Itemmovcondicion> getItemmovcondicionList3() {
        return itemmovcondicionList3;
    }

    public void setItemmovcondicionList3(List<Itemmovcondicion> itemmovcondicionList3) {
        this.itemmovcondicionList3 = itemmovcondicionList3;
    }

    public Moneda getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Moneda idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Ctbgrupo getIdctbgrupo() {
        return idctbgrupo;
    }

    public void setIdctbgrupo(Ctbgrupo idctbgrupo) {
        this.idctbgrupo = idctbgrupo;
    }

    @XmlTransient
    public List<Ctbcuenta> getCtbcuentaList() {
        return ctbcuentaList;
    }

    public void setCtbcuentaList(List<Ctbcuenta> ctbcuentaList) {
        this.ctbcuentaList = ctbcuentaList;
    }

    public Ctbcuenta getIdctbcuentapadre() {
        return idctbcuentapadre;
    }

    public void setIdctbcuentapadre(Ctbcuenta idctbcuentapadre) {
        this.idctbcuentapadre = idctbcuentapadre;
    }

    @XmlTransient
    public List<Ctacte> getCtacteList() {
        return ctacteList;
    }

    public void setCtacteList(List<Ctacte> ctacteList) {
        this.ctacteList = ctacteList;
    }

    @XmlTransient
    public List<Ctacte> getCtacteList1() {
        return ctacteList1;
    }

    public void setCtacteList1(List<Ctacte> ctacteList1) {
        this.ctacteList1 = ctacteList1;
    }

    @XmlTransient
    public List<Familiagrupo> getFamiliagrupoList() {
        return familiagrupoList;
    }

    public void setFamiliagrupoList(List<Familiagrupo> familiagrupoList) {
        this.familiagrupoList = familiagrupoList;
    }

    @XmlTransient
    public List<Familiagrupo> getFamiliagrupoList1() {
        return familiagrupoList1;
    }

    public void setFamiliagrupoList1(List<Familiagrupo> familiagrupoList1) {
        this.familiagrupoList1 = familiagrupoList1;
    }

    @XmlTransient
    public List<Familiagrupo> getFamiliagrupoList2() {
        return familiagrupoList2;
    }

    public void setFamiliagrupoList2(List<Familiagrupo> familiagrupoList2) {
        this.familiagrupoList2 = familiagrupoList2;
    }

    @XmlTransient
    public List<Familiagrupo> getFamiliagrupoList3() {
        return familiagrupoList3;
    }

    public void setFamiliagrupoList3(List<Familiagrupo> familiagrupoList3) {
        this.familiagrupoList3 = familiagrupoList3;
    }

    @XmlTransient
    public List<Familiagrupo> getFamiliagrupoList4() {
        return familiagrupoList4;
    }

    public void setFamiliagrupoList4(List<Familiagrupo> familiagrupoList4) {
        this.familiagrupoList4 = familiagrupoList4;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList() {
        return giFraccionList;
    }

    public void setGiFraccionList(List<GiFraccion> giFraccionList) {
        this.giFraccionList = giFraccionList;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList1() {
        return giFraccionList1;
    }

    public void setGiFraccionList1(List<GiFraccion> giFraccionList1) {
        this.giFraccionList1 = giFraccionList1;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList2() {
        return giFraccionList2;
    }

    public void setGiFraccionList2(List<GiFraccion> giFraccionList2) {
        this.giFraccionList2 = giFraccionList2;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList3() {
        return giFraccionList3;
    }

    public void setGiFraccionList3(List<GiFraccion> giFraccionList3) {
        this.giFraccionList3 = giFraccionList3;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList4() {
        return giFraccionList4;
    }

    public void setGiFraccionList4(List<GiFraccion> giFraccionList4) {
        this.giFraccionList4 = giFraccionList4;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList5() {
        return giFraccionList5;
    }

    public void setGiFraccionList5(List<GiFraccion> giFraccionList5) {
        this.giFraccionList5 = giFraccionList5;
    }

    @XmlTransient
    public List<GiFraccion> getGiFraccionList6() {
        return giFraccionList6;
    }

    public void setGiFraccionList6(List<GiFraccion> giFraccionList6) {
        this.giFraccionList6 = giFraccionList6;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idctbcuenta != null ? idctbcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctbcuenta)) {
            return false;
        }
        Ctbcuenta other = (Ctbcuenta) object;
        if ((this.idctbcuenta == null && other.idctbcuenta != null) || (this.idctbcuenta != null && !this.idctbcuenta.equals(other.idctbcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Ctbcuenta[ idctbcuenta=" + idctbcuenta + " ]";
    }
    
}
