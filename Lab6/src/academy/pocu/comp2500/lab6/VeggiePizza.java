package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    private static final int PRICE = 17;
    private static final int MAX_MEAT_COUNT = 0;
    private static final int MAX_VEGGIE_COUNT = 0;
    private static final int MAX_CHEESE_COUNT = 2;

    public VeggiePizza() {
        super(PRICE, MAX_MEAT_COUNT, MAX_VEGGIE_COUNT, MAX_CHEESE_COUNT);

        super.toppings.add(Topping.BLACK_OLIVES);
        super.toppings.add(Topping.RED_ONIONS);
        super.toppings.add(Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.MOZZARELLA_CHEESE);
        ++super.cheeseCount;
        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = super.toppings.remove(Topping.MOZZARELLA_CHEESE);

        if (isRemoved) {
            --super.cheeseCount;
        }

        return isRemoved;
    }

    public boolean addCheddarCheese() {
        checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.CHEDDAR_CHEESE);
        ++super.cheeseCount;
        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = super.toppings.remove(Topping.CHEDDAR_CHEESE);

        if (isRemoved) {
            --super.cheeseCount;
        }

        return isRemoved;
    }

    public boolean addFetaCheese() {
        checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.FETA_CHEESE);
        ++super.cheeseCount;
        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = super.toppings.remove(Topping.FETA_CHEESE);

        if (isRemoved) {
            --super.cheeseCount;
        }

        return isRemoved;
    }
}