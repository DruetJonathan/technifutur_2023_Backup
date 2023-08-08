package be.technifutur.decouverte.thread.producteurconsommateur;

public class TestStock {

    public static void main(String[] args) {
        Stock stock = new Stock();

        stock.add("pomme");
        stock.setOpen(true);
        stock.add("poire");
        stock.add("banane");
        stock.add("orange");
        System.out.println(stock.remove());
        System.out.println(stock.remove());
        System.out.println(stock.remove());
        System.out.println(stock.remove());
    }
}
