package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(17, 0, 0, 2);

        super.addTopping(Topping.BLACK_OLIVES);
        super.addTopping(Topping.RED_ONIONS);
        super.addTopping(Topping.GREEN_PEPPERS);
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