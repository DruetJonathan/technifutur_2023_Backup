package main.menu.Vue;

import main.Utils.ConsoleColors;
import main.menu.menu.Menu;

import java.util.Map;
import java.util.Scanner;

public class InlineVue implements MenuVue{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getChoice(Menu menu) {
        Map<String, String> map = menu.getItemText();
        affiche(map);
        System.out.print("Votre choix: ");
        String choix = scanner.nextLine();
        System.out.println(ConsoleColors.BLUE_BOLD+"--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---"+ConsoleColors.WHITE_BRIGHT);
        return choix;
    }
    @Override
    public void affiche(Map<String, String> map) {
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.printf(ConsoleColors.RED+"#%s "+ConsoleColors.CYAN_BOLD+"%s | "+ConsoleColors.WHITE_BRIGHT,e.getKey(),e.getValue());
        }
        System.out.println();
    }
}
