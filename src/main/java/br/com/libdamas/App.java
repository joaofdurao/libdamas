package br.com.libdamas;

import br.com.libdamas.DAO.LoanDAO;
import br.com.libdamas.models.Loan;
import br.com.libdamas.views.system.MainScreen;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariaDB");
        // new LoginScreen().setVisible(true);
        Loan loanTest = new Loan();
        LoanDAO loanTeste = new LoanDAO();
        loanTeste.createInstance(loanTest);
        new MainScreen();
        

    }
}
