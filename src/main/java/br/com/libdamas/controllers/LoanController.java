package br.com.libdamas.controllers;



import java.util.List;

import br.com.libdamas.DAO.LoanDAO;
import br.com.libdamas.models.Loan;

public class LoanController {

    LoanDAO loanDAO;

    public LoanController() {
        loanDAO = new LoanDAO();
    }

    // find loan by id
    public Loan findLoanById(Long loanId) {
        try {
            return loanDAO.findInstance(loanId);
        } catch (Exception e) {
            return null;
        }

    }

    public boolean postponeLoan(Long loanId) {
        try {
            Loan loan = loanDAO.findInstance(loanId);
            if (loan != null) {
                loan.setReturnDate(loan.getReturnDate().plusDays(15));
                loanDAO.updateInstance(loan, loanId);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        
        return false;
    }

    public List<Loan> getLoansByUser(Long userId) {
        try {
            return loanDAO.findLoansByUser(userId);
        } catch (Exception e) {
            return null;
        }
    }

    public Loan getUserLoanById(Long loanId, Long userId) {
        Loan loan = loanDAO.findInstance(loanId);
        if (loan != null && loan.getUser().getId() == userId) {
            return loan;
        }
        return null;
    }


}
