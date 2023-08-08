package be.technifutur.decouverte.designPattern.superCanard.strategie;

public class CanardPlastique extends Canard{

    public CanardPlastique() {
        super(new Coincoin()   , new NePasVoler());
    }

    @Override
    public void affiche() {
        System.out.println("je suis un canard en plastique");
    }
}
