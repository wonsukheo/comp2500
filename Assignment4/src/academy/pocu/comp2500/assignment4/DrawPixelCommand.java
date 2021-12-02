package academy.pocu.comp2500.assignment4;

public final class DrawPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private final char c;
    private Canvas canvas;
    private char originalPixel;

    private boolean isExecuted;
    private boolean isUndo;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 && x < canvas.getWidth() && y >= 0 && y < canvas.getHeight()) {
                if (c >= 32 && c <= 126) {
                    this.canvas = canvas;
                    this.originalPixel = canvas.getPixel(x, y);

                    canvas.drawPixel(x, y, c);

                    isExecuted = true;

                    return true;
                }
            }
        }

        return false;
    }

    public boolean undo() {
        if (isExecuted && canvas.getPixel(x, y) == c) {
            this.canvas.drawPixel(x, y, originalPixel);

            isUndo = true;

            return true;
        }

        return false;
    }

    public boolean redo() {
        if (isUndo && canvas.getPixel(x, y) == originalPixel) {
            this.canvas.drawPixel(x, y, c);

            isUndo = false;

            return true;
        }

        return false;
    }
}
