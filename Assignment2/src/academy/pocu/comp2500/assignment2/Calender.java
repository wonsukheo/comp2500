package academy.pocu.comp2500.assignment2;

public class Calender extends Product {
    private static final CalenderColor COLOR = CalenderColor.WHITE;
    private CalenderType type;
    private CalenderSize size;

    public Calender(CalenderType type) {
        super("Wall Calender", 1000, 0);

        this.type = type;
        size = CalenderSize.CALENDER_400X400;

        switch (type) {
            case DESK:
                super.displayName = "Desk Calender";
                size = CalenderSize.CALENDER_200X150;
                break;

            case MAGNET:
                super.displayName = "Magnet Calender";
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
