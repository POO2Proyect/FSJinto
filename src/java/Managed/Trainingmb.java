package Managed;

import Model.Capacitaciones;
import Model.Categorias;
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
public class Trainingmb {
    
    private Capacitaciones capacitacion = new Capacitaciones();
    private List<Capacitaciones> listaCapacitaciones;
    private int idCategoriaForm;
    
    /*Se crea una nueva instancia para Trainingmb*/
    public Trainingmb() {
    }
    
    public List<Categorias> getListaCategoria(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Categorias.findAll");
        List<Categorias> lista = query.getResultList();
        em.close();
                return lista;
    }
    
    public List<Capacitaciones> getListaCapacitaciones(){
        if(listaCapacitaciones==null) generarListaCapacitaciones();
        
        return this.listaCapacitaciones;
    }
    
    public String guardarCapacitaciones(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
        EntityManager em = emf.createEntityManager();
        Categorias catFormulario = em.find(Categorias.class, idCategoriaForm);
        this.capacitacion.setIdCategoria(catFormulario);
        
        em.getTransaction().begin();
        em.persist(this.capacitacion);
        em.getTransaction().commit();
        
        generarListaCapacitaciones();
        
        em.close();
        this.capacitacion = null;
        
        return "index";
        
    }
    
    
    public String modificarCapacitacion(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Capacitaciones tmpCapacitacion = em.find(Capacitaciones.class, capacitacion.getIdCategoria());
        
        this.capacitacion = tmpCapacitacion;
        
        em.merge(capacitacion);
        em.getTransaction().commit();
        generarListaCapacitaciones();
        em.close();
        
        return "index";
    }
    
    private void generarListaCapacitaciones(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFintoPU");
        EntityManager em = emf.createEntityManager();
        
        Query jpaql = em.createQuery("SELECT C FROM Capacitaciones C ORDER BY C.fecha");
        
        this.listaCapacitaciones = jpaql.getResultList();
        
        em.close();
    }

    
    /*GENERACION DE LOS METODOS SETTERS Y GETTERS DE MANETA AUTOMARICA CON EL
    REFACTO DE NETBEANS*/
    
    
    public Capacitaciones getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitaciones capacitacion) {
        this.capacitacion = capacitacion;
    }

    public int getIdCategoriaForm() {
        return idCategoriaForm;
    }

    public void setIdCategoriaForm(int idCategoriaForm) {
        this.idCategoriaForm = idCategoriaForm;
    }
    
    
}
