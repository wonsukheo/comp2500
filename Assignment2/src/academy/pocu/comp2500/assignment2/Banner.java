package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Personalized {
    private static final int REGULAR_PRICE = 5100;

    public Banner(BannerType type, BannerSize size, BannerColor color, Orientation orientation) {
        super(REGULAR_PRICE + (int) ((size.width + size.height - 1500) * 0.4), size.width, size.height, color.rgba, orientation);

        if (type == BannerType.GLOSS) {
            super.price -= 100;
        }
    }
}
