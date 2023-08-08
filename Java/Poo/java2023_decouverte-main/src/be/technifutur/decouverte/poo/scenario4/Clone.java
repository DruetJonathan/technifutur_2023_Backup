package be.technifutur.decouverte.poo.scenario4;

public class Clone extends Empire {
    public Clone() {
        super("Clone");
    }

    @Override
    public void combattre() {
        System.out.println("Je combat comme un Clone");
    }
}
