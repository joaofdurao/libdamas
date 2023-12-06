package br.com.libdamas.DAO;

import br.com.libdamas.utils.JPAUtils;
import jakarta.persistence.EntityManager;

public abstract class InstanceDAO<T> {

    private JPAUtils jpaUtils;

    public InstanceDAO() {
        this.jpaUtils = new JPAUtils();
    }

    public void createInstance(T obj) {
        jpaUtils.executeInsideTransaction(entityManager -> entityManager.persist(obj));
    }

    public T readInstance(Integer id) {
        EntityManager entityManager = jpaUtils.getEntityManager();
        return entityManager.find(getEntityClass(), id);
    }

    public void updateInstance(T obj, Integer id) {
        jpaUtils.executeInsideTransaction(entityManager -> entityManager.merge(obj));
    }

    public void deleteInstance(T obj, Integer id) {
        jpaUtils.executeInsideTransaction(entityManager -> entityManager.remove(obj));
    }

    protected abstract Class<T> getEntityClass();

}
