package be.technifutur.decouverte.designPattern.superCanard.builder;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.*;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau.MurChateau;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau.PieceChateau;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau.PorteChateau;
import be.technifutur.decouverte.designPattern.superCanard.strategie.CanardPlastique;

public class ObjectLabyrintheBuilder implements LabyrintheBuilder{
    private final ElementLabyrintheFactory factory;

    public ObjectLabyrintheBuilder(ElementLabyrintheFactory factory) {
        this.factory = factory;
    }

    LabyrintheMap labyrintheMap;
    @Override
    public void start() {
        labyrintheMap = new LabyrintheMap();
    }

    @Override
    public void addMur(int lig, int col) {
        labyrintheMap.addElement(new Position2D(lig,col),new MurChateau());
    }

    @Override
    public void addPiece(int lig, int col) {
        labyrintheMap.addElement(new Position2D(lig,col),new PieceChateau());
    }

    @Override
    public void addPorte(int lig, int col) {
        labyrintheMap.addElement(new Position2D(lig,col),new PorteChateau());

    }

    @Override
    public void end() {

    }

    @Override
    public void setEntree(int lig, int col) {
        PorteChateau porteChateau = new PorteChateau();
        porteChateau.open();
        labyrintheMap.addElement(new Position2D(lig,col),porteChateau);
        labyrintheMap.setEntree(new Position2D(lig,col));
    }

    @Override
    public void setAnimal(int i, int cpt) {
        labyrintheMap.addElement((Position) new Position2D(i,cpt), (ElementLabyrinthe) new Animal(new CanardPlastique()));
    }

    public LabyrintheMap getLabyrinthe() {
        return labyrintheMap;
    }
}
