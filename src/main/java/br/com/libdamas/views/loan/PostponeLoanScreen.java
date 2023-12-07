package br.com.libdamas.views.loan;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.libdamas.controllers.LoanController;
import br.com.libdamas.models.Loan;

public class PostponeLoanScreen extends JFrame {
    private LoanController loanController;
    private JTextField searchField;
    private JTable resultsTable;
    private JButton searchButton;
    private JButton postponeButton; // Add the postpone button
    private JPanel topPanel;
    private JPanel bottomPanel; // Add the bottom panel

    public PostponeLoanScreen() {
        loanController = new LoanController();

        setTitle("Postpone Loan Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 180);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Search Panel --------------------------------------
        topPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchLoan(Long.parseLong(searchField.getText()));
            }
        });
        topPanel.add(searchField);
        topPanel.add(searchButton);

        // Results Table --------------------------------------
        String[] columnNames = { "Loan ID", "User", "Loan Date", "Return Date", "Overdue" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        resultsTable = new JTable(model);

        // Postpone Button --------------------------------------
        bottomPanel = new JPanel();
        postponeButton = new JButton("Postpone");
        postponeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executePospone(Long.parseLong(resultsTable.getValueAt(0, 0).toString()));
            }
        });
        bottomPanel.add(postponeButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultsTable), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    protected void searchLoan(Long loanId) {
        Loan loan = loanController.findLoanById(loanId);

        if (loan == null) {
            JOptionPane.showMessageDialog(PostponeLoanScreen.this, "Loan not found.", "Error",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            updateTable(loan);
        }

    }

    protected void updateTable(Loan loan) {
        DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();

        if (model.getRowCount() > 0) {
            model.removeRow(0);
            model.addRow(
                    new Object[] { loan.getId(), loan.getUser().getName(), loan.getLoanDate(), loan.getReturnDate(),
                            loan.isOverdue() });

        } else {
            model.addRow(
                    new Object[] { loan.getId(), loan.getUser().getName(), loan.getLoanDate(), loan.getReturnDate(),
                            loan.isOverdue() });
        }

    }

    protected void executePospone(Long loanId) {
        String[] options = { "YES", "NO" };
        int executePospone = JOptionPane.showOptionDialog(
                PostponeLoanScreen.this, "Add more 15 days to the return date?", "Confirm postpone",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (executePospone == 0) {

            boolean postponed = loanController.postponeLoan(loanId);

            if (postponed) {
                updateTable(loanController.findLoanById(loanId));
                JOptionPane.showMessageDialog(PostponeLoanScreen.this, "Loan postponed successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(PostponeLoanScreen.this, "Error postponing loan.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
