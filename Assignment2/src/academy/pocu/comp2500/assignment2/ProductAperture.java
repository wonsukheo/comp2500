package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductAperture extends Product {
    private Orientation orientation;
    private ArrayList<Aperture> apertures = new ArrayList<>();

    protected ProductAperture(String displayName, int price, int width, int height, int color, Orientation orientation) {
        super(displayName, price, width, height, color);

        this.orientation = orientation;
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




    /*
    public void changeOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void removeAperture(Aperture aperture) {
        apertures.remove(aperture);
    }


     */
}
