package br.com.libdamas.DAO;

import java.util.List;

import br.com.libdamas.models.User;
import br.com.libdamas.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAO extends InstanceDAO<User> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	// FindByName
	public User findByName(String name) {
		JPAUtils jpaUtils = new JPAUtils();
		EntityManager entityManager = jpaUtils.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("FROM User WHERE name = :name", User.class);
		query.setParameter("name", name);
		List<User> users = query.getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}
}
