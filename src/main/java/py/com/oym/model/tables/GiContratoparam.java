/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jenci_000
 */
@Entity
@Table(name = "gi_contratoparam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiContratoparam.findAll", query = "SELECT g FROM GiContratoparam g")})
public class GiContratoparam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;
    @Column(name = "numeracionmodo")
    private Short numeracionmodo;
    @Column(name = "numeracionpart1")
    private Short numeracionpart1;
    @Column(name = "numeracionpart2")
    private Short numeracionpart2;
    @Column(name = "noedit")
    private Boolean noedit;

    public GiContratoparam() {
    }

    public GiContratoparam(Long idempresa) {
        this.idempresa = idempresa;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public Short getNumeracionmodo() {
        return numeracionmodo;
    }

    public void setNumeracionmodo(Short numeracionmodo) {
        this.numeracionmodo = numeracionmodo;
    }

    public Short getNumeracionpart1() {
        return numeracionpart1;
    }

    public void setNumeracionpart1(Short numeracionpart1) {
        this.numeracionpart1 = numeracionpart1;
    }

    public Short getNumeracionpart2() {
        return numeracionpart2;
    }

    public void setNumeracionpart2(Short numeracionpart2) {
        this.numeracionpart2 = numeracionpart2;
    }

    public Boolean getNoedit() {
        return noedit;
    }

    public void setNoedit(Boolean noedit) {
        this.noedit = noedit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiContratoparam)) {
            return false;
        }
        GiContratoparam other = (GiContratoparam) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.exceptions.GiContratoparam[ idempresa=" + idempresa + " ]";
    }
    
}
