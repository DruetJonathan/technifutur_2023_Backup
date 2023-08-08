package be.technifutur.decouverte.texte.poo.Scenario4;

public class Empire extends Personnage{
    Empire(String nom) {
        super(nom);
    }

    @Override
    public String getCamp() {
        return "Empire";
    }

    @Override
    public void combattre() {
        System.out.println("Ce personnage se bat pour l'empire");
    }
}
