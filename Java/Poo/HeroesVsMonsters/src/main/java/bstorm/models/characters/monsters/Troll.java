package bstorm.models.characters.monsters;

import bstorm.models.characters.Entity;
import bstorm.models.characters.loots.Gold;
import bstorm.models.characters.loots.ObjectLoot;
import bstorm.models.properties.StatType;
import bstorm.utils.Dice;

public class Troll extends Monster{


    public Troll(){
        this.getInventory().addInventory(ObjectLoot.gold, Dice.D4.throwDice());
    }
    @Override
    public void hit(Entity target) {

        int damage = getStats().modifier(StatType.strength) + Dice.D4.throwDice();
        target.takeDamage(damage);
    }

    @Override
    public void generate(){

        getStats().appendStat(StatType.strength,3);
        super.generate();
    }

}
