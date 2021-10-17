package academy.pocu.comp2500.assignment2;

public class BannerColor {
    protected int rgb;

    public BannerColor(int r, int g, int b) {
        /*
        if (r > 255) {
            r = 255;
        } else if (r < 0) {
            r = 0;
        }

        if (g > 255) {
            g = 255;
        } else if (g < 0) {
            g = 0;
        }

        if (b > 255) {
            b = 255;
        } else if (b < 0) {
            b = 0;
        } */
        rgb = (r << 24 | g << 16 | b << 8);
    }
}
