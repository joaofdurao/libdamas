package br.com.libdamas.DAO;

import java.util.List;

import br.com.libdamas.models.Loan;
import br.com.libdamas.utils.JPAUtils;
import jakarta.persistence.EntityManager;

public class LoanDAO extends InstanceDAO<Loan> {

	JPAUtils jpaUtils;

	public LoanDAO() {
		this.jpaUtils = new JPAUtils();
	}

	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}

	public List<Loan> findLoansByUser(Long userId) {
		EntityManager entityManager = jpaUtils.getEntityManager();
		try {
			return entityManager.createQuery("SELECT l FROM Loan l WHERE l.user.id = :userID", Loan.class)
					.setParameter("userID", userId)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
