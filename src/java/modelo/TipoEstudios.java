/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FERNANDO
 */
@Entity
@Table(name = "tipo_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstudios.findAll", query = "SELECT t FROM TipoEstudios t"),
    @NamedQuery(name = "TipoEstudios.findByIdtipoEstudios", query = "SELECT t FROM TipoEstudios t WHERE t.idtipoEstudios = :idtipoEstudios"),
    @NamedQuery(name = "TipoEstudios.findByNombre", query = "SELECT t FROM TipoEstudios t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoEstudios.findByDescripcion", query = "SELECT t FROM TipoEstudios t WHERE t.descripcion = :descripcion")})
public class TipoEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_estudios")
    private Integer idtipoEstudios;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEstudiosIdtipoEstudios")
    private Collection<Veterinario> veterinarioCollection;

    public TipoEstudios() {
    }

    public TipoEstudios(Integer idtipoEstudios) {
        this.idtipoEstudios = idtipoEstudios;
    }

    public Integer getIdtipoEstudios() {
        return idtipoEstudios;
    }

    public void setIdtipoEstudios(Integer idtipoEstudios) {
        this.idtipoEstudios = idtipoEstudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Veterinario> getVeterinarioCollection() {
        return veterinarioCollection;
    }

    public void setVeterinarioCollection(Collection<Veterinario> veterinarioCollection) {
        this.veterinarioCollection = veterinarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoEstudios != null ? idtipoEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstudios)) {
            return false;
        }
        TipoEstudios other = (TipoEstudios) object;
        if ((this.idtipoEstudios == null && other.idtipoEstudios != null) || (this.idtipoEstudios != null && !this.idtipoEstudios.equals(other.idtipoEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoEstudios[ idtipoEstudios=" + idtipoEstudios + " ]";
    }
    
}
