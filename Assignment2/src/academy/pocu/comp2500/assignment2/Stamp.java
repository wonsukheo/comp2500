package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final int REGULAR_SIZE_PRICE = 2300;

    private String text;
    private StampSize size;
    private StampColor color;

    public Stamp(StampSize size, StampColor color, String text) {
        super(REGULAR_SIZE_PRICE, size.width, size.height, color.rgb);

        this.size = size;
        this.color = color;
        this.text = text;

        if (size == StampSize.STAMP_70x40) {
            super.price += 300;
        }
    }

    public StampSize getSize() {
        return size;
    }

    public StampColor getColor() {
        return color;
    }

    public void setColor(StampColor color) {
        this.color = color;
        super.rgb = color.rgb;
    }

    public String getText() {
        return text;
    }

    public void changeText(String text) {
        this.text = text;
    }

    /* If you want to change color | size
       make new Object


    public void setSize(StampSize size) {
        if (this.size == StampSize.STAMP_7x4 && size != StampSize.STAMP_7x4) {
            super.price -= 300;
        }

        if (this.size != StampSize.STAMP_7x4 && size == StampSize.STAMP_7x4) {
            super.price += 300;
        }

        this.size = size;
    }
    }*/
}
