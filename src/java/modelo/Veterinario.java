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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FERNANDO
 */
@Entity
@Table(name = "veterinario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veterinario.findAll", query = "SELECT v FROM Veterinario v"),
    @NamedQuery(name = "Veterinario.findByIdveterinario", query = "SELECT v FROM Veterinario v WHERE v.idveterinario = :idveterinario"),
    @NamedQuery(name = "Veterinario.findByNombres", query = "SELECT v FROM Veterinario v WHERE v.nombres = :nombres"),
    @NamedQuery(name = "Veterinario.findByApellidos", query = "SELECT v FROM Veterinario v WHERE v.apellidos = :apellidos"),
    @NamedQuery(name = "Veterinario.findByTelefono", query = "SELECT v FROM Veterinario v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "Veterinario.findByTargProfecional", query = "SELECT v FROM Veterinario v WHERE v.targProfecional = :targProfecional")})
public class Veterinario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idveterinario")
    private Integer idveterinario;
    @Size(max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "targ_profecional")
    private Integer targProfecional;
    @JoinColumn(name = "sede_idsede", referencedColumnName = "idsede")
    @ManyToOne(optional = false)
    private Sede sedeIdsede;
    @JoinColumn(name = "tipo_estudios_idtipo_estudios", referencedColumnName = "idtipo_estudios")
    @ManyToOne(optional = false)
    private TipoEstudios tipoEstudiosIdtipoEstudios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veterinarioIdveterinario")
    private Collection<Cita> citaCollection;

    public Veterinario() {
    }

    public Veterinario(Integer idveterinario) {
        this.idveterinario = idveterinario;
    }

    public Integer getIdveterinario() {
        return idveterinario;
    }

    public void setIdveterinario(Integer idveterinario) {
        this.idveterinario = idveterinario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getTargProfecional() {
        return targProfecional;
    }

    public void setTargProfecional(Integer targProfecional) {
        this.targProfecional = targProfecional;
    }

    public Sede getSedeIdsede() {
        return sedeIdsede;
    }

    public void setSedeIdsede(Sede sedeIdsede) {
        this.sedeIdsede = sedeIdsede;
    }

    public TipoEstudios getTipoEstudiosIdtipoEstudios() {
        return tipoEstudiosIdtipoEstudios;
    }

    public void setTipoEstudiosIdtipoEstudios(TipoEstudios tipoEstudiosIdtipoEstudios) {
        this.tipoEstudiosIdtipoEstudios = tipoEstudiosIdtipoEstudios;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idveterinario != null ? idveterinario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veterinario)) {
            return false;
        }
        Veterinario other = (Veterinario) object;
        if ((this.idveterinario == null && other.idveterinario != null) || (this.idveterinario != null && !this.idveterinario.equals(other.idveterinario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Veterinario[ idveterinario=" + idveterinario + " ]";
    }
    
}
