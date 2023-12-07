package br.com.libdamas.DAO;

import br.com.libdamas.models.Loan;

public class LoanDAO extends InstanceDAO<Loan> {
	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
}
	

	

