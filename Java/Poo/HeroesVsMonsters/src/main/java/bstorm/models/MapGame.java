package bstorm.models;

import bstorm.models.characters.Entity;
import bstorm.models.characters.monsters.Dragon;
import bstorm.models.characters.monsters.Monster;
import bstorm.models.characters.monsters.Troll;
import bstorm.models.characters.monsters.Wolf;
import bstorm.utils.View;

public class MapGame {
    Entity[][] tabEntities;

    public MapGame(int nbrLines, int nbrColumns){
        this.tabEntities = new Entity[nbrLines][nbrColumns];
        generateMap();
    }
    public void generateMap(){
        for (int i = 0; i < tabEntities.length; i++) {
            for (int j = 0; j < tabEntities[i].length; j++) {
               int aleat = (int) (Math.random() * (100));
               if (aleat % 3  == 0){
                   //System.out.println("Spawn ->"+i+" "+j);
                   tabEntities[i][j] = generateMonster();
               }
            }
        }
    }

    private Monster generateMonster() {
        Monster m = null;
        int aleat = (int) (Math.random() * (3));
        switch (aleat){
            case 0:
                m = new Wolf();
                break;
            case 1:
                m = new Troll();
                break;
            case 2:
                m = new Dragon();
                break;
        }
        return m;
    }

    public Entity[][] getTabEntities() {
        return tabEntities;
    }
}
