package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Wraith extends Unit implements IMoveable, IThinkable {
    private static final char SYMBOL = 'W';
    private static final UnitType UNIT_TYPE = UnitType.AIR;
    private static final byte VISION = 4;
    private static final byte AOE = 0;
    private static final byte MAX_HP = 80;
    private static final byte AP = 6;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.GROUND, UnitType.AIR);
    //can detect both AIR & GROUND withtin vision

    private final IntVector2D initialPosition;
    private boolean bShield = true;
    private boolean bAttacked = false;

    public Wraith(IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, VISION, AOE, MAX_HP, AP, TARGETABLE);
        this.position = position;
        this.initialPosition = position;
    }

    public ArrayList<IntVector2D> getTargetablePositions() {
        // tile range check??
        ArrayList<IntVector2D> positions = new ArrayList<>();

        int x = this.position.getX();
        int y = this.position.getY();

        positions.add(new IntVector2D(x, y));

        int i = 1;
        positions.add(new IntVector2D(x + i, y));
        positions.add(new IntVector2D(x, y + i));
        positions.add(new IntVector2D(x - i, y));
        positions.add(new IntVector2D(x, y - i));

        return positions;
    }

    public IntVector2D moveAI(IntVector2D destination) {
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
        if (unitsInVision == null) {
            return moveAI(this.initialPosition);
        }

        ArrayList<Unit> airUnits = new ArrayList<>();
        ArrayList<Unit> groundUnits = new ArrayList<>();

        for (Unit unit : unitsInVision) {
            if (unit.unitType == UnitType.AIR) {
                airUnits.add(unit);
            } else {
                groundUnits.add(unit);
            }
        }

        ArrayList<Unit> closestUnits = new ArrayList<>();

        if (airUnits.size() > 1) {
            closestUnits = getUnitsClosest(airUnits);
        } else {
            closestUnits = getUnitsClosest(groundUnits);
        }

        ArrayList<Unit> lowHPUnits = new ArrayList<>();

        if (closestUnits.size() > 1) {
            lowHPUnits = getUnitsLowHP(closestUnits);
        } else {
            return moveAI(closestUnits.get(0).position);
        }

        Unit target = null;

        if (lowHPUnits.size() > 1) {
            target = getUnitsXY(lowHPUnits);
        } else {
            return moveAI(lowHPUnits.get(0).position);
        }

        return moveAI(target.position);
    }

    public IntVector2D targetLogicOrNull(ArrayList<Unit> unitsInTargetPositionOrNull) {
        if (unitsInTargetPositionOrNull == null) {
            return null;
        }

        ArrayList<Unit> airUnits = new ArrayList<>();
        ArrayList<Unit> groundUnits = new ArrayList<>();

        for (Unit unit : unitsInTargetPositionOrNull) {
            if (unit.unitType == UnitType.AIR) {
                airUnits.add(unit);
            } else {
                groundUnits.add(unit);
            }
        }

        ArrayList<Unit> units = new ArrayList<>();
        if (airUnits.size() == 1) {
            return airUnits.get(0).position;
        } else if (airUnits.size() <= 0) {
            units = groundUnits;
        } else {
            units = airUnits;
        }

        units = getUnitsLowHP(units);

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

    public void onAttacked(int damage) {
        if (bShield) {
            damage = 0;
            bAttacked = true;
        }

        this.hp = Math.max(0, this.hp - damage);
    }

    public void setUnitAction() {
        if (bAttacked) {
            bShield = false;
        }
        if (getTargetableUnitsOrNull(instance.getUnits()) != null) {
            unitAction = UnitAction.ATTACK;
        } else if (getUnitsInVisionOrNull(instance.getUnits()) != null) {
            unitAction = UnitAction.MOVE;
        } else {
            unitAction = UnitAction.NONE;
        }
    }

    public void onSpawn() {
        this.instance = SimulationManager.getInstance();
        this.instance.addUnit(this);

        this.instance.registerMovable(this);
        this.instance.registerThinkable(this);
    }

}
