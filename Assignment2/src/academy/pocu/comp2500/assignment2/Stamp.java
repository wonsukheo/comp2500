package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final int REGULAR_SIZE_PRICE = 2300;

    private String text;
    private StampSize size;
    private StampColor color;

    public Stamp(StampSize size, StampColor color, String text, DeliveryMethod deliveryMethod) {
        super("Stamp", REGULAR_SIZE_PRICE, size.width, size.height, color.rgb, deliveryMethod);

        this.size = size;
        this.color = color;
        this.text = text;

        if (size == StampSize.STAMP_70X40) {
            super.displayName = "Stamp";
            super.price += 300;
        } else if (size == StampSize.STAMP_40X30) {
            super.displayName = "Stamp";
        }

        super.displayName = String.format(super.displayName + " (" + super.width + " mm x " + super.height + " mm)");
    }

    public StampSize getSize() {
        return size;
    }

    public StampColor getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public StampType getType() {
        switch (color) {
            case RED:
                return StampType.RED_STAMP;
            case GREEN:
                return StampType.GREEN_STAMP;
            case BLUE:
                return StampType.BLUE_STAMP;
            default:
                return null;
        }
    }
}
