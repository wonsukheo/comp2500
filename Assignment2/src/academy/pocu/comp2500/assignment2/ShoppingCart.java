package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, DeliveryMethod> productDeliveryMethodHashMap = new HashMap<>();

    public ShoppingCart() {
    }

    public void addProduct(Product product, DeliveryMethod deliveryMethod) {
        productDeliveryMethodHashMap.put(product, deliveryMethod);
    }

    public void changeDeliveryMethods(Product product, DeliveryMethod deliveryMethod) {
        productDeliveryMethodHashMap.put(product, deliveryMethod);
    }

    public void removeProduct(Product product) {
        productDeliveryMethodHashMap.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Product p : productDeliveryMethodHashMap.keySet().toArray(new Product[0])) {
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }
}
