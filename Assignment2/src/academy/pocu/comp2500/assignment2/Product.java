package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Product {
    protected String displayName;
    protected int price;
    protected int width;
    protected int height;
    protected int rgb;

    protected Product(String displayName, int price, int width, int height, int rgb) {
        this.displayName = displayName;
        this.price = price;
        this.width = width;
        this.height = height;
        this.rgb = rgb;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPrice() {
        return price;
    }

    public int getRgb() {
        return rgb;
    }

    public int getRed() {
        return rgb >>> 24;
    }

    public int getGreen() {
        int mask = 0x00FF0000;
        int result = mask & rgb;

        return result >>> 16;
    }

    public int getBlue() {
        int mask = 0x0000FF00;
        int result = mask & rgb;

        return result >>> 8;
    }

    /*
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
     */
}
