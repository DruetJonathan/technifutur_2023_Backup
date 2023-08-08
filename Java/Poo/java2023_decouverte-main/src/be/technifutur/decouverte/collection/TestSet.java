package be.technifutur.decouverte.collection;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class TestSet {
    public static void main(String[] args) {
        testSet(new HashSet<>());
        testSet(new LinkedHashSet<>());
        testSet(new TreeSet<>(new MyComparator()));
    }

    private static void testSet(Set<Personne> set) {
        System.out.println(set.size());
        for(Personne p : Personne.getPersonnes()){
            boolean add = set.add(p);
            System.out.println(add);
        }
        System.out.println(set.size());

        for (Personne p : set){
            System.out.println(p);
        }

        set.remove(Personne.getPersonnes()[2]);

        Iterator<Personne> iterator = set.iterator();
        while (iterator.hasNext()){
            Personne personne = iterator.next();
            ChronoLocalDate pivot = LocalDate.of(1997,1,1);
            if(personne.getNaissance().isBefore(pivot)){
                iterator.remove();
            }
        }

        System.out.println(set);
    }
}
