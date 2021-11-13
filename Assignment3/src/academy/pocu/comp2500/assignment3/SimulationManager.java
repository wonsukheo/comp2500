package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashMap;

public final class SimulationManager {
    private static SimulationManager instance;

    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Unit> thinkableUnits = new ArrayList<>();
    private HashMap<Unit, IntVector2D> movableUnits = new HashMap<>();
    private ArrayList<Unit> collisionListenerUnits = new ArrayList<>();

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }

        return instance;
    }

    private SimulationManager() {
    }

    public ArrayList<Unit> getUnits() {
        for (Unit unit : units) {
            /*if (unit.getHp() <= 0) {
                units.remove(unit);
            }*/
        }

        return units;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    public void spawn(Unit unit) {
        unit.onSpawn();
    }

    public void registerThinkable(Unit thinkable) {
        this.thinkableUnits.add(thinkable);
    }

    public void registerMovable(Unit movable) {
        this.movableUnits.put(movable, movable.position);
    }

    public void registerCollisionEventListener(Unit listener) {
        this.collisionListenerUnits.add(listener);
    }

    public void update() {
        for (Unit unit : this.units) {
            if (unit.getHp() == 0) {
                continue;
            }
            unit.setUnitAction();
        }

        // 1. move set
        for (Unit unit : movableUnits.keySet()) {
            if (unit.unitAction == UnitAction.MOVE) {
                char symbol = unit.getSymbol();

                switch (symbol) {
                    case 'M':
                        movableUnits.put(unit, ((Marine) unit).moveLogic(unit.getUnitsInVisionOrNull(units)));
                        break;
                    case 'T':
                        movableUnits.put(unit, ((Tank) unit).moveLogic(unit.getUnitsInVisionOrNull(units)));
                        break;
                    case 'W':
                        movableUnits.put(unit, ((Wraith) unit).moveLogic(unit.getUnitsInVisionOrNull(units)));
                        break;
                }
            }
        }

        ArrayList<AttackIntent> attacks = new ArrayList<>();
        // 2. collision event
        for (Unit unit : this.collisionListenerUnits) {
            ((Mine) unit). checkDetonateCount(units);

            if (((Mine) unit).isDetonate) {
                attacks.add(unit.attack());
            }
        }

        // 3. attack

        for (Unit unit : thinkableUnits) {
            if (unit.unitAction == UnitAction.ATTACK) {
                attacks.add(unit.attack());
            }
        }
        // attack - destroyer
        for (Unit unit : units) {
            if (unit.getSymbol() == 'D') {
                attacks.add(unit.attack());
            }
        }

        //move
        for (Unit unit : movableUnits.keySet()) {
            if (unit.unitAction == UnitAction.MOVE) {
                unit.position = movableUnits.get(unit);
            }
        }

        // 4. dmg

        for (AttackIntent attack : attacks) {
            if (attack == null) {
                continue;
            }

            HashMap<IntVector2D, Integer> targetPosition = attack.getTargetPositions();

            for (IntVector2D position : targetPosition.keySet()) {
                for (Unit unit : units) {
                    if (unit.position.equals(position)) {
                        if (unit.equals(attack.getAttackUnit())) {
                            continue;
                        }
                        unit.onAttacked(targetPosition.get(position));
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

                if (collisionListenerUnits.contains(unit)) {
                    collisionListenerUnits.remove(unit);
                }

                unit.unitAction = UnitAction.NONE;
                updateDead.add(unit);
            }
        }

        for (Unit unit : collisionListenerUnits) {
            if (((Mine) unit).isDetonate) {
                collisionListenerUnits.remove(unit);
                updateDead.add(unit);
            }
        }

        units.removeAll(updateDead);
    }
}
