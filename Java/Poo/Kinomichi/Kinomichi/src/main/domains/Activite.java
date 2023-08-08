package main.domains;

import main.Exception.NullOrEmptyFieldException;
import main.Utils.ConsoleColors;

import java.io.Console;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;

public class Activite implements Serializable {
    private List<Personne> listePersonneParticipantes;
    private Personne responsable;
    private String typeActivite;
    private String nom;
    private LocalDateTime dateDebut, dateFin;

    public Activite(String nom, String typeActivite, LocalDateTime dateDebut, LocalDateTime dateFin, Personne responsable) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeActivite = typeActivite;
        this.responsable = responsable;
        this.listePersonneParticipantes = new ArrayList<>();
    }

    public Activite(String nom, String typeActivite, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeActivite = typeActivite;
        this.listePersonneParticipantes = new ArrayList<>();
    }

    public static ArrayList<Activite> getActiviteTest() throws NullOrEmptyFieldException {
        ArrayList<Activite> liste = new ArrayList<>();
        liste.add(new Activite("Test", "Repas", null, null, new Personne("", "jona", "", true)));
        liste.add(new Activite("Test", "Logement", null, null, new Personne("", "jona", "", true)));
        liste.add(new Activite("Test", "Activite", null, null, new Personne("", "jona", "", true)));

        return liste;
    }

    public static void main(String[] args) throws NullOrEmptyFieldException {
        ArrayList<Activite> liste = getActiviteTest();
        System.out.println(liste.get(0).toString());

    }

    public List<Personne> getListePersonneParticipantes() {
        return listePersonneParticipantes;
    }

    public void setListePersonneParticipantes(List<Personne> listePersonneParticipantes) {
        this.listePersonneParticipantes = listePersonneParticipantes;
    }

    public Personne getResponsable() {
        return responsable;
    }

    public void setResponsable(Personne responsable) {
        this.responsable = responsable;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }


    @Override
    public String toString() {

        String tmp = "";


        for (Personne personne :
                listePersonneParticipantes) {
                tmp += "----" + (personne == null ? "":personne.getNom()) + " " + (personne == null ? "":personne.getPrenom()) + "\n";
        }

        String dateDebutString = dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        String dateFinString = dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        String s = ConsoleColors.PURPLE_BOLD + "Nom Activite = " + ConsoleColors.WHITE_BRIGHT + nom + '\n' +
                ConsoleColors.RED + "--Type d'activite = " + ConsoleColors.WHITE_BRIGHT + typeActivite + '\n' +
                ConsoleColors.RED + "--Date debut = " + ConsoleColors.WHITE_BRIGHT + (dateDebut == null ? "" : dateDebutString) + '\n' +
                ConsoleColors.RED + "--Date fin = " + ConsoleColors.WHITE_BRIGHT + (dateFin == null ? "" : dateFinString) + '\n' +
                ConsoleColors.RED + "--responsable => " + ConsoleColors.WHITE_BRIGHT + (responsable == null?" Pas de responsable":responsable) +
                ConsoleColors.RED + "\n--Personne participante => \n" + ConsoleColors.WHITE_BRIGHT + tmp;
        return s;
    }

}

