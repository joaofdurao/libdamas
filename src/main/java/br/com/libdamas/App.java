package br.com.libdamas;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.libdamas.utils.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    }
}
