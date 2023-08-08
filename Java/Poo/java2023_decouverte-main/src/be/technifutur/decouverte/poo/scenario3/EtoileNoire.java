package be.technifutur.decouverte.poo.scenario3;

public class EtoileNoire {

    public void attireVaisseau(VaisseauAncetre v){
        if(v instanceof Millenium){
            Millenium m = (Millenium) v;
            attireVaisseau(m);
        }else if(v instanceof Xwing x){
            attireVaisseau(x);
        }else {
            v.atterrir();
            System.out.println("vaisseau attirer");
            v.afficheCamps();
            v.decoller();
        }
    }

    public void attireVaisseau(Millenium m){
        m.atterrir();
        System.out.println("vaisseau attirer");
        m.afficheCamps();
        System.out.println("A l'aide Obiwan");
        m.tirer(3);
        m.decoller();
    }

    public void attireVaisseau(Xwing x){
        x.atterrir();
        System.out.println("vaisseau attirer");
        x.afficheCamps();
        System.out.println(" A vos ordres Darkvador");
        x.decoller();
    }

}
