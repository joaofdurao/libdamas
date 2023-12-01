package br.com.libdamas.DAO;

public class UserDAO {


	public void createUser(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public User readUser(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		User user = new User();
		
		try {
			em.getTransaction().begin();
			user = em.find(User.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return user;
	}

	public void updateUser(User user, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			user = em.find(User.class, id);
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void deleteUser(User user, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			user = em.find(User.class, id);
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
