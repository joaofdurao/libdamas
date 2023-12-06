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
			System.out.println("Nenhum usuário foi encontrado com essa matrícula");
			return null;
		} else {
			return users.get(0);
		}
	}

	// Part of the name gives a list of possible results
	public List<User> findByName(String partialName) {
		JPAUtils jpaUtils = new JPAUtils();
		EntityManager entityManager = jpaUtils.getEntityManager();
		
		try {
			TypedQuery<User> query = entityManager.createQuery("FROM User WHERE name LIKE :partialName", User.class);
			query.setParameter("partialName", "%" + partialName + "%");
			List<User> users = query.getResultList();
			if (users.isEmpty()) {
				System.out.println("Nenhum usuário encontrado com o nome buscado");
				return null;
			} else {
				return users;
			}
		} finally {
			entityManager.close();
		}
	}


}
