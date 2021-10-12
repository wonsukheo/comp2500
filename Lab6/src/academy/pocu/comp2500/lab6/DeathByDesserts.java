package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class DeathByDesserts extends ComboMeal {
    private static final int PRICE = 20;
    private static final boolean IS_MAINCOURSE = false;
    private static final int MAX_APPETIZER_COUNT = 0;
    private static final int MAX_DESSERT_COUNT = 4;

    public DeathByDesserts() {
        super(PRICE, MAX_APPETIZER_COUNT, IS_MAINCOURSE, MAX_DESSERT_COUNT);
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        super.setDessert(dessert1);
        super.setDessert(dessert2);
        super.setDessert(dessert3);
        super.setDessert(dessert4);
        this.isValid = true;
    }
}