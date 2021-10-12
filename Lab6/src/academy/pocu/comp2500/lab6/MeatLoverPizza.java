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

}