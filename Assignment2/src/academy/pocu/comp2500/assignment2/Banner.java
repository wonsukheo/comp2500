package academy.pocu.comp2500.assignment2;

public class Banner extends ProductAperture {
    private static final int REGULAR_PRICE = 5100;

    public Banner(BannerType type, BannerSize size, BannerColor color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(REGULAR_PRICE + (int) ((size.width + size.height - 1500) * 0.4), size.width, size.height, color.rgb, orientation, deliveryMethod);

        if (type == BannerType.GLOSS) {
            super.price -= 100;
        }
    }
}
