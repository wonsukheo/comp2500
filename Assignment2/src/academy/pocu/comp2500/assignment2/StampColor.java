package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(0xFF000000),
    GREEN(0x0000FF00),
    BLUE(0x00800000);

    protected final int rgba;

    StampColor(int rgba) {
        this.rgba = rgba;
    }
}
