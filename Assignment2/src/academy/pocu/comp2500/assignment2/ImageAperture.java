package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    String imagePath;
    //boolean isUploaded;

    public ImageAperture(int x, int y, String imagePath) {
        super(x, y);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
