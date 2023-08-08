package be.technifutur.decouverte.texte.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class ExempleForEach {
    public static void main(String[] args) {
        ArrayList<Personne> arrayList = new ArrayList<>(Arrays.asList(Personne.getPersonnes()));
        arrayList.forEach(System.out::println);

        Consumer<Personne> personneConsumer = p -> System.out.printf("%s à %s ans%n", p.getNom(), p.getAge());
        arrayList.forEach(personneConsumer);

        arrayList.forEach(p -> {
            if (p.getAge() > 18) System.out.printf("%s est majeur", p.getPrenom());
            else System.out.printf("%s est mineur", p.getPrenom());
        });

        arrayList.forEach(p -> {
            System.out.printf("%s est %s",
                    p.getPrenom(),
                    p.getAge()>18?"majeur":"mineur");
        });
    }
}
