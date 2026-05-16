/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import util.DatabaseConnection;
import exception.DatabaseConnectionException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Swift
 */
// DAO utk proses peminjaman buku
public class PeminjamanDAO {
    // insert transaksi peminjaman
    public void pinjamBuku(int itemId, String username) {
        try {
            // cek apakah buku sedang dipinjam
            if (isDipinjam(itemId)) {
                JOptionPane.showMessageDialog(
                        null, "Buku sedang dipinjam!"
                );
                return;
            }
            
            Connection conn = DatabaseConnection.getConnection();
            
            String sql = "INSERT INTO peminjaman "
                    + "(item_id, username, tanggal_pinjam, status) "
                    + "VALUES (?, ?, CURDATE(), ?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, itemId);
            pst.setString(2, username);
            pst.setString(3, "DIPINJAM");
            pst.executeUpdate();

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update status pengembalian
    public void kembalikanBuku(int itemId) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            
            String sql =
                    "UPDATE peminjaman "
                    + "SET tanggal_kembali = CURDATE(), "
                    + "status = ? "
                    + "WHERE item_id = ? "
                    + "AND status = 'DIPINJAM'";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "DIKEMBALIKAN");
            pst.setInt(2, itemId);
            pst.executeUpdate();

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // pengembalian by id transaksi
    public void kembalikanById(int idPeminjaman) {
        try {            
            Connection conn = DatabaseConnection.getConnection();
            
            String sql =
                    "UPDATE peminjaman "
                    + "SET tanggal_kembali = CURDATE(), "
                    + "status = ? "
                    + "WHERE id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "DIKEMBALIKAN");
            pst.setInt(2, idPeminjaman);
            pst.executeUpdate();

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // mengambil histori peminjaman
    public ResultSet getHistoriPeminjaman() {
        try {           
            Connection conn = DatabaseConnection.getConnection();
            
            String sql = "SELECT * FROM peminjaman";

            PreparedStatement pst = conn.prepareStatement(sql);

            return pst.executeQuery();

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    // mengambil histori by user login
    public ResultSet getHistoriByUser(String username) {
        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM peminjaman "
                         + "WHERE username = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);

            return pst.executeQuery();

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    // cek apakah buku sedang dipinjam
    public boolean isDipinjam(int itemId) {
        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM peminjaman "
                        + "WHERE item_id = ? "
                        + "AND status = 'DIPINJAM'";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, itemId);
            ResultSet rs = pst.executeQuery();

            // jika ada data = buku masih dipinjam
            return rs.next();

        } catch (DatabaseConnectionException e) {
            JOptionPane.showMessageDialog(
                    null, e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
