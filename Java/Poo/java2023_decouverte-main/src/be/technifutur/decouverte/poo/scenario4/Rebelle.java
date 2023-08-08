package be.technifutur.decouverte.poo.scenario4;

public abstract class Rebelle extends Personnage{
    public Rebelle(String nom) {
        super(nom);
    }

    @Override
    public String getCamps() {
        return "je suis un rebelle";
    }

}
