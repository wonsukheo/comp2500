package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class DeathByDesserts extends ComboMeal {
    private static final int PRICE = 20;
    private static final int MAX_APPETIZER_COUNT = 0;
    private static final int MAX_DESSERT_COUNT = 4;
    private static final int MAX_MAINCOURSE_COUNT = 0;

    public DeathByDesserts() {
        super(PRICE, MAX_APPETIZER_COUNT, MAX_DESSERT_COUNT, MAX_MAINCOURSE_COUNT);
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        super.desserts.clear();

        super.setDessert(dessert1);
        super.setDessert(dessert2);
        super.setDessert(dessert3);
        super.setDessert(dessert4);
    }
}