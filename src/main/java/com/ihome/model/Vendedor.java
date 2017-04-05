/*
 *   Copyright 2013-2017 Clockwork Solutions LLC
 *
 *   All Rights Reserved.
 */

package com.ihome.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmenard
 */
@Entity
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
        , @NamedQuery(name = "Vendedor.findById", query = "SELECT v FROM Vendedor v WHERE v.id = :id")
        , @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor v WHERE v.nombre = :nombre")
        , @NamedQuery(name = "Vendedor.findByApellido", query = "SELECT v FROM Vendedor v WHERE v.apellido = :apellido")
        , @NamedQuery(name = "Vendedor.findByIdTipoVendedor", query = "SELECT v FROM Vendedor v WHERE v.idTipoVendedor = :idTipoVendedor")
        , @NamedQuery(name = "Vendedor.findByTelefono", query = "SELECT v FROM Vendedor v WHERE v.telefono = :telefono")
        , @NamedQuery(name = "Vendedor.findByDireccion", query = "SELECT v FROM Vendedor v WHERE v.direccion = :direccion")
        , @NamedQuery(name = "Vendedor.findByEmail", query = "SELECT v FROM Vendedor v WHERE v.email = :email")
        , @NamedQuery(name = "Vendedor.findByPassword", query = "SELECT v FROM Vendedor v WHERE v.password = :password")
        , @NamedQuery(name = "Vendedor.findByEstado", query = "SELECT v FROM Vendedor v WHERE v.estado = :estado")
        , @NamedQuery(name = "Vendedor.findByFechaRegistro", query = "SELECT v FROM Vendedor v WHERE v.fechaRegistro = :fechaRegistro")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "id_tipo_vendedor")
    private BigInteger idTipoVendedor;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(mappedBy = "idVendedor")
    private Collection<Immueble> immuebleCollection;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TipoVendedor tipoVendedor;

    public Vendedor() {
    }

    public Vendedor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigInteger getIdTipoVendedor() {
        return idTipoVendedor;
    }

    public void setIdTipoVendedor(BigInteger idTipoVendedor) {
        this.idTipoVendedor = idTipoVendedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<Immueble> getImmuebleCollection() {
        return immuebleCollection;
    }

    public void setImmuebleCollection(Collection<Immueble> immuebleCollection) {
        this.immuebleCollection = immuebleCollection;
    }

    public TipoVendedor getTipoVendedor() {
        return tipoVendedor;
    }

    public void setTipoVendedor(TipoVendedor tipoVendedor) {
        this.tipoVendedor = tipoVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendedor[ id=" + id + " ]";
    }

}
