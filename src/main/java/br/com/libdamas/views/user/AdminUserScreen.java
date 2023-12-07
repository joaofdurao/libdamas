package br.com.libdamas.views.user;

import br.com.libdamas.views.user.AdminUserScreen;

public class AdminUserScreen extends UserScreenConfigs<AdminUserScreen>{

    public AdminUserScreen(Long userId) {
        super(userId);
        initUserScreenTemplate();
        initComponents();
        setVisible(true);
    }

    @Override
    protected void initComponents() {
        addAdminUserTable();
        addAdminSearchField();
        addAdminButtonPanel();
    }

    @Override
    protected Class<AdminUserScreen> getEntityClass() {
        return AdminUserScreen.class;
    }
    
}
