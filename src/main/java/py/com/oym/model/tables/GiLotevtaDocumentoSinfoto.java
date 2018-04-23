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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "GiLotevtaDocumentoSinfoto.findAll", query = "SELECT g FROM GiLotevtaDocumentoSinfoto g ")
    , @NamedQuery(name = "GiLotevtaDocumentoSinfoto.findByIdgiLotevtaDocumento", query = "SELECT g FROM GiLotevtaDocumentoSinfoto g WHERE g.idgiLotevtaDocumento = :idgiLotevtaDocumento")
    , @NamedQuery(name = "GiLotevtaDocumentoSinfoto.findByIdgiLotevta", query = "SELECT g FROM GiLotevtaDocumentoSinfoto g WHERE g.idgiLotevta = :idgiLotevta")})
public class GiLotevtaDocumentoSinfoto implements Serializable {
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
    
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    

    public GiLotevtaDocumentoSinfoto() {
    }

    public GiLotevtaDocumentoSinfoto(Long idgiLotevtaDocumento) {
        this.idgiLotevtaDocumento = idgiLotevtaDocumento;
    }

    public GiLotevtaDocumentoSinfoto(Long idgiLotevtaDocumento, long idgiLotevta) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof GiLotevtaDocumentoSinfoto)) {
            return false;
        }
        GiLotevtaDocumentoSinfoto other = (GiLotevtaDocumentoSinfoto) object;
        if ((this.idgiLotevtaDocumento == null && other.idgiLotevtaDocumento != null) || (this.idgiLotevtaDocumento != null && !this.idgiLotevtaDocumento.equals(other.idgiLotevtaDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.GiLotevtaDocumento[ idgiLotevtaDocumento=" + idgiLotevtaDocumento + " ]";
    }

}
