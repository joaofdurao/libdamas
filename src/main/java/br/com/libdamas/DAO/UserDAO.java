package br.com.libdamas.DAO;

import br.com.libdamas.models.User;

public class UserDAO extends InstanceDAO<User> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
}
