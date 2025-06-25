/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Book;

/**
 *
 * @author Do
 */
public class BookDAO {
     private final Connection conn = DBConnection.getConnection();

    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, category, quantity) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getCategory());
            stmt.setInt(4, book.getQuantity());
            int indi = stmt.executeUpdate();
            if(indi >0){
            System.out.println("Book added successfully.");
            }else{
            System.out.println("Book added Unsuccessfully.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
