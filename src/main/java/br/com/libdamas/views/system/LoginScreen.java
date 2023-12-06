package br.com.libdamas.views.system;

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
    private JTextField enrollmentField;
    private JPasswordField passwordField;
    private UserController userController = new UserController();

    public LoginScreen() {

        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel enrollmentLabel = new JLabel("Enrollment:");
        enrollmentField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        panel.add(enrollmentLabel);
        panel.add(enrollmentField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
    }

    private void handleLogin() {
        String enrollment = enrollmentField.getText();
        String password = new String(passwordField.getPassword());

        boolean isValid = userController.validateCredentials(enrollment, password);

        if (isValid) {
            JOptionPane.showMessageDialog(LoginScreen.this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(LoginScreen.this, "Invalid enrollment or password.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            enrollmentField.setText("");
            passwordField.setText("");
        }
    }
}