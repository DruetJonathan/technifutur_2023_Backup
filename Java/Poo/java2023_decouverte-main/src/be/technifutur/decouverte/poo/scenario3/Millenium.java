package be.technifutur.decouverte.poo.scenario3;

public class Millenium extends VaisseauAncetre {

    public Millenium() {
        super(10, "Millenium");
    }

    //overloading
    public void tirer(int nbMissile) {
        for (int i = 0; i < nbMissile; i++) {
            super.tirer();
        }
    }

    @Override
    public void afficheCamps() {
        System.out.println("je suis un rebel");
    }
}
