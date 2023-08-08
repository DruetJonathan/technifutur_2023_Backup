package main.domains;

import main.Exception.NullOrEmptyFieldException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Personne implements Serializable {
    private String nom, prenom, club;
    private boolean estResponsable = false;

    /**
     * Constructeur pour une main.domains.Personne
     *
     * @param nom    le nom de la main.domains.Personne
     * @param prenom le prénom du main.domains.Personne
     */
    public Personne(String nom, String prenom, String club, boolean estResponsable) throws NullOrEmptyFieldException {
        if (nom == null || prenom == null || nom.equalsIgnoreCase("") || prenom.equalsIgnoreCase("")) {
            throw new NullOrEmptyFieldException("Soit le prénom, soit le nom de famille doit être rempli");
        }
            this.nom = nom;
            this.prenom = prenom;
            // Condition pour le club
            if (club == null) this.club = "Club Inconnu";
            else this.club = club;
            // fin condition pour le club
            this.estResponsable = estResponsable;

    }

    /**
     * renvoie le nom de la main.domains.Personne
     *
     * @return le nom de la main.domains.Personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * redefini le nom
     *
     * @param nom le nom du main.domains.Personne
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * renvoie le prenom de la main.domains.Personne
     *
     * @return le prenom de la main.domains.Personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * redefinis le prenom de la stagiaire
     *
     * @param prenom le prenom de la stagiaire
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * renvoie le club de la stagiaire
     *
     * @return le club de la stagiaire
     */
    public String getClub() {
        return club;
    }

    /**
     * redefinis le club de la stagiaire
     *
     * @param club le club de la stagiaires
     */
    public void setClub(String club) {
        this.club = club;
    }

    /**
     * est responsable ou non
     *
     * @return true s'il est responsable sinon false
     */
    public boolean isEstResponsable() {
        return estResponsable;
    }

    /**
     * redefinis le statut de responsable d'une activitées
     *
     * @param estResponsable true ou false
     */
    public void setEstResponsable(boolean estResponsable) {
        this.estResponsable = estResponsable;
    }

    /**
     * Affichage des informations d'une personne
     *
     * @return un string d'affichage d'une personne
     */
    @Override
    public String toString() {
        return
                "nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", club='" + club + '\'' +
                        ", est Responsable=" + (estResponsable == true ? "oui" : "non");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (estResponsable != personne.estResponsable) return false;
        if (!Objects.equals(nom, personne.nom)) return false;
        if (!Objects.equals(prenom, personne.prenom)) return false;
        return Objects.equals(club, personne.club);
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (club != null ? club.hashCode() : 0);
        result = 31 * result + (estResponsable ? 1 : 0);
        return result;
    }
}
