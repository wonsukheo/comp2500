package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Order {
    private int maxMeatCount;
    private int maxVeggieCount;
    private int maxCheeseCount;
    private int meatCount;
    private int veggieCount;
    private int cheeseCount;
    private ArrayList<Topping> toppings = new ArrayList<>();

    protected Pizza(int price, int maxMeatCount, int maxVeggieCount, int maxCheeseCount) {
        super(price);

        this.maxMeatCount = maxMeatCount;
        this.maxVeggieCount = maxVeggieCount;
        this.maxCheeseCount = maxCheeseCount;
    }

    private ArrayList<Topping> getToppings() {
        return toppings;
    }

    public boolean isValid() {
        if (meatCount == 0 && cheeseCount == 0 && veggieCount == 0) {
            return false;
        }

        if (maxMeatCount == meatCount && maxCheeseCount == cheeseCount && maxVeggieCount == veggieCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addTopping(Topping topping) {
        if ((isMeat(topping) && meatCount >= maxMeatCount)
                || (isVeggie(topping) && veggieCount >= maxVeggieCount)
                || (isCheese(topping) && cheeseCount >= maxCheeseCount)) {
            return false;
        }

        toppings.add(topping);

        if (isMeat(topping)) {
            ++meatCount;
        }

        if (isVeggie(topping)) {
            ++veggieCount;
        }

        if (isCheese(topping)) {
            ++cheeseCount;
        }

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
}
