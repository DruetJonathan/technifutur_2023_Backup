package be.technifutur.decouverte.designPattern.superCanard.composite;

import be.technifutur.decouverte.designPattern.superCanard.strategie.CanCan;
import be.technifutur.decouverte.designPattern.superCanard.strategie.Coincoin;
import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementCancan;

public class TestComposite {

    public static void main(String[] args) {
        testBegayer();
        testAlternative();
        testAlternativeBegayer();
    }

    private static void testAlternativeBegayer() {
        ComportementCancan cri1 = new CanCan();
        ComportementCancan cri2 = new Coincoin();
        ComportementCancan alterne = new Alterner(cri1,cri2);
        ComportementCancan begayer = new Begayer(alterne);
        System.out.println(begayer.cancanner());//???
        System.out.println(begayer.cancanner());//???
    }

    private static void testAlternative() {
        ComportementCancan cri1 = new CanCan();
        ComportementCancan cri2 = new Coincoin();
        ComportementCancan alterne = new Alterner(cri1,cri2);
        System.out.println(alterne.cancanner());// Cancan
        System.out.println(alterne.cancanner());// Coincoin
        System.out.println(alterne.cancanner());// Cancan
        System.out.println(alterne.cancanner());// Coincoin
        System.out.println(alterne.cancanner());// Cancan
    }

    private static void testBegayer() {
        ComportementCancan cancan = new CanCan();
        ComportementCancan begayer = new Begayer(cancan);
        System.out.println(begayer.cancanner());// cancan cancan
    }
}
