/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author sgrsm
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            
            System.out.println("LOG-HIBERNATE-UTIL-01" );
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
           // sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
           sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("LOG-HIBERNATE-UTIL-02" );
        } catch (Throwable ex) {
            // Log the exception. 
            System.out.println("LOG-HIBERNATE-UTIL-03" );
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
            System.out.println("LOG-HIBERNATE-UTIL-getSessionFactory()" );
        return sessionFactory;
    }
}
