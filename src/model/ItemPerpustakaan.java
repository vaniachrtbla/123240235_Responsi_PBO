/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Swift
 */
public abstract class ItemPerpustakaan {    // abstract class parent
    // atribut umum item perpustakaan
    private int id;
    private String judul;
    private int tahunTerbit;
    
    //constructor parent
    public ItemPerpustakaan(int id, String judul, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // getter setter 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    // polymorphism
    public abstract String tampilInfo();
}
