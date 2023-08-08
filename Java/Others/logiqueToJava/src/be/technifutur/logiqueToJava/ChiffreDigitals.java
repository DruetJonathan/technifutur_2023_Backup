package be.technifutur.logiqueToJava;

import java.util.Arrays;
import java.util.Scanner;

public class ChiffreDigitals implements Runnable {

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Entrez un chiffre: ");
        String chiffre = scan.nextLine();
        String[] tabChiffre = chiffre.split("");
        String[] tabStringDigit;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < tabChiffre.length; j++) {
                tabStringDigit = getDigitsOfNumber(tabChiffre[j])[i];
                for (int j2 = 0; j2 < tabStringDigit.length; j2++) {
                    System.out.print(tabStringDigit[j2]);
                }
            }
            System.out.println();
        }

    }

    public String[][] getDigitsOfNumber(String number) {
        String[][] tab = null;
        switch (number) {
            case "0":
                // tab = new String[5][3] { {}, {}, {}, {}, {} };
                tab = new String[][] {
                        { " ", "_", " " },
                        { "|", " ", "|" },
                        { "|", "_", "|" },

                };
                break;
            case "1":
                tab = new String[][] {
                        { " ", " ", " " },
                        { " ", " ", "|" },
                        { " ", " ", "|" },

                };
                break;
            case "2":
                tab = new String[][] {
                        { " ", "_", " " },
                        { " ", "_", "|" },
                        { "|_", " ", "" },

                };
                break;
            case "3":
                tab = new String[][] {
                        { " ", "_", " " },
                        { " ", "_", "|" },
                        { " ", "_", "|" },

                };
                break;

            case "4":
                tab = new String[][] {
                        { " ", " ", " " },
                        { "|", "_", "|" },
                        { " ", " ", "|" },

                };
                break;
            case "5":
                tab = new String[][] {
                        { " ", "_", " " },
                        { "|", "_", " " },
                        { " ", "_", "|" },

                };
                break;
            case "6":
                tab = new String[][] {
                        { " ", "_", " " },
                        { "|", "_", " " },
                        { "|", "_", "|" },

                };
                break;
            case "7":
                tab = new String[][] {
                        { " ", "_", " " },
                        { " ", " ", "|" },
                        { " ", " ", "|" },

                };
                break;
            case "8":
                tab = new String[][] {
                        { " ", "_", " " },
                        { "|", "_", "|" },
                        { "|", "_", "|" },

                };
                break;
            case "9":
                tab = new String[][] {
                        { " ", "_", " " },
                        { "|", "_", "|" },
                        { " ", "_", "|" },

                };
                break;

            default:
                break;
        }

        return tab;
    }
}