package com.mvcpattern;

public class StudentController {
    private Student student;
    private StudentView studentView;

    // Constructor
    public StudentController(Student student, StudentView studentView) {
        this.student = student;
        this.studentView = studentView;
    }

    // Method to update student details
    public void setStudentName(String name) {
        student.setName(name);
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentId(String id) {
        student.setId(id);
    }

    public String getStudentId() {
        return student.getId();
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    // Method to update view
    public void updateView() {
        studentView.displayStudentDetails(student);
    }
}
