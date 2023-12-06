package br.com.libdamas.views;

public class MainScreen extends ScreenConfigs<MainScreen> {

    public MainScreen() {
        initScreenTemplate();
        initComponents();
    }

    @Override
    protected void initComponents() {
        booksButton();
        loansButton();
        usersButton();
    }

    @Override
    protected Class<MainScreen> getEntityClass() {
        return MainScreen.class;
    }
}
