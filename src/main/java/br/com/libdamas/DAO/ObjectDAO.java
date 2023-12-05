package br.com.libdamas.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface ObjectDAO {

    public static EntityManager generateEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariaDB");
        EntityManager entityManager = emf.createEntityManager();

        return entityManager;
    }

    public void createInstance(Object obj);

    public Object readInstance(Integer id);

    public void updateInstance(Object obj, Integer id);

    public void deleteInstance(Object obj, Integer id);

}
