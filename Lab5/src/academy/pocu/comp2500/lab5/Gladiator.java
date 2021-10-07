package academy.pocu.comp2500.lab5;

import java.util.ArrayList;

public class Gladiator extends Barbarian {
    private ArrayList<Move> moves = new ArrayList<>(4);

    public Gladiator (String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public boolean addMove(Move move) {
        if (moves.size() >= 4) {
            return false;
        } else if (moves.contains(move)) {
            return false;
        } else {
            moves.add(move);

            return true;
        }
    }

    public boolean removeMove(String moveName) {
        for (Move m : moves) {
            if (m.getName().equals(moveName)) {
                moves.remove(m);

                return true;
            }
        }

        return false;
    }

    public void attack(String moveName, Barbarian target) {
        for (Move m : moves) {
            if (m.getName().equals(moveName)) {
                if(m.getMaxPoint() > 0) {
                    double damage = (this.getAttack() * m.getPower() / target.getDefense() / 2);
                    target.setHp(target.getHp() - Math.max(1, (int)damage));

                    m.setMaxPoint(m.getMaxPoint() - 1);
                    break;
                }
            }
        }
    }

    public void rest() {
        this.setHp(this.getHp() + 10);

        for (Move m : moves) {
            m.setMaxPoint(m.getMaxPoint() + 1);
        }
    }
}
