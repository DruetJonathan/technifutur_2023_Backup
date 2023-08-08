package be.technifutur.decouverte.texte.poo.Scenario4;

public class Soldat extends Rebelle{
    Soldat(String nom) {
        super(nom);
    }
    @Override
    public void combattre(){
        System.out.println("Ce soldat rebelle se bat");
    }
}
