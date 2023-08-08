package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import java.util.Set;

public interface Labyrinthe {

    ElementLabyrinthe getElement(Position pos);
    Set<Position> getSetPosition();
    Position getEntre();

}
