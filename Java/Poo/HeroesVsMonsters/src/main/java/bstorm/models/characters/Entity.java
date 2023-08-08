package bstorm.models.characters;

import bstorm.interfaces.isDeadSubscriber;
import bstorm.models.characters.heroes.Hero;
import bstorm.models.characters.loots.Inventory;
import bstorm.models.characters.monsters.Monster;
import bstorm.models.properties.StatType;
import bstorm.models.properties.Stats;
import bstorm.utils.Dice;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    private Stats stats;

    private Integer currentHp;

    private Integer currentSp;
    private Inventory inventory;

    public Entity(){
        this.stats = new Stats();
        this.inventory = new Inventory();

        generate();
        regen();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Stats getStats() {
        return stats;
    }

    public Integer getCurrentSp() {
        return currentSp;
    }

    private void setCurrentSp(Integer currentSp) {
        this.currentSp = currentSp;
    }

    public Integer getCurrentHp(){

        return currentHp;
    }

    private void setCurrentHp(Integer value){

//        currentHp = value < 0 ? 0 : value > getHp() ? getHp() : value;
        currentHp = value < 0 ? 0 : Math.min(getHp(),value);
    }

    public Integer getHp(){
        return stats.getStat(StatType.hp);
    }

    public Integer getSp(){
        return stats.getStat(StatType.sp);
    }

    public Integer getStrength(){
        return stats.getStat(StatType.strength);
    }

    public Integer getIntelligence(){
        return stats.getStat(StatType.intelligence);
    }

    public boolean isAlive(){
        return getCurrentHp() > 0;
    }

    public void regen(){

        setCurrentHp(getHp());
        setCurrentSp(getSp());
    }

    public void takeDamage(int amount){

        if(currentHp == null)
            return;

        if(amount < 0)
            return;

        setCurrentHp(getCurrentHp() - amount);
        if (currentHp <= 0)
            raiseIsDeadEvent();
    }

    protected void generate(){

        if(this instanceof Hero)
            getStats().generate(Dice.D6);
        if(this instanceof Monster)
            getStats().generate(Dice.D4);
    }

    public abstract void hit(Entity target);
    private final List<isDeadSubscriber> isDeadSubscriberList = new ArrayList<>();

    public void addIsDeadSubscriber(isDeadSubscriber subscriber){
        isDeadSubscriberList.add(subscriber);
    }
    public void removeIsDeadSubscriber(isDeadSubscriber subscriber){
        isDeadSubscriberList.remove(subscriber);
    }
    public void raiseIsDeadEvent(){
        isDeadSubscriberList.forEach(subscriber -> {
            subscriber.execute(this);
        });
    }
}


















