package be.technifutur.decouverte.texte.TestException;

public class DecouverteException {
    public static void main(String[] args){
        /*System.out.println("DecouverteException.main avant");
        fct1(5);
        System.out.println("DecouverteException.main apres");*/

       /* System.out.println("DecouverteException.main avant");
        fct1(7);
        System.out.println("DecouverteException.main apres");*/

        System.out.println("DecouverteException.main avant");
        fct1(8);
        System.out.println("DecouverteException.main apres");

    }

    private static void fct1(int i){
        System.out.println("DecouverteException.main.fct1 avant");

        try {
            fct2(i);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (RuntimeException e){
            System.out.println("C'est une runtime");
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("réenvoie ",e);
        }catch (MyException m){
            System.out.println("MyException: " + m.getNum());
            System.out.println(m.getMessage());
        }finally {
            System.out.println("finally");
        }

        System.out.println("DecouverteException.main.fct1 apres");

    }
    private static void fct2(int i) throws MyException {
        System.out.println("DecouverteException.main.fct2 avant");
        fct3(i);
        System.out.println("DecouverteException.main.fct2 apres");
    }
    private static void fct3(int i) throws MyException {
        System.out.println("DecouverteException.main.fct3 avant");
        if (i == 5){
            throw new IllegalArgumentException("5 C EST PAS BIEN");
        } else if (i == 7) {
            throw new RuntimeException("7 c'est pire");
        } else if (i == 8) {
            throw new MyException("pas de 8",8);
        }
        System.out.println("DecouverteException.main.fct3 apres");
    }
}
