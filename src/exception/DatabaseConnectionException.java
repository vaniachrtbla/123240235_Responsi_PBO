package exception;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Swift
 */
// custom exception utk koneksi database gagal
public class DatabaseConnectionException extends Exception {
    
    public DatabaseConnectionException(String message) {
        super(message);
    }
    
}
