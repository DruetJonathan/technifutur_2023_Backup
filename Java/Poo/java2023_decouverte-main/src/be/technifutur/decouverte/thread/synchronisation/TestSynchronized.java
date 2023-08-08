package be.technifutur.decouverte.thread.synchronisation;

import be.technifutur.decouverte.thread.NameWriter;

public class TestSynchronized {

    public static void main(String[] args) {
        Thread t1 = new Thread(new WriterSynchonize('o', 10, 50),"Lettre'o'");
        Thread t2 = new Thread(new WriterSynchonize('-', 10, 50),"tiret");
        Thread t3 = new Thread(new WriterSynchonize('_', 10, 50),"soulignement");
        t1.start();
        t2.start();
        t3.start();
    }
}
