package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private String imagePath;

    public ImageAperture(String imagePath, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    /*
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }*/
}
