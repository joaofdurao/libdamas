package br.com.libdamas.views.loan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;

import br.com.libdamas.controllers.LoanController;
import br.com.libdamas.models.Loan;
import br.com.libdamas.models.User;
import javax.swing.*;
import java.awt.*;

public class AddLoanScreen extends JFrame {
    public AddLoanScreen() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JTextField clientNameField = new JTextField(20);
        formPanel.add(new JLabel("Client Name:"));
        formPanel.add(clientNameField);

        JTextField loanDateField = new JTextField(20);
        formPanel.add(new JLabel("Loan Date:"));
        formPanel.add(loanDateField);

        JTextField returnDateField = new JTextField(20);
        formPanel.add(new JLabel("Return Date:"));
        formPanel.add(returnDateField);

        JTextField idField = new JTextField(20);
        formPanel.add(new JLabel("Book ID:"));
        formPanel.add(idField);

        JButton submitButton = new JButton("Submit");
        formPanel.add(submitButton);

        add(formPanel, BorderLayout.CENTER);

        submitButton.addActionListener(e -> createAndAddLoan(
                clientNameField.getText(),
                loanDateField.getText(),
                returnDateField.getText(),
                idField.getText()));

        setSize(500, 500); // Onde Defino o tamanho da tela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        pack();
        setVisible(true);
    }

 public void createAndAddLoan(String clientName, String loanDate, String returnDate, String id) {
    if (clientName.isEmpty() || loanDate.isEmpty() || returnDate.isEmpty() || id.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
    } else {
        // Seu código para criar e adicionar um empréstimo vai aqui

        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        dispose();
    }
  }
}