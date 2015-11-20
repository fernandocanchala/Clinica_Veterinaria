/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FERNANDO
 */
@Entity
@Table(name = "vacunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacunas.findAll", query = "SELECT v FROM Vacunas v"),
    @NamedQuery(name = "Vacunas.findByIdvacunas", query = "SELECT v FROM Vacunas v WHERE v.idvacunas = :idvacunas"),
    @NamedQuery(name = "Vacunas.findByVacuna", query = "SELECT v FROM Vacunas v WHERE v.vacuna = :vacuna"),
    @NamedQuery(name = "Vacunas.findByFecha", query = "SELECT v FROM Vacunas v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vacunas.findByProxFecha", query = "SELECT v FROM Vacunas v WHERE v.proxFecha = :proxFecha")})
public class Vacunas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvacunas")
    private Integer idvacunas;
    @Size(max = 45)
    @Column(name = "vacuna")
    private String vacuna;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "prox_fecha")
    @Temporal(TemporalType.DATE)
    private Date proxFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacunasIdvacunas")
    private Collection<Paciente> pacienteCollection;

    public Vacunas() {
    }

    public Vacunas(Integer idvacunas) {
        this.idvacunas = idvacunas;
    }

    public Integer getIdvacunas() {
        return idvacunas;
    }

    public void setIdvacunas(Integer idvacunas) {
        this.idvacunas = idvacunas;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getProxFecha() {
        return proxFecha;
    }

    public void setProxFecha(Date proxFecha) {
        this.proxFecha = proxFecha;
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
        hash += (idvacunas != null ? idvacunas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunas)) {
            return false;
        }
        Vacunas other = (Vacunas) object;
        if ((this.idvacunas == null && other.idvacunas != null) || (this.idvacunas != null && !this.idvacunas.equals(other.idvacunas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vacunas[ idvacunas=" + idvacunas + " ]";
    }
    
}
