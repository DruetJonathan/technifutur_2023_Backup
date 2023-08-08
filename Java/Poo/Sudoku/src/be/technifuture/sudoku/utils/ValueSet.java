package be.technifuture.sudoku.utils;

public class ValueSet {
    private String name;
    private int data = 0;

    public boolean contains(char value) {
        int mask = getMask(value);
        boolean result = (data & mask) != 0;
        return result;
    }

    private static int getMask(char value) {
        int val = Character.digit(value, 10);
        int mask = 1 << val;
        return mask;
    }

    public boolean add(char value) {
        int mask = getMask(value);
        int ancien = data;
        data = mask | data;
        return ancien != data;
    }

    public String getName() {
        return name;
    }

    public ValueSet(String name) {
        this.name = name;
    }

    public boolean remove(char value) {
        int mask = ~getMask(value);
        int ancien = data;
        data = mask & data;
        return ancien != data;
    }

    public static void main(String[] args) {
    }
}
