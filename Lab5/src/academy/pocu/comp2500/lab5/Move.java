package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private int MAXPOINT;
    private int point;

    public Move(String name, int power, int maxPoint) {
        this.name = name;
        this.power = power;
        this.MAXPOINT = maxPoint;
        point = MAXPOINT;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = Math.min(point, this.MAXPOINT);
    }

    public int getPower() {
        return power;
    }
}
