package be.technifutur.decouverte.designPattern.superCanard.strategie;

public abstract class Canard {
    private ComportementCancan comportementCancan;
    private ComportementVol comportementVol;

    public Canard(ComportementCancan comportementCancan, ComportementVol comportementVol) {
        this.comportementCancan = comportementCancan;
        this.comportementVol = comportementVol;
    }

    public abstract void affiche();

    public void nager() {
        System.out.println("plouf plouf");
    }

    public void effectuerCancan() {
        System.out.println(comportementCancan.cancanner());
    }

    public void effectuerVol() {
        System.out.println(comportementVol.voler());
    }

    public ComportementCancan getComportementCancan() {
        return comportementCancan;
    }

    public ComportementVol getComportementVol() {
        return comportementVol;
    }

    public Canard setComportementCancan(ComportementCancan comportementCancan) {
        this.comportementCancan = comportementCancan;
        return this;
    }

    public Canard setComportementVol(ComportementVol comportementVol) {
        this.comportementVol = comportementVol;
        return this;
    }
}
