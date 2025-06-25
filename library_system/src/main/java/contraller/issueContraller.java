/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contraller;

import dao.IssueDAO;
import model.Issue;

/**
 *
 * @author Do
 */
public class issueContraller {
    private final IssueDAO dao = new IssueDAO();

    public void issueBook(int studentId, int bookId, String issueDate, String returnDate) {
     
    
       
        Issue issue = new Issue(studentId, bookId, issueDate, returnDate, "Issued");
        dao.issueBook(issue);
    }
    
    public void returnBook(int issueId,int bookId) {
    dao.returnBook(issueId,bookId);
}
    public int getBookId(int issueId) {
    return dao.getBookIdByIssueId(issueId);
}
}
