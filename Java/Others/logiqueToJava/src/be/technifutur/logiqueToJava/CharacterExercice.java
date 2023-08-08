package be.technifutur.logiqueToJava;

import java.util.Scanner;

public class CharacterExercice implements Runnable {
    public void run() {
        Scanner scan = new Scanner(System.in);
        int firstPos = 0, compteurNombreLettre = 0;
        System.out.print("Entrez un mot: ");
        String texte = scan.nextLine();
        System.out.print("Entrez une lettre à chercher: ");
        char lettre = scan.nextLine().charAt(0);

        for (int i = 0; i < texte.length(); i++) {
            if (texte.charAt(i) == lettre) {
                if (compteurNombreLettre == 0) {
                    firstPos = i;
                }
                compteurNombreLettre++;

            }
        }
        if (compteurNombreLettre != 0) {
            System.out.println("Le caractère a été trouvé sa première position est " + firstPos + " et il est apparut "
                    + compteurNombreLettre + " fois");
        } else {
            System.out.println("Le caractère n'a pas été trouvé");
        }
    }
}
