package academy.pocu.comp2500.lab6;

import java.lang.reflect.Array;
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
        if (isValid) {
            return appetizers;
        }
        return null;
    }

    public ArrayList<MainCourse> getMainCourses() {
        if (isValid) {
            return mainCourses;
        }
        return null;
    }

    public ArrayList<Dessert> getDesserts() {
        if (isValid) {
            return desserts;
        }
        return null;
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

    protected void checkValidity() {
        if (maxAppetizerCount == appetizers.size() && maxDessertCount == desserts.size() && maxMainCourseCount == mainCourses.size()) {
            super.isValid = true;
        } else {
            super.isValid = false;
        }
    }
}