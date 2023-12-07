package br.com.libdamas.views.loan;

public class AdminLoanScreen extends LoanScreenConfigs<AdminLoanScreen> {

    public AdminLoanScreen(Long userId) {
        super(userId);
        initLoanScreenTemplate();
        initComponents();
        setVisible(true);
    }

    @Override
    protected void initComponents() {
        addAdminLoanTable();
        addSearchField();
        addAdminButtonPanel();
    }


    @Override
    protected Class<AdminLoanScreen> getEntityClass() {
        return AdminLoanScreen.class;
    }
}
