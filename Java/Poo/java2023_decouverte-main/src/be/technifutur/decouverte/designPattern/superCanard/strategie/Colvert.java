package be.technifutur.decouverte.designPattern.superCanard.strategie;

public class Colvert extends Canard{
    public Colvert() {
        super(new Coincoin(), new VolerAvecAiles());
    }

    @Override
    public void affiche() {
        System.out.println("je suis un Colvert");
    }
}
