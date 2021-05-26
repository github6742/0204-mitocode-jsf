/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
/*
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
*/


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Usuario;


public class UsuarioDAO {
/*
    private Session session;
    
   public Usuario verificarDatos(Usuario usuario) throws Exception {
        Usuario us = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "' and clave = '" + usuario.getClave() + "'";
            
            Query query = session.createQuery(hql);

            
            if (!query.list().isEmpty()) {
                us = (Usuario) query.list().get(0);
            }

        } catch (Exception e) {
            throw e;
        }

        return us;
    }
    
   */
    private EntityManager em;
    private EntityManagerFactory emf = null;

    public UsuarioDAO() {
        // Usarmos el persistence unit
        emf = Persistence.createEntityManagerFactory("HibernatePU");
    }

    public Usuario verificarDatos(Usuario usuario) throws Exception {
        Usuario us = null;

        try {

            String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "' and clave = '" + usuario.getClave() + "'";
            em = getEntityManager();
            Query query = em.createQuery(hql);

            List<Usuario> list = query.getResultList();

            if (!query.getResultList().isEmpty()) {
                us = (Usuario) query.getResultList().get(0);
            }

        } catch (Exception e) {
            throw e;
        }

        return us;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
