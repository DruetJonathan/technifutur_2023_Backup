package be.technifuture.sudoku.sudoku4x4;

import be.technifuture.sudoku.AbstractSudokuVue;
import be.technifuture.sudoku.SudokuModel;
import be.technifuture.sudoku.SudokuView;

public class SudokuVue4x4 extends AbstractSudokuVue implements SudokuView {
    private static String format = """
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+""".replace(".","%s");

    public SudokuVue4x4(SudokuModel model) {
        super(model,format);
    }



}
