package be.technifutur.logiqueToJava;

import java.util.Arrays;

/**
 * NombrePremier
 */
public class NombrePremier implements Runnable {

    public void run() {

        int compteur = 0, nbr = 2;
        long before = 0, after = 0;
        boolean Premier = true;
        final int TAILLE = 1000 ;
		int nombre[] = new int[TAILLE];
        System.out.println("Nombres Premiers");
        before = System.currentTimeMillis();

        while (compteur < TAILLE) {
            for (int i = 2; i < nbr - 1 && Premier; i++) {
                if (nbr % i == 0) {
                    Premier = false;
                }
            }
            if (Premier) {
                nombre[compteur] = nbr;
                compteur++;

            }
            Premier = true;
            nbr++;
        }
        after = System.currentTimeMillis();
        System.out.println("Temps execution: " + (after - before));
        System.out.println(Arrays.toString(nombre));
    }
}