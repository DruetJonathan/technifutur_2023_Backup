package be.technifutur.thread;

public class CharWritter extends Thread {
    private static final Object token = new Object();

    private Character character;

    public CharWritter(Character character){
        this.character = character;
    }

    public void printMultiLine(){
        for (int i = 0; i < 25; i++) {
            printLine();
        }
    }

    public void printLine(){
        synchronized (System.out){
            for (int i = 0; i < 100; i++) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    @Override
    public void run() {
        try {
            printMultiLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
