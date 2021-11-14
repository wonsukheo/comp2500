package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mine extends Unit implements ICollisionable {
    private static final char SYMBOL = 'N';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
    private static final byte VISION = 0;
    private static final byte AOE = 0;
    private static final byte MAX_HP = 1;
    private static final byte AP = 10;
    private static final List<UnitType> TARGET_TYPE = Arrays.asList(UnitType.GROUND);
    private static final UnitAction unitAction = UnitAction.NONE;

    private int detonateCount;
    private ArrayList<Unit> unitsOnTopLast = new ArrayList<>();
    protected boolean isDetonate;

    public Mine(IntVector2D position, int detonateCount) {
        this(SYMBOL, VISION, AOE, AP, position, detonateCount);
    }

    protected Mine(char symbol, byte vision, byte aoe, byte ap, IntVector2D position, int detonateCount) {
        super(symbol, UNIT_TYPE, vision, aoe, MAX_HP, ap, TARGET_TYPE);

        this.position = position;
        this.detonateCount = detonateCount;
    }

    public boolean isDetonate() {
        return isDetonate;
    }

    public ArrayList<IntVector2D> getTargetablePositions() {
        ArrayList<IntVector2D> positions = new ArrayList<>();

        positions.add(this.position);

        return positions;
    }

    public ArrayList<Unit> getTargetableUnits(ArrayList<Unit> unitsOnMap) {
        return new ArrayList<>();
    }

    public void updateDetonateCount(ArrayList<Unit> unitsOnMap) {
        ArrayList<Unit> unitsOnTop = new ArrayList<>();

        for (Unit unit : unitsOnMap) {
            if (unit.getPosition().equals(this.position) && unit != this) {
                if (unit.unitType == UnitType.GROUND) {
                    unitsOnTop.add(unit);
                }
            }
        }

        detonateCount -= unitsOnTop.size();

        if (detonateCount <= 0) {
            isDetonate = true;
        }
    }

    public boolean setPosition(IntVector2D newPosition) {
        return false;
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();

        attackIntent.setAttackUnit(this);

        attackIntent.addTarget(this.position, AP);

        return attackIntent;
    }

    public void updateAction() {
        if (isDetonate) {
            this.action = UnitAction.ATTACK;
        }
    }

    public void onSpawn() {
        this.instance = SimulationManager.getInstance();

        this.instance.addUnit(this);
        this.instance.registerCollisionEventListener(this);
    }

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
}
