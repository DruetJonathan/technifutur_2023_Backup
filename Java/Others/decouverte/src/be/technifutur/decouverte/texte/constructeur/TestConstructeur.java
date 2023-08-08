package be.technifutur.decouverte.texte.constructeur;


public class TestConstructeur {
    public static void main(String[] args) {
        C c = new C();
        System.out.println("c.v1 = " + c.v1);
        System.out.println("c.v2 = " + c.v2);
        System.out.println("c.v3 = " + c.v3);
    }

    public static void type(A a) {
        System.out.println("Type a ");
    }

    public static void type(B b) {
        System.out.println("Type b ");
    }

    public static void type(C c) {
        System.out.println("Type c ");
    }
}

abstract class A {
    int v1;

    A() {
        System.out.println("A.A");
        TestConstructeur.type(this);
        System.out.println("this.getClass().getName() = " + this.getClass().getName());
        System.out.println("c.v1 = " + this.v1);
        System.out.println("c.v1 = " + this.getv2());
        v1 = 10;
    }

    abstract int getv2();
}

class B extends A {
    {
        System.out.println("this.v2 = " + this.v2);
        TestConstructeur.type(this);

    }

    int v2 = 5;

    B() {
        System.out.println("B.B");
        System.out.println("c.v1 = " + this.v1);
        System.out.println("c.v2 = " + this.v2);
    }

    @Override
    int getv2() {
        return this.v2;
    }
}

class C extends B {
    int v3;

    C(int v) {
        System.out.println("C.C");
        System.out.println("c.v1 = " + this.v1);
        System.out.println("c.v2 = " + this.v2);
        System.out.println("c.v3 = " + this.v3);
        this.v3 = v;
    }
        C(){
        this(5);
    }
}
