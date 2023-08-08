package be.bstorm;

import be.bstorm.entities.Address;
import be.bstorm.entities.Gender;
import be.bstorm.entities.Municipality;
import be.bstorm.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

//        User user = User.builder()
//                .firstname("Seb")
//                .lastname("Bya")
//                .birthdate(LocalDate.of(1991,3,27))
//                .gender(Gender.Monsieur)
//                .address(new Address("Rue ceriser numero 18!!!"))
//                .build();
//        MiniCRUD.add(user);
//        User user2 = User.builder()
//                .firstname("Popol")
//                .lastname("LeTendu")
//                .birthdate(LocalDate.of(1965,2,21))
//                .gender(Gender.Dauphin)
//                .address(new Address("Rue Vagin"))
//                .build();
//        MiniCRUD.add(user2);
//        Optional<User> resultUser = MiniCRUD.getOne(1L);
//        if(resultUser.isPresent())
//            user = resultUser.get();
//        MiniCRUD.getAll();
//
//        user.setGender(Gender.TractopelleTondeuse);
//        MiniCRUD.update(user);
//        MiniCRUD.delete(user);

//        OneToOneDemo.add();
//        OneToOneDemo.get();

//        OneToManyDemo.add();
//        OneToManyDemo.get();
//
//        ManyToManyDemo.add();

//        CustomRequestDemo.getUserByFirstname("Seb");
//        CustomRequestDemo.getMunicipalitiesByName("haut");
        CustomRequestDemo.getUserByBirthdate(2000);
    }
}