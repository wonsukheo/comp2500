package academy.pocu.comp2500.assignment4;

public final class ToLowerPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;
    private char pixel;

    public ToLowerPixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 && x <= canvas.getWidth() - 1 && y >= 0 && y <= canvas.getHeight() - 1) {
                this.pixel = canvas.getPixel(x, y);

                this.canvas = canvas;

                if (this.pixel >= 65 && this.pixel <= 90) {
                    canvas.drawPixel(x, y, this.pixel |= 32);

                    isExecuted = true;

                    return true;
                }
            }
        }

        return false;
    }

    public boolean undo() {
        if (isExecuted && canvas.getPixel(x, y) == this.pixel) {
            if (this.canvas.getPixel(x, y) >= 97 && this.canvas.getPixel(x, y) <= 122) {
                this.canvas.drawPixel(x, y, this.pixel &= ~32);
            }

            isUndo = true;

            return true;
        }

        return false;
    }


    public boolean redo() {
        if (isUndo && canvas.getPixel(x, y) == this.pixel) {
            if (this.pixel >= 65 && this.pixel <= 90) {
                this.canvas.drawPixel(x, y, this.pixel |= 32);
            }

            isUndo = false;

            return true;
        }

        return false;
    }

}
