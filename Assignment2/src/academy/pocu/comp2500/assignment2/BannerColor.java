package academy.pocu.comp2500.assignment2;

public class BannerColor {
    protected int rgba;

    public BannerColor(byte r, byte g, byte b) {
        rgba = (r << 24 | g << 16 | b << 8);
    }
}
