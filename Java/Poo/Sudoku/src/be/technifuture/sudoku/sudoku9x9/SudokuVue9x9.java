package be.technifuture.sudoku.sudoku9x9;

import be.technifuture.sudoku.AbstractSudokuVue;
import be.technifuture.sudoku.SudokuModel;
import be.technifuture.sudoku.SudokuView;

public class SudokuVue9x9 extends AbstractSudokuVue implements SudokuView {
    private SudokuModel9x9 model;
    private static String format = """
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+
            """.replace(".","%s");

    public SudokuVue9x9(SudokuModel model) {
        super(model,format);
    }

}
