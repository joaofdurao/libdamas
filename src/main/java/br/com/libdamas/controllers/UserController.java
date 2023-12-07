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
        // Check if the credentials are admin from the last loggedIn user
        // Fetch user if it exists
        User testUser = this.getUserByEnrollment(user.getEnrollment());
        // Check if user is new testUser is null
        if (testUser == null) {
            try {
                userDAO.createInstance(user);
                System.out.println("Usuário cadastrado com sucesso");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            // If user already exists it should show error message
            System.out.println("Matrícula já cadastrada");
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
    
    public String getUserRole(Long userId) {
        User testUser = getUserById(userId);
        if (testUser != null) {
            return userDAO.findUserRoleById(userId);
        } else {
            return null;
        }
    }

    public void updateUser(Long userId, @Valid User user) {
       // Só admin pode usar esse método - Falta implementar
       // 1º passo) Consulta a tabela de histórico de usuários logados 
       // 2º passo) Confere (if-else) se o user.type = "admin" -> segue, senão sout("Usuário sem permissão para atualizar")
        userDAO.updateInstance(user, userId);
    }

    public void deleteUser(User user, Long userId) {
       // Só admin pode usar esse método - Falta implementar
       // 1º passo) Consulta a tabela de histórico de usuários logados 
       // 2º passo) Confere (if-else) se o user.type = "admin" -> segue, senão sout("Usuário sem permissão para deletar")
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
