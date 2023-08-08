package be.technifutur.decouverte.poo.scenario4;

public abstract class Empire extends Personnage{
    public Empire(String nom) {
        super(nom);
    }

    @Override
    public String getCamps() {
        return "je suis fidèle à l'empire";
    }
}
