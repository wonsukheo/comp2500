package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products = new ArrayList<>();
    private int totalPrice = 0;

    public ShoppingCart() {
    }

    public boolean addProduct(Product product) {
        for (Product p : products) {
            if (p == product) {
                return false;
            }
        }

        products.add(product);
        totalPrice += product.getPrice();
        return true;
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            totalPrice -= product.getPrice();
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Product getProductOrNull(Product product) {
        if (products.contains(product)) {
            return product;
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
