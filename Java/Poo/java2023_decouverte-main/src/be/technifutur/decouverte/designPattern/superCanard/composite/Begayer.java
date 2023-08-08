package be.technifutur.decouverte.designPattern.superCanard.composite;

import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementCancan;

public class Begayer implements ComportementCancan {
    private final ComportementCancan cri;

    public Begayer(ComportementCancan cancan) {
        this.cri = cancan;
    }

    @Override
    public String cancanner() {
        return cri.cancanner()+" "+cri.cancanner();
    }
}
