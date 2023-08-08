package be.technifutur.decouverte.thread.producteurconsommateur;

public class TestStockWithThread {

    public static void main(String[] args) {
        Stock stock1 = new Stock();
        stock1.setOpen(true);
        new Thread(new Consommateur(stock1),"consomateur Léon").start();
        new Thread(new Consommateur(stock1),"consomateur Dédé").start();
        new Thread(new Producteur(stock1, "pomme"),"producteur de pomme").start();
        new Thread(new Producteur(stock1, "poire"),"producteur de poire").start();
        new Thread(new Producteur(stock1, "orange"),"producteur de orange").start();

        try {
            Thread.sleep(10000);
            stock1.setOpen(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
