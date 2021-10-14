package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GREY(0xE6E6E600),
    IVORY(0xFFFFF000),
    WHITE(0xFFFFFF00);

    protected final int rgb;

    BusinessCardColor(int rgb) {
        this.rgb = rgb;
    }
}
