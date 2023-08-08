package be.technifutur.decouverte.texte.collection;

import java.time.LocalDate;
import java.util.*;

public class TestList {
    public static void main(String[] args) {
        System.out.println("// ArrayList");
        testList(new ArrayList<>());
        System.out.println("// LinkedList");
        testList(new LinkedList<>());
        System.out.println("// Array.asList");
        testList(Arrays.asList(Personne.getPersonnes()));
        ArrayList<Personne> arrayList = new ArrayList<>();
        for (Personne p : Personne.getPersonnes()) {
            arrayList.add(p);
        }
        System.out.println("// ArrayList non modifiable");
        List<Personne> personneList = Collections.unmodifiableList(arrayList);
        testList(personneList);
    }

    private static void testList(List<Personne> personnes) {
        try {
            System.out.printf("taille : %s%n", personnes.size());
            for (Personne p : personnes) {
                System.out.println(p);
            }
            Personne element = new Personne("Cristianou", "Ronaldou", LocalDate.now());
            personnes.set(0, element);
            System.out.println(personnes.get(0));
            for (Personne p : personnes) {
                boolean add = personnes.add(p);
                System.out.println(add);
            }
            personnes.remove(3);
            personnes.remove(element);
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
