package be.technifutur.decouverte.texte.poo.scenario3;

public class Millenium extends VaisseauAncetre{
    public Millenium() {
        super("Millenium", 10, 10);
    }

    //overloading
    public void tirer(int nbMissile){
        for (int i = 0; i < nbMissile; i++) {
            this.tirer();
        }

    }

    @Override
    public void afficheCamp() {
        System.out.println("Gentil");
    }
}
