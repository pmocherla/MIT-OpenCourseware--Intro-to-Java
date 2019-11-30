/*
 * MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 4: Library
 * This file is a class that simulates a library
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

import java.util.ArrayList;

public class Library {

    //Init the class and instance variables
    String address;
    int numBooks;
    public static String openingHours = "9am to 5pm";
    ArrayList<Book> books;

    public Library(String libAddress) {
        //Init the instance variables
        address = libAddress;
        books = new ArrayList<Book>();
        numBooks = 0;
    }

    //Add a new book to the list of books
    public void addBook(Book newBook) {
        numBooks++;
        books.add(newBook);
    }

    //Attempt to borrow a book
    public void borrowBook(String book) {

        if (numBooks == 0) {
            System.out.println("Sorry, this book is not in our catalogue.");
            return;
        }

        for (int i = 0; i < numBooks; i++) {
            if (book.equals(books.get(i).title)) {
                if (books.get(i).borrowed) {
                    System.out.println("Sorry, this book is already borrowed.");
                } else {
                    books.get(i).borrowed();
                    System.out.println("You successfully borrowed " + book);
                }
                return;
            }

        }

        System.out.println("Sorry, this book is not in our catalogue.");
        return;

    }

    //Print all available books
    public void printAvailableBooks() {
        if (numBooks == 0) {
            System.out.println("No book in catalogue.");
            return;
        }

        for (int i = 0; i < numBooks; i++) {
            if (!books.get(i).borrowed) {
                System.out.println(books.get(i).title);
            }
        }

        return;
    }

    //Attempt to return a book
    public void returnBook(String book) {

        for (int i = 0; i < numBooks; i++) {
            if (book.equals(books.get(i).title)) {
                books.get(i).returned();
                System.out.println("You successfully returned " + book);
                return;
            }

        }

        System.out.println("Sorry, this book is not in our catalogue.");
        return;
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from " + openingHours + ".");
    }

    public void printAddress() {
        System.out.println(address);
    }

    public static void main(String[] args) {
// Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
// Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
// Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
// Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
// Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
// Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
// Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
