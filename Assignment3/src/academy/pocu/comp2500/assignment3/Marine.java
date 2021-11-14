package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Marine extends Unit implements IMovable, IThinkable {
    private static final char SYMBOL = 'M';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
    private static final byte VISION = 2;
    private static final byte AOE = 0;
    private static final byte MAX_HP = 35;
    private static final byte AP = 6;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.GROUND, UnitType.AIR);

    public Marine(IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, VISION, AOE, MAX_HP, AP, TARGETABLE);
        this.position = position;
    }

    public ArrayList<IntVector2D> getTargetablePositions() {
        // tile range check??
        ArrayList<IntVector2D> positions = new ArrayList<>();

        int x = this.position.getX();
        int y = this.position.getY();

        positions.add(this.position);

        int i = 1;
        positions.add(new IntVector2D(x + i, y));
        positions.add(new IntVector2D(x, y + i));
        positions.add(new IntVector2D(x - i, y));
        positions.add(new IntVector2D(x, y - i));

        return positions;
    }

    private IntVector2D moveAI(IntVector2D destination) {
        int x = this.position.getX();
        int y = this.position.getY();

        int destX = destination.getX();
        int destY = destination.getY();

        if (destY != y) {
            if (destY > y) {
                return new IntVector2D(x, y + 1);
            } else {
                return new IntVector2D(x, y - 1);
            }
        }

        if (destX != x) {
            if (destX > x) {
                return new IntVector2D(x + 1, y);
            } else {
                return new IntVector2D(x - 1, y);
            }
        }

        return this.position;
    }

    public IntVector2D moveLogic(ArrayList<Unit> unitsInVision) {
        // pre- req: arg.size() > 0
        ArrayList<Unit> units = getUnitsLowHP(getUnitsClosest(unitsInVision));

        Unit target = getUnitXyOrNull(units);

        return moveAI(target.position);
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
                return unit.position;
            }
        }

        return getUnitXyOrNull(units).position;
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();
        IntVector2D targetPosition = targetLogicOrNull(getTargetableUnits(this.instance.getUnits()));

        if (targetPosition == null) {
            return new AttackIntent();
        }

        attackIntent.setAttackUnit(this);

        attackIntent.addTarget(targetPosition, AP);

        return attackIntent;
    }

    public void onSpawn() {
        this.instance = SimulationManager.getInstance();

        this.instance.addUnit(this);
        this.instance.registerMovable(this);
        this.instance.registerThinkable(this);
    }
}
