package org.example.models2;

import org.example.Exception.MontantNegatifException;
import org.example.Exception.SoldeInssufisantException;
import org.example.interfaces.PassageEnNegatifSubscriber;

import java.util.ArrayList;
import java.util.List;

public class Compte {
    private final List<PassageEnNegatifSubscriber> passageEnNegatifEvent = new ArrayList<>();
    private String numero;
    private double solde;
    private double ligneDeCredit;

    public Compte(String numero, double ligneDeCredit) {
        this.numero = numero;
        this.ligneDeCredit = ligneDeCredit;
        this.solde = 0;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void retrait(double montant) throws Exception {
        double ancientSolde = getSolde();
        if (montant < 0)
            throw new MontantNegatifException();
        if (solde - montant < -getLigneDeCredit())
            throw new SoldeInssufisantException();
        setSolde(getSolde()-montant);

        if (ancientSolde > 0 && getSolde() < 0)
            raisePassageEnNegatifEvent();
    }
    public void depot(double montant) throws Exception {
        if (montant < 0)
            throw new MontantNegatifException();
        setSolde(getSolde()+montant);
    }

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    public void setLigneDeCredit(double ligneDeCredit) throws MontantNegatifException {
        if (ligneDeCredit < 0)
            throw new MontantNegatifException("Ligne de crédit doit être positive");
        this.ligneDeCredit = ligneDeCredit;
    }
    public void addPassageEnNegatifSubscriber(PassageEnNegatifSubscriber subscriber){
        passageEnNegatifEvent.add(subscriber);
    }
    public void removePassageEnNegatifSubscriber(PassageEnNegatifSubscriber subscriber){
        passageEnNegatifEvent.remove(subscriber);
    }
    public void raisePassageEnNegatifEvent(){
        passageEnNegatifEvent.forEach(subscriber -> {
            subscriber.execute(this);
        });
    }

    public String getNumero() {
        return numero;
    }
}
