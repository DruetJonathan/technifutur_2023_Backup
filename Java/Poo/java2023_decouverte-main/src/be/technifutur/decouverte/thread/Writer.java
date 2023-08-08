package be.technifutur.decouverte.thread;

public class Writer implements Runnable {
    private char car;
    private int nbLine;
    private int size;

    public Writer(char car, int nbLine, int size) {
        this.car = car;
        this.nbLine = nbLine;
        this.size = size;
    }

    @Override
    public void run(){
        for (int i = 0; i < nbLine; i++) {
            printLine();
        }
    }

    private void printLine() {
        for (int i = 0; i < size; i++) {
            System.out.print(car);
        }
        System.out.println();
    }
}
