package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ComboMeal extends Order {
    private final int maxAppetizerCount;
    private final boolean isMainCourse;
    private final int maxDessertCount;

    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected ArrayList<Dessert> desserts = new ArrayList<>();
    protected MainCourse mainCourse;

    protected ComboMeal(int price, int maxAppetizerCount, boolean isMainCourse, int maxDessertCount) {
        super(price);

        this.maxAppetizerCount = maxAppetizerCount;
        this.isMainCourse = isMainCourse;
        this.maxDessertCount = maxDessertCount;
    }

    public ArrayList<Appetizer> getAppetizers() {
        assert (appetizers != null) : "call isValid() first!";
        return appetizers;
    }

    public MainCourse getMainCourse() {
        assert (this.mainCourse != null) : "call isValid() first!";
        return mainCourse;
    }

    public ArrayList<Dessert> getDesserts() {
        assert (desserts != null) : "call isValid() first!";
        return desserts;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;

        checkValidity();
    }

    public void setAppetizer(Appetizer appetizer) {
        if (appetizers.size() == maxAppetizerCount) {
            appetizers.clear();
        }

        if (appetizers.size() < maxAppetizerCount) {
            appetizers.add(appetizer);
        }

        checkValidity();
    }

    public void setDessert(Dessert dessert) {
        if (desserts.size() == maxDessertCount) {
            desserts.clear();
        }

        if (desserts.size() < maxDessertCount) {
            desserts.add(dessert);
        }

        checkValidity();
    }

    private void checkValidity() {
        super.isValid = false;

        if (isMainCourse && mainCourse != null || !isMainCourse && mainCourse == null) {
            if (maxAppetizerCount == appetizers.size() && maxDessertCount == desserts.size()) {
                super.isValid = true;
            }
        }
    }
}