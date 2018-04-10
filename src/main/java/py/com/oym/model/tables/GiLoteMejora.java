/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "gi_lotemejora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLoteMejora.findAll", query = "SELECT g FROM GiLoteMejora g")
    , @NamedQuery(name = "GiLoteMejora.findByIdgiLoteMejora", query = "SELECT g FROM GiLoteMejora g WHERE g.idgiLoteMejora = :idgiLoteMejora")
    , @NamedQuery(name = "GiLoteMejora.findByIdgiLote", query = "SELECT g FROM GiLoteMejora g WHERE g.idgiLote = :idgiLote")
    , @NamedQuery(name = "GiLoteMejora.findByIdgiLotetipomejora", query = "SELECT g FROM GiLoteMejora g WHERE g.idgiLotetipomejora = :idgiLotetipomejora")
    , @NamedQuery(name = "GiLoteMejora.findByNombre", query = "SELECT g FROM GiLoteMejora g WHERE g.nombre = :nombre")})
public class GiLoteMejora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)        
    @Basic(optional = false)
    @Column(name = "idgi_lotemejora")
    private Long idgiLoteMejora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_lote")
    private long idgiLote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_lotetipomejora")
    private long idgiLotetipomejora;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Transient
    private String documentoBase64;    
    @Lob
    @Column(name = "foto")
    private byte[] foto;
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

    public GiLoteMejora() {
    }

    public GiLoteMejora(Long idgiLoteMejora) {
        this.idgiLoteMejora = idgiLoteMejora;
    }

    public GiLoteMejora(Long idgiLoteMejora, long idgiLote, long idgiLotetipomejora) {
        this.idgiLoteMejora = idgiLoteMejora;
        this.idgiLote = idgiLote;
        this.idgiLotetipomejora = idgiLotetipomejora;
    }

    public Long getIdgiLoteMejora() {
        return idgiLoteMejora;
    }

    public void setIdgiLoteMejora(Long idgiLoteMejora) {
        this.idgiLoteMejora = idgiLoteMejora;
    }

    public long getIdgiLote() {
        return idgiLote;
    }

    public void setIdgiLote(long idgiLote) {
        this.idgiLote = idgiLote;
    }

    public long getIdgiLotetipomejora() {
        return idgiLotetipomejora;
    }

    public void setIdgiLotetipomejora(long idgiLotetipomejora) {
        this.idgiLotetipomejora = idgiLotetipomejora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

    public String getDocumentoBase64() {
        return documentoBase64;
    }

    public void setDocumentoBase64(String documentoBase64) {
        this.documentoBase64 = documentoBase64;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiLoteMejora != null ? idgiLoteMejora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLoteMejora)) {
            return false;
        }
        GiLoteMejora other = (GiLoteMejora) object;
        if ((this.idgiLoteMejora == null && other.idgiLoteMejora != null) || (this.idgiLoteMejora != null && !this.idgiLoteMejora.equals(other.idgiLoteMejora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.GiLoteMejora[ idgiLoteMejora=" + idgiLoteMejora + " ]";
    }
    
    @PrePersist
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }      
}
