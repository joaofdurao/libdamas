package br.com.libdamas.views;

import javax.swing.JButton;

public class MainScreen extends ScreenConfigs<MainScreen> {

    public MainScreen() {
        initScreenTemplate();
        initComponents();
    }

    @Override
    protected void initComponents() {
        openBookScreenButton();
        openLoanScreenButton();
        openUserScreenButton();
        addUserUpdateButton();
        addUserDeleteButton();
        addBookUpdateButton();
        addBookDeleteButton();

    }

    private void addUserUpdateButton() {
        JButton addUserUpdateButton = new Jbutton("Update User");
        updateUserButton.addActionListener(new ActionListener() {
            @Override
            public coid actionPerformed(ActionEvent e) {
                // Abre a tela atualização de usuário
                new UpdateUserFrame();
            }
        });
        addComponent(updateUserButton);
    }

    private void addUserDeleteButton() {
        JButton deleteUserButton = new JButton("Delete User");
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de exclusão de usuário
                new DeleteUserFrame();
            }
        });
        addComponent(deleteUserButton);
    }

    private void addBookUpdateButton(){
        JButton updateBookButton = new Jbutton("Update Book");
        updateBookButton.addActionListener(new ActionListener(){
            //Abre a tela de atualização do livro
            new UpdateBookFrame();
        });
    addComponent(updateBookButton);
    }

    private void addBookDeleteButton(){
        JButton deleteBookButton = new JButton("Delete Book");
        deleteBookButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerfomed(ActionEvent e){
                //Abre a tela de exclusão de livro
                newDeleteBookFrame();
            }
        });
        addComponent(deleteBookButton);
    }

    @Override
    protected Class<MainScreen> getEntityClass() {
        return MainScreen.class;
    }
}
