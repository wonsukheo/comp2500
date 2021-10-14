package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class ProductAperture extends Product {
    private Orientation orientation;
    private HashMap<Aperture, Vector> apertures = new HashMap<>();

    protected ProductAperture(String displayName, int price, int color, Orientation orientation) {
        super(displayName, price, color);

        this.orientation = orientation;
    }

    public void addTextAperture(TextAperture textAperture, int x, int y) {
        apertures.put(textAperture, new Vector(x, y));
    }

    public void addImageAperture(ImageAperture imageAperture, int x, int y) {
        apertures.put(imageAperture, new Vector(x, y));
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public HashMap<Aperture, Vector> getApertures() {
        return apertures;
    }

    public void removeAperture(Aperture aperture) {
        apertures.remove(aperture);
    }


    /*
    public void changeOrientation(Orientation orientation) {
        this.orientation = orientation;
    }




     */
}
