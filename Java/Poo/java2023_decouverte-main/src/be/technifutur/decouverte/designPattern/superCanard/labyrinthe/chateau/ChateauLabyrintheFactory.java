package be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.ElementLabyrintheFactory;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Mur;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Piece;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Porte;

public class ChateauLabyrintheFactory implements ElementLabyrintheFactory {
    private MurChateau mur;

    @Override
    public Mur createMur() {
        if (this.mur == null) {
            this.mur = new MurChateau();
        }
        return this.mur;
    }

    @Override
    public Piece createPiece() {
        return new PieceChateau();
    }

    @Override
    public Porte createPorte() {
        return new PorteChateau();
    }
}
