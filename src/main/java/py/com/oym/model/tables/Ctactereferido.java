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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "ctactereferido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctactereferido.findAll", query = "SELECT c FROM Ctactereferido c where idempresa=:idempresa"),
    @NamedQuery(name = "Ctactereferido.findByIdctactereferido", query = "SELECT c FROM Ctactereferido c WHERE c.idctactereferido = :idctactereferido")})
public class Ctactereferido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)           
    @Column(name = "idctactereferido")
    private Long idctactereferido;
    @Column(name = "idctacte")
    private Long idctacte;

    @Column(name = "idempresa")
    private Long idempresa;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 50)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;

    public Ctactereferido() {
    }

    public Ctactereferido(Long idctactereferido) {
        this.idctactereferido = idctactereferido;
    }


    public Long getIdctactereferido() {
        return idctactereferido;
    }

    public void setIdctactereferido(Long idctactereferido) {
        this.idctactereferido = idctactereferido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(Long idctacte) {
        this.idctacte = idctacte;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idctactereferido != null ? idctactereferido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctactereferido)) {
            return false;
        }
        Ctactereferido other = (Ctactereferido) object;
        if ((this.idctactereferido == null && other.idctactereferido != null) || (this.idctactereferido != null && !this.idctactereferido.equals(other.idctactereferido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservices.model.Ctactereferido[ idctactereferido=" + idctactereferido + " ]";
    }
    
}
