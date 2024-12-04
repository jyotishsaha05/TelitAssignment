package com.student.Collections_and_Exception_Handling;

import java.util.*;

/*
 * Part 2: Collections and Exception Handling 
 * 4. Manage a List of Students: 
 * In the `Main` class, create a `List<Student>` to store the students you have created.
 * Add the three `Student` objects to this list.
 * Write a method `Student findStudentById(String studentId)` that searches 
 * for a student by their `studentId` in the list and returns the `Student` object. 
 * If the student is not found, throw an exception with an appropriate message.  
 */
// Main class for managing the student system
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        // Allow user to input new students
        System.out.println("Enter number of students to add:");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        // Loop to add students
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();

            System.out.println("Enter student age:");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after nextInt()

            System.out.println("Enter student ID:");
            String studentId = scanner.nextLine();

            // Create a new student and add it to the list
            Student student = new Student(name, age, studentId);
            studentList.add(student);

            System.out.println("Enter number of courses for " + name + ":");
            int numCourses = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after nextInt()

            // Loop to add courses for each student
            for (int j = 0; j < numCourses; j++) {
                System.out.println("Enter course " + (j + 1) + ":");
                String course = scanner.nextLine();
                student.enrollCourse(course);
            }
        }

        /*
        6. Advanced Features: 
            Implement sorting of students by their `name` using `Collections.sort()` 
            and a custom `Comparator`. 
            Allow users to input new students and courses via the console. 
         */
        // Sort students by name
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        // Print sorted students
        System.out.println("Students sorted by name:");
        for (Student student : studentList) {
            student.printStudentInfo();
        }

        // Example: Handle user input to find a student by ID
        try {
            System.out.println("Enter student ID to search:");
            String searchId = scanner.nextLine();
            Student foundStudent = findStudentById(studentList, searchId);
            foundStudent.printStudentInfo();
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    // Method to find a student by ID
    public static Student findStudentById(List<Student> studentList, String studentId) throws StudentNotFoundException {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        
        /*
        5. Exception Handling: 
            Modify the `Main` class to handle the exception thrown by `findStudentById`.  
            If an exception occurs, print a message like "Student with ID [ID] not found
            */
        throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
    }
}
