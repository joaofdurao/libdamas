package br.com.libdamas;

import java.time.LocalDate;

import br.com.libdamas.DAO.LoanDAO;
import br.com.libdamas.DAO.UserDAO;
import br.com.libdamas.models.Loan;
import br.com.libdamas.models.Student;
import br.com.libdamas.views.system.MainScreen;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariaDB");
        // new LoginScreen().setVisible(true);
        Student studentTest = new Student();   
        studentTest.setName("Teste");
        studentTest.setEnrollment("456");
        studentTest.setPasssword("123");
        studentTest.setPhoneNumber("965472358");

        UserDAO userDAOteste = new UserDAO();
        userDAOteste.createInstance(studentTest);
        
        Loan loanTest = new Loan();
        LoanDAO loanTeste = new LoanDAO();
        loanTest.setUser(studentTest);
        loanTest.setReturnDate(LocalDate.now());
        loanTeste.createInstance(loanTest);
        new MainScreen();
        

    }
}
