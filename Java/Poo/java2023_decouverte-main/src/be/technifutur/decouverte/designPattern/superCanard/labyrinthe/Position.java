package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import java.util.List;

public interface Position {

    List<? extends Position> getVoisin();
}
