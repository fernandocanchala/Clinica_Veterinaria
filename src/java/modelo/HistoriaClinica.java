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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FERNANDO
 */
@Entity
@Table(name = "historia_clinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaClinica.findAll", query = "SELECT h FROM HistoriaClinica h"),
    @NamedQuery(name = "HistoriaClinica.findByIdhistoriaClinica", query = "SELECT h FROM HistoriaClinica h WHERE h.idhistoriaClinica = :idhistoriaClinica"),
    @NamedQuery(name = "HistoriaClinica.findByDescripcion", query = "SELECT h FROM HistoriaClinica h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HistoriaClinica.findByFecha", query = "SELECT h FROM HistoriaClinica h WHERE h.fecha = :fecha")})
public class HistoriaClinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhistoria_clinica")
    private Integer idhistoriaClinica;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "paciente_idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Paciente pacienteIdpaciente;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Integer idhistoriaClinica) {
        this.idhistoriaClinica = idhistoriaClinica;
    }

    public Integer getIdhistoriaClinica() {
        return idhistoriaClinica;
    }

    public void setIdhistoriaClinica(Integer idhistoriaClinica) {
        this.idhistoriaClinica = idhistoriaClinica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    public void setPacienteIdpaciente(Paciente pacienteIdpaciente) {
        this.pacienteIdpaciente = pacienteIdpaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistoriaClinica != null ? idhistoriaClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaClinica)) {
            return false;
        }
        HistoriaClinica other = (HistoriaClinica) object;
        if ((this.idhistoriaClinica == null && other.idhistoriaClinica != null) || (this.idhistoriaClinica != null && !this.idhistoriaClinica.equals(other.idhistoriaClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HistoriaClinica[ idhistoriaClinica=" + idhistoriaClinica + " ]";
    }
    
}
