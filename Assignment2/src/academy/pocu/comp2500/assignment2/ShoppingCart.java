package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products = new ArrayList<>();

    public ShoppingCart() {
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Product p : products) {
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }
}
