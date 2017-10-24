package Managed;

import Model.Empleado;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class Employeemb {

    /**
     * Employee es la instancia de la Entity Class
     * Generar Setters y Getters
     */
    
    private Empleado employee = new Empleado();
    private List<Empleado> listaEmpleados;
    
    /*guardar Empleados en la db*/
    public String guardarEmpleado(){
        //indicamos donde esta ubicado el JSFintoPU
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(this.getEmployee());
        em.getTransaction().commit();
        
        this.employee = null;
        
        generarListaEmpleado();
        
        em.close();
        return "Employee";
    }
    
    //listar los empleados de la Base de Datos
    public List<Empleado> getEmpleado(){
        /**
        * generarListaEmpleado carga la lista de empleados
        * El objetivo es que la lista no se este generando constantemente
        * ademÃ¡s, DataTable trabaja con la lista para poderla ordenar.
        */
        if(this.listaEmpleados == null){
            generarListaEmpleado();
        }
        
        return this.listaEmpleados;
    }
    
    /**
    * @return the employee
    */
    
    //generar lista de Empleados
    private void generarListaEmpleado() {
        //indicar donde se ubica el JSFintoPU
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
        EntityManager em = emf.createEntityManager();
        Query sql = em.createQuery("select E from Empleado E");
        this.listaEmpleados = sql.getResultList();
        em.close();
    }
    
    public Employeemb() {
    }
    
    
    /**
    *
    * LOS SIGUIENTES SETTER Y GETTERS, DEBEN DE GENERARSE AUTOMATICAMENTE
    * CON EL REFACTOR.
    *
    * @return 
    */
    
    
    public Empleado getEmployee() {
        return employee;
    }
    
    /**
    * @param employee the employee to set
    */
    public void setEmployee(Empleado employee) {
        this.employee = employee;
    }

    
    
}
