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
    protected UnitAction action = UnitAction.NONE;
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

    public void updateAction() {
        if (getTargetableUnits(instance.getUnits()).size() > 0) {
            action = UnitAction.ATTACK;
        } else if (getUnitsInVision(instance.getUnits()).size() > 0) {
            action = UnitAction.MOVE;
        } else {
            action = UnitAction.NONE;
        }
    }

    public AttackIntent attack() {

        return null;
    }

    public void onAttacked(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public abstract void onSpawn();

    public ArrayList<Unit> getUnitsInVision(ArrayList<Unit> unitsOnMap) {
        int x = this.position.getX();
        int y = this.position.getY();

        ArrayList<Unit> unitsInVision = new ArrayList<>();

        for (Unit unit : unitsOnMap) {
            if (Math.abs(unit.position.getX() - x) <= this.vision && Math.abs(unit.position.getY() - y) <= this.vision && this.targetable.contains(unit.unitType)) {
                if (unit == this) {
                    continue;
                }
                // Mine is not detectable
                if (unit.getSymbol() == 'N' || unit.getSymbol() == 'A') {
                    continue;
                }

                unitsInVision.add(unit);
            }
        }

        return unitsInVision;
    }

    public abstract ArrayList<IntVector2D> getTargetablePositions();

    public ArrayList<Unit> getTargetableUnits(ArrayList<Unit> unitsOnMap) {
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

        return targetableUnitList;
    }

    public ArrayList<Unit> getUnitsClosest(ArrayList<Unit> unitsInVision) {
        int x = this.position.getX();
        int y = this.position.getY();

        ArrayList<Unit> closestUnits = new ArrayList<>();

        int closestDistance = Integer.MAX_VALUE;

        for (Unit unit : unitsInVision) {
            int unitX = unit.position.getX();
            int unitY = unit.position.getY();

            int ManhattanDistance = Math.abs(x - unitX) + Math.abs(y - unitY);

            if (ManhattanDistance < closestDistance) {
                closestDistance = ManhattanDistance;
                closestUnits.add(unit);
            }
        }

        ArrayList<Unit> removeUnits = new ArrayList<>();

        for (Unit unit : closestUnits) {
            int otherX = unit.position.getX();
            int otherY = unit.position.getY();

            int distance = Math.abs(x - otherX) + Math.abs(y - otherY);

            if (distance > closestDistance) {
                removeUnits.add(unit);
            }
        }

        closestUnits.removeAll(removeUnits);

        return closestUnits;
    }

    public ArrayList<Unit> getUnitsLowHP(ArrayList<Unit> units) {
        int lowHP = Integer.MAX_VALUE;

        ArrayList<Unit> unitsLowHP = new ArrayList<>();

        for (Unit unit : units) {
            if (unit.getHp() < lowHP) {
                lowHP = unit.getHp();
                unitsLowHP.add(unit);
            }
        }

        ArrayList<Unit> removeUnits = new ArrayList<>();

        for (Unit unit : unitsLowHP) {
            if (unit.getHp() > lowHP) {
                removeUnits.add(unit);
            }
        }

        unitsLowHP.removeAll(removeUnits);

        return unitsLowHP;
    }

    public Unit getUnitXyOrNull(ArrayList<Unit> units) {
        for (Unit unit : units) {
            if (unit.position.getY() < this.position.getY()) {
                return unit;
            }
        }

        for (Unit unit : units) {
            if (unit.position.getX() > this.position.getX()) {
                return unit;
            }
        }

        for (Unit unit : units) {
            if (unit.position.getY() > this.position.getY()) {
                return unit;
            }
        }

        for (Unit unit : units) {
            if (unit.position.getX() < this.position.getX()) {
                return unit;
            }
        }

        return null;
    }
}
