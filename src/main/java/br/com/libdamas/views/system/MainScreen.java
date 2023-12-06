package br.com.libdamas.views.system;

public class MainScreen extends ScreenConfigs<MainScreen> {

    public MainScreen() {
        initScreenTemplate();
        initComponents();
        setVisible(true);
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
