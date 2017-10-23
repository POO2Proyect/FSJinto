package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitaciones.findAll", query = "SELECT c FROM Capacitaciones c")
    , @NamedQuery(name = "Capacitaciones.findByIdCapacitacion", query = "SELECT c FROM Capacitaciones c WHERE c.idCapacitacion = :idCapacitacion")
    , @NamedQuery(name = "Capacitaciones.findByIdCategoria", query = "SELECT c FROM Capacitaciones c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "Capacitaciones.findByDescripcion", query = "SELECT c FROM Capacitaciones c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Capacitaciones.findByFecha", query = "SELECT c FROM Capacitaciones c WHERE c.fecha = :fecha")})
public class Capacitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_capacitacion")
    private Integer idCapacitacion;
    @Column(name = "id_categoria")
    private Integer idCategoria;
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Capacitaciones() {
    }

    public Capacitaciones(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCapacitacion != null ? idCapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitaciones)) {
            return false;
        }
        Capacitaciones other = (Capacitaciones) object;
        if ((this.idCapacitacion == null && other.idCapacitacion != null) || (this.idCapacitacion != null && !this.idCapacitacion.equals(other.idCapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Capacitaciones[ idCapacitacion=" + idCapacitacion + " ]";
    }

    public int setIdCategoria(Categorias catFormulario) {
        int c = catFormulario.hashCode();
        return c;
    }
    
}
