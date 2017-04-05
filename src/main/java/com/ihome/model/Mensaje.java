package com.ihome.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmenard
 */
@Entity
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m")
        , @NamedQuery(name = "Mensaje.findById", query = "SELECT m FROM Mensaje m WHERE m.id = :id")
        , @NamedQuery(name = "Mensaje.findByEmailCliente", query = "SELECT m FROM Mensaje m WHERE m.emailCliente = :emailCliente")
        , @NamedQuery(name = "Mensaje.findByTelefonoCliente", query = "SELECT m FROM Mensaje m WHERE m.telefonoCliente = :telefonoCliente")
        , @NamedQuery(name = "Mensaje.findByFechaMensaje", query = "SELECT m FROM Mensaje m WHERE m.fechaMensaje = :fechaMensaje")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "email_cliente")
    private String emailCliente;
    @Column(name = "telefono_cliente")
    private String telefonoCliente;
    @Lob
    @Column(name = "mensaje_cliente")
    private String mensajeCliente;
    @Column(name = "fecha_mensaje")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMensaje;
    @JoinColumn(name = "id_immueble", referencedColumnName = "id")
    @ManyToOne
    private Immueble idImmueble;

    public Mensaje() {
    }

    public Mensaje(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getMensajeCliente() {
        return mensajeCliente;
    }

    public void setMensajeCliente(String mensajeCliente) {
        this.mensajeCliente = mensajeCliente;
    }

    public Date getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Date fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
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
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensaje[ id=" + id + " ]";
    }

}
