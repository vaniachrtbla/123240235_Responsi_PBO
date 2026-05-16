package exception;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Swift
 */
// custom exception utk data yang tidak ditemukan
public class DataNotFoundException extends Exception {
    
    public DataNotFoundException(String message) {
        super(message);
    }
    
}
