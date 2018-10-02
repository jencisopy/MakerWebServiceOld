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
@Table(name = "gi_lotevta_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLotevtaDocumento.findAll", query = "SELECT g FROM GiLotevtaDocumento g")
    , @NamedQuery(name = "GiLotevtaDocumento.findByIdgiLotevtaDocumento", query = "SELECT g FROM GiLotevtaDocumento g WHERE g.idgiLotevtaDocumento = :idgiLotevtaDocumento")
    , @NamedQuery(name = "GiLotevtaDocumento.findByIdgiLotevta", query = "SELECT g FROM GiLotevtaDocumento g WHERE g.idgiLotevta = :idgiLotevta")})
public class GiLotevtaDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Basic(optional = false)
    @Column(name = "idgi_lotevta_documento")
    private Long idgiLotevtaDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_lotevta")
    private long idgiLotevta;
    @Lob
    @Column(name = "documento")
    private byte[] documento;
    @Transient
    private String documentoBase64;
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
    
    @Column(name = "iddocumentlink")
    private Long idDocumentlink;
    

    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    
    
    public GiLotevtaDocumento() {
    }

    public GiLotevtaDocumento(Long idgiLotevtaDocumento) {
        this.idgiLotevtaDocumento = idgiLotevtaDocumento;
    }

    public GiLotevtaDocumento(Long idgiLotevtaDocumento, long idgiLotevta) {
        this.idgiLotevtaDocumento = idgiLotevtaDocumento;
        this.idgiLotevta = idgiLotevta;
    }

    public Long getIdgiLotevtaDocumento() {
        return idgiLotevtaDocumento;
    }

    public void setIdgiLotevtaDocumento(Long idgiLotevtaDocumento) {
        this.idgiLotevtaDocumento = idgiLotevtaDocumento;
    }

    public long getIdgiLotevta() {
        return idgiLotevta;
    }

    public void setIdgiLotevta(long idgiLotevta) {
        this.idgiLotevta = idgiLotevta;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdDocumentlink() {
        return idDocumentlink;
    }

    public void setIdDocumentlink(Long idDocumentlink) {
        this.idDocumentlink = idDocumentlink;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgiLotevtaDocumento != null ? idgiLotevtaDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiLotevtaDocumento)) {
            return false;
        }
        GiLotevtaDocumento other = (GiLotevtaDocumento) object;
        if ((this.idgiLotevtaDocumento == null && other.idgiLotevtaDocumento != null) || (this.idgiLotevtaDocumento != null && !this.idgiLotevtaDocumento.equals(other.idgiLotevtaDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.GiLotevtaDocumento[ idgiLotevtaDocumento=" + idgiLotevtaDocumento + " ]";
    }

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }      
}
