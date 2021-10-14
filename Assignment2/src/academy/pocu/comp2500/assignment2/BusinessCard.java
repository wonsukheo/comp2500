package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductAperture {
    private static final int WIDTH = 90;
    private static final int HEIGHT = 50;
    private static final int SINGLE_SIDE_REGULAR_PRICE = 100;

    private BusinessCardType type;
    private BusinessCardSide sides;
    private BusinessCardColor color;

    public BusinessCard(BusinessCardType type, BusinessCardSide sides, BusinessCardColor color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super("Smooth Business Card", WIDTH, HEIGHT, color.rgb, SINGLE_SIDE_REGULAR_PRICE, orientation, deliveryMethod);

        this.sides = sides;

        if (sides == BusinessCardSide.DOUBLE) {
            super.price += 30;
        }

        this.type = type;

        switch (type) {
            case LINEN:
                super.displayName = "Linen Business Card";
                super.price += 10;
                break;

            case LAID:
                super.displayName = "Laid Business Card";
                super.price += 20;
                break;

            default:
                break;
        }

        this.color = color;
    }

    public BusinessCardType getType() {
        return type;
    }

    public BusinessCardSide getSides() {
        return sides;
    }

    public BusinessCardColor getColor() {
        return color;
    }
}
