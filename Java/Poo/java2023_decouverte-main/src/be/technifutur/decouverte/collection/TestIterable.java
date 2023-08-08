package be.technifutur.decouverte.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestIterable {
    public static void main(String[] args) {
        Personne[] personnes = Personne.getPersonnes();
        //testForEach(personnes);
        Iterable<Personne> personneIterable = Arrays.asList(personnes);

        Iterator<Personne> iterator = personneIterable.iterator();
        int cpt =0;
        while(iterator.hasNext()&& cpt <2){
            Personne personne = iterator.next();
            System.out.println(personne.getNom());
            cpt++;
        }
        /*while(personneIterable.iterator().hasNext()){
            Personne personne = personneIterable.iterator().next();
            System.out.println(personne.getNom());
        }*/

        for(Personne p :personneIterable){
            System.out.println(p.getPrenom());
        }
        //System.out.println(iterator.next());
    }

    private static void testForEach(Personne[] personnes) {
        for(Personne p : personnes){
            System.out.println(p);
        }
    }

}
