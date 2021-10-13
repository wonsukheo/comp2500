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

    public byte getRed() {
        return (byte) (rgba >> 24);
    }

    public byte getGreen() {
        return (byte) (rgba >> 16);
    }

    public byte getBlue() {
        return (byte) (rgba >> 8);
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
