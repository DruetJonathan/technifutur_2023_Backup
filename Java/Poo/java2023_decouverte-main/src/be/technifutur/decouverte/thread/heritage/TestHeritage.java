package be.technifutur.decouverte.thread.heritage;

import be.technifutur.decouverte.thread.Writer;

public class TestHeritage {

    public static void main(String[] args) {
        /*testRun();
        testStart();
        testJoin();*/
        testReStart();
    }

    private static void testReStart() {
        Thread t1 = new ThreadWriter(new Writer('o', 10, 50));
        Thread t2 = new ThreadWriter(new Writer('-', 10, 50));
        Thread t3 = new ThreadWriter(new Writer('|', 10, 50));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t2.start();
        t3.start();
    }

    private static void testJoin() {
        Thread t1 = new ThreadWriter(new Writer('o', 2, 50));
        Thread t2 = new ThreadWriter(new Writer('-', 10, 50));
        Thread t3 = new ThreadWriter(new Writer('|', 10, 50));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("c'est fini");
    }

    private static void testStart() {
        Thread t1 = new ThreadWriter(new Writer('o', 10, 50));
        Thread t2 = new ThreadWriter(new Writer('-', 10, 50));
        Thread t3 = new ThreadWriter(new Writer('|', 10, 50));

        t1.start();
        t2.start();
        t3.start();
        System.out.println("c'est fini");
    }

    private static void testRun() {
        Thread t1 = new ThreadWriter(new Writer('o', 10, 50));
        Thread t2 = new ThreadWriter(new Writer('-', 10, 50));
        Thread t3 = new ThreadWriter(new Writer('|', 10, 50));

        t1.run();
        t2.run();
        t3.run();
    }
}
