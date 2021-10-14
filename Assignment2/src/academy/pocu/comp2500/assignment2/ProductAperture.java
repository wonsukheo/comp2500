package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductAperture extends Product {
    private Orientation orientation;
    private ArrayList<Aperture> apertures;

    protected ProductAperture(String displayName, int price, int color, Orientation orientation) {
        super(displayName, price, color);

        this.orientation = orientation;
    }

    public void addAperture(Aperture aperture) {
        apertures.add(aperture);
        super.price += 5;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }




    /*
    public void changeOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void removeAperture(Aperture aperture) {
        apertures.remove(aperture);
    }


     */
}
