package be.technifutur.decouverte.texte.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScanFile {
    public static void main(String[] args) {
        File file = new File("ressource\\test.txt");
        try(Scanner scanner = new Scanner(file);){
            while (scanner.hasNextLine()){
                System.out.println(scanner.hasNextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas.");
        } ;

    }
}
