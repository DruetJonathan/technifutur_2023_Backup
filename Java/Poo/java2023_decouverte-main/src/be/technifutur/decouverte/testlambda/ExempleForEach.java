package be.technifutur.decouverte.testlambda;

import be.technifutur.decouverte.collection.Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExempleForEach {

    public static void main(String[] args) {
        List<Personne> list = new ArrayList<>(Arrays.asList(Personne.getPersonnes()));
        list.forEach(System.out::println);

        Consumer<Personne> personneConsumer = p -> System.out.printf("%s à %s ans%n", p.getNom(), p.getAge());
        list.forEach(personneConsumer);

        list.forEach(p -> {
            if (p.getAge() > 18) {
                System.out.printf("%s est majeur", p.getPrenom());
            } else {
                System.out.printf("%s est mineur", p.getPrenom());
            }
        });

        list.forEach(p -> {
            System.out.printf("%s est %s",
                    p.getPrenom(),
                    p.getAge() >= 18 ? "majeur" : "mineur"
            );
        });
    }

}
