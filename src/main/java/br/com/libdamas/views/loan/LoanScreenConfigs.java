package br.com.libdamas.views.loan;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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

public abstract class LoanScreenConfigs<T> extends JFrame {

    protected abstract Class<T> getEntityClass();

    protected abstract void initComponents();

    private LoanController loanController;

    private Long userId;

    public LoanScreenConfigs(Long userId) {
        loanController = new LoanController();
        this.userId = userId;
    }

    // Template Method --------------------------------------
    public void initLoanScreenTemplate() {
        setTitle(getEntityClass().getSimpleName());
        setSize(800, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    // Table Component --------------------------------------
    public void addAdminLoanTable() {
        JTable loanTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(loanTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void addUserLoanTable() {
        String[] columnNames = { "Loan ID", "User", "Loan Date", "Return Date", "Closed", "Overdue" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        updateUserTable(model);

        JTable loanTable = new JTable(model);
        loanTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectTableLine(e);
            }
        });
        JScrollPane scrollPane = new JScrollPane(loanTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void fillUserTable(DefaultTableModel model) {
        List<Loan> loans = loanController.getLoansByUser(userId);
        for (Loan loan : loans) {
            model.addRow(
                    new Object[] { loan.getId(), loan.getUser().getName(), loan.getLoanDate(), loan.getReturnDate(),
                            loan.isOverdue() });
        }
    }

    public void updateUserTable(DefaultTableModel model) {
        if (model.getRowCount() > 0) {
            model.setRowCount(0);
            fillUserTable(model);

        } else {
            fillUserTable(model);
        }
    }

    // Select Table Line Method
    public void selectTableLine(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JTable target = (JTable) e.getSource();
            int row = target.getSelectedRow();
            Long loanId = (Long) target.getValueAt(row, 0);

            Loan loan = loanController.findLoanById(loanId);

            if (loan == null) {
                JOptionPane.showMessageDialog(LoanScreenConfigs.this, "Loan not found.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(LoanScreenConfigs.this, loan.toString(), "Loan " + loan.getId(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    // Search Field Component--------------------------------
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

    // Search Loan Method
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

    // Button Panel Component--------------------------------
    public void addAdminButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createAddLoanButton());
        buttonPanel.add(createDeleteLoanButton());
        buttonPanel.add(createPostponeLoanButton());

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
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
