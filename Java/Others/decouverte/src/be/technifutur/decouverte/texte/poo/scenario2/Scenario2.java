package be.technifutur.decouverte.texte.poo.scenario2;

import be.technifutur.decouverte.texte.poo.scenario1.Vaisseau;

public class Scenario2 {
    public static void main(String[] args) {
        VaisseauSecure v = new VaisseauSecure("XWing",-5);
        System.out.println(v.getNbMissile());
        VaisseauSecure v2 = new VaisseauSecure("XWing",5);
        System.out.println(v2.getNbMissile());
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();
        if (!v2.addMissile(10)){
            System.out.println("Depassement nombre max");
        }
        if (v2.addMissile(v2.getMaxMissile())){
            System.out.println("Ajout de missile");
        }
        v2.tirer();
        v2.tirer();

        v2.decolage();
        v2.decolage();
        v2.atterir();
        v2.atterir();
        System.out.println("Nombre d'instance: "+v2.getInstanceCount());
    }
}
