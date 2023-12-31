package br.com.libdamas.views.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import br.com.libdamas.controllers.UserController;
import br.com.libdamas.views.loan.AdminLoanScreen;
import br.com.libdamas.views.loan.LoanScreen;
import br.com.libdamas.views.user.AdminUserScreen;
import br.com.libdamas.views.user.UserScreen;

public abstract class ScreenConfigs<T> extends JFrame {

    protected abstract Class<T> getEntityClass();
    protected abstract void initComponents();
    private UserController userController;
    private Long userId;

    public ScreenConfigs(Long userId) {
        userController = new UserController();
        this.userId = userId;
    }

    public ScreenConfigs() {
        super();
    }

    public void initScreenTemplate() {
        setTitle(getEntityClass().getSimpleName());
        setSize(215, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
    }

    public void openBookScreenButton() {
        JButton booksButton = new JButton("Books");
        booksButton.setBounds(50, 50, 100, 30);
        booksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBooksScreen();
            }
        });

        add(booksButton);
    }

    public void openLoanScreenButton() {
        JButton loansButton = new JButton("Loans");
        loansButton.setBounds(50, 100, 100, 30);
        loansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoansScreen();
            }
        });

        add(loansButton);
    }

    public void openUserScreenButton() {
        JButton usersButton = new JButton("Users");
        usersButton.setBounds(50, 150, 100, 30);
        usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUsersScreen();
            }
        });

        add(usersButton);
    }

    public void openBooksScreen() {
    //    new BookScreen();
    }

    public void openLoansScreen() {
        if (userController.getUserRole(userId).equals("admin")) {
            new AdminLoanScreen(userId);
        } else{
            new LoanScreen(userId);
        }
    }

    public void openUsersScreen() {
        if (userController.getUserRole(userId).equals("admin")) {
            new AdminUserScreen(userId);
        } else{
            // new UserScreen(userId);
        }
    }

}
