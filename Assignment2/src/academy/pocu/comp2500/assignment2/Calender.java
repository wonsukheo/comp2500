package academy.pocu.comp2500.assignment2;

public class Calender extends Product {
    private static final CalenderColor COLOR = CalenderColor.WHITE;
    private CalenderType type;
    private CalenderSize size;

    public Calender(CalenderType type, DeliveryMethod deliveryMethod) {
        super("Wall Calender", 1000, 400, 400, 0, deliveryMethod);

        this.type = type;
        size = CalenderSize.CALENDER_400X400;

        switch (type) {
            case DESK:
                super.displayName = "Desk Calender";
                super.width = 200;
                super.height = 150;
                size = CalenderSize.CALENDER_200X150;
                break;

            case MAGNET:
                super.displayName = "Magnet Calender";
                super.width = 100;
                super.height = 200;
                super.price = 1500;
                size = CalenderSize.CALENDER_100X200;
                break;

            default:
                assert (false) : "wrong CalenderType";
                break;
        }
    }

    public CalenderType getType() {
        return type;
    }

    public CalenderSize getSize() {
        return size;
    }

    public CalenderColor getColor() {
        return COLOR;
    }
}
