package be.technifutur.decouverte.poo.scenario4;

public abstract class Personnage {

    private String nom;

    public Personnage(String nom) {
        this.nom = nom;
     }

    public String getNom() {
        return nom;
    }

    public abstract String getCamps();

    public abstract void combattre();
}
