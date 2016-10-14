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
@Table(name = "personafisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personafisica.findAll", query = "SELECT p FROM Personafisica p")})
public class Personafisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersona")
    private Long idpersona;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 15)
    @Column(name = "titulocortesia")
    private String titulocortesia;
    @Size(max = 50)
    @Column(name = "lugar_de_nacimiento")
    private String lugarDeNacimiento;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    @Size(max = 15)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Size(max = 50)
    @Column(name = "empresatrabaja")
    private String empresatrabaja;
    @Size(max = 50)
    @Column(name = "direcciontrabajo")
    private String direcciontrabajo;
    @Size(max = 50)
    @Column(name = "telefonotrabajo")
    private String telefonotrabajo;
    @Size(max = 20)
    @Column(name = "tarjeta")
    private String tarjeta;
    @Size(max = 5)
    @Column(name = "vencetarjeta")
    private String vencetarjeta;
    @Column(name = "estadocivil")
    private Character estadocivil;
    @Column(name = "sexo")
    private Character sexo;

    @Column(name = "ingresomensual")
    private Long ingresomensual;

    @Column(name = "egresomensual")
    private Long egresomensual;
    
    @Column(name = "hijos_cantidad")
    private Short hijos_cantidad;
    
    @Column(name = "fechaingresotrabajo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingresotrabajo;

    @Column(name = "debitoautomatico")
    private Boolean debitoautomatico;
    
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

    public Personafisica() {
    }

    public Personafisica(Long idpersona) {
        this.idpersona = idpersona;
    }

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulocortesia() {
        return titulocortesia;
    }

    public void setTitulocortesia(String titulocortesia) {
        this.titulocortesia = titulocortesia;
    }

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmpresatrabaja() {
        return empresatrabaja;
    }

    public void setEmpresatrabaja(String empresatrabaja) {
        this.empresatrabaja = empresatrabaja;
    }

    public String getDirecciontrabajo() {
        return direcciontrabajo;
    }

    public void setDirecciontrabajo(String direcciontrabajo) {
        this.direcciontrabajo = direcciontrabajo;
    }

    public String getTelefonotrabajo() {
        return telefonotrabajo;
    }

    public void setTelefonotrabajo(String telefonotrabajo) {
        this.telefonotrabajo = telefonotrabajo;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getVencetarjeta() {
        return vencetarjeta;
    }

    public void setVencetarjeta(String vencetarjeta) {
        this.vencetarjeta = vencetarjeta;
    }

    public Character getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(Character estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
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

    public Long getIngresomensual() {
        return ingresomensual;
    }

    public void setIngresomensual(Long ingresomensual) {
        this.ingresomensual = ingresomensual;
    }

    public Long getEgresomensual() {
        return egresomensual;
    }

    public void setEgresomensual(Long egresomensual) {
        this.egresomensual = egresomensual;
    }

    public Short getHijos_cantidad() {
        return hijos_cantidad;
    }

    public void setHijos_cantidad(Short hijos_cantidad) {
        this.hijos_cantidad = hijos_cantidad;
    }

    public Date getFechaingresotrabajo() {
        return fechaingresotrabajo;
    }

    public void setFechaingresotrabajo(Date fechaingresotrabajo) {
        this.fechaingresotrabajo = fechaingresotrabajo;
    }

    public Boolean getDebitoautomatico() {
        return debitoautomatico;
    }

    public void setDebitoautomatico(Boolean debitoautomatico) {
        this.debitoautomatico = debitoautomatico;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personafisica)) {
            return false;
        }
        Personafisica other = (Personafisica) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.webservices.model.Personafisica[ idpersona=" + idpersona + " ]";
    }
    
}
