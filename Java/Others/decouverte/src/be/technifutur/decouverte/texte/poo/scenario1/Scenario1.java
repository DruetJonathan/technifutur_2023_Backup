package be.technifutur.decouverte.texte.poo.scenario1;

public class Scenario1 {
    public static void main(String[] args) {
        Vaisseau v1 = new Vaisseau("Xwing", 4);

        for (int i = 0; i < 10; i++) {
            System.out.println("--------------------------------------------------");
            v1.tirer();
            System.out.println("Nombre de missiles restannts: "+v1.getNbMissile());

        }
    }
}
