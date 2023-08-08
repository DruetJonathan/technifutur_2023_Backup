package be.technifutur.decouverte.poo.scenario1;

public class Vaisseau {

    // variables d'instance contiennent l'état de l'objet
    String nom;
    int nbMissile;

    // méthode d'instance
    public void tirer() {
        if (this.nbMissile > 0) {
            System.out.println("PAN");
            this.nbMissile--;
        } else {
            System.out.println("POUF");
        }
    }
}
