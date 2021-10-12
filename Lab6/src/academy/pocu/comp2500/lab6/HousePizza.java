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
        super.checkValidity();

        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.BACON);
        ++super.meatCount;
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = super.toppings.remove(Topping.BACON);

        if (isRemoved) {
            --super.meatCount;
        }

        return isRemoved;
    }

    public boolean addPeperoni() {
        super.checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.PEPERONI);
        ++super.meatCount;
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = super.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            --super.meatCount;
        }

        return isRemoved;
    }

    public boolean addSausages() {
        super.checkValidity();

        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.SAUSAGES);
        ++super.meatCount;
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = super.toppings.remove(Topping.SAUSAGES);

        if (isRemoved) {
            --super.meatCount;
        }

        return isRemoved;
    }
}