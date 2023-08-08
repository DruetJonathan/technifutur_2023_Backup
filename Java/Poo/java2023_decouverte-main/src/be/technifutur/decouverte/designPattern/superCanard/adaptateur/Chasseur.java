package be.technifutur.decouverte.designPattern.superCanard.adaptateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chasseur {

    private List<Animal> recolte= new ArrayList<>();

    public List<Animal> getRecolte(){
        // utilisation d'un proxy
        return Collections.unmodifiableList(recolte);
    }

    public void attraper(Animal animal){
        animal.print();
        System.out.println(animal.cri());
        recolte.add(animal);
    }

}
