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

    public IntVector2D targetLogicOrNull(ArrayList<Unit> unitsInTargetPositionOrNull) {

        if (unitsInTargetPositionOrNull == null) {
            return null;
        }

        ArrayList<Unit> units = getUnitsLowHP(unitsInTargetPositionOrNull);


        if (units.size() < 2) {
            return units.get(0).position;
        }

        Unit target = null;

        for (Unit unit : units) {
            if (unit.position.equals(this.position)) {
                target = unit;
            }
        }

        if (target != null) {
            return target.position;
        } else {
            return getUnitsXY(units).position;
        }
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();
        IntVector2D targetPosition = targetLogicOrNull(getTargetableUnitsOrNull(this.instance.getUnits()));

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
