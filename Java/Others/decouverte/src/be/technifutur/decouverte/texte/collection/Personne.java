package be.technifutur.decouverte.texte.collection;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Personne implements Serializable /*implements Comparable<Personne>*/ {
    private String prenom;
    private String nom;
    private LocalDate naissance;

    public Personne(String prenom, String nom, LocalDate naissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.naissance = naissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", naissance=" + naissance +
                '}';
    }

    public static Personne[] getPersonnes() {
        Personne p = new Personne("Cristianou", "Ronaldou", LocalDate.of(1985, 2, 5));
        return new Personne[]{
                new Personne("Cristiano", "Ronaldo", LocalDate.of(1985, 2, 5)),
                new Personne("Athan", "Jaune", LocalDate.of(2000, 3, 13)),
                new Personne("Mionel", "Lessi", LocalDate.of(1989, 6, 24)),
                new Personne("Mionel", "Lessi", LocalDate.of(1989, 6, 24)),
                new Personne("Neville", "Londubat", LocalDate.of(1960, 5, 2)),
                new Personne("Neville", "Londubat", LocalDate.of(1960, 5, 2)),
                new Personne("L'éponge", "Bob", LocalDate.of(1999, 6, 30)),
                new Personne("L'éponge", "Bob", LocalDate.of(1999, 6, 30)),
                new Personne("Dady", "Tacos", LocalDate.of(2001, 7, 01)),
                new Personne("Dady", "Tacos", LocalDate.of(2001, 6, 01)),
                new Personne("t", "t", LocalDate.of(2001, 6, 01)),
                p,
                p
        };
    }
    public int getAge(){
        return Period.between(this.getNaissance(),LocalDate.now()).getYears();
        //this.getNaissance().until(LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (!Objects.equals(prenom, personne.prenom)) return false;
        if (!Objects.equals(nom, personne.nom)) return false;
        return Objects.equals(naissance, personne.naissance);
    }


    @Override
    public int hashCode() {
        int result = prenom != null ? prenom.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (naissance != null ? naissance.hashCode() : 0);
        return result;
    }

   /* @Override
    public int compareTo(Personne o) {
        int i = this.nom.compareTo(o.nom);
        if (i == 0) {
            i = this.prenom.compareTo(o.prenom);
            if (i == 0) {
                i = this.naissance.compareTo(o.naissance);
            }
        }
        return i;
    }*/
   public static void main(String[] args) {
       Personne p = new Personne("Cristianou","Ronaldou",LocalDate.of(1995,5,2));
       System.out.println(p.getAge());
   }
}
