package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductAperture {
    private static final int WIDTH = 90;
    private static final int HEIGHT = 50;
    private static final int SINGLE_SIDE_REGULAR_PRICE = 100;

    private BusinessCardColor color;
    private BusinessCardSide sides;
    private BusinessCardType type;

    public BusinessCard(BusinessCardType type, BusinessCardSide sides, BusinessCardColor color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super("Smooth Business Card", SINGLE_SIDE_REGULAR_PRICE, WIDTH, HEIGHT, color.rgb, orientation, deliveryMethod);

        this.sides = sides;
        this.color = color;
        this.type = type;

        if (sides == BusinessCardSide.DOUBLE) {
            super.price += 30;
        }

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
    }

    public BusinessCardType getType() {
        return type;
    }

    public BusinessCardColor getColor() {
        return color;
    }

    public BusinessCardSide getSides() {
        return sides;
    }

    /*
    public void setSides(BusinessCardSide sides) {
        if (this.sides == BusinessCardSide.SINGLE && sides == BusinessCardSide.DOUBLE) {
            super.price += 30;
        }

        if (this.sides == BusinessCardSide.DOUBLE && sides == BusinessCardSide.SINGLE) {
            super.price -= 30;
        }

        this.sides = sides;
    }

    public void changeColor(BusinessCardColor color) {
        this.color = color;

        super.rgb = color.rgb;
    }

    public void setType(BusinessCardType type) {
        if (this.type == BusinessCardType.LINEN) {
            if (type == BusinessCardType.LAID) {
                super.price += 10;
            } else if (type == BusinessCardType.SMOOTH) {
                super.price -= 10;
            }
        }
        if (this.type == BusinessCardType.LAID) {
            if (type == BusinessCardType.LINEN) {
                super.price -= 10;
            } else if (type == BusinessCardType.SMOOTH) {
                super.price -= 20;
            }
        }
        if (this.type == BusinessCardType.SMOOTH) {
            if (type == BusinessCardType.LINEN) {
                super.price += 10;
            } else if (type == BusinessCardType.LAID) {
                super.price += 20;
            }
        }

        this.type = type;
    }
     */
}
