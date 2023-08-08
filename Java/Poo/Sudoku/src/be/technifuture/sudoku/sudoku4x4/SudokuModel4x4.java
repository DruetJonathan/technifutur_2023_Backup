package be.technifuture.sudoku.sudoku4x4;

import be.technifuture.sudoku.AbstractSudokuModel;
import be.technifuture.sudoku.Cell;
import be.technifuture.sudoku.SudokuModel;
import be.technifuture.sudoku.sudoku9x9.SudokuModel9x9;
import be.technifuture.sudoku.utils.ValueSet;

import javax.swing.*;

public class SudokuModel4x4 extends AbstractSudokuModel implements SudokuModel {
    public static void main(String[] args) {
        SudokuModel4x4 s4x4 = new SudokuModel4x4();

    }
    SudokuModel4x4() {
        ValueSet lineZone;
        ValueSet[] columnZone = new ValueSet[4];
        ValueSet[] squareZone = new ValueSet[4];
        // column
        for (int i = 0; i < 4; i++) {
            columnZone[i] = new ValueSet("Colone " + (i + 1));
            squareZone[i] = new ValueSet("Carré " + (i + 1));
        }
        // ligne
        for (int line = 0; line < 4; line++) {
            lineZone = new ValueSet("Ligne" + (line + 1));
            for (int column = 0; column < 4; column++) {
                Cell cell = this.getCell(line, column);
                cell.add(lineZone);
                cell.add(columnZone[column]);
                cell.add(squareZone[line/2*2+column / 2]);
                System.out.println("lineZone = " + lineZone.getName());
                System.out.println("columnZone[column] = " + columnZone[column].getName());
                System.out.println("squareZonetab[((line/2)*2) + (column * 2)] = " + squareZone[((line/2)*2) + (column / 2)].getName());
            }
        }
    }

    @Override
    public int cellCount() {
        return 16;
    }

    @Override
    public int getMaxLine() {
        return 4;
    }

    @Override
    public int getMaxColumn() {
        return 4;
    }

    @Override
    public boolean isPositionValid(int lineNumber, int columnNumber) {
        // regarde si la valeur peut etre posé à cette position
        boolean flag = true;

        if ((lineNumber > getMaxColumn() || lineNumber < 0)
                && (columnNumber > getMaxColumn() || columnNumber < 0)) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean isValueValid(char value) {
        // regarde si la valeur est acceptable
        char[] tmp = {'1', '2', '3', '4'};
        boolean flag = false;
        int i = 0;
        while (!flag && i < tmp.length) {
            if (tmp[i] == value) flag = true;
            i++;
        }
        return flag;
    }

    @Override
    public int getCompteur() {
        return nombreTotalValue;
    }


}
