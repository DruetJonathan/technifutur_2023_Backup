package be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Porte;

public class PorteChateau implements Porte {

    private boolean open = false;

    @Override
    public String getDescription() {
        return String.format("Lourde porte %s de chateau",this.open?"ouverte":"fermée");
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void open() {
        open = true;
    }
}
