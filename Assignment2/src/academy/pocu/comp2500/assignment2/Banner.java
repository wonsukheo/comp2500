package academy.pocu.comp2500.assignment2;

public class Banner extends ProductAperture {
    private static final int REGULAR_PRICE = 5100;

    private BannerType type;
    private BannerSize size;

    public Banner(BannerType type, BannerSize size, BannerColor color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super("Scrim Banner", REGULAR_PRICE + (int) ((size.width + size.height - 1500) * 0.4), size.width, size.height, color.rgb, orientation, deliveryMethod);

        this.size = size;
        this.type = type;

        if (type == BannerType.GLOSS) {
            super.displayName = "Gloss Banner";
            super.price -= 100;
        } else if (type == BannerType.MESH) {
            super.displayName = "Mesh Banner";
        }

        String displayNameSize = String.format(super.displayName + " (" + super.width + " mm x " + super.height + " mm)");
        super.displayName = displayNameSize;

        if (size == BannerSize.BANNER_2000X500) {
            super.price -= 100;
        }
    }

    public BannerType getType() {
        return type;
    }

    public BannerSize getSize() {
        return size;
    }
}
