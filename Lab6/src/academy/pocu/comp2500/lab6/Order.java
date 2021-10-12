package academy.pocu.comp2500.lab6;

public class Order {
    protected int price;
    protected boolean isValid = false;

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