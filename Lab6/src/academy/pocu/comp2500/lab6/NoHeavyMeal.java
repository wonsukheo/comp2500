package academy.pocu.comp2500.lab6;
import java.util.ArrayList;

public class NoHeavyMeal extends ComboMeal {
    private static final int PRICE = 15;
    private static final int MAX_MAINCOURSE_COUNT = 0;
    private static final int MAX_APPETIZER_COUNT = 2;
    private static final int MAX_DESSERT_COUNT = 1;

    public NoHeavyMeal() {
        super(PRICE, MAX_APPETIZER_COUNT, MAX_MAINCOURSE_COUNT, MAX_DESSERT_COUNT);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        super.appetizers.clear();

        super.appetizers.add(appetizer1);
        super.appetizers.add(appetizer2);
    }
}
