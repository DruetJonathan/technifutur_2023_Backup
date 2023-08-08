package be.technifuture.sudoku;

public interface SudokuView {
    /**
     * Affiche la string
     * @return la string à afficher
     */
    String getScreen() throws SudokuPositionException;
    /**
     * Permet de renvoyer le modele
     * @return le modele sudoky
     */
    SudokuModel getModel();
}
