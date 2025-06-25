/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contraller;

import dao.studentDAO;
import model.student;

/**
 *
 * @author Do
 */
public class studentContraller {
    private final studentDAO dao = new studentDAO();

    public void registerStudent(String name, String email, String course) {
        student student = new student(name, email, course);
        dao.addStudent(student);
    }
}
