package be.technifutur.decouverte.poo.scenario3;

public class Scenario3 {

    public static void main(String[] args) {
        Millenium m = new Millenium();
        Xwing x1 = new Xwing(12);
        Xwing x2 = new Xwing(12);
        Lukywa l = new Lukywa("luky1");
        VaisseauAncetre v1 = new Millenium();

        System.out.println(l.getNom());
        System.out.println(m.getNom());
        System.out.println(x1.getNom());

        m.addMissile(2);

        m.tirer(5);
        m.tirer();
        {
            System.out.println("-----------------");
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
        }
        x1.addMissile(3);

        System.out.println(x1);
        System.out.println(x2);

        System.out.println(x1==x2);
        System.out.println(x1.equals(x2));
        x1.decoller();
        m.decoller();
        v1.decoller();
        EtoileNoire en = new EtoileNoire();
        System.out.println("-----------------");
        en.attireVaisseau(x1);
        x1.afficheCamps();
        System.out.println("-----------------");
        en.attireVaisseau(m);
        m.afficheCamps();
        System.out.println("-----------------");
        en.attireVaisseau(v1);
        v1.afficheCamps();

    }
}
