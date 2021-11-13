package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public interface IThinkable {
    IntVector2D targetLogicOrNull(ArrayList<Unit> unitsInTargetPositionOrNull);
}
