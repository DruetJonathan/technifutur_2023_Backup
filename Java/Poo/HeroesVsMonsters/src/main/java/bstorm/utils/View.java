package bstorm.utils;

import bstorm.models.MapGame;
import bstorm.models.characters.Entity;
import bstorm.models.characters.heroes.Hero;
import bstorm.models.characters.loots.Inventory;
import bstorm.models.characters.loots.ObjectLoot;
import bstorm.models.properties.StatType;

import java.util.Map;

public class View {
    public void barHpSpEntity(Entity e, StatType statType){
        String tmp = "";
        Integer currentValue = 0;
        Integer maxValue = 0;
        if (statType.equals(StatType.hp)){
            tmp = "HP : [";
            currentValue = e.getCurrentHp();
            maxValue = e.getHp();
        }else if(statType.equals(StatType.sp)){
            tmp = "SP : [";
            currentValue = e.getCurrentSp();
            maxValue = e.getSp();
        }

        for (int i = 0; i < currentValue; i++) {
            tmp+="#";
        }
        for (int i = currentValue;i < maxValue;i++){
            tmp+=" ";
        }
        tmp+="] "+currentValue+" / "+maxValue;
        System.out.println(tmp);

    }
    public void entityAffichage(){}
    public void printSeparator(int size,String separator){
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(separator);
        }
        System.out.println();
    }

    public void regenText() {
        System.err.println("--- REGENERATION DE VOTRE HERO ---");
    }
    public void recapButinText(Inventory inventory){
        System.out.println();
        inventory.toString();
        System.out.println("------ Butin ------");
        for(Map.Entry mapEntry : inventory.getInventory().entrySet()){
            System.out.println("- "+mapEntry.getValue()+" "+ mapEntry.getKey());
        }
        System.out.println("-------------------");
    }
    public void printFullNoHideMap(MapGame map){
        Entity[][] tabEntities = map.getTabEntities();
        for (int i = 0; i < tabEntities.length; i++) {
            System.out.println();
            for (int j = 0; j < tabEntities[i].length; j++) {
                System.out.print(" # "+(tabEntities[i][j] == null ? " " : tabEntities[i][j].getClass().getSimpleName().charAt(0)));
            }
            System.out.println(" #");
        }
    }
    public void printFullHideMap(MapGame map){
        Entity[][] tabEntities = map.getTabEntities();
        for (int i = 0; i < tabEntities.length; i++) {
            System.out.println();
            for (int j = 0; j < tabEntities[i].length; j++) {
                System.out.print(" # "+"_");
            }
            System.out.println(" #");
        }
    }
    public void printFullHideMap(MapGame map, int positionX,int positionY){
        Entity[][] tabEntities = map.getTabEntities();
        for (int i = 0; i < tabEntities.length; i++) {
            System.out.println();
            for (int j = 0; j < tabEntities[i].length; j++) {
                System.out.print(" # "+(positionX == i && positionY == j? "P" : "_"));
            }
            System.out.println(" #");
        }
    }
    public void printTitleGame(){
        printSeparator(100,"-");
        System.out.print("    __  __                             _    _______    __  ___                 __                \n" +
                "   / / / /__  _________  ___  _____   | |  / / ___/   /  |/  /___  ____  _____/ /____  __________\n" +
                "  / /_/ / _ \\/ ___/ __ \\/ _ \\/ ___/   | | / /\\__ \\   / /|_/ / __ \\/ __ \\/ ___/ __/ _ \\/ ___/ ___/\n" +
                " / __  /  __/ /  / /_/ /  __(__  )    | |/ /___/ /  / /  / / /_/ / / / (__  ) /_/  __/ /  (__  ) \n" +
                "/_/ /_/\\___/_/   \\____/\\___/____/     |___//____/  /_/  /_/\\____/_/ /_/____/\\__/\\___/_/  /____/  \n");
        printSeparator(100,"-");

    }

    public void recapChoiceOfPlayer(Hero hero) {
        System.out.println("You choose "+ hero.getClass().getSimpleName()+" and his name is "+hero.getName());
    }

    public void printDeathScreen() {
        printSeparator(90,"-");
        System.out.print("___  _ ____  _       ____  ____  _____   ____  _____ ____  ____ \n" +
                "\\  \\///  _ \\/ \\ //\\  /  _ \\/  __\\/  __/  /  _ \\/  __//  _ \\/  _ \\\n" +
                " \\  / | / \\|| | ||  | / \\||  \\/||  \\    | | \\||  \\  | / \\|| | \\|\n" +
                " / /  | \\_/|| \\_/|  | |-|||    /|  /_   | |_/||  /_ | |-||| |_/|\n" +
                "/_/   \\____/\\____/  \\_/ \\|\\_/\\_\\\\____\\  \\____/\\____\\\\_/ \\|\\____/\n");
        printSeparator(90,"-");
    }
}
