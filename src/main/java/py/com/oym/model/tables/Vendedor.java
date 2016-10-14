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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByIdvendedor", query = "SELECT v FROM Vendedor v WHERE v.idvendedor = :idvendedor"),
    @NamedQuery(name = "Vendedor.findByIdempresa", query = "SELECT v FROM Vendedor v WHERE v.idempresa = :idempresa"),
    @NamedQuery(name = "Vendedor.findByCodigo", query = "SELECT v FROM Vendedor v WHERE v.idempresa = :idempresa and v.codigo = :codigo")})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvendedor")
    private Long idvendedor;
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
    @OneToMany(mappedBy = "idvendedorjefe")
    private List<Vendedor> vendedorList;
    @JoinColumn(name = "idvendedorjefe", referencedColumnName = "idvendedor")
    @ManyToOne
    private Vendedor idvendedorjefe;
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne
    private Sucursal idsucursal;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @OneToMany(mappedBy = "idvendedor")
    private List<Ctacte> ctacteList;
    @OneToMany(mappedBy = "idvendedorreserva")
    private List<GiLote> giLoteList;
    @OneToMany(mappedBy = "idconductor")
    private List<GiLotevta> giLotevtaList;
    @OneToMany(mappedBy = "idvendedor")
    private List<GiLotevta> giLotevtaList1;
    @OneToMany(mappedBy = "idvendedorjefe")
    private List<GiLotevta> giLotevtaList2;

    public Vendedor() {
    }

    public Vendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Vendedor(Long idvendedor, long idempresa, String codigo, BigDecimal comision) {
        this.idvendedor = idvendedor;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.comision = comision;
    }

    public Long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
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

    @XmlTransient
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    public Vendedor getIdvendedorjefe() {
        return idvendedorjefe;
    }

    public void setIdvendedorjefe(Vendedor idvendedorjefe) {
        this.idvendedorjefe = idvendedorjefe;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
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

    @XmlTransient
    public List<GiLote> getGiLoteList() {
        return giLoteList;
    }

    public void setGiLoteList(List<GiLote> giLoteList) {
        this.giLoteList = giLoteList;
    }

    @XmlTransient
    public List<GiLotevta> getGiLotevtaList() {
        return giLotevtaList;
    }

    public void setGiLotevtaList(List<GiLotevta> giLotevtaList) {
        this.giLotevtaList = giLotevtaList;
    }

    @XmlTransient
    public List<GiLotevta> getGiLotevtaList1() {
        return giLotevtaList1;
    }

    public void setGiLotevtaList1(List<GiLotevta> giLotevtaList1) {
        this.giLotevtaList1 = giLotevtaList1;
    }

    @XmlTransient
    public List<GiLotevta> getGiLotevtaList2() {
        return giLotevtaList2;
    }

    public void setGiLotevtaList2(List<GiLotevta> giLotevtaList2) {
        this.giLotevtaList2 = giLotevtaList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvendedor != null ? idvendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idvendedor == null && other.idvendedor != null) || (this.idvendedor != null && !this.idvendedor.equals(other.idvendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Vendedor[ idvendedor=" + idvendedor + " ]";
    }
    
}
