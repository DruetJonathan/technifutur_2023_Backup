package be.technifutur.decouverte.texte.poo.Scenario4;

public class Rebelle extends Personnage{
    Rebelle(String nom) {
        super(nom);
    }

    @Override
    public String getCamp() {
        return "Rebelle";
    }

    @Override
    public void combattre() {
        System.out.println("Ce rebelle se bat");
    }
}
