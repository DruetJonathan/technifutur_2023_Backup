package be.technifutur.decouverte.thread.synchronisation;

public class WriterSynchonize implements Runnable {
    private char car;
    private int nbLine;
    private int size;

    public WriterSynchonize(char car, int nbLine, int size) {
        this.car = car;
        this.nbLine = nbLine;
        this.size = size;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < nbLine; i++) {
                Thread.sleep(10);
                printLine();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printLine() {
        synchronized (System.out) {
            for (int i = 0; i < size; i++) {
                System.out.print(car);
            }
            System.out.println();
        }
    }
}
