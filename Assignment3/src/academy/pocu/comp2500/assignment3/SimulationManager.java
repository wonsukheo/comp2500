package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashMap;

public final class SimulationManager {
    private static SimulationManager instance;

    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<IThinkable> thinkableUnits = new ArrayList<>();
    private HashMap<IMovable, IntVector2D> movableUnits = new HashMap<>();
    private ArrayList<ICollisionable> collisionListenerUnits = new ArrayList<>();

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }

        return instance;
    }

    private SimulationManager() {
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    public void spawn(Unit unit) {
        unit.onSpawn();
    }

    public void registerThinkable(IThinkable thinkable) {
        this.thinkableUnits.add(thinkable);
    }

    public void registerMovable(IMovable movable) {
        this.movableUnits.put(movable, ((Unit) movable).position);
    }

    public void registerCollisionEventListener(ICollisionable listener) {
        this.collisionListenerUnits.add(listener);
    }

    public void update() {
        // 0. update
        for (Unit unit : this.units) {
            unit.updateAction();
        }

        // 1. set move
        for (IMovable unit : movableUnits.keySet()) {
            if (((Unit) unit).action == UnitAction.MOVE) {
                movableUnits.put(unit, unit.moveLogic(((Unit) unit).getUnitsInVision(units)));
            }
        }

        // 3. attack
        ArrayList<AttackIntent> attackIntents = new ArrayList<>();

        for (IThinkable unit : thinkableUnits) {
            if (((Unit) unit).action == UnitAction.ATTACK) {
                attackIntents.add(((Unit) unit).attack());
            }
        }

        // attack - destroyer
        for (Unit unit : units) {
            if (unit.getSymbol() == 'D') {
                attackIntents.add(unit.attack());
            }
        }

        // 2. collision event
        for (ICollisionable unit : collisionListenerUnits) {
            unit.updateDetonateCount(units);

            if (unit.isDetonate()) {
                attackIntents.add(((Unit) unit).attack());
            }
        }

        //move
        for (IMovable unit : movableUnits.keySet()) {
            if (((Unit) unit).action == UnitAction.MOVE) {
                ((Unit) unit).position = movableUnits.get(unit);
            }
        }

        // 4. dmg
        for (AttackIntent attack : attackIntents) {
            HashMap<IntVector2D, Integer> targetPosition = attack.getTargetPositions();

            for (IntVector2D tPosition : targetPosition.keySet()) {
                for (Unit unit : units) {
                    if (unit.position.equals(tPosition)) {
                        if (unit.equals(attack.getAttackUnit())) {
                            continue;
                        }

                        if (attack.getAttackUnit().targetable.contains(unit.unitType)) {
                            unit.onAttacked(targetPosition.get(tPosition));
                        }
                    }
                }
            }
        }

        //check dead unit
        
        ArrayList<Unit> updateDead = new ArrayList<>();
        
        for (Unit unit : this.units) {
            if (unit.getHp() <= 0) {
                if (thinkableUnits.contains(unit)) {
                    thinkableUnits.remove(unit);
                }

                if (movableUnits.containsKey(unit)) {
                    movableUnits.remove(unit);
                }

                unit.action = UnitAction.NONE;
                updateDead.add(unit);
            }
        }

        for (ICollisionable unit : collisionListenerUnits) {
            if (unit.isDetonate()) {
                collisionListenerUnits.remove(unit);
                updateDead.add((Unit) unit);
            }
        }

        units.removeAll(updateDead);
    }
}
