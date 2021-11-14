package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public interface ICollisionable {
    void updateDetonateCount(ArrayList<Unit> unitsOnMap);

    boolean isDetonate();
}
