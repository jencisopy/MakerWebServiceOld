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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "documentlink")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentlink.findAll", query = "SELECT d FROM Documentlink d")
    , @NamedQuery(name = "Documentlink.findById", query = "SELECT d FROM Documentlink d WHERE d.documentlinkPK.id = :id")
    , @NamedQuery(name = "Documentlink.findByTabla", query = "SELECT d FROM Documentlink d WHERE d.documentlinkPK.tabla = :tabla")
    , @NamedQuery(name = "Documentlink.findByArchivo", query = "SELECT d FROM Documentlink d WHERE d.documentlinkPK.archivo = :archivo")
    , @NamedQuery(name = "Documentlink.findByCamino", query = "SELECT d FROM Documentlink d WHERE d.camino = :camino")
    , @NamedQuery(name = "Documentlink.findByFechamodificacion", query = "SELECT d FROM Documentlink d WHERE d.fechamodificacion = :fechamodificacion")
    , @NamedQuery(name = "Documentlink.findByAppuser", query = "SELECT d FROM Documentlink d WHERE d.appuser = :appuser")
    , @NamedQuery(name = "Documentlink.findByClasificacion", query = "SELECT d FROM Documentlink d WHERE d.clasificacion = :clasificacion")})
public class Documentlink implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentlinkPK documentlinkPK;
    @Size(max = 200)
    @Column(name = "camino")
    private String camino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @Size(max = 20)
    @Column(name = "clasificacion")
    private String clasificacion;

    public Documentlink() {
    }

    public Documentlink(DocumentlinkPK documentlinkPK) {
        this.documentlinkPK = documentlinkPK;
    }


    public Documentlink(long id, String tabla, String archivo) {
        this.documentlinkPK = new DocumentlinkPK(id, tabla, archivo);
    }

    public DocumentlinkPK getDocumentlinkPK() {
        return documentlinkPK;
    }

    public void setDocumentlinkPK(DocumentlinkPK documentlinkPK) {
        this.documentlinkPK = documentlinkPK;
    }

    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentlinkPK != null ? documentlinkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentlink)) {
            return false;
        }
        Documentlink other = (Documentlink) object;
        if ((this.documentlinkPK == null && other.documentlinkPK != null) || (this.documentlinkPK != null && !this.documentlinkPK.equals(other.documentlinkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.Documentlink[ documentlinkPK=" + documentlinkPK + " ]";
    }

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }       
}
