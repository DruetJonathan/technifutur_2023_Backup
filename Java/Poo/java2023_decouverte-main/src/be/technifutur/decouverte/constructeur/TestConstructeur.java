package be.technifutur.decouverte.constructeur;

public class TestConstructeur {

    public static void main(String[] args) {
        C test = new C();
        System.out.println("v1: "+test.v1);
        System.out.println("v2: "+test.v2);
        System.out.println("v3: "+test.v3);
    }
    public static void type(A a){
        System.out.println("type A");
    }
    public static void type(B b){
        System.out.println("type B");
    }
    public static void type(C c){
        System.out.println("type C");
    }
}

abstract class A{
    // initialisateur d'instance
    {
        System.out.println("v1: "+this.v1);
    }
     A(){
        super();
        System.out.println("A.A");
        TestConstructeur.type(this);
        System.out.println(this.getClass().getName());
        System.out.println("v1: "+this.v1);
        System.out.println("v1: "+this.getv2());
        v1 =10;
    }

    protected abstract int getv2();

    int v1 = 5;
}

class B extends A{
    int v2 = v1 + 2;
    B(int v2){
        super();
        TestConstructeur.type(this);
        System.out.println("B.B");
        System.out.println("v1: "+this.v1);
        System.out.println("v2: "+this.v2);
        this.v2 = v2;
    }

    @Override
    protected int getv2() {
        return v2;
    }
}

class C extends B{
    int v3;
    C(int v){
        super(v);
        System.out.println("C.C");
        System.out.println("v1: "+this.v1);
        System.out.println("v2: "+this.v2);
        System.out.println("v3: "+this.v3);
    }
    C(){
        this(5);
    }
}
