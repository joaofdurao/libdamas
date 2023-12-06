package br.com.libdamas.utils;

import java.util.function.Consumer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAUtils {

    private EntityManagerFactory emf;

    public JPAUtils() {
        emf = Persistence.createEntityManagerFactory("mariaDB");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

}
