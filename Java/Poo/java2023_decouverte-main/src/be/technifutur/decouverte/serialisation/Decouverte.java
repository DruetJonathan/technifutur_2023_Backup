package be.technifutur.decouverte.serialisation;

import be.technifutur.decouverte.collection.Personne;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decouverte {

    public static void main(String[] args) {
        List<Personne> plus30=load();
        if(plus30.isEmpty()){
            System.out.println("liste vide");
            plus30 = getPlus30();
        }else{
            plus30.forEach(System.out::println);
        }
        save(plus30);

    }

    private static void save(List<Personne> plus30) {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("mesdatas.ser"))){
            output.writeObject(plus30);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Personne> load() {
        List<Personne> result;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("mesdatas.ser"))){
            result = (List<Personne>) input.readObject();
        } catch (FileNotFoundException e) {
            result = new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static List<Personne> getPlus30() {
        return Arrays.stream(Personne.getPersonnes())
                .filter(p -> p.getAge() > 30)
                .toList();
    }
}
