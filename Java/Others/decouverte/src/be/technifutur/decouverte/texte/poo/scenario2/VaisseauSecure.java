package be.technifutur.decouverte.texte.poo.scenario2;


public class VaisseauSecure {
    private boolean enVol;
    private int maxMissile;
    private String nom;
    private int nbMissile;
    private static int instanceCount = 0;


    public VaisseauSecure(String nom, int nbMissile) {
        this.nom = (nom != null && !nom.isBlank()) ? nom : "Default";
        this.nbMissile = nbMissile > 0 ? nbMissile : 0;
        this.maxMissile = maxMissile;
        this.enVol = false;
    }

    public VaisseauSecure(Integer maxMissile) {
        //this.maxMissile = maxMissile;
        this("Vaisseau inconnu",10);
    }

    public int getInstanceCount(){
        return instanceCount;
    }
    public void decolage(){

        if (this.enVol){
            System.out.println("Déjà en vole");
        }
        else {
            System.out.println("DECOLAGEEEE");
            instanceCount++;
            this.enVol = !this.enVol;
        }
    }
    public void atterir(){
        if (this.enVol == false){
            System.out.println("Déjà au sol");
        }
        else {
            System.out.println("Atterissageeee");
            instanceCount--;
            this.enVol = !this.enVol;
        }
    }

    public int getNbMissile() {
        return this.nbMissile;
    }

    public String getNom() {
        return this.nom;
    }

    public int getMaxMissile() {
        return this.maxMissile;
    }

    public void setNbMissile(int nbMissile) {
        this.nbMissile = nbMissile;
    }

    public void setMaxMissile(int maxMissile) {
        this.maxMissile = maxMissile;
    }

    public void tirer() {
        if (this.getNbMissile() > 0) {
            System.out.println("Pann");
            this.setNbMissile(this.getNbMissile() - 1);
        } else {
            System.out.println("plouf");
        }
    }

    public boolean deleteMissile(int nbMissile) {
        boolean flag = false;
        if (nbMissile > 0 && nbMissile <= this.getNbMissile()) {
            this.setNbMissile(this.getNbMissile() - nbMissile);
            flag =  true;
        }
        return flag;
    }
    public boolean addMissile(int nbMissile) {
        boolean flag = false;
        if (nbMissile > 0 && nbMissile + this.getNbMissile() <= this.getMaxMissile()) {
            this.setNbMissile(this.getNbMissile() + nbMissile);
            flag =  true;
        }
        return flag;
    }
}
