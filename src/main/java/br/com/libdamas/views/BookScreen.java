package br.com.libdamas.views;

import br.com.libdamas.DAO.BookDAO;
import br.com.libdamas.models.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookScreen extends ScreenConfigs<BookScreen> {

    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;

    public BookScreen() {
        initScreenTemplate();
        initComponents();
    }

    @Override
    protected void initComponents() {
        addUpdateButton();
        addDeleteButton();
    }

    private void addUpdateButton() {
        JButton updateButton = new JButton("Update Book");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateBookFrame();
            }
        });
        addComponent(updateButton);
    }

    private void addDeleteButton() {
        JButton deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteBookFrame();
            }
        });
        addComponent(deleteButton);
    }

    @Override
    protected Class<BookScreen> getEntityClass() {
        return BookScreen.class;
    }

    private class UpdateBookFrame extends JFrame {
        
    }

    private class DeleteBookFrame extends JFrame {
        
    }
}
