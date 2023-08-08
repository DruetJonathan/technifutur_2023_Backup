package be.technifutur.decouverte.poo.scenario2;

import java.util.Objects;

public class VaisseauSecurise extends Object{

    // variable de classe
    private static int nbEnVol = 0;

    // variables d'instance contiennent l'état de l'objet
    // initialisée par défaut à la valeur par défaut du type
    private final String nom ;//= "OVNI";
    private int nbMissile;

    private int maxMissile;
    private boolean enVol = false;

    // constructeur
    public VaisseauSecurise(int maxMissile, String nom) {
        super();
        this.maxMissile = maxMissile;
        //Objects.nonNull(nom);
        if(nom != null && ! nom.isBlank()){
            this.nom = nom;
        }else{
            this.nom = "OVNI";
        }
    }

    public VaisseauSecurise(int maxMissile){
        this(maxMissile, "vaisseau inconnu");
    }

    // méthodes de classe
    public static int getNbEnVol() {
        return VaisseauSecurise.nbEnVol;
    }

    // méthodes d'instance
    public void tirer() {
        if (this.nbMissile > 0) {
            System.out.println("PAN");
            this.nbMissile--;
        } else {
            System.out.println("POUF");
        }
    }

    public int getNbMissile(){
        return this.nbMissile;
    }

    public boolean removeMissile(int nbMissile) {
        boolean accepted =false;
        if( nbMissile > 0 && this.nbMissile >= nbMissile){
            this.nbMissile -= nbMissile;
            accepted = true;
        }
        return accepted;
    }

    public boolean addMissile(int nbMissile) {
        boolean accepted =false;
        if( nbMissile > 0 && this.nbMissile + nbMissile <= this.maxMissile){
            this.nbMissile += nbMissile;
            accepted = true;
        }
        return accepted;
    }

    public void decoller(){
        if (enVol){
            System.out.println("erreur");
        }else{
            enVol = true;
            VaisseauSecurise.nbEnVol++;
            System.out.println("Décollage réussit");
        }
    }

    public void atterrir(){
        if (! enVol){
            System.out.println("erreur");
        }else{
            enVol = false;
            VaisseauSecurise.nbEnVol--;
            System.out.println("atterrissage réussit");
        }
    }

    public String getnom() {
        return this.nom;
    }
}
















