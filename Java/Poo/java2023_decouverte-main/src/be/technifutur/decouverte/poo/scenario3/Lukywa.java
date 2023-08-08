package be.technifutur.decouverte.poo.scenario3;

public class Lukywa extends VaisseauAncetre{
    public Lukywa(String nom) {
        super(0,nom);
    }

    @Override
    public void tirer(){
        System.out.println("PAN");
    }

    @Override
    public void afficheCamps() {
        System.out.println("je suis un mercenaire");
    }
}
