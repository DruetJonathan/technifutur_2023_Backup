package be.technifuture.sudoku.sudoku9x9;

import be.technifuture.sudoku.AbstractSudokuModel;
import be.technifuture.sudoku.Cell;
import be.technifuture.sudoku.SudokuModel;

public class SudokuModel9x9 extends AbstractSudokuModel implements SudokuModel {
    private Cell[][] gameBoard = new Cell[9][9];

    @Override
    public int cellCount() {
        return 81;
    }

    @Override
    public int getMaxLine() {
        return 9;
    }

    @Override
    public int getMaxColumn() {
        return 9;
    }

    @Override
    public boolean isPositionValid(int lineNumber, int columnNumber) {
        // regarde si la valeur peut etre posé à cette position
        boolean flag = true;
        if ((lineNumber > 9 || lineNumber < 0)
                && (columnNumber > 9 || columnNumber < 0))
        {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean isValueValid(char value) {
        // regarde si la valeur est acceptable
        char[] tmp = {'1','2','3','4','5','6','7','8','9'};
        boolean flag = false;
        int i = 0;
        while (!flag && i < tmp.length){
            if (tmp[i] == value) flag = true;
            i++;
        }
        return flag;
    }

    @Override
    public int getCompteur() {
        return 0;
    }

}
