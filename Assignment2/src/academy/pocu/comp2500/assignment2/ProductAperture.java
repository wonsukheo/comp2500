package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductAperture extends Product {
    private Orientation orientation;
    private ArrayList<TextAperture> textApertures;
    private ArrayList<ImageAperture> imageApertures;

    protected ProductAperture(int price, int width, int height, int color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(price, width, height, color, deliveryMethod);

        this.orientation = orientation;
    }

    public boolean addTextAperture(TextAperture textAperture) {
        if (textAperture.x >= 0 && textAperture.x <= super.width && textAperture.y >= 0 && textAperture.y <= super.height) {
            textApertures.add(textAperture);
            price += 5;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeTextAperture(TextAperture textAperture) {
        boolean isRemoved = textApertures.remove(textAperture);

        if (isRemoved) {
            price -= 5;
        }

        return isRemoved;
    }

    public boolean addImageAperture(ImageAperture imageAperture) {
        if (imageAperture.x >= 0 && imageAperture.x <= super.width && imageAperture.y >= 0 && imageAperture.y <= super.height) {
            imageApertures.add(imageAperture);
            price += 5;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeImageAperture(ImageAperture imageAperture) {
        boolean isRemoved = imageApertures.remove(imageAperture);

        if (isRemoved) {
            price -= 5;
        }

        return isRemoved;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
