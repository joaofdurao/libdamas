package br.com.libdamas.views.loan;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.libdamas.controllers.LoanController;
import br.com.libdamas.models.Loan;

public class PostponeLoanScreen extends JFrame {

    private LoanController loanController = new LoanController();

    public PostponeLoanScreen() {
        initPostponeLoanScreenTemplate();
        initComponents();
        setVisible(true);

    }

    public void initPostponeLoanScreenTemplate() {
        setTitle("Postpone Loan");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

    }

    public void initComponents() {
        addSearchField();
    }

    //SEARCH FIELD --------------------------------------------------------------
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
            JOptionPane.showMessageDialog(PostponeLoanScreen.this, "Loan not found.", "Error",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(PostponeLoanScreen.this, loan.toString(), "Loan " + loan.getId(),
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //RESULT FIELD --------------------------------------------------------------

    






}
