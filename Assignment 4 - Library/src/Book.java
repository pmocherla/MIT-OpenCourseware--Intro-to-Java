
/*
 * MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 4: Library
 * This file is a class that simulates a book at a library.
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

public class Book {

    //Init instance variables
    String title;
    public boolean borrowed;

    //Constructor
    public Book(String bookTitle) {
        title = bookTitle;
        borrowed = false;
    }

    //check borrowed method
    public void borrowed() {
        borrowed = true;
    }

    //check returned method
    public void returned() {
        borrowed = false;
    }

    //borrow book method
    public boolean isBorrowed() {
        if (borrowed) {
            return true;
        } else {
            return false;
        }
    }

    //check title method
    public String getTitle() {
        return title;
    }

    public static void main(String[] arguments) {
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }

}
