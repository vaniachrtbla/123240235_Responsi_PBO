/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import util.DatabaseConnection;
import exception.DuplicateDataException;
import exception.DatabaseConnectionException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Swift
 */
// DAO utk proses login dan register user
public class UserDAO {
    // register
    public boolean register(User user) throws DuplicateDataException{

        try {
            Connection conn = DatabaseConnection.getConnection();

            // cek username
            String cekQuery = "SELECT * FROM users WHERE username=?";

            PreparedStatement check = conn.prepareStatement(cekQuery);

            check.setString(1, user.getUsername());

            ResultSet rs = check.executeQuery();

            if (rs.next()) {

                throw new DuplicateDataException(
                        "Username sudah digunakan!"
                );
            }

            // insert user
            String query = "INSERT INTO users(nama_lengkap, username, password) VALUES(?,?,?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, user.getNamaLengkap());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());

            pst.executeUpdate();

            return true;
             
        } catch (DuplicateDataException e) {
            throw e;
            
        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // login
    public boolean login(String username, String password) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String query = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
