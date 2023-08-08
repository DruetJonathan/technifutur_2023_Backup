package be.technifutur.thread.producteurconsommateur;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private static final Integer MAX = 5;
    private List<String> stocks = new ArrayList<>();
    private Boolean open = true;

    public synchronized Boolean add(String product) throws InterruptedException {
        Boolean added = false;
        if(stocks.size() < MAX && open){
            this.wait();
        }

        return false;
    }

    public String remove(){
        if(!stocks.isEmpty()){
            return stocks.remove(0);
        }

        return "Stocks is empty !";
    }
}
