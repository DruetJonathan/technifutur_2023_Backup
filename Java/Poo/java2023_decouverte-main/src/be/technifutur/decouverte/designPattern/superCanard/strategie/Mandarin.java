package be.technifutur.decouverte.designPattern.superCanard.strategie;

public class Mandarin extends Canard {

    public Mandarin() {
        super(new CanCan(), new VolerAvecAiles());
    }

    @Override
    public void affiche() {
        System.out.println("je suis un Mandarin");
    }
}
