/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    , @NamedQuery(name = "Documentlink.findByCamino", query = "SELECT d FROM Documentlink d WHERE d.camino = :camino")
    , @NamedQuery(name = "Documentlink.findByFechamodificacion", query = "SELECT d FROM Documentlink d WHERE d.fechamodificacion = :fechamodificacion")
    , @NamedQuery(name = "Documentlink.findByAppuser", query = "SELECT d FROM Documentlink d WHERE d.appuser = :appuser")
    , @NamedQuery(name = "Documentlink.findByClasificacion", query = "SELECT d FROM Documentlink d WHERE d.clasificacion = :clasificacion")})
public class Documentlink implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "iddocumentlink")
    private Long iddocumentlink;

    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tabla")
    private String tabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "archivo")
    private String archivo;

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

    public long getIddocumentlink() {
        return iddocumentlink;
    }

    public void setIddocumentlink(long iddocumentlink) {
        this.iddocumentlink = iddocumentlink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
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
        hash += (iddocumentlink != null ? iddocumentlink.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Documentlink other = (Documentlink) obj;
        if (!Objects.equals(this.iddocumentlink, other.iddocumentlink)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documentlink{" + "iddocumentlink=" + iddocumentlink + ", id=" + id + ", tabla=" + tabla + ", archivo=" + archivo + ", camino=" + camino + ", fechamodificacion=" + fechamodificacion + ", appuser=" + appuser + ", clasificacion=" + clasificacion + '}';
    }


    @PrePersist
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }       
}
