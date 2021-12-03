package academy.pocu.comp2500.assignment4;

public final class ToUpperPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private Canvas canvas;
    private char pixel;

    private boolean isExecuted;
    private boolean isUndo;
    private boolean isMyAction;

    public ToUpperPixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 && x < canvas.getWidth() && y >= 0 && y < canvas.getHeight()) {
                this.canvas = canvas;
                this.pixel = canvas.getPixel(x, y);

                if (this.pixel >= 97 && this.pixel <= 122) {
                    canvas.drawPixel(x, y, this.pixel &= ~32);
                }

                isExecuted = true;

                return true;
            }
        }

        return false;
    }

    public boolean undo() {
        if (isExecuted && canvas.getPixel(x, y) == this.pixel && isMyAction) {
            if (this.pixel >= 65 && this.pixel <= 90) {
                this.canvas.drawPixel(x, y, this.pixel |= 32);
            }

            isUndo = true;

            return true;
        }

        return false;
    }

    public boolean redo() {
        if (isUndo && canvas.getPixel(x, y) == this.pixel) {
            if (this.pixel >= 97 && this.pixel <= 122) {
                this.canvas.drawPixel(x, y, this.pixel &= ~32);
            }

            isUndo = false;

            return true;
        }

        return false;
    }
}
