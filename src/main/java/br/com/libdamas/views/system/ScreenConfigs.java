package br.com.libdamas.views.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import br.com.libdamas.views.loan.AdminLoanScreen;

public abstract class ScreenConfigs<T> extends JFrame {

    protected abstract Class<T> getEntityClass();
    protected abstract void initComponents();

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
        new AdminLoanScreen();
    }

    public void openUsersScreen() {
        // new UserScreen();
    }

}
