package academy.pocu.comp2500.assignment4;

public final class DecreasePixelCommand implements ICommand {
    private final int x;
    private final int y;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;
    private char pixel;

    public DecreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 && x <= canvas.getWidth() - 1 && y >= 0 && y <= canvas.getHeight() - 1) {
                if (canvas.getPixel(x, y) > 32) {
                    this.canvas = canvas;

                    canvas.drawPixel(x, y, (char) (canvas.getPixel(x, y) - 1));

                    isExecuted = true;

                    this.pixel = canvas.getPixel(x, y);

                    return true;
                }
            }
        }

        return false;
    }

    public boolean undo() {
        if (isExecuted && canvas.getPixel(x, y) == this.pixel) {
            this.canvas.drawPixel(x, y, (char) (canvas.getPixel(x, y) + 1));

            isUndo = true;

            this.pixel = canvas.getPixel(x, y);

            return true;
        }

        return false;
    }


    public boolean redo() {
        if (isUndo && canvas.getPixel(x, y) == this.pixel) {
            this.canvas.drawPixel(x, y, (char) (canvas.getPixel(x, y) - 1));

            isUndo = false;

            this.pixel = canvas.getPixel(x, y);

            return true;
        }

        return false;
    }

}
