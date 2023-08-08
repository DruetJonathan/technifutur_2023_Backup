package be.technifutur.decouverte.thread.waitNotify;

public class TestNotify {

    public static void main(String[] args) {
        Thread[] tab = {
                new Thread(new WriterNotify('à',5,50)),
                new Thread(new WriterNotify('&',5,50)),
                new Thread(new WriterNotify(')',5,50)),
        };
        for (Thread t : tab){
            t.start();
        }
    }
}
