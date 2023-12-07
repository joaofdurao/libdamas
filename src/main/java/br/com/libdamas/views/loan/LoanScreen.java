package br.com.libdamas.views.loan;

public class LoanScreen extends LoanScreenConfigs<LoanScreen> {

    public LoanScreen(Long userId) {
        super(userId);
        initLoanScreenTemplate();
        initComponents();
        setVisible(true);
    }

    @Override
    protected void initComponents() {
        addUserLoanTable();
        addUserSearchField();
        addUserButtonPanel();
    }

    @Override
    protected Class<LoanScreen> getEntityClass() {
        return LoanScreen.class;
    }
}
