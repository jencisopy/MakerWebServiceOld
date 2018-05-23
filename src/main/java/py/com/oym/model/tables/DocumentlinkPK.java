/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mtrinidad
 */
@Embeddable
public class DocumentlinkPK implements Serializable {

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

    public DocumentlinkPK() {
    }

    public DocumentlinkPK(long id, String tabla, String archivo) {
        this.id = id;
        this.tabla = tabla;
        this.archivo = archivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (tabla != null ? tabla.hashCode() : 0);
        hash += (archivo != null ? archivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentlinkPK)) {
            return false;
        }
        DocumentlinkPK other = (DocumentlinkPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.tabla == null && other.tabla != null) || (this.tabla != null && !this.tabla.equals(other.tabla))) {
            return false;
        }
        if ((this.archivo == null && other.archivo != null) || (this.archivo != null && !this.archivo.equals(other.archivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.DocumentlinkPK[ id=" + id + ", tabla=" + tabla + ", archivo=" + archivo + " ]";
    }
    
}
