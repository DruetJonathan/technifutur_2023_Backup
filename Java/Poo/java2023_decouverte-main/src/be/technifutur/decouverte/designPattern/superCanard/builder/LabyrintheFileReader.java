package be.technifutur.decouverte.designPattern.superCanard.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabyrintheFileReader {

    public void read(String fileName, LabyrintheBuilder builder) {
        File file = new File(fileName);
        int cpt = 0;

        try (Scanner scanner = new Scanner(file)) {
            builder.start();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case 'X':
                            builder.addMur(i, cpt);

                            break;
                        case '.':
                            builder.addPiece(i, cpt);

                            break;
                        case '|':
                            builder.addPorte(i, cpt);

                            break;
                        case 'E':
                            builder.setEntree(i,cpt);
                        case 'A':
                            builder.addPiece(i,cpt);
                    }
                }
                cpt++;

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        builder.end();

    }
}
