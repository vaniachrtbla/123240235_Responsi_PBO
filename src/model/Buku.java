/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Swift
 */
// inheritance dari ItemPerpustakaan implement interface Pinjamable
public class Buku extends ItemPerpustakaan implements Pinjamable {
    private String pengarang;
    private String isbn; 
    
    // DAO proses peminjaman
    private PeminjamanDAO peminjamanDAO = new PeminjamanDAO();
    
    // constructor kosong
    public Buku() {
        super(0, "", 0);
    }
    
    // constructor utama
    public Buku(int id, String judul, int tahunTerbit,
                String pengarang, String isbn) {
        
        super(id, judul, tahunTerbit);  // memanggil constructor parent

        this.pengarang = pengarang;
        this.isbn = isbn;
    }
    
    // getter setter
    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    // implementasi method interface
    @Override
    public void pinjam(String username) {
        peminjamanDAO.pinjamBuku(getId(), username); // proses pinjam buku
    }

    @Override
    public void kembalikan() {
        peminjamanDAO.kembalikanBuku(getId()); // proses pengembaliaan buku
    }
    
    // polymorphism
    @Override 
    public String tampilInfo() {
        return "BUKU : " + getJudul()
                + " | Pengarang : " + pengarang
                + " | ISBN : " + isbn;
    }
}
