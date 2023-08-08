package be.bstorm;

import be.bstorm.entities.Mayor;
import be.bstorm.entities.Municipality;
import be.bstorm.entities.Province;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OneToManyDemo {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();

    public static void add(){

        Province province = new Province("Liège");
        Municipality municipality = Municipality.builder()
                .name("Fexhe le Haut Clocher")
                .build();
        Mayor mayor = Mayor.builder()
                .name("Henri christophe")
                .build();

        municipality.setMayor(mayor);

        mayor.setMunicipality(municipality);

        municipality.setProvince(province);

        province.addMunicipality(municipality);

        em.getTransaction().begin();

        em.persist(municipality);

        em.getTransaction().commit();
    }

    public static void get(){

        Municipality municipality = em.find(Municipality.class,1);
        System.out.println(municipality);
        municipality.getProvince().getMunicipalities().forEach(System.out::println);
    }
}
