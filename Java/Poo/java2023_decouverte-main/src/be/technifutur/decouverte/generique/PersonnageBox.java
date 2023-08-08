package be.technifutur.decouverte.generique;

import be.technifutur.decouverte.poo.scenario4.Personnage;

public class PersonnageBox <T extends Personnage> {
    private T contenu;

    public PersonnageBox(T leContenu){
        this.contenu = leContenu;
    }

    public T getContenu() {
        return contenu;
    }
    public void setContenu(T contenu) {
        System.out.println(contenu.getNom());
        this.contenu = contenu;
    }

}
