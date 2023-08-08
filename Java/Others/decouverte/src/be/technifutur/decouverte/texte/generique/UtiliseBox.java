package be.technifutur.decouverte.texte.generique;

import be.technifutur.decouverte.texte.collection.Personne;
import be.technifutur.decouverte.texte.poo.scenario3.Millenium;
import be.technifutur.decouverte.texte.poo.scenario3.VaisseauAncetre;
import be.technifutur.decouverte.texte.poo.scenario3.Xwing;

public class UtiliseBox {
    public static void main(String[] args) {
        // Création des box
        Box<VaisseauAncetre> va1 = new Box<>(new Millenium());
        Box<Personne> va2 = new Box<>(new Personne("", "", null));
        Box<Millenium> millenium = new Box<>(new Millenium());
        Box<Object> objectBox = new Box<>(null);

        // test box1
        va1.setContenu(new Xwing(10));
        VaisseauAncetre contenu = va1.getContenu();
        System.out.println(contenu);

        // test box2
        va2.setContenu(new Personne("toto", "toto", null));
        Personne contenu1 = va2.getContenu();
        System.out.println(contenu1);

        //test box3
        millenium.setContenu(new Millenium());
        Millenium contenuMillenium = millenium.getContenu();
        System.out.println(contenuMillenium);

        //test fct
        manipuleAncetre(va1);
        manipuleSuperAncetre(va1);
//       manipuleSuperAncetre(millenium);
        manipuleSuperAncetre(objectBox);
        //manipuleAncetre(millenium);

    }

    /*
    read and write mais peux pas passer un type millenium dans l'appel
     */
    public static void manipuleAncetre(Box<VaisseauAncetre> boite) {
        VaisseauAncetre contenu = boite.getContenu();
        boite.setContenu(new Millenium());
        boite.setContenu(new Xwing(10));
    }
    /*
    read only
     */
    public static void manipuleExtendsAncetre(Box<? extends VaisseauAncetre> boite) {
        VaisseauAncetre contenu = boite.getContenu();
//        boite.setContenu(new Millenium());
//        boite.setContenu(new Xwing(10));
    }
    public static void manipuleSuperAncetre(Box<? super VaisseauAncetre> boite) {
       // VaisseauAncetre contenu = boite.getContenu();
        boite.setContenu(new Millenium());
        boite.setContenu(new Xwing(10));
    }
}
