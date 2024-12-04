package com.student.Collections_and_Exception_Handling ;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    // Constructor to initialize student details
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    // Getters and setters for the attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    // Method to enroll a student in a course
    public void enrollCourse(String course) {
        courses.add(course);
    }

    // Method to print student's information
    public void printStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.print("Courses Enrolled: ");
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (String course : courses) {
                System.out.print(course + " ");
            }
        }
        System.out.println("\n");
    }
}
