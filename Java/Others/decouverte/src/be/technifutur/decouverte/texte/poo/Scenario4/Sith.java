package be.technifutur.decouverte.texte.poo.Scenario4;

public class Sith extends Empire implements Force{
    Sith(String nom) {
        super(nom);
    }
    @Override
    public void combattre(){
        System.out.println("Ce sith se bat");
    }

    @Override
    public void utiliserforce() {
        System.out.println("UTILISATION DU MAUVAIS COTE DE LA FORCE");
    }
}
