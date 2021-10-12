package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    public MeatLoverPizza() {
        super(21, 0, 1, 0);

        super.addTopping(Topping.BACON);
        super.addTopping(Topping.PEPERONI);
        super.addTopping(Topping.HAM);
        super.addTopping(Topping.SAUSAGES);
        super.addTopping(Topping.CHEDDAR_CHEESE);
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