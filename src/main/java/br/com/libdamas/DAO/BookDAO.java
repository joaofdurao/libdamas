package br.com.libdamas.DAO;

public class BookDAO {


	public void createBook(Book book) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(book);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Book readBook(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Book book = new Book();
		
		try {
			em.getTransaction().begin();
			book = em.find(Book.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return book;
	}

	public void updateBook(Book book, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			book = em.find(Book.class, id);
			em.merge(book);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void deleteBook(Book book, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			book = em.find(Book.class, id);
			em.remove(book);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
