package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {


    public HousePizza() {
        super(20,2, 0, 0);

        addTopping(Topping.BLACK_OLIVES);
        addTopping(Topping.RED_ONIONS);
        addTopping(Topping.GREEN_PEPPERS);
        addTopping(Topping.MOZZARELLA_CHEESE);
    }

}