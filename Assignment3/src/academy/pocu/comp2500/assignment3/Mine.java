package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mine extends Unit implements ICollisionable {
    private static final char SYMBOL = 'N';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
    private static final byte VISION = 0;
    private static final byte AOE = 0;
    private static final int MAX_HP = 1;
    private static final int AP = 10;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.GROUND);

    private int detonateCount;
    protected boolean isDetonate;

    public Mine(IntVector2D position, int detonateCount) {
        this(SYMBOL, VISION, AOE, AP, position, detonateCount);
    }

    protected Mine(char symbol, byte vision, int aoe, int ap, IntVector2D position, int detonateCount) {
        super(symbol, UNIT_TYPE, vision, aoe, MAX_HP, ap, TARGETABLE);

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
        for (Unit unit : unitsOnMap) {
            if (unit.getPosition().equals(this.position) && unit != this) {
                if (unit.unitType == UnitType.GROUND) {
                    detonateCount--;
                }
            }
        }

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
        action = UnitAction.NONE;
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
            if ((Math.abs(unit.position.getX() - x) <= this.vision) && (Math.abs(unit.position.getY() - y) <= this.vision) && (unit.unitType == UnitType.GROUND)) {
                if (unit == this) {
                    continue;
                }
                /*
                if (unit.getSymbol() == 'N' || unit.getSymbol() == 'A') {
                    continue;
                }*/

                unitsInVision.add(unit);
            }
        }

        return unitsInVision;
    }
}
