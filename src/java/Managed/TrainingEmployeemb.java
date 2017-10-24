package Managed;

import Model.CapacitacionEmpleado;
import Model.Capacitaciones;
import Model.Empleado;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.context.RequestContext;

/**
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class TrainingEmployeemb {

    /**
     * Creates a new instance of TrainingEmployeemb
     */
    
    private String idCapacitacion;
    private String[] empleadosSeleccionados;
    
    public TrainingEmployeemb() {
    }
    
    public List<Empleado> listaEmpleadoCapacitacion(){
        List<Empleado> tmpEmpleado = null;
        if(this.idCapacitacion != null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
            EntityManager em = emf.createEntityManager();
            
            Query sql = em.createQuery("select CE.codEmpleado from CapacitacionEmpleado CE where"
                    + "CE.idCapacitacion.idCapacitacion=:idCapacitacion");
            
            sql.setParameter("idCapacitacion", Integer.parseInt(this.idCapacitacion));
            
            tmpEmpleado = sql.getResultList();
            
            em.close();
        }
        
        return tmpEmpleado;
    }
    
    
    public String guardarEmpleado(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
        EntityManager em = emf.createEntityManager();
        
        for(String tmpEmpleados:empleadosSeleccionados){
            Query sql = em.createQuery("select CP from capacitacion_empleado CP where"
                    + "CP.cod_empleado.cod_empleado = :codEmpleado"
                    + "and"
                    + "CP.id_capacitacion.id_capacitacion = :idCapacitacion");
            
            sql.setParameter("codEmpleado", tmpEmpleados);
            sql.setParameter("idCapacitacion", Integer.parseInt(this.idCapacitacion));
            
            Empleado tmpEmpleado = em.find(Empleado.class, tmpEmpleados);
            Capacitaciones tmpCapacitacion = em.find(Capacitaciones.class, Integer.parseInt(this.idCapacitacion));
            
            em.getTransaction().begin();
            
            if(sql.getResultList().isEmpty()){
                CapacitacionEmpleado capacitacionEmpleado = new CapacitacionEmpleado();
                capacitacionEmpleado.setCodEmpleado(tmpEmpleado);
                capacitacionEmpleado.setIdCapacitacion(tmpCapacitacion);
                //los demas valores son automaticos
                em.persist(capacitacionEmpleado);
            }
            
            em.getTransaction().commit();
        }
        em.close();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Finalizada","Operacion Finalizada");
        RequestContext.getCurrentInstance().showMessageInDialog(msg);
        
        return "training";
    }
    
    /**
    *
    * LOS SIGUIENTES SETTER Y GETTERS, DEBEN DE GENERARSE
    AUTOMATICAMENTE
    * CON EL REFACTOR.
    *
    */
    
    
    /**
    * @return the valor
    */

    public String getIdCapacitacion() {
        return idCapacitacion;
    }
    
    /**
     * @param valor
    */

    public void setIdCapacitacion(String valor) {
        this.idCapacitacion = valor;
    }
    
    /**
    * @return the empleadosSeleccionados
    */

    public String[] getEmpleadosSeleccionados() {
        return empleadosSeleccionados;
    }
    
    /**
    * @param empleadosSeleccionados the empleadosSeleccionados to set
    */

    public void setEmpleadosSeleccionados(String[] empleadosSeleccionados) {
        this.empleadosSeleccionados = empleadosSeleccionados;
    }
    
    
    
    
    
    
}
