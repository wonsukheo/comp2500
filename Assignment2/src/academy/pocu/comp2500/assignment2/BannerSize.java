package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    BANNER_1000X500(1000, 500),
    BANNER_1000X1000(1000, 1000),
    BANNER_2000X500(2000, 500),
    BANNER_3000X1000(3000, 1000);

    protected final int width;
    protected final int height;

    BannerSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
