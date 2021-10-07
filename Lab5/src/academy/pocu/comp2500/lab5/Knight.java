package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int maxHp, int attack, int defense) {
        super(name, maxHp, attack, defense);
    }

    public void setPet(Pet petOrNull) {
        pet = petOrNull;
    }

    public void attackTogether(Barbarian target) {
        if (this.isAlive() && target != this && pet != null) {
            double damage = (super.attack + pet.attack - target.defense) / 2;

            int temp = target.hp - Math.max(1, (int) damage);
            target.hp = Math.max(0, temp);
        }
    }
}
