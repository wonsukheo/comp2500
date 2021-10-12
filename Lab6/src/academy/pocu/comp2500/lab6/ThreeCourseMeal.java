package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends ComboMeal {
    public ThreeCourseMeal() {
        super(25, 1, 1, 1);
    }

    public void setMainCourse(MainCourse mainCourse) {
        if (super.mainCourses.size() == super.maxMainCourseCount) {
            super.mainCourses.clear();
        }

        if (super.mainCourses.size() < super.maxMainCourseCount) {
            super.mainCourses.add(mainCourse);
        }

        checkValid();
    }

    public void setDessert(Dessert dessert) {
        if (super.desserts.size() == super.maxDessertCount) {
            super.desserts.clear();
        }

        if (super.desserts.size() < super.maxDessertCount) {
            super.desserts.add(dessert);
        }

        super.checkValid();
    }

    public void setAppetizer(Appetizer appetizer) {
        if (super.appetizers.size() == super.maxAppetizerCount) {
            super.appetizers.clear();
        }

        if (super.appetizers.size() < super.maxAppetizerCount) {
            super.appetizers.add(appetizer);
        }

        checkValid();
    }
}
