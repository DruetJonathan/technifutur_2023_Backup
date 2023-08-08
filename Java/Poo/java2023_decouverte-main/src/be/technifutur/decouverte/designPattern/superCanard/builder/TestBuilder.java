package be.technifutur.decouverte.designPattern.superCanard.builder;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.LabyrintheMap;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Position;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau.ChateauLabyrintheFactory;

public class TestBuilder {

    public static void main(String[] args) {
        ObjectLabyrintheBuilder builder = new ObjectLabyrintheBuilder(new ChateauLabyrintheFactory());
        LabyrintheFileReader reader = new LabyrintheFileReader();
        reader.read("monLaby.txt",builder);
        LabyrintheMap labyrintheMap = builder.getLabyrinthe();

        for (Position p : labyrintheMap.getSetPosition()) {
            affichevoisin(labyrintheMap, p);
        }

    }
    private static void affichevoisin(LabyrintheMap labyrintheMap, Position entre) {
        System.out.println(entre + " " + labyrintheMap.getElement(entre).getDescription());
        for (Position p : entre.getVoisin()) {
            System.out.print(p);
            System.out.println(labyrintheMap.getElement(p).getDescription());
        }
        System.out.println("------------------");
    }
}
