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
@Table(name = "duenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duenio.findAll", query = "SELECT d FROM Duenio d"),
    @NamedQuery(name = "Duenio.findByCedula", query = "SELECT d FROM Duenio d WHERE d.cedula = :cedula"),
    @NamedQuery(name = "Duenio.findByNombre", query = "SELECT d FROM Duenio d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Duenio.findByTelefono", query = "SELECT d FROM Duenio d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Duenio.findByDireccion", query = "SELECT d FROM Duenio d WHERE d.direccion = :direccion")})
public class Duenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private Integer telefono;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "due\u00f1oCedula")
    private Collection<Paciente> pacienteCollection;

    public Duenio() {
    }

    public Duenio(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duenio)) {
            return false;
        }
        Duenio other = (Duenio) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Duenio[ cedula=" + cedula + " ]";
    }
    
}
