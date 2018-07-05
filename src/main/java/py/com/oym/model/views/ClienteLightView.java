/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.views;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "cliente_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteLightView.findAll",           query = "SELECT c FROM ClienteLightView c where c.idempresa = :idempresa order by c.ctactenombre"),
    @NamedQuery(name = "ClienteLightView.findByCodeAndName", query = "SELECT c FROM ClienteLightView c WHERE c.idempresa = :idempresa and (c.ctactenombre like :nombre or c.codigo like :codigo) order by c.ctactenombre")})
public class ClienteLightView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "idctacte")
    private long idctacte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ctactenombre")
    private String ctactenombre;
    @Basic(optional = false)

    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;

    @Size(max = 50)
    @Column(name = "contacto")
    private String contacto;
    @Size(max = 100)
    @Column(name = "direccionctacte")
    private String direccionctacte;
    @Size(max = 30)
    @Column(name = "telefonoctacte")
    private String telefonoctacte;

    
    public ClienteLightView() {
    }

    public long getIdctacte() {
        return idctacte;
    }

    public void setIdctacte(long idctacte) {
        this.idctacte = idctacte;
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

    public String getCtactenombre() {
        return ctactenombre;
    }

    public void setCtactenombre(String ctactenombre) {
        this.ctactenombre = ctactenombre;
    }



    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccionctacte() {
        return direccionctacte;
    }

    public void setDireccionctacte(String direccionctacte) {
        this.direccionctacte = direccionctacte;
    }

    public String getTelefonoctacte() {
        return telefonoctacte;
    }

    public void setTelefonoctacte(String telefonoctacte) {
        this.telefonoctacte = telefonoctacte;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    
}
