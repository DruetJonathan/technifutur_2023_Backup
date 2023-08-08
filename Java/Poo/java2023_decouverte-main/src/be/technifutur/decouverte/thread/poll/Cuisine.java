package be.technifutur.decouverte.thread.poll;

import be.technifutur.decouverte.thread.callback.ServeurDeTarte;
import be.technifutur.decouverte.thread.callback.Tarte;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Cuisine {
    private List<ServeurDeTarte> cuistots = new ArrayList<>();

    public Cuisine() {
        cuistots.add(new ServeurDeTarte());
        cuistots.add(new ServeurDeTarte());
        cuistots.add(new ServeurDeTarte());
    }

    public void CommanderTarte(String gout, Consumer<Tarte> callback) {

        ServeurDeTarte serveur = getServeurDeTarte();
        new Thread(() -> {
            Tarte tarte = serveur.getTarte(gout);
            finTravail(serveur);
            callback.accept(tarte);
        }).start();

    }

    private synchronized ServeurDeTarte getServeurDeTarte() {
        try {
            while (cuistots.size() == 0) {
                wait();
            }
            ServeurDeTarte serveur = cuistots.remove(0);
            return serveur;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void finTravail(ServeurDeTarte serveur) {
        cuistots.add(serveur);
        notifyAll();
    }

    public static void main(String[] args) {
        String[] commande = {"Fraise", "Sucre", "Fraise", "Sucre", "Fraise", "Fraise", "Sucre"};
        Cuisine cuisine = new Cuisine();
        for (String c : commande) {
            cuisine.CommanderTarte(c, (t) -> System.out.printf("Et une tarte au %s une%n", t.getGout()));
        }
    }
}
