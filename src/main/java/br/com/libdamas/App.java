package br.com.libdamas;

import java.time.LocalDate;

import br.com.libdamas.DAO.LoanDAO;
import br.com.libdamas.DAO.UserDAO;
import br.com.libdamas.models.Loan;
import br.com.libdamas.views.system.LoginScreen;

public class App {
    public static void main(String[] args) {

        // Student studentTest = new Student();
        // studentTest.setName("Teste");
        // studentTest.setEnrollment("456");
        // studentTest.setPasssword("123");
        // studentTest.setPhoneNumber("965472358");

        // Admin adminTest = new Admin();
        // adminTest.setName("TesteAdmin");
        // adminTest.setPasssword("123");
        // adminTest.setPhoneNumber("965472358");
        // adminTest.setEnrollment("789");

        // UserDAO userDAOteste = new UserDAO();
        // userDAOteste.createInstance(studentTest);
        // userDAOteste.createInstance(adminTest);

        // for (int i = 0; i < 25; i++) {
        //     Loan loanTest = new Loan();
        //     LoanDAO loanTeste = new LoanDAO();
        //     loanTest.setUser(new UserDAO().findByEnrollment("456"));
        //     loanTest.setLoanDate(LocalDate.now());
        //     loanTest.setReturnDate(LocalDate.now().plusDays(i));
        //     loanTest.setClosed(false);
        //     loanTest.setOverdue(false);
        //     loanTeste.createInstance(loanTest);
        // }

        new LoginScreen();

    }
}
