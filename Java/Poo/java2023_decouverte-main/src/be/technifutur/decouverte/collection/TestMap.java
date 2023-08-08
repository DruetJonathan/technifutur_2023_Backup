package be.technifutur.decouverte.collection;

import java.util.*;

public class TestMap {

    public static void main(String[] args) {
        //testMap(new HashMap<>());
        Map<String, Set<Personne>> famille = getFamille(Personne.getPersonnes());
        for (Map.Entry<String, Set<Personne>> e : famille.entrySet()) {
            System.out.println(e.getKey());
            for (Personne pers : e.getValue()) {
                System.out.println("   " + pers);
            }
        }

        Map<Integer, Set<Personne>> dizaineMap = getParDizaine(Personne.getPersonnes());

    }

    private static Map<Integer, Set<Personne>> getParDizaine(Personne[] personnes) {
        Map<Integer, Set<Personne>> dizaineMap = new TreeMap<>();
        for (Personne p : personnes) {
            int diz = p.getAge() / 10 * 10;
            Set<Personne> set = dizaineMap.get(diz);
            if (set == null) {
                set = new TreeSet<>(getComparator());
                dizaineMap.put(diz, set);
            }
            set.add(p);
        }
        return dizaineMap;
    }

    private static Comparator<Personne> getComparator() {
        /*return new MyComparator();*/

        // classe anonyme interne
        /*return new Comparator<Personne>() {
            @Override
            public int compare(Personne o1, Personne o2) {
                return o1.getNaissance().compareTo(o2.getNaissance());
            }
        };*/

        /*return (Personne o1, Personne o2)-> {
            return o1.getNaissance().compareTo(o2.getNaissance());
        };*/

        //return (o1,o2)->o1.getNaissance().compareTo(o2.getNaissance());

        /*return Comparator.comparing(Personne::getNaissance)
                .thenComparing(Personne::getNom);*/

        /*return new Comparator<Personne>() {
            @Override
            public int compare(Personne o1, Personne o2) {
                return toto(o1,o2);
            }
        };*/

        return TestMap::toto;
    }

    public static int toto(Personne p1, Personne p2) {
        return p1.getNaissance().compareTo(p2.getNaissance());
    }

    private static Map<String, Set<Personne>> getFamille(Personne[] personnes) {
        LinkedHashMap<String, Set<Personne>> familleMap = new LinkedHashMap<>();
        for (Personne p : personnes) {
            Set<Personne> familleSet = familleMap.get(p.getNom());
            if (familleSet == null) {
                familleSet = new HashSet<>();
                familleMap.put(p.getNom(), familleSet);
            }
            familleSet.add(p);

        }
        return familleMap;
    }

    private static void testMap(Map<String, Personne> map) {
        System.out.printf(" taille : %s%n", map.size());
        for (Personne p : Personne.getPersonnes()) {
            System.out.println(map.put(p.getNom(), p));
        }
        System.out.println(map);
        System.out.printf(" taille : %s%n", map.size());

        Iterator<String> iterator = map.keySet().iterator();
        Iterator<Personne> iterator1 = map.values().iterator();
        Iterator<Map.Entry<String, Personne>> iterator2 = map.entrySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }

        while (iterator1.hasNext()) {
            Personne next = iterator1.next();
            System.out.println(next);
        }

        while (iterator2.hasNext()) {
            Map.Entry<String, Personne> next = iterator2.next();
            System.out.println("nom = " + next.getKey() + " personne = " + next.getValue());
        }

    }
}