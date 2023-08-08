package be.technifutur.decouverte.texte.poo.Scenario4;

public abstract class Personnage {
    private String nom;

    Personnage(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }
    public abstract String getCamp();
    public abstract void combattre();
}
