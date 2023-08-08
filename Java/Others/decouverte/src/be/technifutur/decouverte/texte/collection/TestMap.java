package be.technifutur.decouverte.texte.collection;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        //testMap(new HashMap<>());
        //Map<String, Set<Personne>> famille = getFamille(Personne.getPersonnes());
        Map<Integer, Set<Personne>> ageFamille = getFamilleAge(Personne.getPersonnes());

        //affichageMap(famille);
        afficheByAge(ageFamille);
    }

    private static void afficheByAge(Map<Integer, Set<Personne>> ageFamille) {
        for (Map.Entry<Integer, Set<Personne>> e : ageFamille.entrySet()) {
            // System.out.println("nom = " + e.getKey() + " \nfamille = " + e.getValue());
            System.out.println("========== ========== ========== " + e.getKey() + " ========== ========== ==========");
            for (Personne p :
                    e.getValue()) {
                System.out.println(p);
            }
        }
    }

    private static Map<Integer, Set<Personne>> getFamilleAge(Personne[] personnes) {
        Map<Integer, Set<Personne>> familles = new LinkedHashMap<>();
        for (Personne p : personnes) {
            Set<Personne> familleSet = familles.get(p.getAge()/10*10);
            if (familleSet == null) {
                Set<Personne> setPersonne = new TreeSet<>(getComparator());
                setPersonne.add(p);
                familles.put(p.getAge()/10*10, setPersonne);
            } else {
                familleSet.add(p);
            }
        }
        return familles;
    }

    private static Comparator<Personne> getComparator() {
        //Comparator<Personne> comparator = (o1,o2) -> o1.getNom().compareTo(o2.getNom());
        /*return new Comparator<Personne>() {
            @Override
            public int compare(Personne o1, Pers0onne o2) {
                return o1.getNaissance().compareTo(o2.getNaissance());
            }
        };*/
        // return Comparator.comparing(Personne::getNaissance);
        //return new MyComparator();
        return TestMap::toto;
    }
    public static int toto(Personne p1,Personne p2){
        return p1.getNaissance().compareTo(p2.getNaissance());
    }

    private static void affichageMap(Map<String, Set<Personne>> famille) {
        for (Map.Entry<String, Set<Personne>> e : famille.entrySet()) {
            // System.out.println("nom = " + e.getKey() + " \nfamille = " + e.getValue());
            System.out.println("========== ========== ========== " + e.getKey() + " ========== ========== ==========");
            for (Personne p :
                    e.getValue()) {
                System.out.println(p);
            }
        }
    }

    private static Map<String, Set<Personne>> getFamille(Personne[] personnes) {
        Map<String, Set<Personne>> familles = new LinkedHashMap<>();
        for (Personne p : personnes) {
            Set<Personne> familleSet = familles.get(p.getNom());
            if (familleSet == null) {
                Set<Personne> setPersonne = new HashSet<>();
                setPersonne.add(p);
                familles.put(p.getNom(), setPersonne);
            } else {
                familleSet.add(p);
            }
        }
        return familles;
    }

    private static void testMap(Map<String, Personne> map) {
        System.out.printf("taille : %s%n", map.size());
        for (Personne p : Personne.getPersonnes()) {
            System.out.println(map.put(p.getNom(), p));
        }
        System.out.println(map);
        System.out.printf("taille : %s%n", map.size());

        Iterator<String> iterator = map.keySet().iterator();
        Iterator<Personne> iterator1 = map.values().iterator();
        Iterator<Map.Entry<String, Personne>> iterator2 = map.entrySet().iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        while (iterator1.hasNext()) {
            Personne next = iterator1.next();
            System.out.println(next);
        }
        while (iterator2.hasNext()) {
            Map.Entry<String, Personne> next = iterator2.next();
            System.out.println("nom =" + next.getKey());
        }

    }
}
