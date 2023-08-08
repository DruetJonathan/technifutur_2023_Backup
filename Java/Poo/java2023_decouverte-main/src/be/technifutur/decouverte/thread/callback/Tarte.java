package be.technifutur.decouverte.thread.callback;

public class Tarte {
    private String gout;
    private boolean mange = false;

    public Tarte(String gout) {
        this.gout = gout;
    }

    public void manger(){
        if(mange){
            System.out.println("il n'y a plus de tarte");
        }else{
            System.out.println("MMM la bonne tarte au "+gout);
            mange = true;
        }
    }

    @Override
    public String toString() {
        return "Tarte{" +
                "gout='" + gout + '\'' +
                '}';
    }

    public String getGout() {
        return gout;
    }
}
