package be.bstorm;

import be.bstorm.entities.Mayor;
import be.bstorm.entities.Municipality;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OneToOneDemo {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();


    public static void add(){

        Municipality municipality = Municipality.builder()
                .name("Fexhe le Haut Clocher")
                .build();
        Mayor mayor = Mayor.builder()
                .name("Henri Christophe")
                .build();
        municipality.setMayor(mayor);
        mayor.setMunicipality(municipality);


        em.getTransaction().begin();

        em.persist(municipality);

        em.getTransaction().commit();

        System.out.println("Commune ajoutée : " + municipality);
    }

    public static void get(){

        Municipality municipality = em.find(Municipality.class,1);

        System.out.println(municipality);
        System.out.println(municipality.getMayor());
    }
}
