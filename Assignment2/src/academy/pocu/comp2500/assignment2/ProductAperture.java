package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductAperture extends Product {
    private Orientation orientation;
    private ArrayList<Aperture> apertures = new ArrayList<>();

    protected ProductAperture(String displayName, int width, int height, int color, int price, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(displayName, width, height, color, price, deliveryMethod);

        this.orientation = orientation;

        if (orientation == Orientation.PORTRAIT) {
            int temp = super.width;
            super.width = super.height;
            super.height = temp;
        }
    }

    public boolean addAperture(Aperture aperture) {
        if (aperture.x + aperture.width < super.width && aperture.y + aperture.height < super.height && aperture.x >= 0 && aperture.y >= 0) {
            for (Aperture a : apertures) {
                if (a == aperture) {
                    return false;
                }
            }

            apertures.add(aperture);

            super.price += 5;

            return true;
        }

        return false;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }
}
