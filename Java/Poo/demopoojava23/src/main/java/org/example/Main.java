package org.example;

import org.example.Exception.MontantNegatifException;
import org.example.Exception.SoldeInssufisantException;
import org.example.models2.Compte;

public class Main {
    public static void main(String[] args){
//        List<Animal> animalList = new ArrayList<>();
//        animalList.add(new Dog("Doggo",new Date(2005,5,20)));
//        animalList.add(new BergerAllemand("bergerAllemand",new Date(2005,5,20)));
//        animalList.add(new Fish("Fishy",new Date(2010,8,02)));
//        animalList.add(new Bird("Birdy",new Date(2022,9,10)));
//
//        //animalList.forEach(animal -> animal.move());
//
//        animalList.forEach(animal -> {
//            if (animal instanceof Dog d){
//                d.bark();
//            }
//            else if (animal instanceof Bird b){
//                b.shit();
//            }
//            else if (animal instanceof Fish f){
//                f.gloups();
//            }
//        });

        Compte compte = new Compte("4554864564", 100);
        compte.addPassageEnNegatifSubscriber(c -> System.out.println("Le compte numéro "+c.getNumero()+" est passé en négatif"));
        compte.addPassageEnNegatifSubscriber(c -> System.out.println("c'est quand même pas mal..."));
        compte.addPassageEnNegatifSubscriber(c -> System.out.println("Il est capable de retenir tous ce que je veux executer"));
        try {
            compte.depot(100);
            compte.retrait(150);
        }
        catch (SoldeInssufisantException soldeInssufisantException){
            System.err.println("soldeInssufisantException");
        }
        catch (MontantNegatifException montantNegatifException){
            System.err.println("montantNegatifException");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}