package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import be.technifutur.decouverte.designPattern.superCanard.adaptateur.Animal;

import java.util.Optional;

public interface Piece extends ElementLabyrinthe{

    Optional<Animal> getAnimal();
    void setAnimal(Optional<Animal> animal);
}
