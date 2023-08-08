package be.technifutur.decouverte.texte.generique;

import be.technifutur.decouverte.texte.poo.Scenario4.Personnage;

public class PersonnageBox<T extends Personnage>{
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