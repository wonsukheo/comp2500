package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Order {
    protected int maxMeatCount;
    protected int maxVeggieCount;
    protected int maxCheeseCount;
    protected int meatCount;
    protected int veggieCount;
    protected int cheeseCount;
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

    protected void checkValidity() {
        super.isValid = false;

        if (meatCount + veggieCount + cheeseCount != 0) {
            if (meatCount == maxMeatCount && veggieCount == maxVeggieCount && cheeseCount == maxCheeseCount) {
                super.isValid = true;
            }
        }
    }
}