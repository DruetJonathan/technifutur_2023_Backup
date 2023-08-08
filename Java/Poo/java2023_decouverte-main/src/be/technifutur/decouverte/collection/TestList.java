package be.technifutur.decouverte.collection;

import java.time.LocalDate;
import java.util.*;

public class TestList {

    public static void main(String[] args) {
        System.out.println("//  arraylist  ");
        testList(new ArrayList<>());
        System.out.println("//  Linkedlist  ");
        testList(new LinkedList<>());
        System.out.println("//  Arrays.asList  ");
        testList(Arrays.asList(Personne.getPersonnes()));
        System.out.println("//  testList(nonModifiable)  ");
        ArrayList<Personne> arrayList = new ArrayList<>();
        for(Personne p: Personne.getPersonnes()){
            arrayList.add(p);
        }
        List<Personne> nonModifiable = Collections.unmodifiableList(arrayList);

        testList(nonModifiable);
    }

    private static void testList(List<Personne> personnes) {
        try {
            System.out.printf(" taille : %s%n", personnes.size());
            for (Personne p : personnes) {
                System.out.println(p);
            }

            Personne element = new Personne("toto", "toto", LocalDate.now());
            //personnes.set(0, element);
            System.out.println(personnes.get(0));
            /*for (Personne p : Personne.getPersonnes()) {
                boolean add = personnes.add(p);
                System.out.println(add);
            }*/

            personnes.remove(element);
            personnes.remove(3);
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
