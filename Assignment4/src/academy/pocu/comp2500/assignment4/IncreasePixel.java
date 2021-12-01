package academy.pocu.comp2500.assignment4;

public final class IncreasePixel implements ICommand {
    private final int x;
    private final int y;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;

    public IncreasePixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 || x <= canvas.getWidth() - 1 || y >= 0 || y <= canvas.getHeight() - 1) {
                if (canvas.getPixel(x, y) < 126) {
                    this.canvas = canvas;

                    canvas.drawPixel(x, y, (char) (canvas.getPixel(x, y) + 1));

                    isExecuted = true;

                    return true;
                }
            }
        }

        return false;
    }

    public boolean undo() {
        if (!isExecuted) {
            return false;
        }

        this.canvas.drawPixel(x, y, (char) (canvas.getPixel(x, y) - 1));

        isUndo = true;

        return true;
    }


    public boolean redo() {
        if (!isUndo) {
            return false;
        }

        this.canvas.drawPixel(x, y, (char) (canvas.getPixel(x, y) + 1));

        isUndo = false;

        return true;
    }

}
