/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutasuniversitarias.persistencia.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abecerra
 */
@Entity
@Table(name = "apartado_puestos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApartadoPuestos.findAll", query = "SELECT a FROM ApartadoPuestos a"),
    @NamedQuery(name = "ApartadoPuestos.findByIdApartadoPuesto", query = "SELECT a FROM ApartadoPuestos a WHERE a.idApartadoPuesto = :idApartadoPuesto"),
    @NamedQuery(name = "ApartadoPuestos.findByCantidadPuestosApartados", query = "SELECT a FROM ApartadoPuestos a WHERE a.cantidadPuestosApartados = :cantidadPuestosApartados")})
public class ApartadoPuestos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_apartado_puesto")
    private Integer idApartadoPuesto;
    @Column(name = "cantidad_puestos_apartados")
    private Integer cantidadPuestosApartados;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Personas idPersona;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    @ManyToOne(optional = false)
    private Rutas idRuta;

    public ApartadoPuestos() {
    }

    public ApartadoPuestos(Integer idApartadoPuesto) {
        this.idApartadoPuesto = idApartadoPuesto;
    }

    public Integer getIdApartadoPuesto() {
        return idApartadoPuesto;
    }

    public void setIdApartadoPuesto(Integer idApartadoPuesto) {
        this.idApartadoPuesto = idApartadoPuesto;
    }

    public Integer getCantidadPuestosApartados() {
        return cantidadPuestosApartados;
    }

    public void setCantidadPuestosApartados(Integer cantidadPuestosApartados) {
        this.cantidadPuestosApartados = cantidadPuestosApartados;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public Rutas getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Rutas idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApartadoPuesto != null ? idApartadoPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApartadoPuestos)) {
            return false;
        }
        ApartadoPuestos other = (ApartadoPuestos) object;
        if ((this.idApartadoPuesto == null && other.idApartadoPuesto != null) || (this.idApartadoPuesto != null && !this.idApartadoPuesto.equals(other.idApartadoPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutasuniversitarias.persistencia.entidad.ApartadoPuestos[ idApartadoPuesto=" + idApartadoPuesto + " ]";
    }
    
}
