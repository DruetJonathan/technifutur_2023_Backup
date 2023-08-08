package be.technifutur.decouverte.texte.poo.Scenario4;

public class Scenario4 {
    public static void main(String[] args) {
        Personnage[] pers = {
                new Soldat("Leon"),
                new Jedi("Luc"),
                new Sith("DarkVador"),
                new Clone()
        };
        Force f;
        for (Personnage p : pers) {
            System.out.println("----------------");
            System.out.println(p.getNom());
            System.out.println(p.getCamp());
            if (p instanceof  Force){
                f = (Force) p;
                ((Force) p).utiliserforce();
            }
            p.combattre();
            System.out.println("----------------");
        }
    }
}
