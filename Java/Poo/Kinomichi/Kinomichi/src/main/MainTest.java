package main;

import main.Controller.ControllerActivite;
import main.Controller.ControllerData;
import main.Exception.DateEndIsBeforDateStart;
import main.Exception.DateIsNullException;
import main.Exception.KinomichiException;
import main.Exception.NullOrEmptyFieldException;
import main.Controller.ControllerPersonne;
import main.Utils.AffichageUtils;
import main.Utils.ConsoleColors;
import main.domains.Activite;
import main.domains.Personne;
import main.menu.Vue.InlineVue;
import main.menu.Vue.MainVue;
import main.menu.menu.Menu;
import main.menu.menu.MenuBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainTest implements Serializable {
    //Import des donnees stockees
    static ControllerData controllerData = ControllerData.load();
    // Creation des liste et controller Personne / activite depuis les donnees du controlerdata
    static ArrayList<Personne> listePersonne = controllerData.getListePersonnes();
    static ArrayList<Activite> listeActivite = controllerData.getListeActivites();
    static ControllerPersonne cp = new ControllerPersonne(listePersonne,listeActivite);
    static ControllerActivite ca = new ControllerActivite(listePersonne,listeActivite);
    static AffichageUtils affichageUtils = new AffichageUtils();
    public static void main(String[] args){
        // Debut du menu
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            affichageUtils.printEnTete("Menu Principal",ConsoleColors.BLUE_BOLD);
            menuBuilder.startMenu("1", "Gestion des Personnes", new MainVue());// Commencement d'un ajout de sous menu
            {
                // System.out.println("--- --- --- --- --- --- --- Menu Secondaire --- --- --- --- --- --- --- ---");
                menuBuilder.addItem("1", "-Ajouter une personne", controllerPersonne(1));
                menuBuilder.addItem("2", "-Modifier une personne", controllerPersonne(2));
                menuBuilder.addItem("3", "-Supprimer une personne", controllerPersonne(3));
                menuBuilder.addItem("4", "-Afficher la liste des personnes", controllerPersonne(4));
                menuBuilder.addItem("r", "-Retour", () -> menuPrincipal.execute());

            }
            menuBuilder.endMenu();

            menuBuilder.startMenu("2", "Gestion Activitée", new MainVue());// Commencement d'un ajout de sous menu
            {
                // System.out.println("--- --- --- --- --- --- --- Menu Secondaire --- --- --- --- --- --- --- ---");
                menuBuilder.addItem("1", "-Créer activitée", controllerActivite(1));
                menuBuilder.addItem("2", "-Modifier activitée", controllerActivite(2));
                menuBuilder.addItem("3", "-Supprimer activitée", controllerActivite(3));
                menuBuilder.addItem("4", "-Afficher la liste des activitées", controllerActivite(4));
                menuBuilder.addItem("5", "-Ajouter des personnes à une activité", controllerActivite(5));
                menuBuilder.addItem("6", "-Ajouter un responsable à une activité", controllerActivite(6));
                menuBuilder.addItem("r", "-Retour", () -> menuPrincipal.execute());
            }
            menuBuilder.endMenu();

            menuBuilder.addItem("q", "Quitter", () -> {
                controllerData.setListeActivites(listeActivite);
                controllerData.setListePersonnes(listePersonne);
                controllerData.save();
                menuPrincipal.setFinish(true);

            });
        }
        menuBuilder.end();
        while (!menuPrincipal.isFinish()) {
            menuPrincipal.execute();
        }

    }
    public static Runnable controllerPersonne(int choix){

        return cp.getOptionController(choix);
    }
    public static Runnable controllerActivite(int choix){
        return ca.getOptionController(choix);
    }

    

}
