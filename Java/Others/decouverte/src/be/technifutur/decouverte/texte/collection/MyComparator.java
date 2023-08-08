package be.technifutur.decouverte.texte.collection;

import java.util.Comparator;

public class MyComparator implements Comparator<Personne> {

    @Override
    public int compare(Personne o1, Personne o2) {
        int result = o1.getNaissance().compareTo(o2.getNaissance());
        if (result == 0) result = o1.getNom().compareTo(o2.getNom());
        else if (result == 0) result = o1.getPrenom().compareTo(o2.getPrenom());

        return result;
    }
}
