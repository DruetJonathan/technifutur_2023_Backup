package be.technifutur.decouverte.designPattern.superCanard.strategie;

public class NePasVoler implements ComportementVol {
    @Override
    public String voler() {
        return "je ne vole pas";
    }
}
