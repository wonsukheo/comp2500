package academy.pocu.comp2500.assignment2;

public class Calender extends Product {
    private static final int RGBA = 0;

    public Calender(CalenderType type) {
        super(1000, 400, 400, RGBA);

        switch (type) {
            case DESK:
                super.width = 200;
                super.height = 150;
                break;

            case MAGNET:
                super.price = 1500;
                super.width = 100;
                super.height = 200;
                break;

            default:
                break;
        }
    }
}
