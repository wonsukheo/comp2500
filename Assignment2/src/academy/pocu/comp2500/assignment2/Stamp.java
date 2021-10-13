package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final int REGULAR_SIZE_PRICE = 2300;

    private TextAperture textAperture;

    public Stamp(StampSize size, StampColor color, TextAperture textAperture) {
        super(REGULAR_SIZE_PRICE, size.width, size.height, color.value);

        this.textAperture = textAperture;

        if (size.width == 70) {
            super.price += 300;
        }
    }

    public TextAperture getTextAperture() {
        return textAperture;
    }

    public void setTextAperture(TextAperture textAperture) {
        this.textAperture = textAperture;
    }
}
