package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends Personalized {
    private static final int WIDTH = 90;
    private static final int HEIGHT = 50;
    private static final int SINGLE_SIDE_REGULAR_PRICE = 100;

    private BusinessCardSide side;

    public BusinessCard(BusinessCardType type, BusinessCardSide side, BusinessCardColor color, Orientation orientation) {
        super(SINGLE_SIDE_REGULAR_PRICE, WIDTH, HEIGHT, color.value, orientation);

        this.side = side;

        if (side == BusinessCardSide.DOUBLE) {
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

    public BusinessCardSide getSide() {
        return side;
    }

    public void setSide(BusinessCardSide side) {
        this.side = side;
    }
}
