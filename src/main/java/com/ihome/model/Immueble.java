
package com.ihome.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "immueble")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Immueble.findAll", query = "SELECT i FROM Immueble i")
        , @NamedQuery(name = "Immueble.findById", query = "SELECT i FROM Immueble i WHERE i.id = :id")
        , @NamedQuery(name = "Immueble.findByBano", query = "SELECT i FROM Immueble i WHERE i.bano = :bano")
        , @NamedQuery(name = "Immueble.findByHabitaciones", query = "SELECT i FROM Immueble i WHERE i.habitaciones = :habitaciones")
        , @NamedQuery(name = "Immueble.findByMaquecina", query = "SELECT i FROM Immueble i WHERE i.maquecina = :maquecina")
        , @NamedQuery(name = "Immueble.findByMetroCuadrado", query = "SELECT i FROM Immueble i WHERE i.metroCuadrado = :metroCuadrado")
        , @NamedQuery(name = "Immueble.findByPatio", query = "SELECT i FROM Immueble i WHERE i.patio = :patio")
        , @NamedQuery(name = "Immueble.findByPicina", query = "SELECT i FROM Immueble i WHERE i.picina = :picina")
        , @NamedQuery(name = "Immueble.findByPiso", query = "SELECT i FROM Immueble i WHERE i.piso = :piso")
        , @NamedQuery(name = "Immueble.findByLongitud", query = "SELECT i FROM Immueble i WHERE i.longitud = :longitud")
        , @NamedQuery(name = "Immueble.findByLagitude", query = "SELECT i FROM Immueble i WHERE i.lagitude = :lagitude")
        , @NamedQuery(name = "Immueble.findByCiudad", query = "SELECT i FROM Immueble i WHERE i.ciudad = :ciudad")
        , @NamedQuery(name = "Immueble.findBySector", query = "SELECT i FROM Immueble i WHERE i.sector = :sector")
        , @NamedQuery(name = "Immueble.findByPrecio", query = "SELECT i FROM Immueble i WHERE i.precio = :precio")
        , @NamedQuery(name = "Immueble.findByEstado", query = "SELECT i FROM Immueble i WHERE i.estado = :estado")
        , @NamedQuery(name = "Immueble.findByFechaPublicacion", query = "SELECT i FROM Immueble i WHERE i.fechaPublicacion = :fechaPublicacion")
        , @NamedQuery(name = "Immueble.findByFechaAlquila", query = "SELECT i FROM Immueble i WHERE i.fechaAlquila = :fechaAlquila")})
public class Immueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "bano")
    private int bano;
    @Basic(optional = false)
    @Column(name = "habitaciones")
    private int habitaciones;
    @Basic(optional = false)
    @Column(name = "maquecina")
    private int maquecina;
    @Basic(optional = false)
    @Column(name = "metro_cuadrado")
    private int metroCuadrado;
    @Basic(optional = false)
    @Column(name = "patio")
    private int patio;
    @Basic(optional = false)
    @Column(name = "picina")
    private int picina;
    @Basic(optional = false)
    @Column(name = "piso")
    private int piso;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "longitud")
    private String longitud;
    @Basic(optional = false)
    @Column(name = "lagitude")
    private String lagitude;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "sector")
    private String sector;
    @Column(name = "precio")
    private Long precio;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @Basic(optional = false)
    @Column(name = "fecha_alquila")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlquila;
    @JoinColumn(name = "id_referencia", referencedColumnName = "id")
    @ManyToOne
    private Referencia idReferencia;
    @JoinColumn(name = "id_tipo_immueble", referencedColumnName = "id")
    @ManyToOne
    private TipoImmueble idTipoImmueble;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id")
    @ManyToOne
    private Vendedor idVendedor;
    @OneToMany(mappedBy = "idImmueble")
    private Collection<Foto> fotoCollection;
    @OneToMany(mappedBy = "idImmueble")
    private Collection<Mensaje> mensajeCollection;

    public Immueble() {
    }

    public Immueble(Long id) {
        this.id = id;
    }

    public Immueble(Long id, int bano, int habitaciones, int maquecina, int metroCuadrado, int patio, int picina, int piso, String longitud, String lagitude, String ciudad, Date fechaAlquila) {
        this.id = id;
        this.bano = bano;
        this.habitaciones = habitaciones;
        this.maquecina = maquecina;
        this.metroCuadrado = metroCuadrado;
        this.patio = patio;
        this.picina = picina;
        this.piso = piso;
        this.longitud = longitud;
        this.lagitude = lagitude;
        this.ciudad = ciudad;
        this.fechaAlquila = fechaAlquila;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBano() {
        return bano;
    }

    public void setBano(int bano) {
        this.bano = bano;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getMaquecina() {
        return maquecina;
    }

    public void setMaquecina(int maquecina) {
        this.maquecina = maquecina;
    }

    public int getMetroCuadrado() {
        return metroCuadrado;
    }

    public void setMetroCuadrado(int metroCuadrado) {
        this.metroCuadrado = metroCuadrado;
    }

    public int getPatio() {
        return patio;
    }

    public void setPatio(int patio) {
        this.patio = patio;
    }

    public int getPicina() {
        return picina;
    }

    public void setPicina(int picina) {
        this.picina = picina;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLagitude() {
        return lagitude;
    }

    public void setLagitude(String lagitude) {
        this.lagitude = lagitude;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaAlquila() {
        return fechaAlquila;
    }

    public void setFechaAlquila(Date fechaAlquila) {
        this.fechaAlquila = fechaAlquila;
    }

    public Referencia getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Referencia idReferencia) {
        this.idReferencia = idReferencia;
    }

    public TipoImmueble getIdTipoImmueble() {
        return idTipoImmueble;
    }

    public void setIdTipoImmueble(TipoImmueble idTipoImmueble) {
        this.idTipoImmueble = idTipoImmueble;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    @XmlTransient
    public Collection<Foto> getFotoCollection() {
        return fotoCollection;
    }

    public void setFotoCollection(Collection<Foto> fotoCollection) {
        this.fotoCollection = fotoCollection;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
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
        if (!(object instanceof Immueble)) {
            return false;
        }
        Immueble other = (Immueble) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ImmuebleRepository[ id=" + id + " ]";
    }

}
