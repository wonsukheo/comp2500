package academy.pocu.comp2500.assignment2;

import java.util.HashMap;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products = new ArrayList<>();

    public ShoppingCart() {
    }

    public boolean addProduct(Product product) {
        for (Product p : products) {
            if (p == product) {
                return false;
            }
        }

        products.add(product);

        return true;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Product p : products) {
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
