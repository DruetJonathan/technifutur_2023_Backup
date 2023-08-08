package be.technifutur.logiqueToJava;

import java.util.Arrays;

public class TriParTas implements Runnable {
    public void run() {
        int[] tab = {4,7,1,4,8};
        trier(tab);
        System.out.println(Arrays.toString(tab));
    }

    public int grandFils(int[] tab, int taille, int racine) {
        int gf = racine;
        int[] fils = {racine * 2, racine * 2 + 1};
        for (int i = 0; i < 2; i++) {
            if (fils[i] <= taille) {
                if (tab[gf] < tab[fils[i]]) {
                    gf = fils[i];
                }
            }
        }
        return gf;
    }

    public void creerTas(int[] tab) {
        for (int i = tab.length-1; i >= 0; i--) {
            equilibrerTas(tab, tab.length, i);
        }
    }

    public void equilibrerTas(int[] tab, int tailleArbre, int racine) {
        int i = racine;
        int indFilsMax = 0;
        int indFilsG = racine * 2, indFilsD = indFilsG + 1;
        boolean flag = true;
        System.out.println(tailleArbre+" "+indFilsG+" "+indFilsD);
        while (flag && indFilsG < tailleArbre && tab[indFilsG] < tab[i]) {
            if (indFilsD < tailleArbre) {
                indFilsMax = (tab[indFilsG] > tab[indFilsD]) ? indFilsG : indFilsD;
            } else {
                indFilsMax = indFilsG;
            }
            if (tab[indFilsMax] > tab[i]) {
                permuter(tab, i, indFilsMax);
                i = indFilsMax;
                indFilsG = i * 2 + 1;
                indFilsD = indFilsG + 1;
            }
            else {
                flag = false;
            }
        }
    }

    public void trier(int[] tab) {
        creerTas(tab);

    }

    public static void permuter(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
}
