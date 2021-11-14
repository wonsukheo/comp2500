package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tank extends Unit implements IMovable, IThinkable {
    private static final char SYMBOL = 'T';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
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

    public ArrayList<IntVector2D> getTargetablePositions() {
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

    public void updateAction() {
        if (getUnitsInVision(instance.getUnits()).size() > 0) {
            action = UnitAction.ATTACK;
        } else if (getUnitsInVision(instance.getUnits()).size() == 0) {
            action = UnitAction.MOVE;
        }
    }

    public IntVector2D moveLogic(ArrayList<Unit> unitsInVision) {
        // pre- req: arg.size() >= 0
        if (unitsInVision.size() < 1) {
            if (this.mode == TankMode.SIEGE_MODE) {
                this.mode = TankMode.TANK_MODE;
                return this.position;
            }
        }

        if (this.mode == TankMode.SIEGE_MODE) {
            this.mode = TankMode.TANK_MODE;
            return this.position;
        }

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

    public IntVector2D targetLogicOrNull(ArrayList<Unit> unitsInTargetPosition) {
        if (this.mode == TankMode.TANK_MODE) {
            this.mode = TankMode.SIEGE_MODE;

            return null;
        }

        ArrayList<Unit> units = getUnitsLowHP(unitsInTargetPosition);

        if (units.size() < 1) {
            return null;
        } else if (units.size() == 1) {
            return units.get(0).position;
        }

        return getUnitXyOrNull(units).position;
    }

    public AttackIntent attack() {
        AttackIntent attackIntent = new AttackIntent();
        IntVector2D targetPosition = targetLogicOrNull(getTargetableUnits(this.instance.getUnits()));

        if (targetPosition == null) {
            return new AttackIntent();
        }

        attackIntent.setAttackUnit(this);

        attackIntent.addTarget(targetPosition, AP);

        ArrayList<IntVector2D> aoePosition = new ArrayList<>();
        double aoeDamage = AP * (1 - 1 / (double) (AOE + 1));
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
            attackIntent.addTarget(position, (int) aoeDamage);
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
