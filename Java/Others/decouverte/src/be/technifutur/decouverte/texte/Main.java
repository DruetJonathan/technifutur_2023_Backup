
package be.technifutur.decouverte.texte;

import java.time.Clock;

public class Main {
    public static void main(String[] args) {
        System.out.println("javac -d bin -sourcepath src src\\be\\technifutur\\decouverte\\texte\\Main.java");
        System.out.println("java -cp bin be.technifutur.decouverte.texte.Main");

        String texte1 = "Coucou";
        char lettre = 'l';
        System.out.println(texte1.length());
        System.out.println(texte1.charAt(2));
        System.out.println(texte1.substring(2));
        System.out.println(texte1.substring(2, 6));
        String multiLine = """
                    je suis uno
                    ligne2
                """;
        //String.format("%s %n", lettre, texte1.length());
    }
}
