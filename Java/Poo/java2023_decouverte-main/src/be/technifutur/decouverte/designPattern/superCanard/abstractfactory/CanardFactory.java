package be.technifutur.decouverte.designPattern.superCanard.abstractfactory;

import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;
import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementCancan;
import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementVol;

import java.util.List;

public interface CanardFactory {

    List<Canard> getListCanard();
    Canard getMandarin();
    Canard getColvert();
    Canard getCanardPlastique();
    Canard getLeurre();
    ComportementCancan getCancan();
    ComportementCancan getCoincoin();
    ComportementCancan getMuet();
    ComportementCancan getcriAlarme();
    ComportementVol getVolerAvecAile();
    ComportementVol getNePasVoler();
}
