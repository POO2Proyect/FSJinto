/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "capacitacion_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacitacionEmpleado.findAll", query = "SELECT c FROM CapacitacionEmpleado c")
    , @NamedQuery(name = "CapacitacionEmpleado.findByIdCapacitacionEmpleado", query = "SELECT c FROM CapacitacionEmpleado c WHERE c.idCapacitacionEmpleado = :idCapacitacionEmpleado")
    , @NamedQuery(name = "CapacitacionEmpleado.findByIdCapacitacion", query = "SELECT c FROM CapacitacionEmpleado c WHERE c.idCapacitacion = :idCapacitacion")
    , @NamedQuery(name = "CapacitacionEmpleado.findByCodEmpleado", query = "SELECT c FROM CapacitacionEmpleado c WHERE c.codEmpleado = :codEmpleado")
    , @NamedQuery(name = "CapacitacionEmpleado.findByFechaInscripcion", query = "SELECT c FROM CapacitacionEmpleado c WHERE c.fechaInscripcion = :fechaInscripcion")})
public class CapacitacionEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_capacitacion_empleado")
    private Integer idCapacitacionEmpleado;
    @Column(name = "id_capacitacion")
    private Integer idCapacitacion;
    @Column(name = "cod_empleado")
    private String codEmpleado;
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscripcion;

    public CapacitacionEmpleado() {
    }

    public CapacitacionEmpleado(Integer idCapacitacionEmpleado) {
        this.idCapacitacionEmpleado = idCapacitacionEmpleado;
    }

    public Integer getIdCapacitacionEmpleado() {
        return idCapacitacionEmpleado;
    }

    public void setIdCapacitacionEmpleado(Integer idCapacitacionEmpleado) {
        this.idCapacitacionEmpleado = idCapacitacionEmpleado;
    }

    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCapacitacionEmpleado != null ? idCapacitacionEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionEmpleado)) {
            return false;
        }
        CapacitacionEmpleado other = (CapacitacionEmpleado) object;
        if ((this.idCapacitacionEmpleado == null && other.idCapacitacionEmpleado != null) || (this.idCapacitacionEmpleado != null && !this.idCapacitacionEmpleado.equals(other.idCapacitacionEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CapacitacionEmpleado[ idCapacitacionEmpleado=" + idCapacitacionEmpleado + " ]";
    }

    public String setCodEmpleado(Empleado tmpEmpleado) {
        String c = tmpEmpleado.toString();
        return c;
    }

    public int setIdCapacitacion(Capacitaciones tmpCapacitacion) {
        int c = tmpCapacitacion.hashCode();
        return c;
    }
    
}
