package com.student.Basic_Java_Concepts;

import java.util.ArrayList;
import java.util.List;

/*
2. Implement a Class: 
Create a `Student` class with the following attributes: 
  `String name` 
  `int age` 
  `String studentId` 
  `List<String> courses` 
Implement the following methods: 
  A constructor to initialize `name`, `age`, and `studentId`. 
  A method `void enrollCourse(String course)` to add a course to the `courses` list. 
  A method `void printStudentInfo()` to print the student's name, age, student ID, and the list of enrolled courses.  
*/

public class Student {
    // Attributes
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    // Constructor to initialize the student's details
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    // Method to enroll a student in a course
    public void enrollCourse(String course) {
        courses.add(course);
    }

    // Method to print the student's information
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
