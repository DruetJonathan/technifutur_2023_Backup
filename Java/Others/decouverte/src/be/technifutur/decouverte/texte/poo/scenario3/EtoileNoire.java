package be.technifutur.decouverte.texte.poo.scenario3;

public class EtoileNoire {
    public void attireVaiseau(VaisseauAncetre v) {
        if (v instanceof Millenium) {
            attireVaiseau((Millenium) v);
        } else if (v instanceof Xwing) {
            attireVaiseau((Xwing) v);
        } else {
            v.atterir();
            System.out.println("Vaisseau attiré");
            v.afficheCamp();
            v.decolage();
        }
    }

    public void attireVaiseau(Millenium m) {
        m.atterir();
        System.out.println("Vaisseau attiré");
        m.afficheCamp();
        System.out.println("A l'aide ObiWan");
        m.tirer(5);
        m.decolage();
    }

    public void attireVaiseau(Xwing x) {
        x.atterir();
        System.out.println("Vaisseau attiré");
        x.afficheCamp();
        System.out.println("A vos ordres !");
        x.decolage();
    }
}
