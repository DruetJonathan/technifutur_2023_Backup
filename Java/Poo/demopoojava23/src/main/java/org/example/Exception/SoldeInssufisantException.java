package org.example.Exception;

public class SoldeInssufisantException extends Exception{
    public SoldeInssufisantException() {
        super("Montant inferieur à 0");
    }

    public SoldeInssufisantException(String message) {
        super(message);
    }
}
