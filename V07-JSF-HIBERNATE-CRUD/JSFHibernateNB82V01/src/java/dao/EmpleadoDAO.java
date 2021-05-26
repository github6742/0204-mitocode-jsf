/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Empleado;
import org.hibernate.Query;

/**
 *
 * @author sgrsm
 */
public class EmpleadoDAO {

    private EntityManager em;
    private EntityManagerFactory emf = null;
    private List<Empleado> lstEmpleados;

    public EmpleadoDAO() {
        // Usarmos el persistence unit
        emf = Persistence.createEntityManagerFactory("HibernatePU");
    }

    public void Registrar(Empleado emp) throws Exception {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Insertamos la nueva persona
            em.persist(emp);
            // Terminamos la transaccion
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error al registrar empleado: " + emp.getApellidos());
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void Eliminar(Empleado emp) throws Exception {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Insertamos la nueva persona
			em.remove(em.merge(emp));
            // Terminamos la transaccion
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error al eliminar empleado: " + emp.getApellidos());
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void Modificar(Empleado emp) throws Exception {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Actualizamos al objeto persona
            em.merge(emp);
            // Terminamos la transaccion
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error al modificar empleado: " + emp.getApellidos());
            // ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void Listar1(Empleado emp) throws Exception {
        try {

            String hql = "SELECT e FROM Empleado e";
            em = getEntityManager();
            Query query = (Query) em.createQuery(hql);
            List<Empleado> list = query.getResultList();
            for (Empleado p : list) {
                System.out.println(p);
            }
        } catch (Exception ex) {
            System.out.println("Error al listar empleados");
            // ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public List<Empleado> Listar() throws Exception {
        try {

            String hql = "FROM Empleado";
            em = getEntityManager();
            Query query = (Query) em.createQuery(hql);
            lstEmpleados = query.getResultList();
            /*
            List<Empleado> list = query.getResultList();
            for (Empleado p : list) {
                System.out.println(p);
            }*/
        } catch (Exception ex) {
            System.out.println("Error al listar empleado" );
            // ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return lstEmpleados;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    
}
