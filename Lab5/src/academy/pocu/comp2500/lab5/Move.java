package academy.pocu.comp2500.lab5;

public class Move {
    protected String name;
    protected int power;
    protected int maxPoint;
    protected int point;

    public Move(String name, int power, int maxPoint) {
        this.name = name;
        this.power = power;
        this.maxPoint = maxPoint;
        point = this.maxPoint;
    }
}
