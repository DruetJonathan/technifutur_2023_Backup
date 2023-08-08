package be.technifutur.decouverte.thread.callback;

public class ServeurDeTarte {

    public synchronized Tarte getTarte(String gout){
        try {
            System.out.println(this);
            System.out.printf(
                    "%s commence à préparer la tarte au %s%n",
                    Thread.currentThread().getName()
                    ,gout);
            Thread.sleep(5000);
            System.out.printf(
                    "%s a fini de préparer la tarte au %s%n",
                    Thread.currentThread().getName()
                    ,gout);
            return new Tarte(gout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
