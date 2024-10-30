/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author irhas
 */

import java.sql.*;

public class DatabaseHelper {

//    private static final String URL = "jdbc:sqlite:contacts.db";
    private static final String URL = "jdbc:sqlite:src/GUI/contact.db";


    // Metode untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Contoh metode untuk menjalankan query
    public static ResultSet executeQuery(String query) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    // Contoh metode untuk menjalankan update
    public static void executeUpdate(String query) throws SQLException {
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            // Jangan lupa untuk menutup koneksi
        }
    }
}
