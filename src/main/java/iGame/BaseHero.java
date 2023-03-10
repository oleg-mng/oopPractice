package iGame;

import java.util.Random;

public class BaseHero {
    public static int number;
    public static Random r;

    protected String name;
    protected int hp;
    protected int maxHp;

    static {
        number = 0;
        Random r = new Random();
    }

    public BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public String getInfo() {
        return String.format("name: %s   hp: %d   type: %s", name, hp, getClass().getSimpleName());
    }

//    public void healed(int hp) {
//        this.hp = (hp + this.hp) > maxHp ? this.maxHp : hp + this.hp;

    public void healed (BaseHero point) {
        int cure = BaseHero.r.nextInt(3, 7);
        point.getCure(cure);
    }

    public void attack (BaseHero target){
        int damage = BaseHero.r.nextInt(10, 30);
        target.getDamage(damage);
    }

//    public int attack() {
//        int damage = BaseHero.r.nextInt(20, 30);
//        this.hp -= damage * 0.8;
//        if (hp < 0) {
//            return 0;
//        } else {
//            return damage;
//        }
//    }

    public void getDamage(int damage) {
        if ((this.hp - damage) > 0) {
            this.hp -= damage;
        }
    }
    public void getCure(int cure) {
        if ((hp  + cure) < maxHp) {
            hp  += cure;
    }
    }
}

