package be.technifutur.decouverte.collection;

import java.util.Comparator;

public class MyComparator implements Comparator<Personne> {
    @Override
    public int compare(Personne p1, Personne p2) {
        int result = p1.getNaissance().compareTo(p2.getNaissance());
        if(result==0)
            result = p1.getNom().compareTo(p2.getNom());
        if(result==0)
            result = p1.getPrenom().compareTo(p2.getPrenom());
        return result;
    }
}
