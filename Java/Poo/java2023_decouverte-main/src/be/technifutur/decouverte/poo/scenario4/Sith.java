package be.technifutur.decouverte.poo.scenario4;

public class Sith extends Empire implements Force{
    public Sith(String nom) {
        super(nom);
    }

    @Override
    public void combattre() {
        System.out.println("je combat comme un sith");
    }

    @Override
    public void utiliseForce() {
        System.out.println("j'utilise le cotè obscure de la force");
    }
}
