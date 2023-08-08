package be.bstorm;

import be.bstorm.entities.Municipality;
import be.bstorm.entities.User;
import jakarta.persistence.*;

import java.util.List;

public class CustomRequestDemo {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();

    public static void getUserByFirstname(String name){

        TypedQuery<User> query = em.createQuery("select u from User u where u.firstname = :name", User.class);
        query.setParameter("name",name);
        User u = query.getSingleResult();
        System.out.println(u);
    }

    public static void getMunicipalitiesByName(String name){

        TypedQuery<Municipality> query = em.createQuery("select m from Municipality m where lower(m.name) like :name", Municipality.class);
        query.setParameter("name","%" + name.toLowerCase() + "%");
        List<Municipality> m = query.getResultList();
        m.forEach(System.out::println);
    }

    public static void getUserByBirthdate(int year){

        TypedQuery<User> query = em.createNamedQuery("getByBirthdate", User.class);
        query.setParameter("year",year);
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }
}
