package be.technifutur.decouverte.designPattern.superCanard.builder;

public interface LabyrintheBuilder {

    void start();
    void addMur(int lig, int col);
    void addPiece(int lig, int col);
    void addPorte(int lig, int col);
    void end();
    void setEntree(int lig,int col);

    void setAnimal(int i, int cpt);
}
