package org.example.exceptions;

public class CustomiserNotFound extends CustomiserException{
    public CustomiserNotFound(String message) {
        super(message);
    }

    public CustomiserNotFound() {
        super("Book not found.");
    }
}
