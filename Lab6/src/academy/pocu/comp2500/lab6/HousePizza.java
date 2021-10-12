package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    private static final int PRICE = 20;
    private static final int MAX_MEAT_COUNT = 2;

    public HousePizza() {
        super(PRICE, MAX_MEAT_COUNT, 0, 0);

        addTopping(Topping.BLACK_OLIVES);
        addTopping(Topping.RED_ONIONS);
        addTopping(Topping.GREEN_PEPPERS);
        addTopping(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        return super.addTopping(Topping.BACON);
    }

    public boolean removeBacon() {
        return removeTopping(Topping.BACON);
    }

    public boolean addPeperoni() {
        return super.addTopping(Topping.PEPERONI);
    }

    public boolean removePeperoni() {
        return removeTopping(Topping.PEPERONI);
    }

    public boolean addSausages() {
        return addTopping(Topping.SAUSAGES);
    }

    public boolean removeSausages() {
        return removeTopping(Topping.SAUSAGES);
    }
}