package be.technifutur.decouverte.designPattern.superCanard.adaptateur;

import be.technifutur.decouverte.designPattern.superCanard.abstractfactory.AbstractCanardFactory;
import be.technifutur.decouverte.designPattern.superCanard.abstractfactory.CanardFactory;
import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;

import java.util.List;

public class TestDesign {
    public static void main(String[] args) {
        String className = "be.technifutur.decouverte.designPattern.superCanard.abstractfactory.MaFactory";
        CanardFactory factory = AbstractCanardFactory.getfactory(className);
        List<Canard> listCanard = factory.getListCanard();
        Chasseur chasseur = new Chasseur();

        listCanard.forEach(
                (c)->{
                    // TODO ??
                    chasseur.attraper(adapte(c));
                }
        );
    }

    private static Animal adapte(Canard c) {
        return new Animal() {
            @Override
            public void print() {
                c.affiche();
            }

            @Override
            public String cri() {
                return c.getComportementCancan().cancanner();
            }
        };
    }
}
