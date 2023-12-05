package br.com.libdamas.DAO;

import jakarta.persistence.EntityManager;

public class BookDAO implements ObjectDAO {

	public void createInstance(Object obj) {
		EntityManager em = ObjectDAO.generateEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Object readInstance(Integer id) {
		EntityManager em = ObjectDAO.generateEntityManager();
		Object obj = new Object();

		try {
			em.getTransaction().begin();
			obj = em.find(Object.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return obj;
	}

	public void updateInstance(Object obj, Integer id) {
		EntityManager em = ObjectDAO.generateEntityManager();

		try {
			em.getTransaction().begin();
			obj = em.find(Object.class, id);
			em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void deleteInstance(Object obj, Integer id) {
		EntityManager em = ObjectDAO.generateEntityManager();

		try {
			em.getTransaction().begin();
			obj = em.find(Object.class, id);
			em.remove(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
