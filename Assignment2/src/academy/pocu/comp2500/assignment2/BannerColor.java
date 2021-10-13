package academy.pocu.comp2500.assignment2;

public class BannerColor {
    protected int rgb;

    public BannerColor(int r, int g, int b) {
        rgb = (r << 24 | g << 16 | b << 8);
    }
}
