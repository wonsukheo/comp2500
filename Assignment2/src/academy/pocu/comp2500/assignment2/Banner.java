package academy.pocu.comp2500.assignment2;

public class Banner extends ProductAperture {
    private static final int REGULAR_PRICE = 5100;

    private BannerSize size;
    private BannerType type;

    public Banner(BannerType type, BannerSize size, BannerColor color, Orientation orientation) {
        super("Scrim Banner", REGULAR_PRICE + (int) ((size.width + size.height - 1500) * 0.4), color.rgb, orientation);

        this.size = size;
        this.type = type;
        if (type == BannerType.GLOSS) {
            super.displayName = "Gloss Banner";
            super.price -= 100;
        } else if (type == BannerType.MESH) {
            super.displayName = "Mesh Banner";
        }

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
