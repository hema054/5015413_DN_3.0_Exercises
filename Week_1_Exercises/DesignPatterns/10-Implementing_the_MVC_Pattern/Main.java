package com.mvcpattern;

public class Main {
    public static void main(String[] args) {
        // Create a student object
        Student student = new Student("John Doe", "12345", "A");

        // Create a view object
        StudentView studentView = new StudentView();

        // Create a controller object
        StudentController studentController = new StudentController(student, studentView);

        // Display initial student details
        studentController.updateView();

        // Update student details
        studentController.setStudentName("Jane Doe");
        studentController.setStudentId("54321");
        studentController.setStudentGrade("B");

        // Display updated student details
        studentController.updateView();
    }
}
