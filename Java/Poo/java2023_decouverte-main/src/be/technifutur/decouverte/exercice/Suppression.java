package be.technifutur.decouverte.exercice;

import be.technifutur.decouverte.collection.Personne;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Suppression {

    public static void main(String[] args) {
        Set<Personne> result = new HashSet<>();
        /*Arrays.asList(Personne.getPersonnes())
                .forEach(p->{
                    if(p.getAge()>30){
                        result.add(p);
                    }
                });*/

        List<String> grands = Arrays.asList(Personne.getPersonnes())
                .stream()
                .filter(p-> p.getAge()>30)
                .map(p->p.getNom()+" agé de "+p.getAge())
                .sorted()
                .collect(Collectors.toList());

        long count = Arrays.asList(Personne.getPersonnes())
                .stream()
                .filter(p -> p.getAge() > 30)
                .count();

        Optional<Personne> max = Arrays.asList(Personne.getPersonnes())
                .stream()
                .filter(p -> p.getAge() < 30)
                .max(Comparator.comparing(Personne::getNaissance));

        if(max.isPresent()){
            System.out.println(max.get());
        }else{
            System.out.println(" nobody");
        }
        result.forEach(System.out::println);

        List<Personne> personnes = Arrays.asList(Personne.getPersonnes())
                .stream()
                .filter(p -> p.getNom().length() > 7)
                .distinct()
                .sorted(Comparator.comparing(Personne::getAge)
                        .thenComparing(Personne::getNom)
                        .thenComparing(Personne::getPrenom))
                .toList();

        System.out.println(Arrays.stream(Personne.getPersonnes()).allMatch(p-> p.getAge() > 20));

        Arrays.stream(Personne.getPersonnes())
                .filter(p -> p.getNaissance()
                        .withYear(LocalDate.now().getYear())
                        .isAfter(LocalDate.now())
                )
                .map(p -> String.format(" %s %s ",p.getNom(),p.getPrenom()))
                .forEach(System.out::println);

    }
}
