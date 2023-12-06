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

	// FindByEnrollment
	public User findByEnrollment(String enrollment) {
		JPAUtils jpaUtils = new JPAUtils();
		EntityManager entityManager = jpaUtils.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("FROM User WHERE enrollment = :enrollment", User.class);
		query.setParameter("enrollment", enrollment);
		List<User> users = query.getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

	public User findByName(String partialName) {
		return null;
	}
}
