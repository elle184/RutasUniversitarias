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
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r"),
    @NamedQuery(name = "Rutas.findByIdRuta", query = "SELECT r FROM Rutas r WHERE r.idRuta = :idRuta"),
    @NamedQuery(name = "Rutas.findByCodigoRuta", query = "SELECT r FROM Rutas r WHERE r.codigoRuta = :codigoRuta"),
    @NamedQuery(name = "Rutas.findByNombreRuta", query = "SELECT r FROM Rutas r WHERE r.nombreRuta = :nombreRuta"),
    @NamedQuery(name = "Rutas.findByCantidadPuestos", query = "SELECT r FROM Rutas r WHERE r.cantidadPuestos = :cantidadPuestos"),
    @NamedQuery(name = "Rutas.findByPuestosDisponibles", query = "SELECT r FROM Rutas r WHERE r.puestosDisponibles = :puestosDisponibles")})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ruta")
    private Long idRuta;
    @Column(name = "codigo_ruta")
    private String codigoRuta;
    @Column(name = "nombre_ruta")
    private String nombreRuta;
    @Column(name = "cantidad_puestos")
    private Integer cantidadPuestos;
    @Column(name = "puestos_disponibles")
    private Integer puestosDisponibles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private List<ApartadoPuestos> apartadoPuestosList;
    @JoinColumn(name = "id_bus_responsable_ruta", referencedColumnName = "id_bus")
    @ManyToOne(optional = false)
    private Buses idBusResponsableRuta;

    public Rutas() {
    }

    public Rutas(Long idRuta) {
        this.idRuta = idRuta;
    }

    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public String getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(String codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public Integer getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(Integer cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }

    public Integer getPuestosDisponibles() {
        return puestosDisponibles;
    }

    public void setPuestosDisponibles(Integer puestosDisponibles) {
        this.puestosDisponibles = puestosDisponibles;
    }

    @XmlTransient
    public List<ApartadoPuestos> getApartadoPuestosList() {
        return apartadoPuestosList;
    }

    public void setApartadoPuestosList(List<ApartadoPuestos> apartadoPuestosList) {
        this.apartadoPuestosList = apartadoPuestosList;
    }

    public Buses getIdBusResponsableRuta() {
        return idBusResponsableRuta;
    }

    public void setIdBusResponsableRuta(Buses idBusResponsableRuta) {
        this.idBusResponsableRuta = idBusResponsableRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutasuniversitarias.persistencia.entidad.Rutas[ idRuta=" + idRuta + " ]";
    }
    
}
