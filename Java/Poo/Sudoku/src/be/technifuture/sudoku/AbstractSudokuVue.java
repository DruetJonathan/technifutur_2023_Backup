package be.technifuture.sudoku;

import be.technifuture.sudoku.sudoku4x4.SudokuModel4x4;

public abstract class AbstractSudokuVue {
    private String format;
    SudokuModel model;
    public AbstractSudokuVue(SudokuModel model,String format){
        this.model = model;
        this.format = format;
    }
    public SudokuModel getModel(){
        return model;
    }
    public String getScreen() throws SudokuPositionException {
        Character[] val = new Character[this.getModel().cellCount()];
        int pos = 0;
        for (int i = 0; i < model.getMaxLine(); i++) {
            for (int j = 0; j < model.getMaxColumn(); j++) {
                if (model.isEmpty(i,j)) val[pos] = '.';
                else val[pos] = model.getValue(i,j);
                pos ++;
            }
        }

        return String.format(this.format,val);
    }
}
