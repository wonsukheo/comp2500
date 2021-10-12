package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    private static final int PRICE = 21;
    private static final int MAX_MEAT_COUNT = 0;
    private static final int MAX_VEGGIE_COUNT = 1;
    private static final int MAX_CHEESE_COUNT = 0;

    public MeatLoverPizza() {
        super(PRICE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);

        super.toppings.add(Topping.BACON);
        super.toppings.add(Topping.PEPERONI);
        super.toppings.add(Topping.HAM);
        super.toppings.add(Topping.SAUSAGES);
        super.toppings.add(Topping.CHEDDAR_CHEESE);
    }

    public boolean addBlackOlives() {
        checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.BLACK_OLIVES);
        ++super.veggieCount;
        return true;
    }

    public boolean removeBlackOlives() {
        boolean isRemoved = super.toppings.remove(Topping.BLACK_OLIVES);

        if (isRemoved) {
            --super.veggieCount;
        }

        return isRemoved;
    }

    public boolean addRedOnions() {
        checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.RED_ONIONS);
        ++super.veggieCount;
        return true;
    }

    public boolean removeRedOnions() {
        boolean isRemoved = super.toppings.remove(Topping.RED_ONIONS);

        if (isRemoved) {
            --super.veggieCount;
        }

        return isRemoved;
    }

    public boolean addGreenPeppers() {
        checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.GREEN_PEPPERS);
        ++super.veggieCount;
        return true;
    }

    public boolean removeGreenPeppers() {
        boolean isRemoved = super.toppings.remove(Topping.GREEN_PEPPERS);

        if (isRemoved) {
            --super.veggieCount;
        }

        return isRemoved;
    }
}