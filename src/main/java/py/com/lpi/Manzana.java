/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lpi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JORGE
 */
@Entity
@Table(name = "MANZANAS")
@NamedQueries({
    @NamedQuery(name = "Manzanas.findAll", query = "SELECT m FROM Manzana m")})
public class Manzana implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANZANA")
    private Integer idManzana;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FRACCION")
    private Integer idFraccion;

    @Column(name = "CANTIDAD_LOTES")
    private Short cantidadLotes;

    public Manzana() {
    }


    public Integer getIdManzana() {
        return idManzana;
    }

    public void setIdManzana(Integer idManzana) {
        this.idManzana = idManzana;
    }

    public Integer getIdFraccion() {
        return idFraccion;
    }

    public void setIdFraccion(Integer idFraccion) {
        this.idFraccion = idFraccion;
    }


    public Short getCantidadLotes() {
        return cantidadLotes;
    }

    public void setCantidadLotes(Short cantidadLotes) {
        this.cantidadLotes = cantidadLotes;
    }
}
