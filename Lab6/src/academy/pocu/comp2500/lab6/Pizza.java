package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Order {
    private int maxMeatCount;
    private int maxVeggieCount;
    private int maxCheeseCount;
    private int meatCount;
    private int veggieCount;
    private int cheeseCount;
    protected ArrayList<Topping> toppings = new ArrayList<>();

    protected Pizza(int price, int maxMeatCount, int maxVeggieCount, int maxCheeseCount) {
        super(price);

        this.maxMeatCount = maxMeatCount;
        this.maxVeggieCount = maxVeggieCount;
        this.maxCheeseCount = maxCheeseCount;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public boolean addTopping(Topping topping) {
        if ((isMeat(topping) && this.meatCount >= maxMeatCount)
                || (isVeggie(topping) && this.veggieCount >= maxVeggieCount)
                || (isCheese(topping) && this.cheeseCount >= maxCheeseCount)) {
            return false;
        }

        this.toppings.add(topping);

        if (isMeat(topping)) {
            ++this.meatCount;
        }

        if (isVeggie(topping)) {
            ++this.veggieCount;
        }

        if (isCheese(topping)) {
            ++this.cheeseCount;
        }

        checkValidity();
        return true;
    }

    public boolean removeTopping(Topping topping) {
        boolean isRemoved = toppings.remove(topping);

        if (isRemoved) {
            if (isMeat(topping)) {
                --meatCount;
            }

            if (isVeggie(topping)) {
                --veggieCount;
            }

            if (isCheese(topping)) {
                --cheeseCount;
            }
        }

        return isRemoved;
    }

    private static boolean isMeat(Topping topping) {
        return topping == Topping.BACON
                || topping == Topping.CHICKEN
                || topping == Topping.PEPERONI
                || topping == Topping.SAUSAGES
                || topping == Topping.HAM;
    }

    private static boolean isVeggie(Topping topping) {
        return topping == Topping.BLACK_OLIVES
                || topping == Topping.RED_ONIONS
                || topping == Topping.GREEN_PEPPERS;
    }

    private static boolean isCheese(Topping topping) {
        return topping == Topping.MOZZARELLA_CHEESE
                || topping == Topping.CHEDDAR_CHEESE
                || topping == Topping.FETA_CHEESE;
    }

    private void checkValidity() {
        super.isValid = false;

        if (meatCount + veggieCount + cheeseCount != 0) {
            if (meatCount == maxMeatCount && veggieCount == maxVeggieCount && cheeseCount == maxCheeseCount) {
                super.isValid = true;
            }
        }
    }
}