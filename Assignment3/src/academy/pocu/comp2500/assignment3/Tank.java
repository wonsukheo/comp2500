package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tank extends Unit implements IMoveable, IThinkable {
    private static final char SYMBOL = 'T';
    private static final UnitType UNIT_TYPE= UnitType.GROUND;
    private static final byte VISION = 3;
    private static final byte AOE = 1;
    private static final byte MAX_HP = 85;
    private static final byte AP = 8;
    private static final List<UnitType> TARGETABLE = Arrays.asList(UnitType.GROUND);

    private TankMode mode = TankMode.TANK_MODE;
    private boolean moveEast;

    public Tank(IntVector2D position) {
        super(SYMBOL, UNIT_TYPE, VISION, AOE, MAX_HP, AP, TARGETABLE);
        this.position = position;
        moveEast = true;
    }

    public ArrayList<IntVector2D> getTargetablePositions(){
        // tile range check??
        ArrayList<IntVector2D> positions = new ArrayList<>();

        int x = this.position.getX();
        int y = this.position.getY();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == j) || (i == 1 && j == 0) || (i == 0 && j == 1)) {
                    continue;
                }

                positions.add(new IntVector2D(x + i, y + j));
                positions.add(new IntVector2D(x - i, y - j));

                if (i == 0 || j == 0) {
                    continue;
                }

                positions.add(new IntVector2D(x - i, y + j));
                positions.add(new IntVector2D(x + i, y - j));
            }
        }

        return positions;
    }

    public IntVector2D moveAI(IntVector2D destinationOrNull) {
        int x = this.position.getX();
        int y = this.position.getY();

        if (x == 15) {
            this.moveEast = false;
        } else if (x == 0) {
            this.moveEast = true;
        }

        if (moveEast) {
            return new IntVector2D(x + 1, y);
        } else {
            return new IntVector2D(x - 1, y);
        }
    }

    public IntVector2D moveLogic(ArrayList<Unit> unitsInVision) {
        if (unitsInVision == null) {
            if (this.mode == TankMode.TANK_MODE) {
                return moveAI(null);
            } else {
                this.mode = TankMode.TANK_MODE;
                return this.position;
            }
        } else {
            this.mode = TankMode.SIEGE_MODE;
            return this.position;
        }
    }

    public IntVector2D targetLogicOrNull(ArrayList<Unit> unitsInTargetPositionOrNull) {
        if (unitsInTargetPositionOrNull == null) {
            return null;
        }

        if (this.mode == TankMode.TANK_MODE) {
            this.mode = TankMode.SIEGE_MODE;

            return null;
        }

        ArrayList<Unit> units = getUnitsLowHP(unitsInTargetPositionOrNull);

        if (units.size() < 2) {
            return units.get(0).position;
        }

        return getUnitsXY(units).position;
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();
        IntVector2D targetPosition = targetLogicOrNull(getTargetableUnitsOrNull(this.instance.getUnits()));

        if (targetPosition == null) {
            return null;
        }

        attackIntent.setAttackUnit(this);

        attackIntent.addTarget(targetPosition, this.AP);

        ArrayList<IntVector2D> aoePosition = new ArrayList<>();
        double aoeDamage = this.AP * (1 - 1 / (double) (AOE + 1));
        int x = targetPosition.getX();
        int y = targetPosition.getY();

        aoePosition.add(new IntVector2D(x - 1, y));
        aoePosition.add(new IntVector2D(x, y - 1));
        aoePosition.add(new IntVector2D(x + 1, y - 1));
        aoePosition.add(new IntVector2D(x + 1, y + 1));
        aoePosition.add(new IntVector2D(x + 1, y));
        aoePosition.add(new IntVector2D(x, y + 1));
        aoePosition.add(new IntVector2D(x - 1, y - 1));
        aoePosition.add(new IntVector2D(x - 1, y + 1));

        for (IntVector2D position : aoePosition) {
            attackIntent.addTarget(position, (int)aoeDamage);
        }

        return attackIntent;
    }

    public void onAttacked(int damage) {
        if (mode == TankMode.SIEGE_MODE) {
            damage *= 2;
        }

        this.hp = Math.max(0, this.hp - damage);
    }

    public void onSpawn() {
        this.instance = SimulationManager.getInstance();
        this.instance.addUnit(this);

        this.instance.registerMovable(this);
        this.instance.registerThinkable(this);
    }
}
