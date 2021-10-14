package academy.pocu.comp2500.assignment2;

import java.util.HashMap;
import java.util.ArrayList;

public class ShoppingCart {
    private HashMap<Product, DeliveryMethod> productDeliveryMethodHashMap = new HashMap<>();

    public ShoppingCart() {
    }

    public void addProduct(Product product, DeliveryMethod deliveryMethod) {
        productDeliveryMethodHashMap.put(product, deliveryMethod);
    }

    public boolean removeProduct(Product product) {
        if (productDeliveryMethodHashMap.get(product) == null) {
            return false;
        }
        productDeliveryMethodHashMap.remove(product);
        return true;
    }

    public DeliveryMethod getDeliveryMethod(Product product) {
        return productDeliveryMethodHashMap.get(product);
    }

    public void changeDeliveryMethod(Product product, DeliveryMethod deliveryMethod) {
        productDeliveryMethodHashMap.put(product, deliveryMethod);
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Product p : productDeliveryMethodHashMap.keySet().toArray(new Product[0])) {
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();

        for (Product p : productDeliveryMethodHashMap.keySet().toArray(new Product[0])) {
            products.add(p);
        }

        return products;
    }
}
