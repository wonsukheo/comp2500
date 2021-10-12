package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends ComboMeal {
    private static final int PRICE = 25;
    private static final int MAX_APPETIZER_COUNT = 1;
    private static final int MAX_DESSERT_COUNT = 1;
    private static final int MAX_MAINCOURSE_COUNT = 1;

    public ThreeCourseMeal() {
        super(PRICE, MAX_APPETIZER_COUNT, MAX_DESSERT_COUNT, MAX_MAINCOURSE_COUNT);
    }
}
