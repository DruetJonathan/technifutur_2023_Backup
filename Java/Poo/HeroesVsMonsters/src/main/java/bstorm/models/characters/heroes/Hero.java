package bstorm.models.characters.heroes;

import bstorm.models.characters.Entity;
import bstorm.models.characters.loots.Gold;
import bstorm.models.characters.loots.Inventory;
import bstorm.models.characters.loots.Leather;
import bstorm.models.characters.loots.ObjectLoot;
import bstorm.models.characters.monsters.Dragon;
import bstorm.models.characters.monsters.Troll;
import bstorm.models.characters.monsters.Wolf;
import bstorm.utils.Dice;

import java.util.Map;

public abstract class Hero extends Entity{

    private String name;

    public Hero(String name){

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void loot(Entity target){
        Inventory inventoryTarget = target.getInventory();
        for(Map.Entry mapEntry : inventoryTarget.getInventory().entrySet()){
            this.getInventory().addInventory((ObjectLoot) mapEntry.getKey(), (Integer) mapEntry.getValue());
        }
        regen();
    }

    public Inventory getInventory() {
        return super.getInventory();
    }

    public void goToLoot(Entity target){
        if (!target.isAlive()) loot(target);
    }
}
