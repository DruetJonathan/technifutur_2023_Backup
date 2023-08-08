package main.Controller;

import main.domains.Activite;
import main.domains.Personne;

import java.io.*;
import java.util.ArrayList;

public class ControllerData implements Serializable{
   /* public static void main(String[] args) throws NullOrEmptyFieldException {
        //save(new ControllerData(Personne.getPersonnesTest(), Activite.getActiviteTest()));
        ControllerData controllerData = load();
        save(controllerData);
        //System.out.println(controllerData.getListePersonnes().get(0));
    }*/
    ArrayList<Personne> listePersonnes;
    ArrayList<Activite> listeActivites;

    public ControllerData(ArrayList<Personne> listePersonnes,ArrayList<Activite> listeActivites) {
        this.listePersonnes = listePersonnes;
        this.listeActivites = listeActivites;
    }

    public ArrayList<Personne> getListePersonnes() {
        return listePersonnes;
    }

    public void setListePersonnes(ArrayList<Personne> listePersonnes) {
        this.listePersonnes = listePersonnes;
    }

    public ArrayList<Activite> getListeActivites() {
        return listeActivites;
    }

    public void setListeActivites(ArrayList<Activite> listeActivites) {
        this.listeActivites = listeActivites;
    }
    public void save() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("mesDatas.ser"))) {
            output.writeObject(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ControllerData load() {
        ControllerData result;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("mesDatas.ser"))) {
            result = (ControllerData) input.readObject();
        } catch (FileNotFoundException e) {
            result = new ControllerData(new ArrayList<Personne>(),new ArrayList<Activite>());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
