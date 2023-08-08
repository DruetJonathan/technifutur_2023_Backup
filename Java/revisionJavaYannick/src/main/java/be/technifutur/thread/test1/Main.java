package be.technifutur.thread.test1;

import be.technifutur.thread.CharWritter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread charWritter1 = new CharWritter('-');
        Thread charWritter2 = new CharWritter('+');
        Thread charWritter3 = new CharWritter('/');
        Thread charWritter4 = new CharWritter('*');

        charWritter1.start();
        charWritter2.start();
        charWritter3.start();
        charWritter4.start();

        charWritter1.join();
        System.out.println("Il n'y a plus de -");
        Thread.sleep(100);
        System.out.println("C'est fini !");
    }
}
