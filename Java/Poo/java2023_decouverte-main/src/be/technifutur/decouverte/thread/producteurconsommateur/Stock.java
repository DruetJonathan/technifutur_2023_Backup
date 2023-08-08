package be.technifutur.decouverte.thread.producteurconsommateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stock {
    private List<String> stock = new ArrayList<>();
    private boolean open = false;

    public boolean isOpen() {
        return open;
    }

    public synchronized Stock setOpen(boolean open) {
        this.open = open;
        System.out.printf("%s du stock", open ? "Ouverture" : "Fermeture");
        notifyAll();
        return this;
    }

    public synchronized boolean add(String produit) {
        try {
            boolean add = false;
            while (stock.size() >= 3 && open) {
                wait();
            }
            if (stock.size() < 3 && open) {
                add = stock.add(produit);
                System.out.println(produit + " ajouté");
                notifyAll();
            }
            return add;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized Optional<String> remove() {
        try{
        Optional<String> produit;
        while(open&&stock.size()==0){
            wait();
        }
        if (stock.size() > 0 && open) {
            produit = Optional.of(stock.remove(0));
            notifyAll();
            System.out.printf("%s retirer par %s%n", produit.get(), Thread.currentThread().getName());
        } else {
            produit = Optional.empty();
        }
        return produit;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
