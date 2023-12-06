package br.com.libdamas.controllers;

import br.com.libdamas.DAO.UserDAO;
import br.com.libdamas.models.User;

public class UserController {

    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public boolean validateCredentials(String enrollment, String password) {
        User user = userDAO.findByEnrollment(enrollment);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

}
