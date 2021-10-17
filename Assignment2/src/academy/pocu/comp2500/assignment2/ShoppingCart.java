package academy.pocu.comp2500.assignment2;

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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProductOrNull(Product product) {
        if (products.contains(product)) {
            return product;
        }

        return null;
    }

    public Product getProductOrNull(int index) {
        return products.get(index);
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Product p : products) {
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }
}