package academy.pocu.comp2500.lab6;

public class Order {
    private int price;

    protected Order(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
