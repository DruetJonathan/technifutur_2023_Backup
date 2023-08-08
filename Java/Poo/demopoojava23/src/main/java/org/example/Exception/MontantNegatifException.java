package org.example.Exception;

public class MontantNegatifException extends Exception{
    public MontantNegatifException() {
        super("Vous n'avez pas assez d'argent");
    }

    public MontantNegatifException(String message) {
        super(message);
    }
}
