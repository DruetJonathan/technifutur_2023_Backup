package be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau;

import be.technifutur.decouverte.designPattern.superCanard.adaptateur.Animal;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Piece;

import java.util.Optional;

public class PieceChateau implements Piece {

    private Optional<Animal> animal = Optional.empty();

    @Override
    public String getDescription() {
        return "piece de chateau";
    }

    @Override
    public Optional<Animal> getAnimal() {
        Optional<Animal> result = animal;
        animal = Optional.empty();
        return result;
    }

    @Override
    public void setAnimal(Optional<Animal> animal) {
        this.animal = animal;
    }
}
