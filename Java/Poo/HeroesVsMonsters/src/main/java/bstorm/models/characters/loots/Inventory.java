package bstorm.models.characters.loots;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<ObjectLoot,Integer> inventory;
    public Inventory() {
        this.inventory = new HashMap<>();
    }
    public void addInventory(ObjectLoot objectLoot, Integer quantity){
        Integer currentQty = inventory.get(objectLoot);
        inventory.put(objectLoot, currentQty == null ? quantity : currentQty + quantity);
    }

    public Map<ObjectLoot, Integer> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + inventory +
                '}';
    }
}
