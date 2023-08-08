package be.technifuture.sudoku;

public abstract class AbstractSudokuModel {
    private Cell[][] gameBoard = new Cell[this.getMaxLine()][this.getMaxColumn()];
    public int nombreTotalValue = 0;

    public AbstractSudokuModel() {
        initGameBoard();
    }

    public abstract boolean isPositionValid(int lineNumber, int columnNumber);

    public abstract boolean isValueValid(char value);

    public abstract int getMaxLine();

    public abstract int getMaxColumn();

    public abstract int cellCount();

    public void initGameBoard() {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                this.gameBoard[i][j] = new Cell();
            }
        }
    }

    public void lock() {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                this.gameBoard[i][j].lock();
            }
        }
    }

    public void clearCell(int lineNumber, int columnNumber) throws SudokuExceptionLock, SudokuException, SudokuDoublonException {
        this.gameBoard[lineNumber][columnNumber].setValeur(SudokuModel.EMPTY);
    }

    public boolean isEmpty(int lineNumber, int columnNumber) {
        return this.gameBoard[lineNumber][columnNumber].getValeur() == SudokuModel.EMPTY ? true : false;
    }

    public void setValue(int lineNumber, int columnNumber, char value) throws SudokuException, SudokuDoublonException {
        if (isPositionValid(lineNumber,columnNumber)) {
            if (isValueValid(value)) {
                this.gameBoard[lineNumber][columnNumber].setValeur(value);
            }
            else {
                if (value == SudokuModel.EMPTY) {

                    this.gameBoard[lineNumber][columnNumber].setValeur(SudokuModel.EMPTY);
                }
                else {
                    throw new SudokuValueException("Valeur incorrect " + value);
                }
            }
        } else {
            throw new SudokuPositionException("Position incorrect "+(lineNumber+1)+" "+(columnNumber+1));
        }
        //this.nombreTotalValue ++;
    }

    public char getValue(int lineNumber, int columnNumber) throws SudokuPositionException {
        if (isPositionValid(lineNumber, columnNumber)) {
            return this.gameBoard[lineNumber][columnNumber].getValeur();
        } else {
            throw new SudokuPositionException("Position incorrect " + (lineNumber + columnNumber));
        }
    }
    protected Cell getCell(int line, int column){
        return this.gameBoard[line][column];
    }


}
