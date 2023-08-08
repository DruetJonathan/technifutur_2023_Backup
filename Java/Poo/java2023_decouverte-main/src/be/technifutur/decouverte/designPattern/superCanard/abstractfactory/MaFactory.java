package be.technifutur.decouverte.designPattern.superCanard.abstractfactory;

import be.technifutur.decouverte.designPattern.superCanard.composite.Alterner;
import be.technifutur.decouverte.designPattern.superCanard.composite.Begayer;
import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;
import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementCancan;
import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementVol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaFactory extends AbstractCanardFactory{
    private ComportementCancan alarme;

    @Override
    public List<Canard> getListCanard() {
        return Collections.unmodifiableList(Arrays.asList(
                getCanardPlastique(),
                getColvert(),
                getColvert(),
                getCanardPlastique(),
                getLeurre(),
                getMandarin().setComportementCancan(getcriAlarme())
        ));
    }

    @Override
    public ComportementCancan getcriAlarme() {
        if (this.alarme == null) {
            this.alarme = new Begayer(new Alterner(getCancan(),getCoincoin()));
        }
        return this.alarme;
    }
}
