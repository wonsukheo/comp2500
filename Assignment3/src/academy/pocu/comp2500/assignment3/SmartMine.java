package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SmartMine extends Mine implements ICollisionable {
    private static final char SYMBOL = 'A';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
    private static final byte VISION = 1;
    private static final byte AOE = 1;
    private static final int MAX_HP = 1;
    private static final int AP = 15;
    private static final List<UnitType> TARGET_TYPE = Arrays.asList(UnitType.GROUND);

    private final int autoDetonateCount;

    public SmartMine(IntVector2D position, int detonateCount, int autoDetonateCount) {
        super(SYMBOL, VISION, AOE, AP, position, detonateCount);

        this.autoDetonateCount = autoDetonateCount;
    }

    public void updateDetonateCount(ArrayList<Unit> units) {
        super.updateDetonateCount(units);

        if (getUnitsInVision(units).size() >= autoDetonateCount) {
            this.isDetonate = true;
        }
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();

        attackIntent.setAttackUnit(this);

        attackIntent.addTarget(this.position, AP);

        double aoeDamage = AP * (1 - 1 / (double) (AOE + 1));

        int x = this.position.getX();
        int y = this.position.getY();

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i == x && j == y) {
                    continue;
                }

                attackIntent.addTarget(new IntVector2D(i, j), (int) aoeDamage);
            }
        }

        return attackIntent;
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

                if (unit.getSymbol() == 'N' || unit.getSymbol() == 'A') {
                    continue;
                }

                unitsInVision.add(unit);
            }
        }

        return unitsInVision;
    }
}
