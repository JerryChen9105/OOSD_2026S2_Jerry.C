package java_foundation.hero_fight_game;

public class Hero {
    private String name;
    private int hp;
    private int baseAttack;

    public Hero(String name, int hp, int baseAttack) {
        this.name = name;
        this.hp = hp;
        this.baseAttack = baseAttack;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getBaseAttack() {
        return this.baseAttack;
    }

    public void attack() {
        System.out.printf("%s 发动了普通攻击, 造成 %d 点伤害!\n\n", this.name, this.baseAttack);
    }

}
