package com.babiarzdruet.labojavadataweb.exceptions;

public class PasswordException extends RuntimeException{


    public PasswordException() {super("Password Invalid !");
    }

    public PasswordException(String message) {
        super(message);
    }
}
