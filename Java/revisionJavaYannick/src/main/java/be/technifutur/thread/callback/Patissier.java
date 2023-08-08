package be.technifutur.thread.callback;

public class Patissier {
    public synchronized String getGateau(String fruit) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("commande ok");

        return String.format("La tarte aux %s est prête",fruit);
    }
}
