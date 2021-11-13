package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit {
    protected final char symbol;
    protected final UnitType unitType;
    protected final int vision;
    protected final int AOE;
    protected final int maxHP;
    protected final int AP;
    protected final List<UnitType> targetable;

    protected IntVector2D position;
    protected int hp;
    protected SimulationManager instance;
    protected UnitAction unitAction = UnitAction.NONE;
    protected boolean isAvailable;

    public Unit(char symbol, UnitType unitType, int vision, int aoe, int maxHp, int ap, List<UnitType> targetable) {
        this.symbol = symbol;
        this.unitType = unitType;
        this.vision = vision;
        this.AOE = aoe;
        this.maxHP = maxHp;
        this.AP = ap;
        this.targetable = targetable; //needs deep copy if can be changed.
        position = new IntVector2D(0, 0);
        hp = maxHP;
        isAvailable = true;
    }

    public IntVector2D getPosition() {
        return position;
    }

    public boolean setPosition(IntVector2D newPosition) {
        int x = newPosition.getX();
        int y = newPosition.getY();

        if (x < 0 || x > 15 || y < 0 || y > 7) {
            return false;
        }

        this.position = newPosition;
        return true;
    }

    public int getHp() {
        return hp;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setUnitAction() {
        if (getTargetableUnitsOrNull(instance.getUnits()) != null) {
            unitAction = UnitAction.ATTACK;
        } else if (getUnitsInVisionOrNull(instance.getUnits()) != null) {
            unitAction = UnitAction.MOVE;
        } else {
            unitAction = UnitAction.NONE;
        }
    }

    public AttackIntent attack() {

        return null;
    }

    public void onAttacked(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public abstract void onSpawn();

    protected ArrayList<Unit> getUnitsInVisionOrNull(ArrayList<Unit> unitsOnMap) {
        int x = this.position.getX();
        int y = this.position.getY();

        ArrayList<Unit> unitsInVision = new ArrayList<>();

        for (Unit unit : unitsOnMap) {
            if (unit != this && Math.abs(unit.position.getX() - x) <= this.vision && Math.abs(unit.position.getY() - y) <= this.vision && this.targetable.contains(unit.unitType)) {
                if (unit.getSymbol() == 'N' || unit.getSymbol() == 'A') {
                    continue;
                }
                unitsInVision.add(unit);
            }
        }

        return (unitsInVision.size() < 1) ? null : unitsInVision;
    }

    protected abstract ArrayList<IntVector2D> getTargetablePositions();

    protected ArrayList<Unit> getTargetableUnitsOrNull(ArrayList<Unit> unitsOnMap) {
        ArrayList<IntVector2D> targetablePositions = this.getTargetablePositions();

        ArrayList<Unit> targetableUnitList = new ArrayList<>();

        for (Unit unit : unitsOnMap) {
            if (unit.equals(this)) {
                continue;
            }

            for (IntVector2D position : targetablePositions) {
                if (unit.position.equals(position)) {
                    targetableUnitList.add(unit);
                    break;
                }
            }
        }

        return (targetableUnitList.size() == 0) ? null : targetableUnitList;
    }

    protected ArrayList<Unit> getUnitsClosest(ArrayList<Unit> unitsInVision) {
        int x = this.position.getX();
        int y = this.position.getY();

        ArrayList<Unit> closestUnitList = new ArrayList<>();

        int closestDistance = Integer.MAX_VALUE;

        for (Unit unit : unitsInVision) {
            int unitX = unit.position.getX();
            int unitY = unit.position.getY();

            int distance = Math.abs(x - unitX) + Math.abs(y - unitY);

            if (distance < closestDistance) {
                closestDistance = distance;
                closestUnitList.add(unit);
            }
        }
        ArrayList<Unit> toRemoved = new ArrayList<>();

        for (Unit unit : closestUnitList) {
            int unitX = unit.position.getX();
            int unitY = unit.position.getY();

            int distance = Math.abs(x - unitX) + Math.abs(y - unitY);

            if (distance > closestDistance) {
                toRemoved.add(unit);
            }
        }

        closestUnitList.removeAll(toRemoved);

        return closestUnitList;
    }

    protected ArrayList<Unit> getUnitsLowHP(ArrayList<Unit> units) {
        int lowHP = Integer.MAX_VALUE;

        ArrayList<Unit> unitsLowHP = new ArrayList<>();

            for (Unit unit : units) {
            if (unit.getHp() < lowHP) {
                lowHP = unit.getHp();
                unitsLowHP.add(unit);
            }
        }

        for (Unit unit : unitsLowHP) {
            if (unit.getHp() > lowHP) {
                unitsLowHP.remove(unit);
            }
        }

        return unitsLowHP;
    }

    protected Unit getUnitsXY(ArrayList<Unit> units) {
        Unit target = null;

        for (Unit unit : units) {
            if (unit.position.getY() < this.position.getY()) {
                target = unit;
                return target;
            }
        }

        for (Unit unit : units) {
            if (unit.position.getX() > this.position.getX()) {
                target = unit;
                return target;
            }
        }

        for (Unit unit : units) {
            if (unit.position.getY() > this.position.getY()) {
                target = unit;
                return target;
            }
        }

        for (Unit unit : units) {
            if (unit.position.getX() < this.position.getX()) {
                target = unit;
                return target;
            }
        }

        return target;
    }
}
