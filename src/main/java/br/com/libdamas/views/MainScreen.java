package br.com.libdamas.views;

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
    }

    @Override
    protected Class<MainScreen> getEntityClass() {
        return MainScreen.class;
    }
}
