package be.technifutur.logiqueToJava;

import java.util.Arrays;

public class RechercheDicoto implements Runnable {
    public void run() {
        double before,after;
        final int TAILLE = 1000000;
        int borneMax = 10000 ,valeur = (int)(Math.random()*borneMax),position=0;
        System.out.println("Valeur de recherche: "+valeur);
        // Initialisation tableau
        int[] tab = new int[TAILLE];
        tab = initialisationTab(tab,borneMax);
        Arrays.sort(tab);
        System.out.println(Arrays.toString(tab));

        // Recherche basique
        before = System.currentTimeMillis();
        position = rechercheBasique(tab,valeur);
        after = System.currentTimeMillis();
        System.out.println("Temps execution: " + (after - before));
        System.out.println("Position: " + position);
        // Fin recherche basique
        ////////////////////////
        // Recherche dicoto
        before = System.currentTimeMillis();
        position = rechercheDico(tab,valeur);
        after = System.currentTimeMillis();
        System.out.println("Temps execution: " + (after - before));
        System.out.println("Position: " + position);
        // Fin recherche dicoto
    }

    private int rechercheDico(int[] tab, int valeur) {
        int position = -1,debut = 0,fin = tab.length-1,milieu;
        while (debut < fin){
            milieu = (debut + fin) / 2;
            if (tab[milieu] < valeur){
                debut = milieu + 1;
            }
            else {
                fin = milieu;
            }
        }
        if (valeur == tab[debut]){
            position = debut;
        }
        return position;
    }

    private int[] initialisationTab(int[] tab,int borneMax) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int)(Math.random()*borneMax);
        }
        return tab;
    }

    private int rechercheBasique(int[] tab, int valeur) {
        int position = -1,indice = 0;
        boolean recherche = true;
        while (recherche){
            if (tab[indice] == valeur){
                position = indice;
                recherche = false;
            }
            if (indice >= tab.length-1){
                recherche = false;
            }
            indice ++;
        }
        return position;
    }
}
