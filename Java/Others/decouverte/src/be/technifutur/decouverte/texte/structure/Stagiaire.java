package be.technifutur.decouverte.texte.structure;

import java.util.Scanner;

public class Stagiaire {
    public static void main(String[] args) {
        Personne[] stagiaires = new Personne[2];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < stagiaires.length; i++) {
            stagiaires[i] = new Personne();
            System.out.print("Nom: ");
            stagiaires[i].nom = scan.nextLine();
            System.out.print("Prénom: ");
            stagiaires[i].prenom = scan.nextLine();
            stagiaires[i].naissance = new MyDate();

            System.out.println("Date de naissance");
            System.out.print("Jour: ");
            stagiaires[i].naissance.jour = Integer.parseInt(scan.nextLine());
            System.out.print("Mois: ");
            stagiaires[i].naissance.mois = Integer.parseInt(scan.nextLine());
            System.out.print("Année: ");
            stagiaires[i].naissance.annee = Integer.parseInt(scan.nextLine());
        }
        System.out.println("--------------- Affichage ---------------");
        for (int i = 0; i < stagiaires.length; i++) {
            System.out.println("--------------- N°"+(i+1)+" ---------------");

            System.out.println("Nom: "+stagiaires[i].nom);
            System.out.println("Prénom: "+stagiaires[i].prenom);
            System.out.println("Date de naissance");
            System.out.println("Jour: "+stagiaires[i].naissance.jour);
            System.out.println("Mois: "+stagiaires[i].naissance.mois);
            System.out.println("Année: "+stagiaires[i].naissance.annee);
        }
        System.out.println("--------------------------------");

        for (Personne stagiaire : stagiaires) {
            System.out.printf("| %s | %s | %s/%s/%s |%n",
                    stagiaire.nom,
                    stagiaire.prenom,
                    stagiaire.naissance.jour,
                    stagiaire.naissance.mois,
                    stagiaire.naissance.annee);
        }
    }
}
