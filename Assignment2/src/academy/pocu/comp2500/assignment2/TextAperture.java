package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {
    private String text;

    public TextAperture(String text, int width, int height) {
        super(width, height);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    /*
    public void setText(String text) {
        this.text = text;
    }*/
}
