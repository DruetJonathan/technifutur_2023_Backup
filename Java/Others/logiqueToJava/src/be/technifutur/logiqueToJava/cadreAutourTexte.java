package be.technifutur.logiqueToJava;

import java.util.Arrays;
import java.util.Scanner;

public class cadreAutourTexte implements Runnable {
    public void run() {
        Scanner scan = new Scanner(System.in);
        boolean recherche = true;

        System.out.print("Entrez un texte: ");
        String texte = scan.nextLine();

        cadreHorizontal(texte);
        System.out.println();
        cadreVertical(texte);
    }

    public void cadreVertical(String texte) {
        String[] tabTexte = texte.split(" ");
        int positionMotPlusGrand = getPositionMotPlusLong(tabTexte);

        for (String s : tabTexte) {
            System.out.print("+");
            for (int j = 0; j < tabTexte[positionMotPlusGrand].length() + 2; j++) {
                System.out.print("-");
            }
            System.out.print("+");

            System.out.println();
            System.out.print("| " + s + " ");
            for (int j = 0; j < tabTexte[positionMotPlusGrand].length() - s.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.print("+");

        for (int j = 0; j < tabTexte[positionMotPlusGrand].length() + 2; j++) {
            System.out.print("-");
        }
        System.out.print("+");
        System.out.println();

    }

    public void cadreHorizontal(String texte) {
        String[] tabTexte = texte.split(" ");
        System.out.print("+");

        for (String item : tabTexte) {
            for (int j = 0; j < item.length() + 2; j++) {
                System.out.print("-");
            }
            System.out.print("+");

        }

        System.out.println();
        System.out.print("|");
        for (String value : tabTexte) {
            System.out.print(" " + value + " ");
            System.out.print("|");

        }
        System.out.println();
        System.out.print("+");

        for (String s : tabTexte) {
            for (int j = 0; j < s.length() + 2; j++) {
                System.out.print("-");
            }
            System.out.print("+");

        }

        System.out.println();

    }

    public int getPositionMotPlusLong(String[] tabTexte) {
        int position = 0;
        for (int i = 1; i < tabTexte.length; i++) {
            if (tabTexte[i].length() > tabTexte[position].length()) {
                position = i;
            }
        }

        return position;
    }
}
