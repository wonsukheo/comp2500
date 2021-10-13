package academy.pocu.comp2500.assignment2;

public class Aperture {
    protected int x;
    protected int y;

    protected Aperture(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected int getX() {
        return x;
    }

    protected boolean setX(int x) {
        if (x < 0) {
            return false;
        } else {
            this.x = x;
            return true;
        }
    }

    protected int getY() {
        return y;
    }

    protected boolean setY(int y) {
        if (y < 0) {
            return false;
        } else {
            this.y = y;
            return true;
        }
    }
}
