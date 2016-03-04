/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutasuniversitarias.persistencia.entidad;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abecerra
 */
@Entity
@Table(name = "buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b"),
    @NamedQuery(name = "Buses.findByIdBus", query = "SELECT b FROM Buses b WHERE b.idBus = :idBus"),
    @NamedQuery(name = "Buses.findByMarca", query = "SELECT b FROM Buses b WHERE b.marca = :marca"),
    @NamedQuery(name = "Buses.findByNumeroPlaca", query = "SELECT b FROM Buses b WHERE b.numeroPlaca = :numeroPlaca")})
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bus")
    private Integer idBus;
    @Column(name = "marca")
    private String marca;
    @Column(name = "numero_placa")
    private String numeroPlaca;
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Personas idConductor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBusResponsableRuta")
    private List<Rutas> rutasList;

    public Buses() {
    }

    public Buses(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Personas getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Personas idConductor) {
        this.idConductor = idConductor;
    }

    @XmlTransient
    public List<Rutas> getRutasList() {
        return rutasList;
    }

    public void setRutasList(List<Rutas> rutasList) {
        this.rutasList = rutasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBus != null ? idBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.idBus == null && other.idBus != null) || (this.idBus != null && !this.idBus.equals(other.idBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutasuniversitarias.persistencia.entidad.Buses[ idBus=" + idBus + " ]";
    }
    
}
