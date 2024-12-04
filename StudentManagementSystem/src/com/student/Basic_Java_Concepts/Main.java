package com.student.Basic_Java_Concepts;

/*
 * 1. Create a Java Console Application: 
 * Create a new Java project named `StudentManagementSystem`.
 * Inside this project, create a main class called `Main`.
 */
 
/*
 * 3. Create and Manage Objects: 
 * In the `Main` class, instantiate three `Student` objects with different details. 
 * Enroll each student in 23 different courses.
 * Print out the details of each student using the `printStudentInfo()` method. 
 * 
*/
public class Main {
    public static void main(String[] args) {
        // Create 3 students with different details
    	Student student1 = new Student("Amit Kumar", 20, "S001");
    	Student student2 = new Student("Priya Sharma", 22, "S002");
    	Student student3 = new Student("Ravi Patel", 21, "S003");

        // Enroll each student in 23 courses
        String[] courses = new String[23];
        for (int i = 0; i < 23; i++) {
            courses[i] = "Course " + (i + 1);
        }

        // Enroll the students in the courses
        for (String course : courses) {
            student1.enrollCourse(course);
            student2.enrollCourse(course);
            student3.enrollCourse(course);
        }

        // Print out the details of each student
        student1.printStudentInfo();
        student2.printStudentInfo();
        student3.printStudentInfo();
    }
}
