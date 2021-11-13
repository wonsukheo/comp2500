package academy.pocu.comp2500.assignment3;

import java.util.Objects;

public class IntVector2D {
    private int x;
    private int y;

    public IntVector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.hashCode() != obj.hashCode()) {
            return false;
        }

        IntVector2D that = (IntVector2D) obj;

        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return this.x * 13 + (this.y * 17) << 16;
    }
}
