package be.technifutur.thread.callback;

public class testCallBack extends Thread{
    public static void main(String[] args) throws InterruptedException {
        testCallBack callBack = new testCallBack();
        callBack.start();
    }
    public void run(){
        Patissier patissier = new Patissier();
        try {
            String gateau = patissier.getGateau("fraises");
            System.out.println(gateau);

            String gateau2 = patissier.getGateau("fraises2");
            System.out.println(gateau2);

            String gateau3 = patissier.getGateau("fraises3");

            System.out.println(gateau3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
