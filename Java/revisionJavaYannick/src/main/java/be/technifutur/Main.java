package be.technifutur;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // via une class "classique"
//        MonPredicat monPredicat = new MonPredicat();

        // via une class anonyme interne
//        Predicate<String> monPredicat = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("L");
//            }
//        };

//        Predicate<String> monPredicat = s -> s.startsWith("L");

//        utilisationDeLaLambda(monPredicat);

        Predicate<String> monPredicat = Main::monTest;
        monPredicat = s -> Main.monTest(s);

        Arrays.asList("toto", "dede", "Louis").stream()
                .filter(monPredicat)
                .toList();
    }

    static void utilisationDeLaLambda(Predicate<String> predicate){
        String val = "toto va a la plage";
        System.out.println(predicate.test(val));
    }

    static Boolean monTest(String s){
        return s.startsWith("L");
    }

    static void testVariableFinale(){
        AtomicInteger cpt = new AtomicInteger(1);
        Arrays.asList("toto", "dede", "Louis").stream()
                .map(s -> cpt.getAndIncrement() + ") " + s)
                .toList();
    }
}

class MonPredicat implements Predicate<String>{

    @Override
    public boolean test(String s) {
        return s.startsWith("L");
    }
}