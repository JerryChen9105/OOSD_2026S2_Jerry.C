package java_foundation.hero_fight_game;

public class Mage extends Hero {
    private int mp;

    public Mage(String name, int hp, int mp, int baseAttack) {
        super(name, hp, baseAttack);
        this.mp = mp;
    }

    public int getMp() {
        return this.mp;
    }

    @Override
    public void attack() {
        if (this.mp >= 10) {
            System.out.printf("%s 消耗10点MP, 吟唱【火球术】, ", this.getName());
            this.mp -= 10;
            System.out.printf("造成 %d 点魔法伤害! (剩余MP: %d)\n\n", this.getBaseAttack() * 2, this.mp);
        } else {
            super.attack();
        }
        
    }

}
