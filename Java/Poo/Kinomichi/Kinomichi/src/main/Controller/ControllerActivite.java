package main.Controller;

import main.Utils.AffichageUtils;
import main.Utils.Console;
import main.Utils.ConsoleColors;
import main.domains.Activite;
import main.domains.Personne;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ControllerActivite implements Controller {
    private ArrayList<Personne> listePersonne;
    private ArrayList<Activite> listeActivite;
    AffichageUtils affichageUtils = new AffichageUtils();
    //Runnable r;

    public ControllerActivite(ArrayList<Personne> listePersonne, ArrayList<Activite> listeActivite) {
        this.listePersonne = listePersonne;
        this.listeActivite = listeActivite;
    }

    public Runnable getOptionController(int choix) {
        Runnable r = null;

        switch (choix) {
            case 1:
                r = ajouter();
                break;
            case 2:
                r = modifier();
                break;

            case 3:
                r = supprimer();
                break;

            case 4:
                r = afficher();
                break;
            case 5:
                r = ajouterPersonneAUneActviviteBy();
                break;

            case 6:
                r = ajouterResponsable();
                break;

        }


        return r;
    }

    private Runnable ajouterResponsable() {
        return () -> {
            // variable ///////////////////////////////////////////////////////////////////////////////////////
            int idActivite, idPersonne;
            boolean flagEstResponsableToujours = false;
            ControllerPersonne controllerPersonne;
            Personne responsable, responsableOld;
            // Clear la console
            affichageUtils.clearConsole();
            this.afficher().run();
            // affichage demande + lecture saisie user
            System.out.print("L'id de l'activitée: ");
            idActivite = Console.lireInt() - 1;
            // création du controller personne + affichage de celyi-ci ///////////////////////////////////////
            controllerPersonne = new ControllerPersonne(listePersonne, listeActivite);
            controllerPersonne.afficher().run();
            // affichage demande + lecture saisie user ///////////////////////////////////////////////////////
            System.out.print("L'id de la personne: ");
            idPersonne = Console.lireInt() - 1;
            // creation objet resposabel nouveau + sauvegarde de l'ancien responsable ////////////////////////
            responsable = listePersonne.get(idPersonne);
            responsableOld = listeActivite.get(idActivite).getResponsable();
            // on set la variable du nouveau respnsable dans la personne a true
            responsable.setEstResponsable(true);
            // boucle si la longueur de la liste est plus grande que 0
            if (listeActivite.size() != 0) {
                for (Activite a : listeActivite) {
                    // si la liste de participant de l'activiré contient l'ancien responsable alors flag a true
                    if (!a.getListePersonneParticipantes().contains(responsableOld)) {
                        flagEstResponsableToujours = true;
                    }
                }
                // on set le nouveau responsable à l'activité
                listeActivite.get(idActivite).setResponsable(responsable);
            }
            // si le flag est false alors on set le statut de l'ancien responsable à false
            if (!flagEstResponsableToujours) {
                responsableOld.setEstResponsable(false);
            }
        };
    }

    private Runnable ajouterPersonneAUneActviviteBy() {
        return () -> {
            // affichage des activité
            this.afficher().run();
            // affichage demande + lecture du choix user
            System.out.print("L'id de l'activitée: ");
            int id = Console.lireInt() - 1;
            // appel fonction pour ajouter une personne à une activité
            ajouterPersonneAUneActvivite(id, 1);
        };
    }

    @Override
    public Runnable ajouter() {
        return () -> {
            // Clear la console
            affichageUtils.clearConsole();
            // variables //////////////////////////////////////////////////////////////////////////////////////////////
            String nom, typeActivite;
            LocalDateTime dateDebut = LocalDateTime.now(), dateFin = LocalDateTime.of(1, 1, 1, 1, 1, 1);
            ControllerPersonne cp;
            int choix;
            Activite activite;
            Personne p = null;
            // en tete ///////////////////////////////////////////////////////////////////////////////////////////////
            affichageUtils.printEnTete("Encodage", ConsoleColors.BLUE);
            System.out.print("Nom de l'activité: ");
            nom = Console.lireString();
            // todo faire liste a ajouter etc
            System.out.print("Type de l'activité: ");
            typeActivite = Console.lireString();
            try {
                // tant que la date de debut est apres la date de fin
                while (!dateFin.isAfter(dateDebut)) {
                    System.out.println("Date de début: ");
                    dateDebut = getDate();
                    System.out.println("Date de fin: ");
                    dateFin = getDate();
                }
                // creation controller personne et affichage de la liste de personne
                cp = new ControllerPersonne(listePersonne, listeActivite);
                cp.afficher().run();
                // affichage demande + lecture de la saisie
                System.out.print("Séléctionner un numero de responsable: ");
                choix = Console.lireInt();
                // si le choix est différent de 0 sinon on crée l'activité sans responsable
                if (choix != 0) {
                    // sauvegarde la personne choisie + set true de la variable responsable de la personne à true
                    p = listePersonne.get(choix - 1);
                    p.setEstResponsable(true);
                    // création de l'activité + ajout de la personne responsable à la liste de participant
                    activite = new Activite(nom, typeActivite, dateDebut, dateFin, p);
                    activite.getListePersonneParticipantes().add(p);
                } else {
                    activite = new Activite(nom, typeActivite, dateDebut, dateFin);
                }
                // on ajoute l'activité créé à la liste d'activitée
                listeActivite.add(activite);
                // affichage demande + lecture de la saisie
                System.out.println(ConsoleColors.GREEN + "Voulez-ajouter une autre personne (Enter pour confirmer sinon n)? " + ConsoleColors.WHITE_BRIGHT);
                // si la saisie est diff de n alors on lance la methode d'ajout de personne à une activité
                if (!Console.lireString().equals("n")) {
                    ajouterPersonneAUneActvivite(listeActivite.size() - 1, 0);
                }
            } catch (DateTimeException e) {
                // si il y a un exception de date on ecris le message + separteur
                System.err.println(e.getMessage());
                affichageUtils.printSeparator(30, ConsoleColors.BLUE);
            }
            //affichage de séparateur
            affichageUtils.printSeparator(30, ConsoleColors.BLUE);

        };
    }

    private static LocalDateTime getDate() {
        // variables
        LocalDateTime date;
        String input;
        String[] tab;
        // tant que le nombre de valeur entré est diff de celle attendu alors on execute la boucle
        do {
            //affichage demande + lecture input user
            System.out.println("Annee.Mois.Jour.Heure.Minute");
            input = Console.lireString();
            tab = input.split("\\.");
        } while (tab.length < 5);
        // création de la date à partie des saisies
        date = LocalDateTime.of(
                Integer.valueOf(tab[0]),
                Integer.valueOf(tab[1]),
                Integer.valueOf(tab[2]),
                Integer.valueOf(tab[3]),
                Integer.valueOf(tab[4]));
        // retourne la date
        return date;
    }

    @Override
    public Runnable modifier() {
        return () -> {
            // variable ///////////////////////////////////////////////
            int choix, idResponsable;
            String nom, typeActivite;
            Activite currentActivite;
            LocalDateTime dateDebut, dateFin;
            ControllerPersonne cp;
            // clear console + affichange en tete
            affichageUtils.clearConsole();
            affichageUtils.printEnTete("Modification", ConsoleColors.BLUE);
            // affichage de la liste d'activité
            this.afficher().run();
            // affichage demande + lecutre input user
            System.out.print("Entrez le numéro de l'activité à modifier: ");
            choix = Console.lireInt();
            //affichage recapitulatif de l'activité choisie
            System.out.println(listeActivite.get(choix - 1).toString());
            // sauvegarde de l'activité choisie dans une variable
            currentActivite = (Activite) listeActivite.get(choix - 1);
            // affichage du message d'informations de consigne de suppression
            System.out.println("/!\\ Appuyez sur Enter pour ne pas modifier le champ /!\\");
            //
            System.out.print("Nom de l'activité: ");
            nom = Console.lireString();
            if (!nom.equalsIgnoreCase(""))
                currentActivite.setNom(nom);
            //
            System.out.print("Type de l'activité: ");
            typeActivite = Console.lireString();
            if (!typeActivite.equalsIgnoreCase(""))
                currentActivite.setTypeActivite(typeActivite);
            // demande pour les dates
            System.out.println("Réinserer la date début / fin");
            System.out.println("Date de début: ");
            dateDebut = getDate();
            currentActivite.setDateDebut(dateDebut);
            System.out.println("Date de fin: ");
            dateFin = getDate();
            currentActivite.setDateFin(dateFin);
            ////////////////////////////////////////////////////////////////////////////////
            // creation du controller de personne + affichage de la liste de personne
            cp = new ControllerPersonne(listePersonne, listeActivite);
            cp.afficher().run();
            // affichage demande + lecture saisie user
            System.out.print("Séléctionner un numero de responsable: ");
            idResponsable = Console.lireInt();
            // si la value entrée par le user es diff de "" alors on set le responsable par la personne séléctionné par
            // le user
            if (String.valueOf(idResponsable).equalsIgnoreCase("")) ;
            currentActivite.setResponsable(listePersonne.get(idResponsable - 1));
            // appel fonction pour ajouter une personne à une activité
            ajouterPersonneAUneActvivite(choix - 1, 0);
            // affichage séparateur
            affichageUtils.printSeparator(30, ConsoleColors.BLUE);
        };
    }

    @Override
    public Runnable supprimer() {
        return () -> {
            // clear console + affichage en tete
            affichageUtils.clearConsole();
            affichageUtils.printEnTete("Suppression", ConsoleColors.BLUE);
            // affichae de la liste d'activité
            this.afficher().run();
            System.out.print("Entrez le numéro de l'activité à supprimer: ");
            int choix = Console.lireInt();
            //affichage demande + lecture saisie user
            // sie le choix est compris dans les bornes alors on execute
            choix = affichageUtils.readInt("Entrez le numéro de l'activité à supprimer: ", listeActivite.size());
            //if (listeActivite.size() != 0 || listeActivite.size() < choix - 1) {
            // remove de l'activité de la liste d'activité
            listeActivite.remove(choix - 1);
            //}
            //affichage de séparateur
            affichageUtils.printSeparator(30, ConsoleColors.BLUE);
        };
    }

    @Override
    public Runnable afficher() {
        return () -> {
            // var
            AtomicInteger cpt = new AtomicInteger(1);
            // print de l'en tete
            affichageUtils.printEnTete("Affichage Activité", ConsoleColors.BLUE);
            // boucle d'affichage avec un comparateur sur les dates
            /*listeActivite.stream().sorted(Comparator.comparing(Activite::getDateDebut).thenComparing(Activite::getDateFin)).forEach(a -> {
                System.out.println(ConsoleColors.RED + cpt + ConsoleColors.WHITE_BRIGHT + "- " + a);
                cpt.getAndIncrement();
            });*/
            listeActivite.stream().forEach(a -> {
                System.out.println(ConsoleColors.RED + cpt + ConsoleColors.WHITE_BRIGHT + "- " + a);
                cpt.getAndIncrement();
                // afichage separateur
                affichageUtils.printSeparator(78, ConsoleColors.BLUE);
            });
        };
    }

    private void ajouterPersonneAUneActvivite(int idActivite, int idAppelFonction) {
        // variables
        String demande = "";
        // verification de qui apel la methode par un index
        // if (idAppelFonction == 0) {
        // lecture d ela demande et -1 sur l'id
        //demande = Console.lireString();
        //   idActivite -= 1;
        // }
        // si la demadnde est diff de n
        if (!demande.equals("n")) {
            // variables
            char continuer = 'p';
            int idPersonne = -1;
            ControllerPersonne cp = new ControllerPersonne(listePersonne, listeActivite);
            Activite currentActivite;
            //Tant que le caractère est different de n
            while (Character.toLowerCase(continuer) != 'n') {
                // affichage liste de personne
                cp.afficher().run();
                // affichage demande + saisie user
                System.out.print("Entrez le numéro de la personne à ajouter a cette activite: ");
                idPersonne = Console.lireInt();
                // on save l'activité sur laquelle on doit effectuer les actions futurs
                currentActivite = listeActivite.get(idActivite);
                // si l'activité contient la personne concerné alors on le dit sinon on l'ajoute à sa liste de personne
                List<Personne> listePersonneParticipantes = currentActivite.getListePersonneParticipantes();
                if (idPersonne != -1 & listePersonneParticipantes.contains(listePersonne.get(idPersonne - 1))) {
                    System.out.println(ConsoleColors.RED + "Cette personne participe deja a celle-ci" + ConsoleColors.WHITE_BRIGHT);
                } else if (idPersonne != -1) {
                    listePersonneParticipantes.add(listePersonne.get(idPersonne - 1));
                }
                // on demande si on veux réitérer la demande d'ajout + lecture du choix user
                System.out.println(ConsoleColors.GREEN + "Voulez-ajouter une autre personne (Enter pour confirmer sinon n)? " + ConsoleColors.WHITE_BRIGHT);
                continuer = Console.lireChar();
            }
        }
    }
}
// todo verifier ajout responsable dans modif et idactivite-1
