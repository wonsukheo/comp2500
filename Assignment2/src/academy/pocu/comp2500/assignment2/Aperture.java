package academy.pocu.comp2500.assignment2;

public class Aperture {
    protected int width;
    protected int height;

    protected Aperture(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /*
    public boolean setX(int x) {
        if (x < 0) {
            return false;
        } else {
            this.x = x;
            return true;
        }
    }


    public boolean setY(int y) {
        if (y < 0) {
            return false;
        } else {
            this.y = y;
            return true;
        }
    }
     */
}
