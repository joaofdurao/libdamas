package br.com.libdamas.views;

import br.com.libdamas.DAO.UserDAO;
import br.com.libdamas.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserScreen extends JFrame {

    private JTextField nameField;
    private JTextField identificationField;
    private JTextField typeField;

    public UserScreen() {
        setTitle("User Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(4, 2));

        nameField = new JTextField(20);
        identificationField = new JTextField(20);
        typeField = new JTextField(20);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Identification:"));
        add(identificationField);
        add(new JLabel("Type:"));
        add(typeField);

        addUpdateUserButton();
        addDeleteUserButton();
    }

    private void addUpdateUserButton() {
        JButton updateUserButton = new JButton("Update User");
        updateUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });
        add(updateUserButton);
    }

    private void addDeleteUserButton() {
        JButton deleteUserButton = new JButton("Delete User");
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });
        add(deleteUserButton);
    }

    private void updateUser() {
        String name = nameField.getText();
        String identification = identificationField.getText();
        String type = typeField.getText();

        UserDAO userDAO = new UserDAO();
        User userToUpdate = userDAO.findByIdentification(identification);

        if (userToUpdate != null) {
            userToUpdate.setName(name);
            userToUpdate.setType(type);
            userDAO.updateUser(userToUpdate);

            // Limpar campos após atualizar usuário
            clearFields();
        } else {
            // Usuário não encontrado
            JOptionPane.showMessageDialog(UserScreen.this, "Usuário não encontrado!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUser() {
        String identification = identificationField.getText();

        UserDAO userDAO = new UserDAO();
        User userToDelete = userDAO.findByIdentification(identification);

        if (userToDelete != null) {
            userDAO.deleteUser(userToDelete);

            // Limpar campos após excluir usuário
            clearFields();
        } else {
            // Usuário não encontrado
            JOptionPane.showMessageDialog(UserScreen.this, "Usuário não encontrado!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        identificationField.setText("");
        typeField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserScreen().setVisible(true);
            }
        });
    }
}
