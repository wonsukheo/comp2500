package academy.pocu.comp2500.lab5;

import java.util.ArrayList;

public class Gladiator extends Barbarian {
    private ArrayList<Move> moves = new ArrayList<>(4);

    public Gladiator(String name, int maxHp, int attack, int defense) {
        super(name, maxHp, attack, defense);
    }

    public boolean addMove(Move move) {
        if (moves.size() >= 4) {
            return false;
        }

        for (Move m : moves) {
            if (m.name.equals(move.name)) {
                return false;
            }
        }

        moves.add(move);
        return true;
    }

    public boolean removeMove(String moveName) {
        for (Move m : moves) {
            if (m.name.equals(moveName)) {
                moves.remove(m);
                return true;
            }
        }

        return false;
    }

    public void attack(String moveName, Barbarian target) {
        if (super.isAlive() && target != this) {
            for (Move m : moves) {
                if (m.name.equals(moveName)) {
                    if (m.point > 0) {
                        double damage = (super.attack * m.power / target.defense / 2);

                        int temp = target.hp - Math.max(1, (int) damage);
                        target.hp = Math.max(0, temp);

                        m.point = Math.max(0, m.point - 1);
                        break;
                    }
                }
            }
        }
    }

    public void rest() {
        // hp? super.hp?
        // 상속을 받았으니 이젠 내꺼? 아니면 still 부모 변수를 명시적으로 표시?
        int temp = super.hp += 10;
        super.hp = Math.min(hp, maxHp);

        for (Move m : moves) {
            m.point = Math.min(m.point + 1, m.maxPoint);
        }
    }
}
