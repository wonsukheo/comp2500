package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    Pet pet;

    public Knight (String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public void setPet(Pet petOrNull) {
        this.pet = petOrNull;
    }

    public void attackTogether(Barbarian target) {
        if (this.pet != null) {
            double damage = (super.getAttack() + this.pet.getAttack() - target.getDefense()) / 2;

            target.setHp(target.getHp() - Math.max(1, (int)damage));
        }
    }
}
