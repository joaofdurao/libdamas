package br.com.libdamas.views.loan;

public class AdminLoanScreen extends LoanScreenConfigs<AdminLoanScreen> {

    public AdminLoanScreen() {
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
    protected Class<AdminLoanScreen> getEntityClass() {
        return AdminLoanScreen.class;
    }
}
