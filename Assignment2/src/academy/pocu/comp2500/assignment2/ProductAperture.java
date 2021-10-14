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

    public boolean addTextAperture(String text, int width, int height, int x, int y) {
        if (x < 0 || x > super.width || y < 0 || y > super.height || width < 0 || width > super.width || height < 0 || height > super.height) {
            return false;
        }

        textApertures.add(new TextAperture(text, width, height, x, y));
        super.price += 5;
        return true;
    }

    public boolean addImageAperture(String imagePath, int width, int height, int x, int y) {
        if (x < 0 || x > super.width || y < 0 || y > super.height || width < 0 || width > super.width || height < 0 || height > super.height) {
            return false;
        }

        imageApertures.add(new ImageAperture(imagePath, width, height, x, y));
        super.price += 5;
        return true;
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

    /*
    public void changeOrientation(Orientation orientation) {
        this.orientation = orientation;
    }




     */
}
