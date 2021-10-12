package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ComboMeal extends Order {
    private int maxAppetizerCount;
    private int maxDessertCount;
    private int maxMainCourseCount;

    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected ArrayList<Dessert> desserts = new ArrayList<>();
    protected MainCourse mainCourse;

    protected ComboMeal(int price, int maxAppetizerCount, int maxDessertCount, int maxMainCourseCount) {
        super(price);

        this.maxAppetizerCount = maxAppetizerCount;
        this.maxDessertCount = maxDessertCount;
        this.maxMainCourseCount = maxMainCourseCount;
    }

    public boolean isValid() {
        if (maxMainCourseCount == 1) {
            if (mainCourse != null && appetizers.size() == maxAppetizerCount && desserts.size() == maxDessertCount) {
                return true;
            }
        } else {
            if (mainCourse == null && appetizers.size() == maxAppetizerCount && desserts.size() == maxDessertCount) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Appetizer> getAppetizers() {
        assert (appetizers != null) : "call isValid() first!";
        return appetizers;
    }

    public MainCourse getMainCourse() {
        assert (mainCourse != null) : "call isValid() first!";
        return mainCourse;
    }

    public ArrayList<Dessert> getDesserts() {
        assert (desserts != null) : "call isValid() first!";
        return desserts;
    }

    public void setMainCourse(MainCourse mainCourse) {
        if (this.mainCourse == null) {
            this.mainCourse = mainCourse;
        }
    }

    public void setAppetizer(Appetizer appetizer) {
        if (appetizers.size() < maxAppetizerCount) {
            appetizers.add(appetizer);
        }
    }

    public void setDessert(Dessert dessert) {
        if (desserts.size() < maxDessertCount) {
            desserts.add(dessert);
        }
    }
}
