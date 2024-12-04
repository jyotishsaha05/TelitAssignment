# Student Management System - Part 2: Collections and Exception Handling

This section of the `StudentManagementSystem` project focuses on managing a collection of students using a `List`, implementing exception handling for student searches, and adding advanced features like sorting and user input for new students and courses.

## Project Overview

In **Part 2**, the project demonstrates the following:
- Storing `Student` objects in a `List`.
- Searching for a student by their `studentId` and throwing an exception if not found.
- Handling exceptions to provide useful feedback when a student is not found.
- Sorting students by their names.
- Allowing users to input new students and enroll them in courses via the console.

### Part 2 Features Implemented:

#### 4. Manage a List of Students:
- In the `Main` class, a `List<Student>` is created to store the `Student` objects.
- Three `Student` objects are added to this list.

#### 5. Exception Handling:
- A method `findStudentById(String studentId)` is written to search for a student by their `studentId` in the list.
- If the student is not found, an exception is thrown with a message like: "Student with ID [ID] not found."
- The exception is caught and handled in the `Main` class, where an appropriate message is printed.

#### 6. Advanced Features (Optional - Bonus):
- Sorting of students by their `name` is implemented using `Collections.sort()` and a custom `Comparator`.
- Users can input new students and enroll them in courses via the console.

## How to Run the Program

### Using an IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans):

1. **Import the Project**:
   - Open your IDE (e.g., IntelliJ IDEA, Eclipse).
   - Import or open the `StudentManagementSystem` project.

2. **Run the Program**:
   - Locate the `Main.java` file in the project structure.
   - Right-click on the `Main.java` file and select **Run**.
   - The program will execute, manage the student list, handle exceptions, and print the sorted student list.

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

When the program runs, it will print the details of students, allow searching for students by `studentId`, and display sorted lists. The output will look something like this:

