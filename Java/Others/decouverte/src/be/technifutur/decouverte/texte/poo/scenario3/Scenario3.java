package be.technifutur.decouverte.texte.poo.scenario3;

public class Scenario3 {
    public static void main(String[] args) {
        Millenium m = new Millenium();
        Xwing x = new Xwing(15);
        Xwing x2 = new Xwing(15);
        Lukywa l = new Lukywa("ZirkaOneBeats");

        System.out.println(m.getNom());
        System.out.println(x.getNom());
        System.out.println(x2.getNom());
        m.tirer(5);
        System.out.println(l.getNom());



            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
            l.tirer();
        System.out.println(l.toString());
        System.out.println(x==x2);
        System.out.println(x.equals(x2));

        x.decolage();
        EtoileNoire en = new EtoileNoire();
        //en.attireVaiseau(x);
        //en.attireVaiseau(m);
        //en.attireVaiseau(l);
    }
}
