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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.idpaciente = :idpaciente"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByFechaNasaprox", query = "SELECT p FROM Paciente p WHERE p.fechaNasaprox = :fechaNasaprox")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "fecha_nasaprox")
    private String fechaNasaprox;
    @JoinColumn(name = "due\u00f1o_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Duenio dueñoCedula;
    @JoinColumn(name = "tipo_paciente_idtipo_paciente", referencedColumnName = "idtipo_paciente")
    @ManyToOne(optional = false)
    private TipoPaciente tipoPacienteIdtipoPaciente;
    @JoinColumn(name = "vacunas_idvacunas", referencedColumnName = "idvacunas")
    @ManyToOne(optional = false)
    private Vacunas vacunasIdvacunas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteIdpaciente")
    private Collection<HistoriaClinica> historiaClinicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteIdpaciente")
    private Collection<Cita> citaCollection;

    public Paciente() {
    }

    public Paciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNasaprox() {
        return fechaNasaprox;
    }

    public void setFechaNasaprox(String fechaNasaprox) {
        this.fechaNasaprox = fechaNasaprox;
    }

    public Duenio getDueñoCedula() {
        return dueñoCedula;
    }

    public void setDueñoCedula(Duenio dueñoCedula) {
        this.dueñoCedula = dueñoCedula;
    }

    public TipoPaciente getTipoPacienteIdtipoPaciente() {
        return tipoPacienteIdtipoPaciente;
    }

    public void setTipoPacienteIdtipoPaciente(TipoPaciente tipoPacienteIdtipoPaciente) {
        this.tipoPacienteIdtipoPaciente = tipoPacienteIdtipoPaciente;
    }

    public Vacunas getVacunasIdvacunas() {
        return vacunasIdvacunas;
    }

    public void setVacunasIdvacunas(Vacunas vacunasIdvacunas) {
        this.vacunasIdvacunas = vacunasIdvacunas;
    }

    @XmlTransient
    public Collection<HistoriaClinica> getHistoriaClinicaCollection() {
        return historiaClinicaCollection;
    }

    public void setHistoriaClinicaCollection(Collection<HistoriaClinica> historiaClinicaCollection) {
        this.historiaClinicaCollection = historiaClinicaCollection;
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
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Paciente[ idpaciente=" + idpaciente + " ]";
    }
    
}
