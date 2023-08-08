package be.technifutur.decouverte.designPattern.superCanard.strategie;

import be.technifutur.decouverte.designPattern.superCanard.composite.Begayer;

import java.util.Arrays;
import java.util.List;

public class TestStrategie {

    public static void main(String[] args) {
        List<Canard> mare = Arrays.asList(
                new Colvert(),
                new Mandarin()
                        .setComportementCancan(new Begayer(new CanCan()))
                        .setComportementVol(()-> "vol à réaction"),
                new CanardPlastique(),
                new Leurre()
        );

        for(Canard c : mare){
            c.affiche();
            c.nager();
            c.effectuerCancan();
            c.effectuerVol();
        }
    }
}
