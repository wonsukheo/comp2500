package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    private int attack;
    private int defense;
    private int MAXHP;
    private int hp;

    public Barbarian(String name, int hp, int attack, int defense) {
        this.name = name;
        MAXHP = hp;
        this.hp = MAXHP;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        int temp = Math.max(0, hp);

        this.hp = Math.min(temp, MAXHP);
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void attack(Barbarian target) {
        if(isAlive() && target != this) {
            double damage = (attack - target.defense) / 2;

            target.setHp(target.hp - Math.max(1, (int) damage));
        }
    }

    public boolean isAlive() {
        return hp > 0 ? true : false;
    }
}
