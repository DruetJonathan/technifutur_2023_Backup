package be.technifuture.sudoku;

import be.technifuture.sudoku.utils.ValueSet;

import java.util.ArrayList;

public class Cell {
    public static void main(String[] args) throws SudokuExceptionLock {
        Cell cell = new Cell();
        ValueSet ligne = new ValueSet("Ligne 1");
        cell.add(ligne);
        System.out.println(cell.valueSetList.size());
        System.out.println(cell.valueSetList.get(0).getName());
        System.out.println(cell.valueSetList.contains('1'));
    }

    private char valeur;
    private boolean lock;
    private ArrayList<ValueSet> valueSetList = new ArrayList<>();

    protected ArrayList<ValueSet> getValueSetList() {
        return valueSetList;
    }

    public Cell() {
        this.valeur = SudokuModel.EMPTY;
        this.lock = false;
    }

    public boolean add(ValueSet zone) {
        return valueSetList.add(zone);
    }

    public boolean isLock() {
        return lock;
    }

    public char getValeur() {
        return valeur;
    }

    public void setValeur(char valeur) throws SudokuDoublonException, SudokuException {
        if (this.valeur != valeur) {
            if (this.isLock()) {
                throw new SudokuExceptionLock("Imposssible de modifier une valeur lock");
            }
            if (valeur != SudokuModel.EMPTY) {
                for (ValueSet set : valueSetList) {
                    if (set.contains(valeur)) {
                        throw new SudokuDoublonException("Contient deja la valeur: " + valeur + " dans " + set.getName());
                    }
                }
            }
            if (this.valeur != SudokuModel.EMPTY) {
                for (ValueSet v : this.valueSetList) {
                    v.remove(this.valeur);
                }
            }

            if (valeur != SudokuModel.EMPTY) {
                for (ValueSet v : this.valueSetList) {
                    v.add(valeur);
                }
            }

            this.valeur = valeur;
        }
    }

    public void lock() {
        if (!(this.getValeur() == SudokuModel.EMPTY)) {
            this.lock = true;
        }
    }
}
