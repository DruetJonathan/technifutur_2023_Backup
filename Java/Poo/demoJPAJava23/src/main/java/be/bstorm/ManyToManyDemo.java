package be.bstorm;

import be.bstorm.entities.Instrument;
import be.bstorm.entities.Musician;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManyToManyDemo {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();


    public static void add(){

        Instrument instrument = new Instrument();
        instrument.setName("Youkoulele");
        Musician musician = new Musician();
        musician.setName("Jonathan");

        instrument.addMusician(musician);
        musician.addInstrument(instrument);

        em.getTransaction().begin();

        em.persist(musician);

        em.getTransaction().commit();
    }
}
