/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FERNANDO
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIdcita", query = "SELECT c FROM Cita c WHERE c.idcita = :idcita"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcita")
    private Integer idcita;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "paciente_idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Paciente pacienteIdpaciente;
    @JoinColumn(name = "veterinario_idveterinario", referencedColumnName = "idveterinario")
    @ManyToOne(optional = false)
    private Veterinario veterinarioIdveterinario;

    public Cita() {
    }

    public Cita(Integer idcita) {
        this.idcita = idcita;
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Paciente getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    public void setPacienteIdpaciente(Paciente pacienteIdpaciente) {
        this.pacienteIdpaciente = pacienteIdpaciente;
    }

    public Veterinario getVeterinarioIdveterinario() {
        return veterinarioIdveterinario;
    }

    public void setVeterinarioIdveterinario(Veterinario veterinarioIdveterinario) {
        this.veterinarioIdveterinario = veterinarioIdveterinario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcita != null ? idcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idcita == null && other.idcita != null) || (this.idcita != null && !this.idcita.equals(other.idcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cita[ idcita=" + idcita + " ]";
    }
    
}
