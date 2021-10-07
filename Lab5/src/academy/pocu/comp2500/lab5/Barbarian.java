package academy.pocu.comp2500.lab5;

public class Barbarian {
    protected String name;
    protected int attack;
    protected int defense;
    protected int maxHp;
    protected int hp;

    public Barbarian(String name, int maxHp, int attack, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        hp = this.maxHp;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Barbarian target) {
        if (isAlive() && target != this) {
            double damage = (attack - target.defense) / 2;

            target.hp -= Math.max(1, (int) damage);
        }
    }

    public boolean isAlive() {
        return hp > 0 ? true : false;
    }
}
