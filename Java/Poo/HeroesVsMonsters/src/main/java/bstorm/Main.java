package bstorm;

import bstorm.models.MapGame;
import bstorm.models.characters.heroes.Hero;
import bstorm.models.characters.heroes.Warrior;
import bstorm.models.characters.monsters.Dragon;
import bstorm.models.characters.monsters.Monster;
import bstorm.models.properties.StatType;
import bstorm.utils.View;

public class Main {
    public static void main(String[] args) {
//        View v = new View();
//        MapGame map = new MapGame(5,5);
//        Hero h = new Warrior("Rocky");
//        Monster m = new Dragon();
//        m.addIsDeadSubscriber(h::loot);
//        Monster m1 = new Dragon();
//        m1.addIsDeadSubscriber(h::loot);
//
//        System.out.println(h.getName());
//        v.barHpSpEntity(h, StatType.hp);
//        v.barHpSpEntity(h,StatType.sp);
//        System.out.println(m.getClass().getSimpleName());
//        v.barHpSpEntity(m, StatType.hp);
//        v.barHpSpEntity(m,StatType.sp);
//        while(h.isAlive() && m.isAlive()){
//            v.printSeparator(90,"_");
//            h.hit(m);
//            if(m.isAlive()) {
//                m.hit(h);
//            }
//            System.out.println(h.getName());
//            v.barHpSpEntity(h, StatType.hp);
//            v.barHpSpEntity(h,StatType.sp);
//            System.out.println(m.getClass().getSimpleName());
//            v.barHpSpEntity(m, StatType.hp);
//            v.barHpSpEntity(m,StatType.sp);
//        }
//        v.recapButinText(m.getInventory());
//        v.regenText();
        //v.printFullNoHideMap(map);
        //v.printFullHideMap(map);
        //System.out.println(h.getInventory().getInventory());
        Controler controler = new Controler();
        controler.start(5,5);

    }
}