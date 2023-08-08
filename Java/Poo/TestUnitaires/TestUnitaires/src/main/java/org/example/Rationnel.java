package org.example;

import org.example.exception.RationnalException;

import java.util.Objects;

public class Rationnel {
    private int numerator;
    private int denominator;

    public Rationnel(int a, int b) {
        if (b == 0){
            throw new RationnalException("Numérateur = 0");
        }
        this.numerator = a;
        this.denominator = b;
    }

    public int getRationnel() {
        return numerator / denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rationnel add(Rationnel rationnel) {
        return new Rationnel(
                this.numerator*rationnel.getDenominator()+rationnel.getNumerator()*this.denominator,
                this.denominator*rationnel.denominator
        );
    }
    public void simplification() {
        int pgcd = pgcd(numerator, denominator);
        this.numerator /= pgcd;
        this.denominator /= pgcd;
    }
    public Rationnel multiplication(Rationnel rationnel){
        return new Rationnel(this.getNumerator()*rationnel.getNumerator(),this.getDenominator()*rationnel.getDenominator());
    }
    public Rationnel multiplication(Integer a){
        Rationnel rationnel = new Rationnel(a,1);
        return this.multiplication(rationnel);
    }

    private int pgcd(int num, int denom) {
        while (denom != 0) {
            int r = num % denom;
            num = denom;
            denom = r;
        }
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rationnel rationnel = (Rationnel) o;
        return numerator == rationnel.numerator && denominator == rationnel.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
