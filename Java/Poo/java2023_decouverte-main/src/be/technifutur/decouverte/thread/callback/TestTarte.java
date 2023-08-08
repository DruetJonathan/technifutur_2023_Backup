package be.technifutur.decouverte.thread.callback;

import java.util.function.Consumer;

public class TestTarte {

    public static void main(String[] args) {
        commandeTarte("fraise",(t)->t.manger());
        commandeTarte("cerise",(t)->t.manger());
        System.out.println("je fais quelque chose en attendant la tarte" );
    }
    //static    ServeurDeTarte serveurDeTarte = new ServeurDeTarte();

    private static void commandeTarte(String gout, Consumer<Tarte> action) {
        ServeurDeTarte serveurDeTarte = new ServeurDeTarte();
        // 1 créer un Runnable avec le code à effecuer par le Thread
        Runnable r = ()->{
            // le code de la méthode run
            Tarte tarte = serveurDeTarte.getTarte(gout);
            action.accept(tarte);
        };
        // 2. créer le thread avec le Runnable
        Thread thread = new Thread(r);

        // 3. lancer le Thread
        thread.start();

        //new Thread(()->action.accept(new ServeurDeTarte().getTarte(gout))).start();

    }

 }
