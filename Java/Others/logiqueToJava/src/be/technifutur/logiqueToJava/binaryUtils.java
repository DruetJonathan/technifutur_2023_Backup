package be.technifutur.logiqueToJava;

public class binaryUtils implements Runnable{
    public void run() {
        // init
        int data = init();
        System.out.println("Data vaut: "+Integer.toBinaryString(data));

        //estPossible
        boolean estPossibleValue = estPossible(data,7);
        System.out.println("estPossible: "+estPossibleValue);
        ////////////////////////////////////////////////////////////////////////////////////

        //delete
        data = deletePossibilite(data,7);
        System.out.println("New data sans 7: "+Integer.toBinaryString(data));
        System.out.println("----");
        data = deletePossibilite(data,7);
        System.out.println("New data sans 7: "+Integer.toBinaryString(data));
        //estPossible
        estPossibleValue = estPossible(data,7);
        System.out.println("estPossible: "+estPossibleValue);

        ////////////////////////////////////////////////////////////////////////////////////
        //add
        data = addPossibilite(data,7);
        System.out.println("New data add 7: "+Integer.toBinaryString(data));
        //estPossible
        estPossibleValue = estPossible(data,7);
        System.out.println("estPossible: "+estPossibleValue);

        data = addPossibilite(data,7);
        System.out.println("New data add 7: "+Integer.toBinaryString(data));
        ////////////////////////////////////////////////////////////////////////////////////
    }
    private static int combine(int data, int data2){
        return data&data2;
    }
    private int addPossibilite(int data, int value) {
        int tmp = (1 << (value -1));
        return data | tmp;
    }

    private int deletePossibilite(int data, int value) {
        int tmp = ~(1 << (value - 1));
        return data & tmp;
    }

    static int init(){
        // 1 decaler de 9 positions a gauche
        return (1<<9)-1;
    }
    static boolean estPossible(int data ,int value){
        int tmp = (1 << (value -1));
        return combine(data, tmp) == tmp;
    }
}
