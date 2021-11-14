package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Turret extends Unit implements IThinkable {
    private static final char SYMBOL = 'U';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
    private static final byte VISION = 2;
    private static final byte AOE = 0;
    private static final byte MAX_HP = 99;
    private static final byte AP = 7;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.AIR);

    public Turret(IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, VISION, AOE, MAX_HP, AP, TARGETABLE);
        this.position = position;
    }

    public ArrayList<IntVector2D> getTargetablePositions() {
        // tile range check??
        ArrayList<IntVector2D> positions = new ArrayList<>();

        int x = this.position.getX();
        int y = this.position.getY();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                if (i == 0 && j == 0) {
                    positions.add(this.position);
                } else {
                    positions.add(new IntVector2D(x + i, y + i));
                    positions.add(new IntVector2D(x - i, y - i));

                    if (i == 1 && j == 1) {
                        positions.add(new IntVector2D(x + i, y - i));
                        positions.add(new IntVector2D(x - i, y + i));
                    }
                }
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
