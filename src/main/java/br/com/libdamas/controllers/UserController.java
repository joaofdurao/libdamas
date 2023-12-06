package br.com.libdamas.controllers;

import java.util.List;

import br.com.libdamas.DAO.UserDAO;
import br.com.libdamas.models.User;
import jakarta.validation.Valid;

public class UserController {

    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public void createUser(@Valid User user) {
        // Fetch user if it exists
        User testUser = this.getUserByEnrollment(user.getEnrollment());
        // Check if user is new testUser is null
        if (testUser == null) {
            try {
                userDAO.createInstance(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            // If user already exists it should show error message
            System.out.println("Matrícula já existe");
        }
    }

    public User getUserById(Long userId) {
        return userDAO.findInstance(userId);
    }

    public User getUserByEnrollment(String enrollment) {
        return userDAO.findByEnrollment(enrollment);
    }

    public List<User> getUserByName(String partialName) {
        return userDAO.findByName(partialName);
    }

    public void updateUser(Long userId, @Valid User user) {
        userDAO.updateInstance(user, userId);
    }

    public void deleteUser(User user, Long userId) {
        userDAO.deleteInstance(user, userId);
    }

    public boolean validateCredentials(String enrollment, String password) {
        User user = userDAO.findByEnrollment(enrollment);
        if (user == null) {
            return false;
        }
        return user.getPasssword().equals(password);
    }

}
