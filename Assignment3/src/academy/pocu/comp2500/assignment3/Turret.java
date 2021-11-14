package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Turret extends Unit implements IThinkable {
    private static final char SYMBOL = 'U';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
    private static final byte VISION = 2;
    private static final byte AOE = 0;
    private static final int MAX_HP = 99;
    private static final int AP = 7;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.AIR);

    public Turret(IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, VISION, AOE, MAX_HP, AP, TARGETABLE);
        this.position = position;
    }

    public void updateAction() {
        if (getTargetableUnits(instance.getUnits()).size() > 0) {
            action = UnitAction.ATTACK;
        } else {
            action = UnitAction.NONE;
        }
    }

    public ArrayList<IntVector2D> getTargetablePositions() {
        ArrayList<IntVector2D> positions = new ArrayList<>();

        int x = this.position.getX();
        int y = this.position.getY();

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                positions.add(new IntVector2D(i, j));
            }
        }

        return positions;
    }

    public IntVector2D targetLogicOrNull(ArrayList<Unit> unitsInTargetPosition) {
        ArrayList<Unit> units = getUnitsLowHP(unitsInTargetPosition);

        if (units.size() < 1) {
            return null;
        } else if (units.size() == 1) {
            return units.get(0).position;
        }

        for (Unit unit : units) {
            if (unit.position.equals(this.position)) {
                return this.position;
            }
        }

        Unit targetUnit = getUnitXyOrNull(units);

        return targetUnit == null ? null : targetUnit.position;
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();
        IntVector2D targetPosition = targetLogicOrNull(getTargetableUnits(this.instance.getUnits()));

        if (targetPosition == null) {
            return null;
        }

        attackIntent.setAttackUnit(this);

        attackIntent.addTarget(targetPosition, AP);

        return attackIntent;
    }

    public void onSpawn() {
        this.instance = SimulationManager.getInstance();

        this.instance.addUnit(this);
        this.instance.registerThinkable(this);
    }
}
