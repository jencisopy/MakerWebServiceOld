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
@Table(name = "gi_lotevta_mejora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLotevtaMejora.findAll", query = "SELECT g FROM GiLotevtaMejora g")
    , @NamedQuery(name = "GiLotevtaMejora.findByIdgiLotevtaMejora", query = "SELECT g FROM GiLotevtaMejora g WHERE g.idgiLotevtaMejora = :idgiLotevtaMejora")
    , @NamedQuery(name = "GiLotevtaMejora.findByIdgiLotevta", query = "SELECT g FROM GiLotevtaMejora g WHERE g.idgiLotevta = :idgiLotevta")
    , @NamedQuery(name = "GiLotevtaMejora.findByIdgiLotetipomejora", query = "SELECT g FROM GiLotevtaMejora g WHERE g.idgiLotetipomejora = :idgiLotetipomejora")
    , @NamedQuery(name = "GiLotevtaMejora.findByNombre", query = "SELECT g FROM GiLotevtaMejora g WHERE g.nombre = :nombre")})
public class GiLotevtaMejora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)        
    @Basic(optional = false)
    @Column(name = "idgi_lotevta_mejora")
    private Long idgiLotevtaMejora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_lotevta")
    private long idgiLotevta;
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
    @Column(name = "documento")
    private byte[] documento;
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

    public GiLotevtaMejora() {
    }

    public GiLotevtaMejora(Long idgiLotevtaMejora) {
        this.idgiLotevtaMejora = idgiLotevtaMejora;
    }

    public GiLotevtaMejora(Long idgiLotevtaMejora, long idgiLotevta, long idgiLotetipomejora) {
        this.idgiLotevtaMejora = idgiLotevtaMejora;
        this.idgiLotevta = idgiLotevta;
        this.idgiLotetipomejora = idgiLotetipomejora;
    }

    public Long getIdgiLotevtaMejora() {
        return idgiLotevtaMejora;
    }

    public void setIdgiLotevtaMejora(Long idgiLotevtaMejora) {
        this.idgiLotevtaMejora = idgiLotevtaMejora;
    }

    public long getIdgiLotevta() {
        return idgiLotevta;
    }

    public void setIdgiLotevta(long idgiLotevta) {
        this.idgiLotevta = idgiLotevta;
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

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
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
        hash += (idgiLotevtaMejora != null ? idgiLotevtaMejora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLotevtaMejora)) {
            return false;
        }
        GiLotevtaMejora other = (GiLotevtaMejora) object;
        if ((this.idgiLotevtaMejora == null && other.idgiLotevtaMejora != null) || (this.idgiLotevtaMejora != null && !this.idgiLotevtaMejora.equals(other.idgiLotevtaMejora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.GiLotevtaMejora[ idgiLotevtaMejora=" + idgiLotevtaMejora + " ]";
    }
    
    @PrePersist
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }      
}
