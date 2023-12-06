package br.com.libdamas.views.loan;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.libdamas.controllers.LoanController;
import br.com.libdamas.models.Loan;

public abstract class LoanScreenConfigs<T> extends JFrame {

    protected abstract Class<T> getEntityClass();

    protected abstract void initComponents();

    private LoanController loanController = new LoanController();

    public void initLoanScreenTemplate() {
        setTitle(getEntityClass().getSimpleName());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    public void addLoanTable() {
        JTable loanTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(loanTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addSearchField() {
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchLoan(Long.parseLong(searchField.getText()));
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);
    }

    protected void searchLoan(Long loanId) {
        Loan loan = loanController.findLoanById(loanId);

        if (loan == null) {
            JOptionPane.showMessageDialog(LoanScreenConfigs.this, "Loan not found.", "Error",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(LoanScreenConfigs.this, loan.toString(), "Loan " + loan.getId(),
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createAddLoanButton());
        buttonPanel.add(createDeleteLoanButton());
        buttonPanel.add(createPostponeLoanButton());

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // buttonPanel
    public Component createAddLoanButton() {
        JButton addButton = new JButton("Add Loan");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Loan button action
                // TODO: Implement add loan functionality
            }
        });

        return addButton;
    }

    // buttonPanel
    public Component createDeleteLoanButton() {
        JButton deleteButton = new JButton("Delete Loan");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete Loan button action
                // TODO: Implement delete loan functionality
            }
        });

        return deleteButton;
    }

    // buttonPanel
    public Component createPostponeLoanButton() {
        JButton postponeButton = new JButton("Postpone Return Date");
        postponeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PostponeLoanScreen();
            }
        });

        return postponeButton;
    }

}
