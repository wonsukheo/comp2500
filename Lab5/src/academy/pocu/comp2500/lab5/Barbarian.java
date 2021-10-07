package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    private int attack;
    private int defense;
    private int hp;

    public Barbarian (String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void attack(Barbarian target) {
        double damage = (attack - target.getDefense()) / 2;

        target.setHp(target.getHp() - Math.max(1, (int)damage));
    }

    public boolean isAlive() {
        return hp > 0 ? true : false;
    }
}
