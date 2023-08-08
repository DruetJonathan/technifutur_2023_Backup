package be.technifutur.decouverte.thread.producteurconsommateur;

public class Producteur implements Runnable{
    private Stock stock;
    private String produit;

    public Producteur(Stock stock, String produit) {
        this.stock = stock;
        this.produit = produit;
    }

    @Override
    public void run() {
        boolean added = stock.add(produit);
        while (added){

            added = stock.add(produit);
        }
        System.out.println("fin de la production de " +produit);
    }

    public static void main(String[] args) {
        Stock stock1 = new Stock();
        stock1.setOpen(true);
        new Thread(new Producteur(stock1,"pomme")).start();

        try {
            Thread.sleep(10000);
            System.out.println("fermeture du stock");
            stock1.setOpen(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
