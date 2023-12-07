package br.com.libdamas.DAO;

import br.com.libdamas.models.Book;
import br.com.libdamas.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class BookDAO extends InstanceDAO<Book> {

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }

    public void update(Book book) {
		JPAUtils jpaUtils = new JPAUtils();
        EntityManager entityManager = jpaUtils.getEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            if (!entityManager.contains(book)) {
                book = entityManager.merge(book);
            }

            entityManager.merge(book);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void delete(Book book) {
        JPAUtils jpaUtils = new JPAUtils();
        EntityManager entityManager = jpaUtils.getEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            if (!entityManager.contains(book)) {
                book = entityManager.merge(book);
            }

            entityManager.remove(book);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
