package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(CalendarType type, DeliveryMethod deliveryMethod) {
        super("Wall Calendar", 400, 400, 0xFFFFFF00, 1000, deliveryMethod);

        this.type = type;

        switch (type) {
            case DESK:
                super.displayName = "Desk Calendar";
                super.width = 200;
                super.height = 150;
                break;

            case MAGNET:
                super.displayName = "Magnet Calendar";
                super.width = 100;
                super.height = 200;
                super.price = 1500;
                break;

            default:
                assert (false) : "wrong CalendarType";
                break;
        }
    }

    public CalendarType getType() {
        return type;
    }
}
