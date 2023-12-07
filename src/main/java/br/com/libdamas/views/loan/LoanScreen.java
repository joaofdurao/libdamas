package br.com.libdamas.views.loan;

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
