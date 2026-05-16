/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author Swift
 */
public interface Pinjamable {   // utk item yang dapat dipinjam
    // method peminjaman
    void pinjam(String username);
    
    // method pengembalian
    void kembalikan();
}
