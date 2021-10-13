package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final int REGULAR_SIZE_PRICE = 2300;

    private String text;

    public Stamp(StampSize size, StampColor color, String text, DeliveryMethod deliveryMethod) {
        super(REGULAR_SIZE_PRICE, size.width, size.height, color.rgb, deliveryMethod);

        if (size.width == 70) {
            super.price += 300;
        }

        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
