package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(0xFF000000),
    BLUE(0x0000FF00),
    GREEN(0x00800000);

    protected final int rgb;

    StampColor(int rgb) {
        this.rgb = rgb;
    }
}
