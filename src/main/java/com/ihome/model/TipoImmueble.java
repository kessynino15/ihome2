package com.ihome.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmenard
 */
@Entity
@Table(name = "tipo_immueble")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TipoImmueble.findAll", query = "SELECT t FROM TipoImmueble t")
        , @NamedQuery(name = "TipoImmueble.findById", query = "SELECT t FROM TipoImmueble t WHERE t.id = :id")})
public class TipoImmueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoImmueble")
    private Collection<Immueble> immuebleCollection;

    public TipoImmueble() {
    }

    public TipoImmueble(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Immueble> getImmuebleCollection() {
        return immuebleCollection;
    }

    public void setImmuebleCollection(Collection<Immueble> immuebleCollection) {
        this.immuebleCollection = immuebleCollection;
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
        if (!(object instanceof TipoImmueble)) {
            return false;
        }
        TipoImmueble other = (TipoImmueble) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoImmueble[ id=" + id + " ]";
    }

}
