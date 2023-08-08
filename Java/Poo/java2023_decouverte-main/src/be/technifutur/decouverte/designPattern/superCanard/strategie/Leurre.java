package be.technifutur.decouverte.designPattern.superCanard.strategie;

public class Leurre extends Canard {
    public Leurre() {
        super(new Muet(), new NePasVoler());
    }

    @Override
    public void affiche() {
        System.out.println("je suis un leurre");
    }
}
