package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;
import be.technifutur.decouverte.designPattern.superCanard.strategie.CanardPlastique;

public class Animal implements ElementLabyrinthe{
    Canard canard;

    public Animal(Canard canard ) {
        this.canard = canard;
    }

    @Override
    public String getDescription() {
        return "Animal!";
    }
}
