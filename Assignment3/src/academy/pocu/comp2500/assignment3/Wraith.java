package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Wraith extends Unit implements IMovable, IThinkable {
    private static final char SYMBOL = 'W';
    private static final UnitType UNIT_TYPE = UnitType.AIR;
    private static final byte VISION = 4;
    private static final byte AOE = 0;
    private static final int MAX_HP = 80;
    private static final int AP = 6;
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

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i != x && j != y) {
                    continue;
                }
                positions.add(new IntVector2D(i, j));
            }
        }

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
        if (unitsInVision.size() < 1) {
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

        ArrayList<Unit> targetUnits = new ArrayList<>();

        if (airUnits.size() > 0) {
            targetUnits = getUnitsClosest(airUnits);
        } else {
            targetUnits = getUnitsClosest(groundUnits);
        }

        return moveAI(getUnitXyOrNull(getUnitsLowHP(targetUnits)).position);
    }

    public IntVector2D targetLogicOrNull(ArrayList<Unit> unitsInTargetPosition) {
        if (unitsInTargetPosition.size() < 1) {
            return null;
        } else if (unitsInTargetPosition.size() == 1) {
            return unitsInTargetPosition.get(0).position;
        }

        ArrayList<Unit> airUnits = new ArrayList<>();
        ArrayList<Unit> groundUnits = new ArrayList<>();

        for (Unit unit : unitsInTargetPosition) {
            if (unit.unitType == UnitType.AIR) {
                airUnits.add(unit);
            } else {
                groundUnits.add(unit);
            }
        }

        ArrayList<Unit> units = new ArrayList<>();
        if (airUnits.size() == 1) {
            return airUnits.get(0).position;
        } else if (airUnits.size() < 1) {
            units = groundUnits;
        } else {
            units = airUnits;
        }

        units = getUnitsLowHP(units);

        if (units.size() < 2) {
            return units.get(0).position;
        }

        for (Unit unit : units) {
            if (unit.position.equals(this.position)) {
                return this.position;
            }
        }

        Unit targetUnit = getUnitXyOrNull(units);

        return (targetUnit == null) ? null : targetUnit.position;
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

    public void onAttacked(int damage) {
        if (bShield) {
            damage = 0;
            bAttacked = true;
        }

        this.hp = Math.max(0, this.hp - damage);
    }

    public void updateAction() {
        if (bAttacked && bShield) {
            bShield = false;
        }

        if (getTargetableUnits(instance.getUnits()).size() > 0) {
            action = UnitAction.ATTACK;
        } else {
            action = UnitAction.MOVE;
        }
    }

    public void onSpawn() {
        this.instance = SimulationManager.getInstance();

        this.instance.addUnit(this);
        this.instance.registerMovable(this);
        this.instance.registerThinkable(this);
    }
}
