package com.student.Collections_and_Exception_Handling;

//Custom exception for when a student is not found by ID
@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
 public StudentNotFoundException(String message) {
     super(message);
 }
}