package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Destroyer extends Unit {
    private static final char SYMBOL = 'D';
    private static final UnitType UNIT_TYPE = UnitType.AIR;
    private static final byte VISION = Byte.MAX_VALUE;
    private static final byte AOE = 0;
    private static final int MAX_HP = Integer.MAX_VALUE / 2;
    private static final int AP = Byte.MAX_VALUE * 2;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.GROUND, UnitType.AIR);

    public Destroyer(IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, VISION, AOE, MAX_HP, AP, TARGETABLE);
        this.position = position;
    }

    public ArrayList<IntVector2D> getTargetablePositions() {
        // tile range check??
        ArrayList<IntVector2D> positions = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 8; j++) {
                positions.add(new IntVector2D(i, j));
            }
        }

        return positions;
    }

    public void onAttacked(int damage) {
        damage = 1;
        this.hp = Math.max(0, this.hp - damage);
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();

        attackIntent.setAttackUnit(this);

        for (IntVector2D position : getTargetablePositions()) {
            attackIntent.addTarget(position, AP);
        }


        return attackIntent;
    }

    public void onSpawn() {
        this.instance = SimulationManager.getInstance();
        this.instance.addUnit(this);
    }
}