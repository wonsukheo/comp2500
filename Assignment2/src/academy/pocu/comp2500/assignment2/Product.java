package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Product {
    protected int price;
    protected int width;
    protected int height;
    protected int rgba;
    protected DeliveryMethod deliveryMethod;

    protected ArrayList<Aperture> apertures = new ArrayList<>();

    protected Product(int price, int width, int height, int color) {
        this.price = price;
        this.width = width;
        this.height = height;
        this.rgba = color;
    }

    public int getPrice() {
        return price;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRgba() {
        return rgba;
    }

    public int getRed() {
        return (int) (rgba >> 24);
    }

    public int getGreen() {
        return (int) (rgba >> 16);
    }

    public int getBlue() {
        return (int) (rgba >> 8);
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
