package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public interface IMoveable {
    IntVector2D moveLogic(ArrayList<Unit> unitsInVision);
}
