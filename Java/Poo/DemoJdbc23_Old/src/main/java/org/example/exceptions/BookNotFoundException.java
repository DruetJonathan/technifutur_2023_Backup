package org.example.exceptions;

public class BookNotFoundException extends BookException{
    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException() {
        super("Book not found.");
    }
}
