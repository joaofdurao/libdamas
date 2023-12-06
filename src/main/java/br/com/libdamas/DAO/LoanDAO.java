package br.com.libdamas.DAO;

import br.com.libdamas.models.Loan;

public class LoanDAO extends InstanceDAO<Loan> {
	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}

	public void postponeLoan(Integer loanId) {
		Loan loan = findInstance(loanId);
		if (loan != null) {
			loan.setReturnDate(loan.getReturnDate().plusDays(15));
			updateInstance(loan, loanId);
		}
	}
}
	

	

