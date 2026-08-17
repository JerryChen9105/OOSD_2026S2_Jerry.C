package java_foundation.hero_fight_game;

import java.util.ArrayList;
import java.util.List;

public class BattleField {

    private static int turnNum = 1;

    public static void main(String[] args) {

        List<Hero> heroList = new ArrayList<>();
        Warrior warrior1 = new Warrior("aaa", 25, 35);
        Mage mage1 = new Mage("bbb", 50, 35, 15);
        Warrior warrior2 = new Warrior("ccc", 60, 10);
        Mage mage2 = new Mage("ddd", 10, 55, 40);
        heroList.add(warrior1);
        heroList.add(mage1);
        heroList.add(warrior2);
        heroList.add(mage2);

        System.out.println(" ");
        for (int i = 0; i < 4; i++) {
            turnStart();
            heroList.forEach(hero -> hero.attack());
        }

    }

    public static void turnStart() {
        System.out.printf("--- 第%d回合开始 ---\n\n", turnNum);
        turnNum++;
    }

}
