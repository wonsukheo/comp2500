package academy.pocu.comp2500.assignment2;

public class Calender extends Product {
    private CalenderType type;

    public Calender(CalenderType type, DeliveryMethod deliveryMethod) {
        super("Wall Calender", 400, 400, 0xFFFFFF00, 1000, deliveryMethod);

        this.type = type;

        switch (type) {
            case DESK:
                super.displayName = "Desk Calender";
                super.width = 200;
                super.height = 150;
                break;

            case MAGNET:
                super.displayName = "Magnet Calender";
                super.width = 100;
                super.height = 200;
                super.price = 1500;
                break;

            default:
                assert (false) : "wrong CalenderType";
                break;
        }
    }

    public CalenderType getType() {
        return type;
    }
}
