package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    private static final int PRICE = 20;
    private static final int MAX_MEAT_COUNT = 2;
    private static final int MAX_VEGGIE_COUNT = 0;
    private static final int MAX_CHEESE_COUNT = 0;

    public HousePizza() {
        super(PRICE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);

        super.toppings.add(Topping.BLACK_OLIVES);
        super.toppings.add(Topping.RED_ONIONS);
        super.toppings.add(Topping.GREEN_PEPPERS);
        super.toppings.add(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        return super.addTopping(Topping.BACON);
    }

    public boolean removeBacon() {
        return super.removeTopping(Topping.BACON);
    }

    public boolean addPeperoni() {
        return super.addTopping(Topping.PEPERONI);
    }

    public boolean removePeperoni() {
        return super.removeTopping(Topping.PEPERONI);
    }

    public boolean addSausages() {
        return super.addTopping(Topping.SAUSAGES);
    }

    public boolean removeSausages() {
        return super.removeTopping(Topping.SAUSAGES);
    }
}