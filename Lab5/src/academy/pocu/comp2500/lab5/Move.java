package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private int maxPoint;

    public Move (String name, int power, int maxPoint) {
        this.name = name;
        this.power = power;
        this.maxPoint = maxPoint;
    }

    public String getName() {
        return name;
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = Math.max(0, maxPoint);
    }

    public int getPower() {
        return power;
    }
}
