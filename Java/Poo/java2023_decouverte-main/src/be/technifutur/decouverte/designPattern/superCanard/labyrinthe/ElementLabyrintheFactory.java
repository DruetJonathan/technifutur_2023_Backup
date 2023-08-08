package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import be.technifutur.decouverte.designPattern.superCanard.adaptateur.Animal;

import java.util.Optional;

public interface ElementLabyrintheFactory {

    Mur createMur();
    Piece createPiece();
    Porte createPorte();
}
