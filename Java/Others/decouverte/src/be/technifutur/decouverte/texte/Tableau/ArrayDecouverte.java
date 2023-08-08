package be.technifutur.decouverte.texte.Tableau;

import be.technifutur.decouverte.texte.structure.MyDate;
import be.technifutur.decouverte.texte.structure.Personne;

public class ArrayDecouverte {
    public static void main(String[] args) {
        int[] tab = new int[56];
        int[] tab2 = tab;
        tab[2] = 12;
        System.out.println(tab2[2]);
        tab = new int[2];

        int[] tab3 = new int[]{2, 5, 4, 8, 9, 3, 2, 5, 1, 4, 7};
        int[] tab4 = {2, 5, 4, 8, 9, 3, 2, 5, 1, 4, 7};

        int[][] tab2d = new int[3][2];
        tab = tab2d[2];
        tab[1] = 5;
        System.out.println(tab2d[2][1]);

        int[][] tab2d2 = new int[3][];
        tab2d2[0] = new int[5];
        tab2d2[1] = new int[3];
        tab2d2[2] = tab2d2[0];

        int[][] tab2d3 = {
                {1, 5, 9},
                {2, 4, 52},
                null
        };

        for (int i = 0; i < tab2d3.length; i++) {
            for (int j = 0; tab2d3[i] != null && j < tab2d3[1].length; j++) {
                System.out.println(tab2d3[i][j]);
            }
        }

        /*for (int[] t: tab2d3){
            for (int val : t){
                System.out.println(t);
            }
        }*/
        Personne[] groupe = new Personne[2];
        groupe[0] = new Personne();
        groupe[0].nom = "Dupont";
        groupe[0].prenom = "Kevin";
        groupe[1] = new Personne();
        groupe[1].nom = "ducon";
        groupe[1].prenom = "jean";
        MyDate nais = new MyDate();
        nais.jour = 11;
        nais.mois = 12;
        nais.annee = 2005;
        for (Personne p :
                groupe) {
            p.naissance = nais;
        }
    }
}
