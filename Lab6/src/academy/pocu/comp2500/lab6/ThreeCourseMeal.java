package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends ComboMeal {
    private static final int PRICE = 25;
    private static final int MAX_APPETIZER_COUNT = 1;
    private static final int MAX_DESSERT_COUNT = 1;
    private static final boolean IS_MAINCOURSE = true;

    public ThreeCourseMeal() {
        super(PRICE, MAX_APPETIZER_COUNT, IS_MAINCOURSE, MAX_DESSERT_COUNT);
    }
}
