package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(17, 0, 0, 2);

        super.addTopping(Topping.BLACK_OLIVES);
        super.addTopping(Topping.RED_ONIONS);
        super.addTopping(Topping.GREEN_PEPPERS);
    }


}