package academy.pocu.comp2500.assignment2;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductAperture extends Product {
    private Orientation orientation;
    private HashMap<Aperture, Vector> apertures = new HashMap<>();

    protected ProductAperture(String displayName, int price, int width, int height, int color, Orientation orientation) {
        super(displayName, price, width, height, color);

        this.orientation = orientation;
    }

    public void addTextAperture(String text, int width, int height, int x, int y) {
        apertures.put(new TextAperture(text, width, height), new Vector(x, y));
    }

    public void addImageAperture(String imagePath, int width, int height, int x, int y) {
        apertures.put(new ImageAperture(imagePath, width, height), new Vector(x, y));
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
