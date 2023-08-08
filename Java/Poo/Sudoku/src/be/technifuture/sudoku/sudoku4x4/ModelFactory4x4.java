package be.technifuture.sudoku.sudoku4x4;

import be.technifuture.sudoku.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ModelFactory4x4 implements ModelFactory {
    @Override
    public SudokuModel4x4 getModel(String FileName) throws SudokuException {
        SudokuModel4x4 s4x4 = new SudokuModel4x4();
        File file = new File(FileName);
        String ligne = "";
        int j = 0;
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNextLine()) {
                ligne = scanner.nextLine();
                for (int i = 0; i < 4; i++) {
                    char value = ligne.charAt(i);
                    if (s4x4.isValueValid(value))
                        s4x4.setValue(j, i, value);
                    s4x4.lock();
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas.");
        }
        ;
        return s4x4;
    }

    @Override
    public SudokuVue4x4 getVue(String FileName) throws SudokuException {
        return new SudokuVue4x4(this.getModel(FileName));
    }
}
