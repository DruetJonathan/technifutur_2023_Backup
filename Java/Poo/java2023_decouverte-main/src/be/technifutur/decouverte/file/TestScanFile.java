package be.technifutur.decouverte.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScanFile {

    public static void main(String[] args) {
        File file = new File("ressource\\test.txt");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("le fichier n'existe pas");
        }
    }
}
