/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import util.DatabaseConnection;
import exception.DataNotFoundException;
import exception.DatabaseConnectionException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.*;
/**
 *
 * @author Swift
 */
// DAO utk operasi database item perpustakaan
public class ItemDAO {

    // tambah data item
    public void tambahItem(
            String jenis, String judul,
            int tahunTerbit, String pengarang,
            String isbn, String edisi, String penerbit
    ) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String query = "INSERT INTO item_perpustakaan VALUES(NULL,?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, jenis);
            pst.setString(2, judul);
            pst.setInt(3, tahunTerbit);
            pst.setString(4, pengarang);
            pst.setString(5, isbn);
            pst.setString(6, edisi);
            pst.setString(7, penerbit);
            pst.executeUpdate();

            System.out.println("Data berhasil ditambah");

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // mengambil seluruh data item
    public ResultSet getAllItem() {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String query = "SELECT * FROM item_perpustakaan";

            Statement st = conn.createStatement();

            return st.executeQuery(query);

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // hapus item by id
    public void hapusItem(int id) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String query = "DELETE FROM item_perpustakaan WHERE id=?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();

            System.out.println("Data berhasil dihapus");

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // edit data item
    public void updateItem(
            int id, String jenis,
            String judul, int tahunTerbit,
            String pengarang, String isbn,
            String edisi, String penerbit
    ) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String query =
                    "UPDATE item_perpustakaan SET jenis=?, judul=?, tahun_terbit=?, "
                    + "pengarang=?, isbn=?, edisi=?, penerbit=? WHERE id=?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, jenis);
            pst.setString(2, judul);
            pst.setInt(3, tahunTerbit);
            pst.setString(4, pengarang);
            pst.setString(5, isbn);
            pst.setString(6, edisi);
            pst.setString(7, penerbit);
            pst.setInt(8, id);
            pst.executeUpdate();

            System.out.println("Data berhasil diupdate");

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    // cari item by judul
    public ResultSet cariItem(String keyword) throws DataNotFoundException {
        try {

            Connection conn = DatabaseConnection.getConnection();

            String query = "SELECT * FROM item_perpustakaan "
                         + "WHERE judul LIKE ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();
            // cek apakah ada data
            if (!rs.isBeforeFirst()) {   
                throw new DataNotFoundException(
                        "Data tidak ditemukan!"
                );
            }

            return rs;

        } catch (DataNotFoundException e) {
            throw e;
        
        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {            
            e.printStackTrace();
        }

        return null;
    }
}
