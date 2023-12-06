package br.com.libdamas.controllers;

import br.com.libdamas.DAO.LoanDAO;
import br.com.libdamas.models.Loan;

public class LoanController {

    public Loan findLoanById(Long loanId) {
        LoanDAO loanDAO = new LoanDAO();
        try {
            return loanDAO.findInstance(loanId);
        } catch (Exception e) {
            return null;
        }

    }
}
