package be.technifutur.decouverte.testException;

public class DecouverteException {

    public static void main(String[] args) {
        System.out.println("DecouverteException.main avant");
        fct1(3);
        System.out.println("essais IllegalArgumentException");
        fct1(5);
        System.out.println("essais  MyException");
        fct1(8);
        System.out.println("essais  RuntimeException resoulvée");
        fct1(7);
        System.out.println("DecouverteException.main aprés");
    }

    private static void fct1(int i) {
        System.out.println("DecouverteException.fct1 avant");
        try {
            System.out.println("DecouverteException.fct1 debut try");
            fct2(i);
            System.out.println("DecouverteException.fct1 fin try");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (RuntimeException e){
            System.out.println("c'est une runtime");
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("réenvoie", e);
        }catch (MyException m){
            System.out.println("MyException : "+m.getNum());
            System.out.println(m.getMessage());
        }finally {
            System.out.println("Finally");
        }
        System.out.println("DecouverteException.fct1 après");
    }

    private static void fct2(int i) throws  MyException{
        System.out.println("DecouverteException.fct2 avant");
        fct3(i);
        System.out.println("DecouverteException.fct2 après");
    }

    private static void fct3(int i) throws MyException{
        System.out.println("DecouverteException.fct3 avant");

        if ( i == 5){
            throw new IllegalArgumentException("5 c'est pas bien");
        } else if (i == 7) {
            throw new RuntimeException("7 c'est pas mieux...");
        } else if (i == 8) {
            throw new MyException("pas de 8",8);
        }
        System.out.println("DecouverteException.fct3 après");
    }
}






