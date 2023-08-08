package be.technifutur.decouverte.thread.producteurconsommateur;

import java.util.Optional;

public class Consommateur implements Runnable{

    private Stock stock;

    public Consommateur(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {

        Optional<String> produit = stock.remove();
        while (produit.isPresent()){
            produit= stock.remove();
        }
        System.out.printf("Arret de la consomation par %s%n",Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Stock stock1 = new Stock();
        new Thread(new Consommateur(stock1)).start();
        try {
            Thread.sleep(10000);
            System.out.println("fermeture du stock");
            stock1.setOpen(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
