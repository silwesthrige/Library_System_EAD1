/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Do
 */
public class student {
    private int studentId;
    private String name;
    private String email;
    private String course;

    // Constructors
    public student() {}

    public student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public student(int studentId, String name, String email, String course) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
