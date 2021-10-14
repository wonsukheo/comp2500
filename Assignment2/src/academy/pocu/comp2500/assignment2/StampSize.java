package academy.pocu.comp2500.assignment2;

public enum StampSize {
    STAMP_40X30(40, 30),
    STAMP_50X20(50, 20),
    STAMP_70X40(70, 40);

    protected final int width;
    protected final int height;

    StampSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
