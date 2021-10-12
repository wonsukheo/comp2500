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
        return super.addTopping(Topping.BLACK_OLIVES);
    }

    public boolean removeBlackOlives() {
        return super.removeTopping(Topping.BLACK_OLIVES);
    }

    public boolean addRedOnions() {
        return super.addTopping(Topping.RED_ONIONS);
    }

    public boolean removeRedOnions() {
        return super.removeTopping(Topping.RED_ONIONS);
    }

    public boolean addGreenPeppers() {
        return super.addTopping(Topping.GREEN_PEPPERS);
    }

    public boolean removeGreenPeppers() {
        return super.removeTopping(Topping.GREEN_PEPPERS);
    }
}