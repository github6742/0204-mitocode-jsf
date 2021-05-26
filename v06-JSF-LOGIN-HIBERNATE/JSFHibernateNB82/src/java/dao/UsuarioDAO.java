/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class UsuarioDAO {

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
}
