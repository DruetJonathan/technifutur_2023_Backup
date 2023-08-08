package be.technifutur.logiqueToJava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nombre = 0;

        Runnable[] exercices = {
                new NombrePremier(),
                new CharacterExercice(),
                new cadreAutourTexte(),
                new ChiffreDigitals(),
                new RechercheDicoto(),
                new binaryUtils(),
                new testListe(),
                new TriParTas()
        };
        do {
            for (int i = 0; i < exercices.length; i++) {
                System.out.printf(" %s : %s%n", i + 1, exercices[i].getClass().getSimpleName());
            }
            System.out.printf(" %s : %s%n", 0, "Quitter");
            String input = scan.nextLine(); // Saisir input
            nombre = Integer.parseInt(input);
            if (nombre > 0 && nombre <= exercices.length) {
                exercices[nombre - 1].run();
            }
        } while (nombre != 0);
    }

    public static void syntaxe() {
        Scanner scan = new Scanner(System.in);
        int nombre = 0; // var nombre :N <- 0
        String text = ""; // var text :T <- ""
        boolean flag = true; // var flag :B <- VRAI
        char car = 'a'; // var car :C <- 'a'
        final int taille = 5; // const taille :N <- 5
        int[] vect = new int[taille]; // var vect :N[taille]
        int[][] tab = new int[taille][taille]; // var tab : N[taille, taille]

        String input = scan.nextLine(); // Saisir input
        nombre = Integer.parseInt(input);
        // nombre = Integer.parseInt(scan.nextLine());
        System.out.println("logique to java"); // afficher "logique to java"

        if (car == ' ') { // si car = ' ' alors

        } else { // sinon

        } // finsi

        while (nombre < 10) {
            nombre = nombre + 1;
        }

        System.out.println(input.length()); // longueur(input)
        System.out.println(input.charAt(2)); // caract(input, 3)
        System.out.println(input.substring(2, 3)); // sousChaine(input,3,4)

    }
}