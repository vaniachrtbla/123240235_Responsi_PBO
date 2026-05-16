/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Swift
 */
public class User {
    private int id;
    private String namaLengkap;
    private String username;
    private String password;
    
    // constructor utama
    public User(int id, String namaLengkap,
                String username,
                String password) {

        this.id = id;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
    }
    
    // getter setter
    public int getId() {
        return id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
