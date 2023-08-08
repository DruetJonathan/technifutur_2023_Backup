package main.Utils;

import java.util.Scanner;

public class AffichageUtils {
    public void printSeparator(int n,String couleur){
        System.out.print(couleur);
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println(ConsoleColors.WHITE_BRIGHT);
    }
    public void printSeparator(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
    }
    public void printEnTete(String titre,String couleur){
        System.out.print(couleur);
        printSeparator(30);
        System.out.print(titre);
        printSeparator(30);
        System.out.println(ConsoleColors.WHITE_BRIGHT);
    }
    public int readInt(String prompt, int userChoices) {
        Scanner scanner = new Scanner(System.in);
        // initialisation variables
        int input = 0;
        // Boucle tant que l'input ne suit pas les conditions alors ca toune
        // On print le texte et on demande l'entier correspondant à un choix
        // Si c'est pas compris dans les bornes alors on souleve exception et on ecris un message d'erreur
        do {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Entrez un entier!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }
    public void printMessageErreur(String message){
        System.out.println(ConsoleColors.RED+message+ConsoleColors.WHITE_BRIGHT);
    }
    public void clearConsole(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
