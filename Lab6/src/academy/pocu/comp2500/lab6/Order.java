package academy.pocu.comp2500.lab6;

public class Order {
    private int price;
    protected boolean isValid;

    protected Order(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return isValid;
    }
}