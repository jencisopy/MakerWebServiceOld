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
@Table(name = "concepto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concepto.findAll", query = "SELECT c FROM Concepto c"),
    @NamedQuery(name = "Concepto.findByIdconcepto", query = "SELECT c FROM Concepto c WHERE c.idconcepto = :idconcepto"),
    @NamedQuery(name = "Concepto.findByIdempresa", query = "SELECT c FROM Concepto c WHERE c.idempresa = :idempresa"),
    @NamedQuery(name = "Concepto.findByCodigo", query = "SELECT c FROM Concepto c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Concepto.findByNombre", query = "SELECT c FROM Concepto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Concepto.findByFechareplicacion", query = "SELECT c FROM Concepto c WHERE c.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Concepto.findByFechamodificacion", query = "SELECT c FROM Concepto c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Concepto.findByFechacreacion", query = "SELECT c FROM Concepto c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Concepto.findByFirma", query = "SELECT c FROM Concepto c WHERE c.firma = :firma"),
    @NamedQuery(name = "Concepto.findByAppuser", query = "SELECT c FROM Concepto c WHERE c.appuser = :appuser")})
public class Concepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idconcepto")
    private Long idconcepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(mappedBy = "idconcepto")
    private List<GiLotevta> giLotevtaList;

    public Concepto() {
    }

    public Concepto(Long idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Concepto(Long idconcepto, long idempresa, String codigo, String nombre) {
        this.idconcepto = idconcepto;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Long idconcepto) {
        this.idconcepto = idconcepto;
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
    public List<GiLotevta> getGiLotevtaList() {
        return giLotevtaList;
    }

    public void setGiLotevtaList(List<GiLotevta> giLotevtaList) {
        this.giLotevtaList = giLotevtaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconcepto != null ? idconcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concepto)) {
            return false;
        }
        Concepto other = (Concepto) object;
        if ((this.idconcepto == null && other.idconcepto != null) || (this.idconcepto != null && !this.idconcepto.equals(other.idconcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservicesprb.Concepto[ idconcepto=" + idconcepto + " ]";
    }
    
}
