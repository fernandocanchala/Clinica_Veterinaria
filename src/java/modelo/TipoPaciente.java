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
@Table(name = "tipo_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaciente.findAll", query = "SELECT t FROM TipoPaciente t"),
    @NamedQuery(name = "TipoPaciente.findByIdtipoPaciente", query = "SELECT t FROM TipoPaciente t WHERE t.idtipoPaciente = :idtipoPaciente"),
    @NamedQuery(name = "TipoPaciente.findByClase", query = "SELECT t FROM TipoPaciente t WHERE t.clase = :clase"),
    @NamedQuery(name = "TipoPaciente.findByRaza", query = "SELECT t FROM TipoPaciente t WHERE t.raza = :raza")})
public class TipoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_paciente")
    private Integer idtipoPaciente;
    @Size(max = 45)
    @Column(name = "clase")
    private String clase;
    @Size(max = 45)
    @Column(name = "raza")
    private String raza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPacienteIdtipoPaciente")
    private Collection<Paciente> pacienteCollection;

    public TipoPaciente() {
    }

    public TipoPaciente(Integer idtipoPaciente) {
        this.idtipoPaciente = idtipoPaciente;
    }

    public Integer getIdtipoPaciente() {
        return idtipoPaciente;
    }

    public void setIdtipoPaciente(Integer idtipoPaciente) {
        this.idtipoPaciente = idtipoPaciente;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
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
        hash += (idtipoPaciente != null ? idtipoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaciente)) {
            return false;
        }
        TipoPaciente other = (TipoPaciente) object;
        if ((this.idtipoPaciente == null && other.idtipoPaciente != null) || (this.idtipoPaciente != null && !this.idtipoPaciente.equals(other.idtipoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoPaciente[ idtipoPaciente=" + idtipoPaciente + " ]";
    }
    
}
