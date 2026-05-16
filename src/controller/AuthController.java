/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import model.UserDAO;
import exception.DuplicateDataException;
import javax.swing.JOptionPane;
/**
 *
 * @author Swift
 */
// controller utk proses autentikasi user
public class AuthController {
    private UserDAO userDAO;

    public AuthController() {
        userDAO = new UserDAO();
    }

    // register
    public boolean register(
            String nama, String username,
            String password
    ) {

        User user = new User(0, nama, username, password);

        try {            
            return userDAO.register(user);
        
        } catch (DuplicateDataException e) {          
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );
        }

        return false;
    }

    // login
    public boolean login(String username, String password) {
        
        return userDAO.login(username, password);
    
    }
}
