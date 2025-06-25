/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contraller;

import dao.BookDAO;
import model.Book;

/**
 *
 * @author Do
 */
public class bookContraller {
     private final BookDAO dao = new BookDAO();

    public  void addBook(String title, String author, String category, int quantity) {
        Book book = new Book(title, author, category, quantity);
        dao.addBook(book);
    }
}
