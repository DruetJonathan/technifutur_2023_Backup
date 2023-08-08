package be.technifutur.decouverte.texte.testLambda;

import be.technifutur.decouverte.texte.poo.scenario2.VaisseauSecure;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaParametre {
    public static void main(String[] args) {
        new VaisseauSecure("v1", 10);
        volEsquadrille(VaisseauSecure::new);
        volEsqadrilleInconnue(VaisseauSecure::new);
        VaisseauSecure vaisseauSecure = new VaisseauSecure(10);
        volEsqadrilleInconnue(i -> vaisseauSecure);
        volEsqadrilleInconnue(new Function<Integer, VaisseauSecure>() {
            @Override
            public VaisseauSecure apply(Integer i) {

                return vaisseauSecure;
            }
        });
    }

    public static void volEsquadrille(BiFunction<String, Integer, VaisseauSecure> toto) {
        for (int i = 0; i < 10; i++) {
            VaisseauSecure v = toto.apply("vaisseau " + i, 10);
            System.out.println(v.getNom());
            v.decolage();
        }
    }

    public static void volEsqadrilleInconnue(Function<Integer, VaisseauSecure> dede) {
        for (int i = 0; i < 10; i++) {
            VaisseauSecure v = dede.apply(10);
            System.out.println(v.getNom());
            v.decolage();
        }
    }
}
