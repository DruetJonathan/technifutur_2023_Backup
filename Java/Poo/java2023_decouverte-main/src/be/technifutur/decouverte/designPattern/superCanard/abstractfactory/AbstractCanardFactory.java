package be.technifutur.decouverte.designPattern.superCanard.abstractfactory;

import be.technifutur.decouverte.designPattern.superCanard.strategie.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractCanardFactory implements CanardFactory{

    private CanCan cancan;
    private Coincoin coincoin;
    private Muet muet;
    private VolerAvecAiles avecAile;
    private NePasVoler nepasvoler;

    public static CanardFactory getfactory(String className){
        try {
            Class<CanardFactory> maClass = (Class<CanardFactory>) Class.forName(className);
            Constructor<CanardFactory> constructor = maClass.getConstructor();
            CanardFactory factory = constructor.newInstance();
            return factory;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Canard getMandarin() {
        return new Mandarin();
    }

    @Override
    public Canard getColvert() {
        return new Colvert();
    }

    @Override
    public Canard getCanardPlastique() {
        return new CanardPlastique();
    }

    @Override
    public Canard getLeurre() {
        return new Leurre();
    }

    @Override
    public ComportementCancan getCancan() {
        if (this.cancan == null) {
            this.cancan = new CanCan();
        }
        return this.cancan;
    }

    @Override
    public ComportementCancan getCoincoin() {
        if (this.coincoin == null) {
            this.coincoin = new Coincoin();
        }
        return this.coincoin;
    }

    @Override
    public ComportementCancan getMuet() {
        if (this.muet == null) {
            this.muet = new Muet();
        }
        return this.muet;
    }

    @Override
    public ComportementVol getVolerAvecAile() {
        if (this.avecAile == null) {
            this.avecAile = new VolerAvecAiles();
        }
        return this.avecAile;
    }

    @Override
    public ComportementVol getNePasVoler() {
        if (this.nepasvoler == null) {
            this.nepasvoler = new NePasVoler();
        }
        return this.nepasvoler;
    }
}
