package academy.pocu.comp2500.assignment4;

public final class IncreasePixelCommand implements ICommand {
    private final int x;
    private final int y;
    private Canvas canvas;
    private char pixel;

    private boolean isExecuted;
    private boolean isUndo;

    public IncreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (canvas.increasePixel(x, y)) {
                this.canvas = canvas;
                this.pixel = canvas.getPixel(x, y);

                isExecuted = true;

                return true;
            }
        }

        return false;
    }

    public boolean undo() {
        if (isExecuted && canvas.getPixel(x, y) == this.pixel) {
            canvas.drawPixel(x, y, --this.pixel);

            isUndo = true;

            return true;
        }

        return false;
    }

    public boolean redo() {
        if (isUndo && canvas.getPixel(x, y) == this.pixel) {
            canvas.drawPixel(x, y, ++this.pixel);

            isUndo = false;

            return true;
        }

        return false;
    }
}
