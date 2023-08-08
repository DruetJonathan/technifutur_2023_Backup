package be.technifutur.decouverte.poo.scenario2;

public class Scenario2 {
    public static void main(String[] args) {
        System.out.println(VaisseauSecurise.getNbEnVol());
        VaisseauSecurise v1 = new VaisseauSecurise(5,"Xwing");
        VaisseauSecurise v2 = new VaisseauSecurise(5,"Xwing");
        VaisseauSecurise v3 = new VaisseauSecurise(5,"Xwing");
        VaisseauSecurise v4 = new VaisseauSecurise(5,"Xwing");
        VaisseauSecurise v5 = new VaisseauSecurise(5,"Xwing");
        VaisseauSecurise v6 = new VaisseauSecurise(5,"Xwing");

        System.out.println(v2.getnom());
        v2.addMissile(3);
        System.out.println(v2.getNbMissile());

        System.out.println(VaisseauSecurise.getNbEnVol());
        v2.decoller();
        System.out.println(VaisseauSecurise.getNbEnVol());
        v3.decoller();
        System.out.println(VaisseauSecurise.getNbEnVol());
        v4.decoller();
        System.out.println(VaisseauSecurise.getNbEnVol());
        v2.decoller();
        System.out.println(VaisseauSecurise.getNbEnVol());
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();

        System.out.println(v2.getNbMissile());

        v4.toString();

    }
}
