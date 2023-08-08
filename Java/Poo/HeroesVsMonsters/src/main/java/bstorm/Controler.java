package bstorm;

import bstorm.models.MapGame;
import bstorm.models.characters.Entity;
import bstorm.models.characters.heroes.Hero;
import bstorm.models.characters.heroes.Mage;
import bstorm.models.characters.heroes.Warrior;
import bstorm.models.characters.monsters.Monster;
import bstorm.models.properties.StatType;
import bstorm.utils.View;

import java.util.Scanner;
import java.util.Vector;

public class Controler {
    private Hero hero;
    private View view;
    private MapGame map;

    public Controler() {

    }
    int posX,posY;
    public void start(int nbrLines, int nbrCollumns) {
        this.view = new View();
        this.map = new MapGame(nbrLines, nbrCollumns);
        view.printTitleGame();
        this.hero = getHero();
        view.recapChoiceOfPlayer(hero);
        posX = (int) (Math.random() * (nbrLines));
        posY = (int) (Math.random() * (nbrCollumns));
        while (hero.isAlive()) {
            // turn
            checkCombat();
            gameTurn();
            //
        }
        view.printDeathScreen();
    }

    private void checkCombat() {
        if (map.getTabEntities()[posX][posY] instanceof Entity) {
            System.out.println("Monstre");
            Monster m = (Monster) map.getTabEntities()[posX][posY];
            while (hero.isAlive() && m.isAlive()) {
                view.printSeparator(90, "_");
                hero.hit(m);
                if (m.isAlive()) {
                    m.hit(hero);
                }
                System.out.println(hero.getName());
                view.barHpSpEntity(hero, StatType.hp);
                view.barHpSpEntity(hero, StatType.sp);
                System.out.println(m.getClass().getSimpleName());
                view.barHpSpEntity(m, StatType.hp);
                view.barHpSpEntity(m, StatType.sp);
            }
        }
    }

    private void gameTurn() {
        Scanner scanner = new Scanner(System.in);
        view.printFullHideMap(map, posX, posY);
        System.out.println("Choose Direction (Z,S,Q,D)");
        char c = scanner.nextLine().toUpperCase().charAt(0);
        switch (c){
            case 'Z':
                if (posX +1> -1){
                    posX --;
                }
                break;
            case 'S':
                if (posX < map.getTabEntities().length-1){
                    posX ++;
                }
                break;
            case 'Q':
                if (posY +1> -1){
                    posY --;
                }
                break;
            case 'D':
                if (posY < map.getTabEntities()[posX].length-1){
                    posY ++;
                }
                break;
        }
    }

    private Hero getHero() {
        Scanner scanner = new Scanner(System.in);
        char c = '.';
        while (true) {
            System.out.print("Choose between (W)arrior & (M)age -> ");
            c = scanner.nextLine().toUpperCase().charAt(0);
            if (c == 'W' || c == 'M')
                break;
        }
        System.out.print("Choose is name -> ");
        String name = scanner.nextLine();
        if (c == 'W')
            return new Warrior(name);
        if (c == 'M')
            return new Mage(name);
        return null;
    }
}
