package br.com.libdamas.DAO;

import br.com.libdamas.models.Book;
import br.com.libdamas.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookDAO extends InstanceDAO<Book> {

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }

    public void update(Book book) {
        EntityManager entityManager = JPAUtils.getEntityManager();

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
        EntityManager entityManager = JPAUtils.getEntityManager();

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
