package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final int REGULAR_SIZE_PRICE = 2300;

    private TextAperture textAperture;

    public Stamp(StampSize size, StampColor color, TextAperture textAperture) {
        super(REGULAR_SIZE_PRICE, size.width, size.height, color.rgba);

        setTextAperture(textAperture);

        if (size.width == 70) {
            super.price += 300;
        }
    }

    public TextAperture getTextAperture() {
        return textAperture;
    }

    public boolean setTextAperture(TextAperture textAperture) {
        if (textAperture.x >= 0 && textAperture.x <= super.width && textAperture.y >= 0 && textAperture.y <= super.height) {
            this.textAperture = textAperture;
            return true;
        } else {
            return false;
        }
    }
}
