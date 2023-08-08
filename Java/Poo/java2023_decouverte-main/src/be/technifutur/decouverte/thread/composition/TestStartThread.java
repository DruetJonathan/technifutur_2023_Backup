package be.technifutur.decouverte.thread.composition;

import be.technifutur.decouverte.thread.NameWriter;
import be.technifutur.decouverte.thread.Writer;

public class TestStartThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new NameWriter('o', 10, 50),"Lettre'o'");
        Thread t2 = new Thread(new NameWriter('-', 10, 50),"tiret");
        Thread t3 = new Thread(new NameWriter('_', 10, 50),"soulignement");
        t1.start();
        t2.start();
        t3.start();
    }
}
