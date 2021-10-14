package academy.pocu.comp2500.assignment2;

public enum StampSize {
    STAMP_40x30(40, 30),
    STAMP_50x20(50, 20),
    STAMP_70x40(70, 40);

    protected final int width;
    protected final int height;

    StampSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
