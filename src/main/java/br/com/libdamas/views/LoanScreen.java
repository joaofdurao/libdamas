package br.com.libdamas.views;

import br.com.libdamas.views.configs.LoanScreenConfigs;

public class LoanScreen extends LoanScreenConfigs<LoanScreen> {

    public LoanScreen() {
        initLoanScreenTemplate();
        initComponents();
        setVisible(true);
    }

    @Override
    protected void initComponents() {
        addLoanTable();
        addSearchField();
        addButtonPanel();
    }

    @Override
    protected Class<LoanScreen> getEntityClass() {
        return LoanScreen.class;
    }
}
