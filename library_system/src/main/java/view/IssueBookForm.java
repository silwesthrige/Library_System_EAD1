/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import contraller.issueContraller;
import dao.IssueDAO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Issue;

/**
 *
 * @author Do
 */
public class IssueBookForm extends javax.swing.JFrame {

    /**
     * Creates new form IssueBookForm
     */
    public IssueBookForm() {
        initComponents();
        loadTableStudents();
        
        loadBooksToTableAndCombo();
        
    }
    
     private void loadBooksToTableAndCombo() {
    try {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM books WHERE quantity > 0");

        // Reset combo box and table
        cmbBook.removeAllItems();

        // Create table model with full columns
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Book ID");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Quantity");

        // Loop and populate
        while (rs.next()) {
            int bookId = rs.getInt("book_id");
            String title = rs.getString("title");
            String author = rs.getString("author");
  
            int quantity = rs.getInt("quantity");

           cmbBook.addItem(rs.getInt("book_id") + " - " + rs.getString("title"));

            // Add row to table
            model.addRow(new Object[]{
                bookId, title, author, quantity
            });
        }

        // Set the model to table
        tblStudent.setModel(model);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading books: " + e.getMessage());
        e.printStackTrace();
    }
}
     private void loadTableStudents() {
    try {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        // Clear combo box
        cmbStudent.removeAllItems();

        // Create table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Student ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Course");
        

        // Loop through result set
        while (rs.next()) {
            int studentId = rs.getInt("student_id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String course = rs.getString("course");
            
            cmbStudent.addItem(rs.getInt("student_id") + " - " + rs.getString("name"));
            
           

            // Add row to table
            model.addRow(new Object[]{studentId, name, email, course});
        }

        // Set model to table
        tblBooks.setModel(model);

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading students: " + e.getMessage());
    }
}
 private void issueBook() {
        try {
            int studentId = Integer.parseInt(cmbStudent.getSelectedItem().toString().split(" - ")[0]);
            int bookId = Integer.parseInt(cmbBook.getSelectedItem().toString().split(" - ")[0]);

            
            String issueDate =  txtIssuedDate.getText();
            String returnDate =  txtReturnDate.getText();
            
            if(issueDate.isEmpty() || returnDate.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Fill All the Fields");
            }else{
            issueContraller icon = new issueContraller();
            icon.issueBook(studentId, bookId, issueDate, returnDate);

            JOptionPane.showMessageDialog(this, "Book Issued Successfully!");
            }
            

            
            txtIssuedDate.setText("");
             txtReturnDate.setText("");
              cmbBook.setSelectedIndex(-1);
              cmbStudent.setSelectedIndex(-1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

     private void loadBooks() {
        try {
            Connection conn = DBConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT book_id, title FROM books");
            while (rs.next()) {
                cmbBook.addItem(rs.getInt("book_id") + " - " + rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        utilDateModel1 = new org.jdatepicker.impl.UtilDateModel();
        jDatePickerUtil3 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil4 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil5 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil6 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil7 = new org.jdatepicker.util.JDatePickerUtil();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        cmbBook = new javax.swing.JComboBox<>();
        cmbStudent = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIssued = new javax.swing.JButton();
        txtIssuedDate = new javax.swing.JTextField();
        txtReturnDate = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStudent);

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblBooks);

        cmbStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStudentActionPerformed(evt);
            }
        });

        jLabel1.setText("Student :");

        jLabel2.setText("Book :");

        jLabel3.setText("Issue date :");

        jLabel4.setText("Return Date :");

        btnIssued.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 12)); // NOI18N
        btnIssued.setForeground(new java.awt.Color(102, 255, 0));
        btnIssued.setText("Issued");
        btnIssued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssuedActionPerformed(evt);
            }
        });

        txtIssuedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIssuedDateActionPerformed(evt);
            }
        });

        txtReturnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReturnDateActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 0, 0));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 2, 18)); // NOI18N
        jLabel5.setText("ISSUE BOOKS");

        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbBook, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReturnDate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(txtIssuedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnIssued)
                        .addGap(27, 27, 27)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtIssuedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIssued)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStudentActionPerformed

    private void btnIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssuedActionPerformed
        issueBook();  
        loadBooksToTableAndCombo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIssuedActionPerformed

    private void txtReturnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReturnDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReturnDateActionPerformed

    private void txtIssuedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIssuedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIssuedDateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
            txtIssuedDate.setText("");
             txtReturnDate.setText("");
              cmbBook.setSelectedIndex(-1);
              cmbStudent.setSelectedIndex(-1);    // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userMenuForm menu = new userMenuForm();
            menu.setVisible(true);
            this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBookForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnIssued;
    private javax.swing.JComboBox<String> cmbBook;
    private javax.swing.JComboBox<String> cmbStudent;
    private javax.swing.JButton jButton1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil3;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil4;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil5;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil6;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtIssuedDate;
    private javax.swing.JTextField txtReturnDate;
    private org.jdatepicker.impl.UtilDateModel utilDateModel1;
    // End of variables declaration//GEN-END:variables
}
