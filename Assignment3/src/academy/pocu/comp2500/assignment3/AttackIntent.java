package academy.pocu.comp2500.assignment3;

import java.util.HashMap;

public class AttackIntent {
    private HashMap<IntVector2D, Integer> targetPositions = new HashMap<>();
    private Unit attackUnit;

    public void addTarget(IntVector2D position, int damage) {
        targetPositions.put(position, damage);
    }

    public HashMap<IntVector2D, Integer> getTargetPositions() {
        return targetPositions;
    }

    public void setAttackUnit(Unit unit) {
        attackUnit = unit;
    }

    public Unit getAttackUnit() {
        return attackUnit;
    }
}
