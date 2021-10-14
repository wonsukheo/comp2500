package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductAperture {
    private static final int WIDTH = 90;
    private static final int HEIGHT = 50;
    private static final int SINGLE_SIDE_REGULAR_PRICE = 100;

    private BusinessCardSide sides;

    public BusinessCard(BusinessCardType type, BusinessCardSide sides, BusinessCardColor color, Orientation orientation) {
        super(SINGLE_SIDE_REGULAR_PRICE, WIDTH, HEIGHT, color.rgba, orientation);

        this.sides = sides;

        if (sides == BusinessCardSide.DOUBLE) {
            super.price += 30;
        }

        switch (type) {
            case LINEN:
                super.price += 10;
                break;

            case LAID:
                super.price += 20;
                break;

            default:
                break;
        }
    }

    public BusinessCardSide getSides() {
        return sides;
    }

    public void setSides(BusinessCardSide sides) {
        this.sides = sides;
    }
}
