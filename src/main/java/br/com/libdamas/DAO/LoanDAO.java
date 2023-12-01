package br.com.libdamas.DAO;

public class LoanDAO {


	public void createLoan(Loan loan) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(loan);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Loan readLoan(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Loan loan = new Loan();
		
		try {
			em.getTransaction().begin();
			loan = em.find(Loan.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return loan;
	}

	public void updateLoan(Loan loan, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			loan = em.find(Loan.class, id);
			em.merge(loan);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void deleteLoan(Loan loan, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			loan = em.find(Loan.class, id);
			em.remove(loan);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
