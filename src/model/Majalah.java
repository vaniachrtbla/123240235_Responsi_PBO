/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Swift
 */
// inheritance dari ItemPerpustakaan
public class Majalah extends ItemPerpustakaan {
    private String edisi;
    private String penerbit;
    
    // constructor utama
    public Majalah(int id, String judul, int tahunTerbit,
                   String edisi, String penerbit) {

        super(id, judul, tahunTerbit);  // memanggil constructor parent

        this.edisi = edisi;
        this.penerbit = penerbit;
    }
    
    // getter setter
    public String getEdisi() {
        return edisi;
    }

    public void setEdisi(String edisi) {
        this.edisi = edisi;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    
    // polymorphism
    @Override
    public String tampilInfo() {
        return "MAJALAH : " + getJudul()
                + " | Edisi : " + edisi
                + " | Penerbit : " + penerbit;
    }
}
