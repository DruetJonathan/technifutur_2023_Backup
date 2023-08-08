package be.technifutur.decouverte.texte.poo.Scenario4;

public class Jedi extends Rebelle implements Force{
    Jedi(String nom) {
        super(nom);
    }
    @Override
    public void combattre(){
        System.out.println("Ce Jedi se bat");
    }

    @Override
    public void utiliserforce() {
        System.out.println("UTILISATION DU BON COTE DE LA FORCE");

    }
}
