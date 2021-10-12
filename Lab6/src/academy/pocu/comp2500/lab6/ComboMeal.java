package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ComboMeal extends Order {
    protected final int maxAppetizerCount;
    protected final int maxMainCourseCount;
    protected final int maxDessertCount;

    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected ArrayList<Dessert> desserts = new ArrayList<>();
    protected ArrayList<MainCourse> mainCourses = new ArrayList<>();

    protected ComboMeal(int price, int maxAppetizerCount, int maxMainCourseCount, int maxDessertCount) {
        super(price);

        this.maxAppetizerCount = maxAppetizerCount;
        this.maxMainCourseCount = maxMainCourseCount;
        this.maxDessertCount = maxDessertCount;
    }

    public ArrayList<Appetizer> getAppetizers() {
        return appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    protected void checkValid() {
        if (maxAppetizerCount == appetizers.size() && maxDessertCount == desserts.size() && maxMainCourseCount == mainCourses.size()) {
            super.isValid = true;
        } else {
            super.isValid = false;
        }
    }
}