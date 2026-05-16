/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Buku;
import model.ItemDAO;
import model.PeminjamanDAO;
import exception.DataNotFoundException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Swift
 */
// controller utk proses item perpustakaan
public class ItemController {
    
    private ItemDAO dao = new ItemDAO();    // DAO item   
    private PeminjamanDAO peminjamanDAO = new PeminjamanDAO();  // DAO peminjaman
    
    private DefaultTableModel createTableModel() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Jenis");
        model.addColumn("Judul");
        model.addColumn("Tahun");
        model.addColumn("Pengarang");
        model.addColumn("ISBN");
        model.addColumn("Edisi");
        model.addColumn("Penerbit");

        return model;
    }
    
    private void fillTable(JTable tblItem, ResultSet rs) {        
        try {            
            if (rs == null) {
                return;
            }
            
            DefaultTableModel model = createTableModel();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("jenis"),
                        rs.getString("judul"),
                        rs.getInt("tahun_terbit"),
                        rs.getString("pengarang"),
                        rs.getString("isbn"),
                        rs.getString("edisi"),
                        rs.getString("penerbit")
                });
            }
            tblItem.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    // CRUD item baru
    // tambah item
    public void tambahItem(
            String jenis, String judul,
            int tahunTerbit, String pengarang,
            String isbn, String edisi, String penerbit
    ) {

        dao.tambahItem(
                jenis,
                judul,
                tahunTerbit,
                pengarang,
                isbn,
                edisi,
                penerbit
        );
    }

    // mengambil seluruh data item
    public ResultSet getAllItem() {
        return dao.getAllItem();
    }    
    // load data item ke jtable
    public void loadTable(JTable tblItem) {
        fillTable(tblItem, getAllItem());
    }

    // edit item
    public void editItem(
            int id,
            String jenis, String judul,
            int tahunTerbit, String pengarang,
            String isbn, String edisi, String penerbit
    ) {

        dao.updateItem(
                id,
                jenis,
                judul,
                tahunTerbit,
                pengarang,
                isbn,
                edisi,
                penerbit
        );
    }
    
    // hapus item by id
    public void hapusItem(int id) {
        dao.hapusItem(id);
    }        
    
    // cari item by judul
    public ResultSet cariItem(String keyword) {
        try {
        return dao.cariItem(keyword);

        } catch (DataNotFoundException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );
        }

        return null;
    }    
    // load hasil cari ke jtable
    public void cariTable(JTable tblItem, String keyword) {
        fillTable(tblItem, cariItem(keyword));
    }
    
    // proses peminjaman buku
    public void pinjamItem(int id, String username) {
        Buku buku = new Buku();
        buku.setId(id);
        buku.pinjam(username);
    }
    
    // proses pengembalian buku by item buku
    public void kembalikanItem(int id) {
        Buku buku = new Buku();
        buku.setId(id);
        buku.kembalikan();
    }
    
    // histori peminjaman buku
    public ResultSet getHistoriPeminjaman(String username) {
        return peminjamanDAO.getHistoriByUser(username);
    }    
    // load histori peminjaman ke jtable
    public void loadHistoriTable(JTable tblHistori, String username) {
        try {
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Item ID");
            model.addColumn("Username");
            model.addColumn("Tanggal Pinjam");
            model.addColumn("Tanggal Kembali");
            model.addColumn("Status");

            ResultSet rs = getHistoriPeminjaman(username);
            
            if (rs == null) {
                return;
            }
            
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getInt("item_id"),
                        rs.getString("username"),
                        rs.getDate("tanggal_pinjam"),
                        rs.getDate("tanggal_kembali"),
                        rs.getString("status")
                });
            }
            tblHistori.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // proses pengembalian buku by id transaksi histori
    public void kembalikanHistori(int idPeminjaman) {
        peminjamanDAO.kembalikanById(idPeminjaman);
    }
}
