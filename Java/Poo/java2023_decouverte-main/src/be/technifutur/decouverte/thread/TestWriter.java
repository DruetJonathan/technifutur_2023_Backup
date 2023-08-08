package be.technifutur.decouverte.thread;

public class TestWriter {

    public static void main(String[] args) {
        Writer w1 = new Writer('o', 10, 50);
        Writer w2 = new Writer('-', 10, 50);
        Writer w3 = new Writer('|', 10, 50);

        w1.run();
        w2.run();
        w3.run();
    }
}
