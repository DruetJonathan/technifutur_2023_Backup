package be.technifutur.decouverte.designPattern.superCanard.abstractfactory;

import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;

import java.util.List;

public class TestFactory {

    public static void main(String[] args) {
        String className = "be.technifutur.decouverte.designPattern.superCanard.abstractfactory.MaFactory";
        CanardFactory factory = AbstractCanardFactory.getfactory(className);
        List<Canard> listCanard = factory.getListCanard();
        factory.getcriAlarme().cancanner();

        for(Canard c: listCanard){
            c.effectuerVol();
        }

        System.out.println(factory.getCancan()== factory.getCancan());
    }
}
