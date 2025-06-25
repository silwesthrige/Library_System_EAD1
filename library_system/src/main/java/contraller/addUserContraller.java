/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contraller;

import dao.userDAO;
import model.user;

/**
 *
 * @author Do
 */
public class addUserContraller {
    private userDAO userDAO;

    public addUserContraller() {
        userDAO = new userDAO();
    }

    public String register(String username, String password, String confirmPassword,String role) {
        // Basic validation
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || role.isEmpty()) {
            return "Please fill all fields.";
        }

        if (!password.equals(confirmPassword)) {
            return "Passwords do not match.";
        }

        // You can add more validation here (e.g. password strength, username length)

        // Create user model
        user user = new user(username, password,confirmPassword,role);

        // Save to DB
        boolean result = userDAO.registerUser(user);

        if (result) {
            return "Registration successful!";
        } else {
            return "Registration failed. Username might already exist.";
        }
    }
}
