package academy.pocu.comp2500.assignment2;

public class Aperture {
    protected int x;
    protected int y;

    protected Aperture(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
