package be.technifuture.sudoku.sudoku9x9;

import be.technifuture.sudoku.*;
import be.technifuture.sudoku.sudoku4x4.SudokuModel4x4;
import be.technifuture.sudoku.sudoku4x4.SudokuVue4x4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ModelFactory9x9 implements ModelFactory {
    @Override
    public SudokuModel9x9 getModel(String FileName) throws SudokuException {
        SudokuModel9x9 s9x9 = new SudokuModel9x9();
        File file = new File(FileName);
        String ligne = "";
        int j = 0;
        try(Scanner scanner = new Scanner(file);){
            while (scanner.hasNextLine()){
                ligne = scanner.nextLine();
                for (int i = 0; i < 9; i++) {
                    char value = ligne.charAt(i);
                    if (s9x9.isValueValid(value))
                        s9x9.setValue(j, i, value);
                    s9x9.lock();
                }
                j ++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas.");
        };
        return s9x9;
    }
    @Override
    public SudokuVue9x9 getVue(String FileName) throws SudokuException {
        return new SudokuVue9x9(this.getModel(FileName));
    }
}
