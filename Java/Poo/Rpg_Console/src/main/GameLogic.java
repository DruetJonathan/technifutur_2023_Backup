package main;

import java.io.IOException;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    private static Player player;
    public static boolean isRunning;

    /**
     * Cette methode permet de lire le choix de l'utilisateur en verifiant les données entrées
     *
     * @param prompt      le texte a print
     * @param userChoices le nombre max que l'utilisateur peur rentrer
     * @return le choix de l'utilisateur vérifier
     */
    public static int readInt(String prompt, int userChoices) {
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

    /**
     * Cette methode permet de "clear" la console
     */
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    /**
     * Cette methode permet de print un séparateur avec une longueur en param
     *
     * @param n la longueur
     */
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Cette methode permet de print une en-tête
     *
     * @param title le titre de l'en-tête
     */
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    /**
     * Cette methode permet de read l'input(n'importe lequel) de l'utilisateur pour continuer
     */
    public static void anythingToContinue() {
        System.out.println("\nEntrez n'importe quoi pour continuer...");
        scanner.next();
    }

    /**
     * Cette methode permet de commencer une partie
     */
    public static void startGame() {
        boolean nameSet = false;
        String name;
        // Ecrire le titre
        clearConsole();
        printHeading("RPG CONSOLE");
        // Boucle de choix du pseudo
        do {
            clearConsole();
            printHeading("Quel est votre pseudo");
            System.out.print("-> ");
            name = scanner.next();
            printHeading("Votre pseudo est " + name + ".\nEst-ce correct ?");
            System.out.println("(1) Oui");
            System.out.println("(2) Non, je veux changer");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);
        // Creation du joueur
        player = new Player(name);
        // Commencement de la boucle principale
        // On set isRunning a true pour commencer la gameloop
        isRunning = true;
        gameLoop();
    }

    private static void continueJourney() {
    }

    /**
     * Cette methode permet d'afficher les infos du personnage
     */
    private static void characterInfo() {
        clearConsole();
        printHeading("Infos du personnage");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: "+player.xp);

        if(player.numAtkUpgrades >0){
            System.out.println("Trait offensif: "+player.atkUpgrades[player.numAtkUpgrades]);
        }
        if(player.numDefUpgrades >0){
            System.out.println("Trait offensif: "+player.defUpgrades[player.numDefUpgrades]);
        }
        anythingToContinue();
    }

    /**
     * Cette methode permet d'afficher le menu de jeu
     */
    private static void printMenu() {
        clearConsole();
        printHeading("Menu");
        System.out.println("Choissisez une action: ");
        printSeparator(20);
        System.out.println("(1) Continuer le voyage");
        System.out.println("() Infos du personnage");
        System.out.println("() Quitter le jeu");


    }

    private static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt(" ->", 3);
            if (input == 1) {
                continueJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }


}
