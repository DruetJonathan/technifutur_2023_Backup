package be.technifuture.sudoku;

public interface SudokuModel {
    char EMPTY = 0;
    /**
     * Retourne le nombre de cellules
     *
     * @return le nombre de cellules
     */
    int cellCount();

    /**
     * Retourne la valeur à une position précises ( lignes , colones)
     *
     * @param lineNumber   le numéro de la ligne
     * @param columnNumber le numero de la colone
     * @return la valeur à une position données
     */
    char getValue(int lineNumber, int columnNumber) throws SudokuPositionException;

    /**
     * Change la valeur à une position donnée
     *
     * @param lineNumber   le numéro de la ligne
     * @param columnNumber le numéro de la colone
     */
    void setValue(int lineNumber, int columnNumber,char value) throws SudokuException, SudokuDoublonException;

    /**
     * Retourne retourne le nombre de ligne
     *
     * @return le nombre de ligne
     */
    int getMaxLine();

    /**
     * Retourne retourne le nombre de colone
     *
     * @return le nombre de colone
     */
    int getMaxColumn();

    /**
     * Retourne true si la position est valide sinon renvoi false
     *
     * @param lineNumber   le numéro de la ligne
     * @param columnNumber le numéro de la colone
     * @return true si la position est valide sinon false
     */
    boolean isPositionValid(int lineNumber, int columnNumber);

    /**
     * Retourne true si la valeur est valide sinon renvoie false
     *
     * @param value la valeur à check si elle est valide
     * @return true si la valeur est valide sinon false
     */
    boolean isValueValid(char value);
    /**
     * Verifie si une case est vide
     * @return true si la case est vide sinon false
     */
    public boolean isEmpty(int lineNumber, int columnNumber);

    /**
     * Permet de clear une case
     */
    public void clearCell(int lineNumber, int columnNumber) throws SudokuException;

    public void initGameBoard();
    public void lock() throws SudokuExceptionLock;

    int getCompteur();
}
