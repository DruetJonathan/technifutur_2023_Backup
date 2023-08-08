package be.technifutur.decouverte.texte.poo.scenario3;

public class Lukywa extends VaisseauAncetre{
    public Lukywa(String name) {
        super(name,0, 0);
    }

    @Override
    public void tirer(){
        System.out.println("Pann");
    }

    @Override
    public void afficheCamp() {
        System.out.println("Gentil");
    }
}
