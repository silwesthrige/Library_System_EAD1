/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.Issue;

/**
 *
 * @author Do
 */
public class IssueDAO {
    private final Connection conn = DBConnection.getConnection();

    public void issueBook(Issue issue) {
        String sql = "INSERT INTO issued_books (student_id, book_id, issue_date, return_date, status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, issue.getStudentId());
            stmt.setInt(2, issue.getBookId());
            stmt.setString(3, issue.getIssueDate());
            stmt.setString(4, issue.getReturnDate());
            stmt.setString(5, issue.getStatus());
            stmt.executeUpdate();
            System.out.println("Book issued successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "UPDATE books SET quantity = quantity - 1 WHERE book_id = ?";
        try{
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setInt(1, issue.getBookId());
            stmt1.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void returnBook(int issueId,int bookId) {
    String sql = "UPDATE issued_books SET status = 'Returned' WHERE issue_id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, issueId);
        stmt.executeUpdate();
        System.out.println("Book marked as returned.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    String sql1 = "UPDATE books SET quantity = quantity + 1 WHERE book_id = ?";
        try{
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setInt(1, bookId);
            stmt1.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
}
    public int getBookIdByIssueId(int issueId) {
    int bookId = -1; // default if not found
    String sql = "SELECT book_id FROM issued_books WHERE issue_id = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, issueId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            bookId = rs.getInt("book_id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bookId;
}

}
