package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Destroyer extends Unit {
    private static final char SYMBOL = 'D';
    private static final UnitType UNIT_TYPE = UnitType.UNKNOWN;
    private static final byte VISION = 0;
    private static final byte AOE = 0;
    private static final byte MAX_HP = 0;
    private static final byte AP = Byte.MAX_VALUE;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.GROUND, UnitType.AIR);

    public Destroyer(IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, VISION, AOE, MAX_HP, AP, TARGETABLE);
        this.position = position;
    }

    public ArrayList<IntVector2D> getTargetablePositions(){
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
            attackIntent.addTarget(position, this.AP);
        }


        return attackIntent;
    }
}