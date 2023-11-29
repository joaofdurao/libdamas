package br.com.libdamas;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariaDB");
        
        
    }
}
