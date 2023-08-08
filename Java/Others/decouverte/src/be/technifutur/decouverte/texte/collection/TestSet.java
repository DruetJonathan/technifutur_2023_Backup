package be.technifutur.decouverte.texte.collection;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class TestSet {
    public static void main(String[] args) {
        //Set<Personne> hashSet = new TreeSet<>();
        //Set<Personne> hashSet = new LinkedHashSet<>();
        //HashSet<Personne> hashSet = new HashSet<>();
        testSet(new HashSet<>());
        testSet(new LinkedHashSet<>());
        testSet(new TreeSet<>(new MyComparator()));

    }

    private static void testSet(Set<Personne> set) {
        System.out.println(set.size());
        for (Personne p :
                Personne.getPersonnes()) {
            boolean add = set.add(p);
            System.out.println(add);
        }
        set.remove(Personne.getPersonnes()[2]);
        for (Personne p :
                set) {
            System.out.println(p);
        }

        Iterator<Personne> iterator = set.iterator();
        while (iterator.hasNext()){
            Personne next = iterator.next();
            ChronoLocalDate pivot = LocalDate.of(1997,1,1);
            if (next.getNaissance().isBefore(pivot)){
                iterator.remove();
            }
        }
    }
}
