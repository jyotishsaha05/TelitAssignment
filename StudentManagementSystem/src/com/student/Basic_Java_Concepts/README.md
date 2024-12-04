# Student Management System - Part 1: Basic Java Concepts

This project demonstrates basic Java concepts by creating a simple **Student Management System**. The main goal of this part is to implement the functionality for managing students, enrolling them in courses, and displaying their details.

## Project Overview

The `StudentManagementSystem` project is designed to:
- Create a `Student` class to hold details about a student.
- Implement methods to enroll students in courses and display their information.
- Create a `Main` class that handles creating and managing student objects.

## Steps Implemented in Part 1

### Step 1: Create a Java Console Application
- A Java project named `StudentManagementSystem` has been created.
- Inside the project, the main class is named `Main`.

### Step 2: Implement the `Student` Class
- The `Student` class is implemented with the following attributes:
  - `String name`: The name of the student.
  - `int age`: The age of the student.
  - `String studentId`: The unique student ID.
  - `List<String> courses`: A list to store the courses the student is enrolled in.
  
- The class includes the following methods:
  - **Constructor** to initialize `name`, `age`, and `studentId`.
  - `enrollCourse(String course)`: Adds a course to the `courses` list.
  - `printStudentInfo()`: Prints the student's details, including name, age, student ID, and enrolled courses.

### Step 3: Create and Manage Objects in the `Main` Class
- In the `Main` class, three `Student` objects are instantiated, each with different details.
- Each student is enrolled in 23 different courses.
- The `printStudentInfo()` method is called to display each student's information.

## How to Run the Program

### Using an IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans):
1. **Import the Project**:
   - Open your IDE (e.g., IntelliJ IDEA, Eclipse).
   - Import or open the project folder `StudentManagementSystem`.

2. **Run the Program**:
   - Locate the `Main.java` file in the project structure.
   - Right-click on the `Main.java` file and select **Run**.
   - The program will execute and print the details of the three students along with the courses they are enrolled in.

### Using the Command Line:

1. **Navigate to the Project Folder**:
   - Open a terminal or command prompt.
   - Change the directory to where the `StudentManagementSystem` project is located.

2. **Compile the Java Files**:
   - Use the following command to compile the Java files:
     ```bash
     javac *.java
     ```

3. **Run the Program**:
   - After compiling the Java files, run the `Main` class using the following command:
     ```bash
     java Main
     ```

### Example Output:

When the program runs, it will output the details of each student along with their enrolled courses. The output will look something like this:

