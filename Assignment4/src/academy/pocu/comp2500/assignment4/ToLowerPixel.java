package academy.pocu.comp2500.assignment4;

public final class ToLowerPixel implements ICommand {
    private final int x;
    private final int y;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;

    public ToLowerPixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 || x <= canvas.getWidth() - 1 || y >= 0 || y <= canvas.getHeight() - 1) {
                char c = canvas.getPixel(x, y);

                if (c >= 65 && c <= 90) {
                    this.canvas = canvas;

                    canvas.drawPixel(x, y, c |= 32);

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

        char c = canvas.getPixel(x, y);

        this.canvas.drawPixel(x, y, c &= ~32);

        isUndo = true;

        return true;
    }


    public boolean redo() {
        if (!isUndo) {
            return false;
        }

        char c = canvas.getPixel(x, y);

        this.canvas.drawPixel(x, y, c |= 32);

        isUndo = false;

        return true;
    }

}
