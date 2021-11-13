package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SmartMine extends Mine {
    private static final char SYMBOL = 'A';
    private static final UnitType UNIT_TYPE= UnitType.GROUND;
    private static final byte VISION = 1;
    private static final byte AOE = 1;
    private static final byte MAX_HP = 1;
    private static final byte AP = 15;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.GROUND);

    private final int autoDetonateCount;

    public SmartMine(IntVector2D position, int detonateCount, int autoDetonateCount) {
        super(SYMBOL, VISION, AOE, AP, position, detonateCount);
        this.autoDetonateCount = autoDetonateCount;
    }

    public void checkAutoDetonateCount(ArrayList<Unit> units) {
        checkDetonateCount(units);
        int count = getUnitsInVisionOrNull(units).size();

        if (count >= autoDetonateCount) {
            isDetonate = true;
        }
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();

        attackIntent.setAttackUnit(this);

        attackIntent.addTarget(this.position, this.AP);

        ArrayList<IntVector2D> aoePosition = new ArrayList<>();
        double aoeDamage = this.AP * (1 - 1 / (double) (AOE + 1));
        int x = this.position.getX();
        int y = this.position.getY();

        aoePosition.add(new IntVector2D(x - 1, y));
        aoePosition.add(new IntVector2D(x, y - 1));
        aoePosition.add(new IntVector2D(x + 1, y - 1));
        aoePosition.add(new IntVector2D(x + 1, y + 1));
        aoePosition.add(new IntVector2D(x + 1, y));
        aoePosition.add(new IntVector2D(x, y + 1));
        aoePosition.add(new IntVector2D(x - 1, y - 1));
        aoePosition.add(new IntVector2D(x - 1, y + 1));

        for (IntVector2D position : aoePosition) {
            attackIntent.addTarget(position, (int) aoeDamage);
        }

        return attackIntent;
    }
}
