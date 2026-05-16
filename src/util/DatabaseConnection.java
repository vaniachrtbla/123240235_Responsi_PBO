/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import exception.DatabaseConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Swift
 */
public class DatabaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/db_perpustakaan";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws DatabaseConnectionException {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi berhasil!");
        
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Koneksi database gagal!");
        }

        return conn;
    }
}
