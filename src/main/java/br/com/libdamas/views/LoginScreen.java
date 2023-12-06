package br.com.libdamas.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.libdamas.controllers.UserController;

public class LoginScreen extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());

                UserController userController = new UserController();
                boolean isValid = userController.validateCredentials(name, password);

                if (isValid) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Invalid name or password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
    }


}
