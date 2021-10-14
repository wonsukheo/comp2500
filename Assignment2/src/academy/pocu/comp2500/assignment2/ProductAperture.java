package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductAperture extends Product {
    private Orientation orientation;
    private ArrayList<TextAperture> textApertures;
    private ArrayList<ImageAperture> imageApertures;

    protected ProductAperture(String displayName, int price, int width, int height, int color, Orientation orientation) {
        super(displayName, price, width, height, color);

        this.orientation = orientation;
    }

    public boolean addTextAperture(String text, int x, int y) {
        if (x < 0 || x > super.width || y < 0 || y > super.height) {
            textApertures.add(new TextAperture(x, y, text));
            return true;
        }

        return false;
    }

    public boolean addImageAperture(String imagePath, int x, int y) {
        if (x < 0 || x > super.width || y < 0 || y > super.height) {
            imageApertures.add(new ImageAperture(x, y, imagePath));
            return true;
        }

        return false;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<TextAperture> getTextApertures() {
        return textApertures;
    }

    public ArrayList<ImageAperture> getImageApertures() {
        return imageApertures;
    }

    /*
    public void changeOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public boolean removeTextAperture(TextAperture textAperture) {
        boolean isRemoved = textApertures.remove(textAperture);

        if (isRemoved) {
            price -= 5;
        }

        return isRemoved;
    }


    public boolean removeImageAperture(ImageAperture imageAperture) {
        boolean isRemoved = imageApertures.remove(imageAperture);

        if (isRemoved) {
            price -= 5;
        }

        return isRemoved;
    }


     */
}
