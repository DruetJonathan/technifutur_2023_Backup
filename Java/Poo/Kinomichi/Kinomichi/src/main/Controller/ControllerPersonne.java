package main.Controller;

import main.Exception.NullOrEmptyFieldException;
import main.Utils.AffichageUtils;
import main.Utils.Console;
import main.Utils.ConsoleColors;
import main.domains.Activite;
import main.domains.Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerPersonne implements Runnable,Controller {
    private ArrayList<Personne> listePersonne;
    ArrayList<Activite> listeActivite;
    AffichageUtils affichageUtils = new AffichageUtils();

    public ControllerPersonne(ArrayList<Personne> listePersonne,ArrayList<Activite> listeActivite)
    {
        this.listePersonne = listePersonne;
        this.listeActivite = listeActivite;
    }

    public Runnable getOptionController(int choix){
        Runnable r = null;
        switch (choix) {
            case 1:
                    r=ajouter();
                break;
            case 2:
                r=modifier();
                break;

            case 3:
                r=supprimer();
                break;

            case 4:
                r=afficher();
                break;

        }
        return r;
    }

    @Override
    public void run() {
    }

    @Override
    public Runnable ajouter() {
        return () -> {
            // Clear la console
            affichageUtils.clearConsole();
            // variable///////////////////////////////////////////////////////////////////////////////////////
            String nom, prenom, club,input;
            String[] tab;
            char estResponsable = 'n';
            Personne personne;
            affichageUtils.printEnTete("Encodage",ConsoleColors.BLUE);
            // saisie ///////////////////////////////////////////////////////////////////////////////////////
            System.out.println("Nom.Prenom.club");
            input = Console.lireString();
            tab = input.split("\\.");
            // creation de l'objet personne/////////////////////////////////////////////////////////////////
            personne = null;
            // Try catch de l'exception si le prenom ou le nom est vide ou null//////////////////////////////
            try {
                // création de la personne avec les données et verification si le club est empty ou null alors on set le
                //club a une chaine vide
                // le statut de responsable est par défaut à false
                personne = new Personne(tab[0], tab[1], tab.length<3 ? "": tab[2], estResponsable == 'o' ? true : false);
                // ajout de la personne à la liste de personne
                listePersonne.add(personne);
                // Si le nom et le prenom sont tous deux soit vide ou null alots exception
            } catch (NullOrEmptyFieldException e) {
                System.err.println(e.getMessage());
            }
            // On catch les erreurs de saisie
            catch (ArrayIndexOutOfBoundsException r){
                affichageUtils.printMessageErreur("Erreur de saisie");
            }
            // on print le séparateur de section
            affichageUtils.printSeparator(68,ConsoleColors.BLUE);
        };
    }

    @Override
    public Runnable modifier() {
        return () -> {
            // variable///////////////////////////////////////////////////////////////////////////////////////
            String nom, prenom, club;
            char estResponsable = 'n';
            int choix;
            Personne currentPersonne;
            //affichage en-tete///////////////////////////////////////////////////////////////////////////////
            // Clear la console
            affichageUtils.clearConsole();
            affichageUtils.printEnTete("Modification",ConsoleColors.BLUE);
            this.afficher().run();
            // input//////////////////////////////////////////////////////////////////////////////////////////
            // affichage de demande de numero de la personne + lecture saisie user
            System.out.print("Entrez le numéro de la personne à modifier: ");
            choix = affichageUtils.readInt("-> ", listePersonne.size());
            //////////////////////////////////////////////////////////////////////////////////////////////////
            //affichage récapitulatif de la personne choisie
            System.out.println(listePersonne.get(choix - 1).toString());
            // sauvegarde de la personne choisie dans une variable
            currentPersonne = (Personne) listePersonne.get(choix - 1);
            //////////////////////////////////////////////////////////////////////////////////////////////////
            affichageUtils.printMessageErreur("/!\\ Appuyez sur Enter pour ne pas modifier le champ /!\\");
            System.out.print("Nom: ");
            nom = Console.lireString();
            if (!nom.equalsIgnoreCase(""))
                currentPersonne.setNom(nom);
            ////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.print("Prénom: ");
            prenom = Console.lireString();
            if (!prenom.equalsIgnoreCase(""))
                currentPersonne.setPrenom(prenom);
            ////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.print("Club (Optionnel) : ");
            club = Console.lireString();
            if (!club.equalsIgnoreCase(""))
                currentPersonne.setClub(club);
            ////////////////////////////////////////////////////////////////////////////////////////////////////
            /*System.out.print("Est responsable d'une activité (o = oui / n = non): ");
            estResponsable = Console.lireChar();
            if (estResponsable != ' ')
                currentPersonne.setEstResponsable(estResponsable == 'o' ? true : false);*/
            affichageUtils.printSeparator(30,ConsoleColors.BLUE);
        };
    }

    @Override
    public Runnable supprimer() {
        return () -> {
            // variable///////////////////////////////////////////////////////////////////////////////////////
            int choix;
            Personne p;
            //////////////////////////////////////////////////////////////////////////////////////////////////
            //affichage en-tete + liste de personne
            // Clear la console
            affichageUtils.clearConsole();
            affichageUtils.printEnTete("Suppression",ConsoleColors.BLUE);
            this.afficher().run();
            //////////////////////////////////////////////////////////////////////////////////////////////////
            // affichage de la demande + lecture de la saisie user
            System.out.print("Entrez le numéro de la personne à supprimer: ");
            choix = affichageUtils.readInt("-> ", listePersonne.size());
            p = listePersonne.get(choix-1);
            // si la siz est diff de 0 alors on execute pour une suppression
            if (listeActivite.size()!=0) {
                // boucle sur la liste d activite
                for (Activite a : listeActivite) {
                    // sauvegarde a chaque tour de boucle la liste de personne participantes
                    List<Personne> listePersonneParticipantes = a.getListePersonneParticipantes();
                    // si la liste n'est pas vide on test
                    if (!listePersonneParticipantes.isEmpty()){
                        // si la personne est contenu dans la liste on la remove
                        listePersonneParticipantes.removeIf(personne -> personne.equals(p));
                    }
                    // si la personne est responsable de l'activité alors on set le responsable à null
                    if (a.getResponsable() == p){
                        a.setResponsable(null);
                    }
                }
                // on remove la personne de la liste de personne
                listePersonne.remove(choix - 1);
            }
            // affichage de séparateur de section
            affichageUtils.printSeparator(78,ConsoleColors.BLUE);

        };

    }

    @Override
    public Runnable afficher() {
        return () -> {
            // Clear la console
            affichageUtils.clearConsole();
            int cpt = 1;
            // afichage de l'en-tete
            affichageUtils.printEnTete("Affichage Personne",ConsoleColors.BLUE);
            //boucle d'affichage
            for (Personne p : listePersonne) {
                System.out.println(ConsoleColors.RED+cpt + ConsoleColors.WHITE_BRIGHT+"- " + p);
                cpt++;
            }
            //affichage de séparateur de section
            affichageUtils.printSeparator(78,ConsoleColors.BLUE);
        };
    }

}
