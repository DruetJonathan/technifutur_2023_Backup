package be.technifutur.decouverte.collection;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Personne implements Serializable/*implements Comparable<Personne>*/ {
    private String nom;
    private String prenom;
    private LocalDate naissance;

    public Personne(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", naissance=" + naissance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(naissance, personne.naissance);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, naissance);
    }

    public int getAge(){
        return naissance.until(LocalDate.now()).getYears();
    }

    public static Personne[] getPersonnes() {
        Personne p = new Personne("Dupond", "toto", LocalDate.of(1995, 5, 15));
        return new Personne[]{
                new Personne("Dupont", "toto", LocalDate.of(1995, 5, 15)),
                new Personne("Cristiano", "Ronaldo", LocalDate.of(1985, 2, 5)),
                new Personne("Athan", "Jaune", LocalDate.of(2000, 3, 13)),
                new Personne("Cristiano", "SIUUUU", LocalDate.of(1980, 5, 25)),
                new Personne("Chrome", "ShinyAnd", LocalDate.of(1988, 7, 27)),
                new Personne("Mionel", "Lessi", LocalDate.of(1989, 6, 24)),
                new Personne("Chrome", "ShinyAnd", LocalDate.of(1988, 7, 27)),
                new Personne("Chrome", "ShinyAnd", LocalDate.of(1988, 7, 27)),
                new Personne("L'éponge", "Bob", LocalDate.of(1999, 6, 30)),
                p,
                p
        };
    }



   /* @Override
    public int compareTo(Personne o) {
        int result;
        result = this.nom.compareTo(o.nom);

        if (result == 0) {
            result = this.prenom.compareTo(o.prenom);
            if (result == 0) {
                result = this.naissance.compareTo(o.naissance);
            }
        }
        return result;
    }*/
}
