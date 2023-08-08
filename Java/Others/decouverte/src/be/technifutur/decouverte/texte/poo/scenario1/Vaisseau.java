package be.technifutur.decouverte.texte.poo.scenario1;

public class Vaisseau {
    private String nom;
    private int nbMissile;

    Vaisseau(String nom, int nbMissile){
        this.nom = nom;
        this.nbMissile = nbMissile;
    }

    public int getNbMissile() {
        return this.nbMissile;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNbMissile(int nbMissile) {
        this.nbMissile = nbMissile;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void tirer() {
        if (this.getNbMissile() > 0){
            this.setNbMissile(this.getNbMissile()-1);
            System.out.println("Pann");
        }
        else{
            System.out.println("plouf");
        }
    }
}
