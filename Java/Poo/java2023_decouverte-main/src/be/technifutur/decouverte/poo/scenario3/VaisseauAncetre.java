package be.technifutur.decouverte.poo.scenario3;

public abstract class VaisseauAncetre {

    // variable de classe
    private static int nbEnVol = 0;

    // variables d'instance contiennent l'état de l'objet
    // initialisée par défaut à la valeur par défaut du type
    private final String nom ;//= "OVNI";
    private int nbMissile;

    private int maxMissile;
    private boolean enVol = false;

    // constructeur
    public VaisseauAncetre(int maxMissile, String nom) {
        this.maxMissile = maxMissile;
        //Objects.nonNull(nom);
        if(nom != null && ! nom.isBlank()){
            this.nom = nom;
        }else{
            this.nom = "OVNI";
        }
    }

    // méthodes de classe
    public static int getNbEnVol() {
        return VaisseauAncetre.nbEnVol;
    }

    // méthodes d'instance
    public void tirer() {
        if (this.nbMissile > 0) {
            System.out.println("PAN");
            this.nbMissile--;
        } else {
            System.out.println("POUF");
        }
    }

    public int getNbMissile(){
        return this.nbMissile;
    }

    public boolean removeMissile(int nbMissile) {
        boolean accepted =false;
        if( nbMissile > 0 && this.nbMissile >= nbMissile){
            this.nbMissile -= nbMissile;
            accepted = true;
        }
        return accepted;
    }

    public boolean addMissile(int nbMissile) {
        boolean accepted =false;
        if( nbMissile > 0 && this.nbMissile + nbMissile <= this.maxMissile){
            this.nbMissile += nbMissile;
            accepted = true;
        }
        return accepted;
    }

    public void decoller(){
        if (enVol){
            System.out.println("erreur");
        }else{
            enVol = true;
            VaisseauAncetre.nbEnVol++;
            System.out.println("Décollage réussit");
        }
    }

    public void atterrir(){
        if (! enVol){
            System.out.println("erreur");
        }else{
            enVol = false;
            VaisseauAncetre.nbEnVol--;
            System.out.println("atterrissage réussit");
        }
    }

    public String getNom() {
        return this.nom;
    }

    @Override
    public String toString() {
        return "VaisseauAncetre{" +
                "nom='" + nom + '\'' +
                ", nbMissile=" + nbMissile +
                ", maxMissile=" + maxMissile +
                ", enVol=" + enVol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VaisseauAncetre that = (VaisseauAncetre) o;

        if (maxMissile != that.maxMissile) return false;
        return nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        int result = nom.hashCode();
        result = 31 * result + maxMissile;
        return result;
    }

    public abstract void afficheCamps();
}
















