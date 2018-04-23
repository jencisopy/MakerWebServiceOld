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
@Table(name = "gi_lotemejora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiLoteMejoraSinfoto.findByIdlote", query = "SELECT g FROM GiLoteMejoraSinfoto g where g.idgiLote = :idgilote")})
public class GiLoteMejoraSinfoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)        
    @Basic(optional = false)
    @Column(name = "idgi_lotemejora")
    private Long idgiLoteMejora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_lote")
    private long idgiLote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgi_lotetipomejora")
    private long idgiLotetipomejora;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;

    
    public GiLoteMejoraSinfoto() {
    }

    public GiLoteMejoraSinfoto(Long idgiLoteMejora) {
        this.idgiLoteMejora = idgiLoteMejora;
    }

    public GiLoteMejoraSinfoto(Long idgiLoteMejora, long idgiLote, long idgiLotetipomejora) {
        this.idgiLoteMejora = idgiLoteMejora;
        this.idgiLote = idgiLote;
        this.idgiLotetipomejora = idgiLotetipomejora;
    }

    public Long getIdgiLoteMejora() {
        return idgiLoteMejora;
    }

    public void setIdgiLoteMejora(Long idgiLoteMejora) {
        this.idgiLoteMejora = idgiLoteMejora;
    }

    public long getIdgiLote() {
        return idgiLote;
    }

    public void setIdgiLote(long idgiLote) {
        this.idgiLote = idgiLote;
    }

    public long getIdgiLotetipomejora() {
        return idgiLotetipomejora;
    }

    public void setIdgiLotetipomejora(long idgiLotetipomejora) {
        this.idgiLotetipomejora = idgiLotetipomejora;
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
        hash += (idgiLoteMejora != null ? idgiLoteMejora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GiLoteMejoraSinfoto)) {
            return false;
        }
        GiLoteMejoraSinfoto other = (GiLoteMejoraSinfoto) object;
        if ((this.idgiLoteMejora == null && other.idgiLoteMejora != null) || (this.idgiLoteMejora != null && !this.idgiLoteMejora.equals(other.idgiLoteMejora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.GiLoteMejora[ idgiLoteMejora=" + idgiLoteMejora + " ]";
    }
    
}
