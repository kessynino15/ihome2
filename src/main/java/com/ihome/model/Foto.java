
package com.ihome.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmenard
 */
@Entity
@Table(name = "foto")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Foto.findAll", query = "SELECT f FROM Foto f")
        , @NamedQuery(name = "Foto.findById", query = "SELECT f FROM Foto f WHERE f.id = :id")})
public class Foto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @Lob
    @Column(name = "video")
    private String video;
    @JoinColumn(name = "id_immueble", referencedColumnName = "id")
    @ManyToOne
    private Immueble idImmueble;

    public Foto() {
    }

    public Foto(Long id) {
        this.id = id;
    }

    public Foto(Long id, String video) {
        this.id = id;
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Immueble getIdImmueble() {
        return idImmueble;
    }

    public void setIdImmueble(Immueble idImmueble) {
        this.idImmueble = idImmueble;
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
        if (!(object instanceof Foto)) {
            return false;
        }
        Foto other = (Foto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Foto[ id=" + id + " ]";
    }

}
