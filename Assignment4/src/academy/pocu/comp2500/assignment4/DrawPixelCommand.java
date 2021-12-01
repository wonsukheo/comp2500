package academy.pocu.comp2500.assignment4;

public final class DrawPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private final char c;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;
    private char previousPixel;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 && x <= canvas.getWidth() - 1 && y >= 0 && y <= canvas.getHeight() - 1) {
                if (c >= 32 && c <= 126) {
                    this.canvas = canvas;

                    this.previousPixel = canvas.getPixel(x, y);

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
            this.canvas.drawPixel(x, y, previousPixel);

            isUndo = true;

            return true;
        }

        return false;
    }

    public boolean redo() {
        if (isExecuted && canvas.getPixel(x, y) == previousPixel) {
            this.canvas.drawPixel(x, y, c);

            isUndo = false;

            return true;
        }

        return false;
    }

}
