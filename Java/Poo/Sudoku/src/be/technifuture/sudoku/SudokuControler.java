package be.technifuture.sudoku;

import java.util.Scanner;

public class SudokuControler {
    private ModelFactory modelFactory;

    SudokuControler(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    void start(String FileName) throws SudokuException{
        boolean continuer = true;
        SudokuView sv = null;
        Scanner scanner = null;
        String userInput = null;
        String[] userInputTab = null;
        SudokuModel model = null;
        try {
            sv = this.modelFactory.getVue(FileName);
            model = sv.getModel();
            scanner = new Scanner(System.in);
            userInput = "";

        } catch (Exception e) {
            System.out.println("Fichier non valide: " + e.getMessage());
            continuer = false;
        }
        while (continuer) {
            // Affichage de la grille + get des inputs
            System.out.print(sv.getScreen());
            System.out.println("\nEntre valeur.row.col(0.#.# pour vider une case): ");
            userInput = scanner.nextLine();
            userInputTab = userInput.split("\\.");

            // traitements des inputs
            if (!userInput.equalsIgnoreCase("q") || model.getCompteur() == 16) {
                /*if (model.isPositionValid(Integer.parseInt(userInputTab[1]), Integer.parseInt(userInputTab[2]))
                        && model.isValueValid(userInput.charAt(0))) {
                    try {
                        model.setValue(Integer.parseInt(userInputTab[1]) - 1, Integer.parseInt(userInputTab[2]) - 1, userInputTab[0].charAt(0));
                    } catch (SudokuValueException sve) {
                        System.out.println(sve.getMessage());
                    }
                }*/
                try{
                    if (userInputTab[0].charAt(0) == '0'){
                        model.setValue(Integer.parseInt(userInputTab[1]) - 1, Integer.parseInt(userInputTab[2]) - 1, SudokuModel.EMPTY);
                    }
                    else {
                        model.setValue(Integer.parseInt(userInputTab[1]) - 1, Integer.parseInt(userInputTab[2]) - 1, userInputTab[0].charAt(0));
                    }
                }catch (SudokuValueException sve){
                    System.out.println(sve.getMessage());
                } catch (SudokuPositionException sudokuPositionException) {
                    System.out.println(sudokuPositionException.getMessage());
                }catch (SudokuExceptionLock sel){
                    System.out.println(sel.getMessage());
                }
                catch (SudokuDoublonException se){
                    System.out.println(se.getMessage());
                }
            } else {
                continuer = false;
            }
        }
    }
}
