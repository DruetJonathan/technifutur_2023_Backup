package be.technifuture.sudoku;

import be.technifuture.sudoku.SudokuModel;

public interface ModelFactory {
    SudokuModel getModel(String FileName) throws SudokuException;
    SudokuView getVue(String FileName) throws SudokuException;
}
