package be.technifutur.decouverte.thread.waitNotify;

public class WriterNotify implements Runnable {

    private static Object lock = new Object();

    private char car;
    private int nbLine;
    private int size;

    public WriterNotify(char car, int nbLine, int size) {
        this.car = car;
        this.nbLine = nbLine;
        this.size = size;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                for (int i = 0; i < nbLine; i++) {
                    printLine();
                    Thread.sleep(10);
                }
                lock.notify();
                lock.wait(100);

                for (int i = 0; i < nbLine; i++) {
                    printLineWithPoint();
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printLine() {
        for (int i = 0; i < size; i++) {
            System.out.print(car);
        }
        System.out.println();
    }

    private void printLineWithPoint() {
        for (int i = 0; i < size; i++) {
            System.out.print(car + ".");
        }
        System.out.println();
    }
}
