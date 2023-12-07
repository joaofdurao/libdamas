package br.com.libdamas.views.user;

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

import br.com.libdamas.controllers.UserController;
import br.com.libdamas.models.User;

public abstract class UserScreenConfigs<T> extends JFrame {

    protected abstract Class<T> getEntityClass();

    protected abstract void initComponents();

    private UserController userController;

    private Long userId;

    public UserScreenConfigs(Long userId) {
        userController = new UserController();
        this.userId = userId;
    }

    // Template Method --------------------------------------
    public void initUserScreenTemplate() {
        setTitle(getEntityClass().getSimpleName());
        setSize(800, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    // Search Field Component--------------------------------
    public void addAdminSearchField() {
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUser(Long.parseLong(searchField.getText()));
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);
    }

    // Search User Method
    protected void searchUser(Long userId) {
        User user = userController.getUserById(userId);

        if (user == null) {
            JOptionPane.showMessageDialog(UserScreenConfigs.this, "User not found.", "Error",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(UserScreenConfigs.this, user.toString(), "User " + user.getId(),
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addUserSearchField() {
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUserNoPrivilege(searchField.getText());
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);
    }

    protected void searchUserNoPrivilege(String search) {
        User enrollSearch = userController.getUserByEnrollment(search);
        // List<User> partialNameSearch = userController.getUserByName(search);

        if (enrollSearch == null) {
            JOptionPane.showMessageDialog(UserScreenConfigs.this, "User not found.", "Error",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(UserScreenConfigs.this, enrollSearch.toString(), "User " + enrollSearch.getId(),
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    // Table Component --------------------------------------
    public void addAdminUserTable() {
        JTable userTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(userTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void addUserUserTable() {
        String[] columnNames = { "User ID", "Name", "Phone Number", "Enrollment" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        updateUserTable(model);

        JTable userTable = new JTable(model);
        userTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectTableLine(e);
            }
        });
        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void fillUserTable(DefaultTableModel model) {
        List<User> users = userController.getAll();
        for (User user : users) {
            model.addRow(
                    new Object[] { user.getId(), user.getName(), user.getPhoneNumber(), user.getEnrollment() });
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
            Long userId = (Long) target.getValueAt(row, 0);

            User user = userController.getUserById(userId);

            if (user == null) {
                JOptionPane.showMessageDialog(UserScreenConfigs.this, "User not found.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(UserScreenConfigs.this, user.toString(), "User " + user.getId(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    // Button Panel Component--------------------------------
    public void addAdminButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createAddUserButton());
        buttonPanel.add(createDeleteUserButton());
        buttonPanel.add(createUpdateUserButton());

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addUserButtonPanel() {
        JPanel buttonPanel = new JPanel();

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // buttonPanel
    public Component createAddUserButton() {
        JButton addButton = new JButton("Add User");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add User button action
                // TODO: Implement add user functionality
            }
        });

        return addButton;
    }

    // buttonPanel
    public Component createDeleteUserButton() {
        JButton deleteButton = new JButton("Delete User");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete User button action
                // TODO: Implement delete user functionality
            }
        });

        return deleteButton;
    }

    public Component createUpdateUserButton() {
        JButton updateButton = new JButton("Update User");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete User button action
                // TODO: Implement update user functionality
            }
        });

        return updateButton;
    }

}
