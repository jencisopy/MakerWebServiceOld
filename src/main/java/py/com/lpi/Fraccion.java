/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lpi;

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

/**
 *
 * @author JORGE
 */
@Entity
@Table(name = "FRACCIONES")
@NamedQueries({
    @NamedQuery(name = "Fracciones.findAll", query = "SELECT f FROM Fraccion f")})
public class Fraccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FRACCION")
    private Integer idFraccion;
    @Size(max = 240)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Fraccion() {
    }

    public Fraccion(Integer idFraccion) {
        this.idFraccion = idFraccion;
    }

    public Integer getIdFraccion() {
        return idFraccion;
    }

    public void setIdFraccion(Integer idFraccion) {
        this.idFraccion = idFraccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFraccion != null ? idFraccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fraccion)) {
            return false;
        }
        Fraccion other = (Fraccion) object;
        if ((this.idFraccion == null && other.idFraccion != null) || (this.idFraccion != null && !this.idFraccion.equals(other.idFraccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lpi.Fracciones[ idFraccion=" + idFraccion + " ]";
    }
    
}
