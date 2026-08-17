package java_foundation.hero_fight_game;

public class Warrior extends Hero {

    public Warrior(String name, int hp, int baseAttack) {
        super(name, hp, baseAttack);
    }

    @Override
    public void attack() {
        System.out.printf("%s 挥舞大剑发动【重击】, 造成 %d 点物理伤害!\n\n", this.getName(), this.getBaseAttack() + 20);
    }

}
