package be.technifutur.decouverte.poo.scenario3;

public class Xwing extends VaisseauAncetre{

    public Xwing(int maxMissile) {
        super(maxMissile, makeName(maxMissile));
    }

    private static String makeName(int maxMissile) {
        String name = "Xwing-";
        for (int i = 0; i<maxMissile;i++){
           name += "o";
        }
        return name;
    }

    @Override
    public void afficheCamps() {
        System.out.println("je suis fidèle à l'empire");
    }
}
