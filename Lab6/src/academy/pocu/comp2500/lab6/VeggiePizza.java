package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    private static final int PRICE = 17;
    private static final int MAX_MEAT_COUNT = 0;
    private static final int MAX_VEGGIE_COUNT = 0;
    private static final int MAX_CHEESE_COUNT = 2;

    public VeggiePizza() {
        super(PRICE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);

        this.toppings.add(Topping.BLACK_OLIVES);
        this.toppings.add(Topping.RED_ONIONS);
        this.toppings.add(Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        return super.addTopping(Topping.MOZZARELLA_CHEESE);
    }

    public boolean removeMozzarellaCheese() {
        return super.removeTopping(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addCheddarCheese() {
        return super.addTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean removeCheddarCheese() {
        return super.removeTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean addFetaCheese() {
        return super.addTopping(Topping.FETA_CHEESE);
    }

    public boolean removeFetaCheese() {
        return super.removeTopping(Topping.FETA_CHEESE);
    }
}