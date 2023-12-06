package br.com.libdamas.DAO;

import br.com.libdamas.models.Book;

public class BookDAO extends InstanceDAO<Book> {

	@Override
	protected Class<Book> getEntityClass() {
		return Book.class;
	}
}
